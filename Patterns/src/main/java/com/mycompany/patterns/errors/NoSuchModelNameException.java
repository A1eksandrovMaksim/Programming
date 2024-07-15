package com.mycompany.patterns.errors;



public class NoSuchModelNameException extends Exception {
    
    public NoSuchModelNameException(String modelName){
        super("Нет модели с именем "+modelName);
    }
    
}
