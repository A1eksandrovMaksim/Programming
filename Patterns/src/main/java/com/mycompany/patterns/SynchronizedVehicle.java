package com.mycompany.patterns;

import com.mycompany.patterns.errors.DuplicateModelNameException;
import com.mycompany.patterns.errors.ModelPriceOutOfBoundsException;
import com.mycompany.patterns.errors.NoSuchModelNameException;



public class SynchronizedVehicle implements Vehicle{

    private Vehicle vehicle;
    
    public SynchronizedVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    
    @Override
    public synchronized String getMark() {
        return vehicle.getMark();
    }

    @Override
    public synchronized void setMark(String mark) {
        vehicle.setMark(mark);
    }

    @Override
    public synchronized String[] getModels() {
        return vehicle.getModels();
    }

    @Override
    public synchronized double getModelPrice(String name) throws NoSuchModelNameException {
        return vehicle.getModelPrice(name);
    }

    @Override
    public synchronized void setModelPrice(String name, double price) throws ModelPriceOutOfBoundsException, NoSuchModelNameException {
        this.vehicle.setModelPrice(name, price);
    }

    @Override
    public synchronized void setModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        this.vehicle.setModelName(oldName, newName);
    }

    @Override
    public synchronized double[] getPrices() {
        return this.vehicle.getPrices();
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException, ModelPriceOutOfBoundsException {
        this.vehicle.addModel(name, price);
    }

    @Override
    public synchronized void removeModel(String name) throws NoSuchModelNameException {
        this.vehicle.removeModel(name);
    }

    @Override
    public synchronized int countModels() {
        return this.vehicle.countModels();
    }
    
    
    
}
