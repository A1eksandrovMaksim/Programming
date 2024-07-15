package com.mycompany.lw1;

import com.mycompany.lw1.Errors.DuplicateModelNameException;
import com.mycompany.lw1.Errors.ModelPriceOutOfBoundsException;
import com.mycompany.lw1.Errors.NoSuchModelNameException;
import java.util.Arrays;

public class Car implements Vehicle{
    
    private String brand;
    
    private Model[] models;
    
    public Car(String carBrand, int modelsQuantity){
        
        brand = carBrand;
        models = new Model[modelsQuantity];
        
        for(int i=0; i<modelsQuantity; ++i)
            models[i]=new Model("ModelCar-"+i, i);
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getBrand(){
        return brand;
    }
    
    /**
     *
     * @param carBrand
     */
    @Override
    public void setBrand(String carBrand){
        brand = carBrand;
    }
    
    private class Model implements Cloneable{
        private String title;
        private double price;
        
        Model(String modelTitle, double modelPrice){
            title = modelTitle;
            price = modelPrice;
        }
    
        public void editTitle(String modelTitle){
            title = modelTitle;
        }
       
        public String getTitle(){
            return title;
        }
        
        public void editPrice(double modelPrice){
            price = modelPrice;
        }
    
        public double getPrice(){
            return price;
        }
        
        public Object clone() throws CloneNotSupportedException{
            return super.clone();
        }
    }
    
    /**
     *
     * @param oldModelTitle
     * @param newModelTitle
     * @throws DuplicateModelNameException
     * @throws NoSuchModelNameException
     */
    @Override
    public void editModelTitle(String oldModelTitle, String newModelTitle)
        throws DuplicateModelNameException,
            NoSuchModelNameException{

        int oldModelPosition = -1;
        for(int i=0; i<models.length; ++i)
            if(models[i].getTitle().equals(newModelTitle))
                throw new DuplicateModelNameException();
            else if(models[i].getTitle().equals(oldModelTitle))
                oldModelPosition = i;
        
        if(oldModelPosition != -1)
            models[oldModelPosition].editTitle(newModelTitle);
        else
            throw new NoSuchModelNameException();
    }
    
    /**
     *
     * @return
     */
    @Override
    public String[] getModelTitles(){
        
        String[] titles = new String[models.length];
        for(int i=0; i<models.length; ++i){
            titles[i] = models[i].getTitle();
        }
        
        return titles;
    }
    
    /**
     *
     * @param modelTitle
     * @param newPrice
     * @throws ModelPriceOutOfBoundsException
     * @throws NoSuchModelNameException
     */
    @Override
    public void editModelPrice(String modelTitle, double newPrice)
        throws 
            NoSuchModelNameException{
        
        if(newPrice < 0)
            throw new ModelPriceOutOfBoundsException();
        
        for(int i=0; i<models.length; ++i)
            if(models[i].getTitle().equals(modelTitle)){
                models[i].editPrice(newPrice);
                return;
            }
        
        throw new NoSuchModelNameException();
        
    }
    
    /**
     *
     * @param modelTitle
     * @return
     * @throws NoSuchModelNameException
     */
    @Override
    public double getModelPrice(String modelTitle)
        throws NoSuchModelNameException{
        
        for(int i=0; i<models.length; ++i)
            if(models[i].getTitle().equals(modelTitle)){
                return models[i].getPrice();
            }
        
        throw new NoSuchModelNameException();
    }

    /**
     *
     * @return
     */
    @Override
    public double[] getModelPrices(){
        
        double[] prices = new double[models.length];
        for(int i=0; i<models.length; ++i){
            prices[i] = models[i].getPrice();
        }
        
        return prices;
    }
    
    /**
     *
     * @param modelTitle
     * @param modelPrice
     * @throws ModelPriceOutOfBoundsException
     * @throws DuplicateModelNameException
     */
    @Override
    public void addNewModel(String modelTitle, double modelPrice)
        throws 
            DuplicateModelNameException{
          
        if(modelPrice < 0)
            throw new ModelPriceOutOfBoundsException();
           
        for(int i=0; i<models.length; ++i)
            if( models[i].getTitle().equals(modelTitle))
                throw new DuplicateModelNameException();
        
        models = Arrays.copyOf(models, models.length + 1);
        models[models.length-1] = new Model(modelTitle, modelPrice);
        
    }

    /**
     *
     * @param modelTitle
     * @param modelPrice
     * @throws NoSuchModelNameException
     */
    @Override
    public void deleteModel(String modelTitle, double modelPrice)
        throws NoSuchModelNameException{
        
        for(int i=0; i<models.length; ++i)
            if(models[i].getTitle().equals(modelTitle) 
                    && models[i].getPrice() == modelPrice){
                
                Model[] newModels = Arrays.copyOf(models, models.length-1);
                System.arraycopy(models, i+1, newModels, i, models.length-i-1);
                models = newModels;
                
                return;
            }
        
        throw new NoSuchModelNameException();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Car clone = (Car)super.clone();
        clone.models = new Model[models.length];
        for(int i=0; i < models.length; ++i){
            clone.models[i] = (Model)models[i].clone();
        }
        return clone;
    }
    
}
