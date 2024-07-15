package com.mycompany.lw2.Errors;


public class DuplicateModelNameException extends Exception{
    public DuplicateModelNameException(){
        super("Such a model already exists !");
    }
}
