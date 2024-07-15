package com.mycompany.lw2;

import com.mycompany.lw2.Errors.DuplicateModelNameException;
import com.mycompany.lw2.Errors.NoSuchModelNameException;

public class SynchronizedVehicle implements Vehicle{
    private Vehicle vehicle = null;
    
    public SynchronizedVehicle(Vehicle v){
        vehicle = v;
    }
    
    public synchronized String getBrand(){
        return vehicle.getBrand();
    }
    
    public synchronized void setBrand(String motoBrand){
        vehicle.setBrand(motoBrand);
    }
    
    public synchronized void editModelTitle(String oldModelTitle, String newModelTitle)
        throws DuplicateModelNameException,
            NoSuchModelNameException{
        vehicle.editModelTitle(oldModelTitle, newModelTitle);
    }
    
    public synchronized String[] getModelTitles(){
        return vehicle.getModelTitles();
    }
    
    public synchronized void editModelPrice(String modelTitle, double newPrice)
        throws 
            NoSuchModelNameException{
        vehicle.editModelPrice(modelTitle, newPrice);
    }
    
    public synchronized double getModelPrice(String modelTitle)
        throws NoSuchModelNameException{
        return vehicle.getModelPrice(modelTitle);
    }

    public synchronized double[] getModelPrices(){
        return vehicle.getModelPrices();
    }
    
    public synchronized void addNewModel(String modelTitle, double modelPrice)
        throws 
            DuplicateModelNameException{
        vehicle.addNewModel(modelTitle, modelPrice);
    }

    public synchronized void deleteModel(String modelTitle, double modelPrice)
        throws NoSuchModelNameException{
        vehicle.deleteModel(modelTitle, modelPrice);
    }
    
    public synchronized Object clone() throws CloneNotSupportedException{
        return vehicle.clone();
    }
    
    
}
