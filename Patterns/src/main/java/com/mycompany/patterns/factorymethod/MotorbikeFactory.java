package com.mycompany.patterns.factorymethod;

import com.mycompany.patterns.Motorbike;
import com.mycompany.patterns.Vehicle;



public class MotorbikeFactory implements VehicleFactory{

    @Override
    public Vehicle createInstance(String mark, int quantityModels) {
        return new Motorbike(mark, quantityModels);
    }
}
