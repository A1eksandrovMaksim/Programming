package com.mycompany.patterns.chainofresponsibility;

import com.mycompany.patterns.Vehicle;



public class InLinePrinterLink implements ChainOfResponsibility{

    private ChainOfResponsibility next;
    
    @Override
    public void setNext(ChainOfResponsibility next) {
        this.next = next;
    }

    @Override
    public void print(Vehicle vehicle) {
        
        if(vehicle.countModels() > 3){
            
            if(next != null){
                next.print(vehicle);
            }
            
        }
        else{
            printInLine(vehicle);
        }      
    }
    
    private void printInLine(Vehicle vehicle){
        
        System.out.print(vehicle.getMark());
        System.out.print(" (" + vehicle.countModels() + ") {");
        for(var modelName : vehicle.getModels()){
            
            try{
                double modelPrice = vehicle.getModelPrice(modelName);
            
                System.out.print(
                    " Model: " + modelName + 
                    " Price: " + modelPrice + ";");
                
            }catch(Exception ex){
                ex.printStackTrace();
                return;
            }
        }
        System.out.println("}");
    }
}
