package com.mycompany.lw1.Errors;


public class DuplicateModelNameException extends Exception{
    public DuplicateModelNameException(){
        super("Such a model already exists !");
    }
}
