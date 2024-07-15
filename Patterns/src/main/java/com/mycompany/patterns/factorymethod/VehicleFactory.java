package com.mycompany.patterns.factorymethod;

import com.mycompany.patterns.Vehicle;



public interface VehicleFactory {
    
    public Vehicle createInstance(String mark, int quantityModels);
    
}
