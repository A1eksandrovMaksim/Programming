package com.mycompany.patterns.factorymethod;

import com.mycompany.patterns.Car;
import com.mycompany.patterns.Vehicle;



public class CarFactory implements VehicleFactory{

    @Override
    public Vehicle createInstance(String mark, int quantityModels) {
        return new Car(mark, quantityModels);
    }
}
