package com.mycompany.patterns.dao;

import com.mycompany.patterns.Vehicle;

public interface VehicleDAO {
    
    public void write(Vehicle vehicle, String filePath);
    
    public Vehicle read(String filePath);
    
}
