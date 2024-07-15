package com.mycompany.lw2.Errors;


public class ModelPriceOutOfBoundsException extends RuntimeException{
    public ModelPriceOutOfBoundsException(){
        super("The price of the model is prohibitive!");
    }
}
