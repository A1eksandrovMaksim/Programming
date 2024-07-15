package com.mycompany.lw2;

import com.mycompany.lw2.HighwayWorld.WorldPresenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class LW2 {
    public static void main(String[] args) {
        
        // ---  Adapter testing ---
        
        try{
            
            String[] strings = {"Word1", "HHHHHHHH"};
            File file = new File("AdapterResult.txt");
            OutputStream outputStream = new FileOutputStream(file);
            Adapter adapter = new Adapter(outputStream);
            adapter.adapt(strings);
            outputStream.close();
            
        }catch(FileNotFoundException fnfEx){
            System.out.println(fnfEx.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
        // ---  Decorator testing   ---
        /*Vehicle someVehicle = VehiclePresenter.createInstance("Toyota", 5);
        //someVehicle = VehiclePresenter.sinchronizedVehicle(someVehicle);
        Thread thread1 = new Thread(() -> {
            try{
                someVehicle.addNewModel("Corolla", 3900000);
                someVehicle.addNewModel("Camry", 6514000);
                someVehicle.addNewModel("Yaris", 6800000);
                someVehicle.addNewModel("RAV4", 6500000);
                System.out.println("NewThread Presenting");
                VehiclePresenter.printVehicle(someVehicle);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        });
        thread1.start();
        
        System.out.println("MainThread Presenting");
        VehiclePresenter.printVehicle(someVehicle);
        */
        
        // ---  Facade testing   ---
//        WorldPresenter worldPresenter = new WorldPresenter();
//        worldPresenter.launch(WorldPresenter.class, args);
        
    }
}
