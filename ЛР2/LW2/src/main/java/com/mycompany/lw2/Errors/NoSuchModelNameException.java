package com.mycompany.lw2.Errors;


public class NoSuchModelNameException extends Exception{
    public NoSuchModelNameException(){
        super("Model with this name wasn't found !");
    }
}
