package com.mycompany.sqlproject.exceptions;


public class WrongNumberOfArgumentsException extends Exception {
    public WrongNumberOfArgumentsException(String msg){
        super(msg);
    }
}
