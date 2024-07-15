package com.mycompany.patterns;

import com.mycompany.patterns.command.Command;
import com.mycompany.patterns.errors.DuplicateModelNameException;
import com.mycompany.patterns.errors.ModelPriceOutOfBoundsException;
import com.mycompany.patterns.errors.NoSuchModelNameException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;

public class Car implements Vehicle, Serializable{
    
    private String mark;
    private Model[] models;
    
    private Command command;
    
    public Car(String mark, int quantityModels){
        this.mark = mark;
        
        models = new Model[quantityModels];
        for(int i = 0; i < quantityModels; ++i){
            models[i] = new Model("CarModel-"+i, i+1000);
        }
    }
    
    public String getMark(){
        return mark;
    }
    
    public void setMark(String mark){
        this.mark = mark;
    }
    
    public void setPrintCommand(Command command){
        this.command = command;
    }
    
    public String[] getModels(){
        
        String[] names = new String[models.length];
        
        for(int i=0; i < names.length; ++i)
            names[i]=models[i].getName();
        
        return names;
    }
    
    public double getModelPrice(String name)
        throws NoSuchModelNameException{
        
        for(int i = 0; i < models.length; ++i){
            
            if(models[i].getName().equals(name))
                return models[i].getPrice();
        }
        throw new NoSuchModelNameException(name);
    }
    
    @Override
    public void setModelPrice(String name, double price)
        throws NoSuchModelNameException,
            ModelPriceOutOfBoundsException{
        
        if(isNotValidPrice(price))
            throw new ModelPriceOutOfBoundsException();
        
        for(int i = 0; i < models.length; ++i){
            
            if(models[i].getName().equals(name)){
                models[i].setPrice(price);
                return;
            }
        }
        
        throw new NoSuchModelNameException(name);
    }
    
    public void setModelName(String oldName, String newName)
        throws NoSuchModelNameException,
            DuplicateModelNameException{
        
        int searchedModelId = -1;
        for(int i = 0; i < models.length; ++i){
            
            if(models[i].getName().equals(oldName)){
                searchedModelId = i;
            }
            
            if(models[i].getName().equals(newName)){
                throw new DuplicateModelNameException(newName);
            }
        }
        
        if(searchedModelId != -1)
            models[searchedModelId].setName(newName);
        else
            throw new NoSuchModelNameException(oldName);
    }

    public double[] getPrices(){
        
        double[] prices = new double[models.length];
        
        for(int i = 0; i < models.length; ++i)
            prices[i] = models[i].getPrice();
        
        return prices;
    }
    
    public void addModel(String name, double price)
        throws DuplicateModelNameException,
            ModelPriceOutOfBoundsException{
        
        if(isNotValidPrice(price))
            throw new ModelPriceOutOfBoundsException();
        
        if(!isUniqueModel(name))
            throw new DuplicateModelNameException(name);
        
        Model[] newModels
                = Arrays.copyOf(models, models.length+1);
        newModels[models.length-1] = new Model(name, price);
        
        models = newModels;
    }
    
    public void removeModel(String name)
        throws NoSuchModelNameException{
        
        int i = 0;
        for(; i < models.length; ++i){
            
            if(models[i].getName().equals(name)){
                removeModel(i);
                return;
            }
        }
        
        throw new NoSuchModelNameException(name);
    }
    
    public int countModels(){
        return models.length;
    }
    
    private boolean isUniqueModel(String name){
        for(var model : models)
            if(model.getName().equals(name))
                return false;
        return true;
    }

    private void removeModel(int id){
        
        Model[] newModels 
                = Arrays.copyOf(models, models.length-1);
        System.arraycopy(
                models,id+1,
                newModels,id,
                models.length-(id+1)
                );
        models = newModels;
    }
    
    private boolean isNotValidPrice(double price){
        boolean validity = price > 0;
        return !(validity);
    }
    
    @Override
    public Car clone(){
        
        Car clone = new Car(this.mark, this.models.length);
        
        for(int i = 0; i < this.models.length; ++i){
            
            String thisModelName = this.models[i].getName();
            double thisModelPrice = this.models[i].getPrice();
            clone.models[i].setName(thisModelName);
            clone.models[i].setPrice(thisModelPrice);
        }
        return clone;
    }
    
    public void print(Writer writer){
        command.print(this, writer);
    }
    
    public CarIterator iterator(){
        return new CarIterator();
    }
    
    public Memento createMemento(){
        
        var memento = new Memento();
        memento.setCar(this);
        return memento;
    }
    
    public void setMemento(Memento memento){
        
        Car car = memento.getCarElseNull();
        
        if(car == null)
            return;
        
        this.mark = car.mark;
        this.models = car.models;
    }
    
    
    public static class Memento{
        
        byte[] carByteArray;
        
        public void setCar(Car car){
            
            try(ByteArrayOutputStream baos =
                    new ByteArrayOutputStream()){
                
                var oos = new ObjectOutputStream(baos);
                oos.writeObject(car);
                
                carByteArray = baos.toByteArray();
                
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
        public Car getCarElseNull(){
            
            if(carByteArray == null)
                return null;
            
            try(ByteArrayInputStream bais =
                    new ByteArrayInputStream(carByteArray)){
                
                var ois = new ObjectInputStream(bais);
                return (Car)ois.readObject();
                
            }catch(Exception ex){
                ex.printStackTrace();
                return null;
            }
        }
        
    }
    
    static class Model implements Serializable{
        
        private String name;
        private double price;

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        
        public String toString(){
            return name + " " + Double.toString(price);
        }
    }
    
    public class CarIterator implements Iterator{

        private int currentNodeId = -1;
        
        @Override
        public boolean hasNext() {
            
            int nextNodeId = currentNodeId + 1;
            int lastNodeId = models.length - 1;
            
            return nextNodeId <= lastNodeId;
        }

        @Override
        public Object next() {
            return models[++currentNodeId];
        }
    }
    
    
}
