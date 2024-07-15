package com.mycompany.lw2;


public class CarFactory implements VehicleFactory{

    @Override
    public Vehicle createInstance(String brand, int amount) {
        return new Car(brand, amount);
    }
    
}
