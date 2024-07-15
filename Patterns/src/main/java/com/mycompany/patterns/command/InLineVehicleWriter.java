package com.mycompany.patterns.command;

import com.mycompany.patterns.Vehicle;
import java.io.Writer;



public class InLineVehicleWriter implements Command{
    
    public void print(Vehicle vehicle, Writer writer) {
        try{
            writer.write(vehicle.getMark());
            writer.write(" (" + vehicle.countModels() + ") {");
            for(var modelName : vehicle.getModels()){

                    writer.write(
                            " Model: " + modelName 
                            + " Price: " +
                            vehicle.getModelPrice(modelName)
                            + ";"
                    );
            }
            writer.write("}");
        }
        catch(Exception ex){
             ex.printStackTrace();
        } 
    }
    
}
