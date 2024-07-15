package com.mycompany.patterns.command;

import com.mycompany.patterns.Vehicle;
import com.mycompany.patterns.errors.NoSuchModelNameException;
import java.io.Writer;



public class ColumnVehicleWriter implements Command{

    @Override
    public void print(Vehicle vehicle, Writer writer) {
        try{
            writer.write(vehicle.getMark() + "\n");
            for(var modelName : vehicle.getModels()){

                    writer.write(
                            modelName + " - " 
                            + vehicle.getModelPrice(modelName)
                            + "\n"
                    );
                }
            }
        catch(Exception ex){
             ex.printStackTrace();
        } 
    }
}
