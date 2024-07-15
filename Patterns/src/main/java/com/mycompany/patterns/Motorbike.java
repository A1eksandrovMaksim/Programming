package com.mycompany.patterns;

import com.mycompany.patterns.errors.DuplicateModelNameException;
import com.mycompany.patterns.errors.ModelPriceOutOfBoundsException;
import com.mycompany.patterns.errors.NoSuchModelNameException;




public class Motorbike implements Vehicle{
    
    private String mark;
    private Model head = new Model();
    private int size;
    
    public Motorbike(String mark, int quantityModels){
        this.mark = mark;
        head.setNext(head);
        head.setPrev(head);
        
        for(int i = 0; i < quantityModels; ++i){
            try{
                addModel("MotorbikeModel-"+i, i+1000);
            }catch(Exception ex){}
        }
    }
    
    public String getMark(){
        return mark;
    }
    
    public void setMark(String mark){
        this.mark = mark;
    }
    
    class Model{
        
        private String name;
        private double price;
        private Model prev;
        private Model next;
        

        public Model getPrev() {
            return prev;
        }

        public void setPrev(Model prev) {
            this.prev = prev;
        }

        public Model getNext() {
            return next;
        }

        public void setNext(Model next) {
            this.next = next;
        }
        
        public Model(){
        
        }
        
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
        
    }
    
    public String[] getModels(){
        
        String[] names = new String[this.size];
        
        Model currentModel = head;
        for(int i=0; i < this.size; ++i){
            
            currentModel = currentModel.getNext();
            names[i]=currentModel.getName();
        }
        
        return names;
    }
    
    public double getModelPrice(String name)
        throws NoSuchModelNameException{
        
        Model currentModel = head.getNext();
        while(currentModel != head){
            
            if(currentModel.getName().equals(name)){
                return currentModel.getPrice();
            }
            
            currentModel = currentModel.getNext();
        }
        throw new NoSuchModelNameException(name);
    }
    
    public void setModelPrice(String name, double price)
        throws NoSuchModelNameException,
            ModelPriceOutOfBoundsException{
        
        if(isNotValidPrice(price))
            throw new ModelPriceOutOfBoundsException();
        
        Model currentModel = head.getNext();
        while(currentModel != head){
            
            if(currentModel.getName().equals(name)){
                currentModel.setPrice(price);
                return;
            }
            
            currentModel = currentModel.getNext();
        }
        
        throw new NoSuchModelNameException(name);
    }
    
    public void setModelName(String oldName, String newName)
        throws NoSuchModelNameException,
            DuplicateModelNameException{
       
        Model currentModel = head.getNext();
        Model searchedModel = null;
        while(currentModel != head){
            
            if(currentModel.getName().equals(oldName)){
                searchedModel = currentModel;
            }
            
            if(currentModel.getName().equals(newName)){
                throw new DuplicateModelNameException(newName);
            }
            
            currentModel = currentModel.getNext();
        }
        
        if(searchedModel != null)
            searchedModel.setName(newName);
        else
            throw new NoSuchModelNameException(oldName);
    }

    public double[] getPrices(){
        
        double[] prices = new double[this.size];
        
        Model currentModel = head;
        for(int i = 0; i < this.size; ++i){
            currentModel = currentModel.getNext();
            prices[i] = currentModel.getPrice();
        }
        
        return prices;
    }
    
    public void addModel(String name, double price)
        throws DuplicateModelNameException,
            ModelPriceOutOfBoundsException{
        
        if(isNotValidPrice(price))
            throw new ModelPriceOutOfBoundsException();
        
        if(!isUniqueModel(name))
            throw new DuplicateModelNameException(name);
        
        Model newModel = new Model(name, price);
        
        newModel.setNext(head.getNext());
        newModel.setPrev(head);
        head.getNext().setPrev(newModel);
        head.setNext(newModel);
        size++;
    }
    
    public void removeModel(String name)
        throws NoSuchModelNameException{
        
        Model currentModel = head.getNext();
        while(currentModel != head){
            
            if(currentModel.getName().equals(name)){
                Model next = currentModel.getNext();
                Model prev = currentModel.getPrev();
                next.setPrev(prev);
                prev.setNext(next);
                return;
            }
            currentModel = currentModel.getNext();
        }
        throw new NoSuchModelNameException(name);
    }
    
    public int countModels(){
        return this.size;
    }
    
    private boolean isUniqueModel(String name){
        Model currentModel = head.getNext();
        while(currentModel != head){
            
            if(currentModel.getName().equals(name))
                return false;
            
            currentModel = currentModel.getNext();
        }
            
                
        return true;
    }
    
    private boolean isNotValidPrice(double price) {
        boolean validity = price > 0;
        return !(validity);
    }
    
    @Override
    public Motorbike clone(){
        
        Motorbike clone = new Motorbike(this.mark, this.size);
        
        Model thisCurrentModel = head.getNext();
        Model cloneCurrentModel = clone.head.getNext();
        while(thisCurrentModel != head){
            
            String thisModelName = thisCurrentModel.getName();
            double thisModelPrice = thisCurrentModel.getPrice();
            cloneCurrentModel.setName(thisModelName);
            cloneCurrentModel.setPrice(thisModelPrice);
            
            thisCurrentModel = thisCurrentModel.getNext();
            cloneCurrentModel = cloneCurrentModel.getNext();
        }
        return clone;
    }
}
