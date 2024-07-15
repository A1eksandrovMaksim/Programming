package com.mycompany.patterns.chainofresponsibility;

import com.mycompany.patterns.Vehicle;



public class ColumnPrinterLink implements ChainOfResponsibility{

    private ChainOfResponsibility next;
    
    @Override
    public void setNext(ChainOfResponsibility next) {
        this.next = next;
    }

    @Override
    public void print(Vehicle vehicle) {
        
        if(vehicle.countModels() < 4){
            
            if(next != null){
                next.print(vehicle);
            }
            
        }
        else{
            printColumn(vehicle);
        }      
    }
    
    private void printColumn(Vehicle vehicle){
        
        System.out.println(vehicle.getMark());
        System.out.println("Quantity of models: " + vehicle.countModels());
        for(var modelName : vehicle.getModels()){
            
            try{
                double modelPrice = vehicle.getModelPrice(modelName);
            
                System.out.println(
                    "Model: " + modelName + 
                    " Price: " + modelPrice);
                
            }catch(Exception ex){
                ex.printStackTrace();
                return;
            }
        }
    }
}
