package com.mycompany.lw2;


public class MotorbikeFactory implements VehicleFactory{

    @Override
    public Vehicle createInstance(String brand, int amount) {
        return new Motorbike(brand, amount);
    }
    
}
