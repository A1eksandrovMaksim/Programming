package com.mycompany.mywebproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "think it up yourself")
public class UniversalException  extends RuntimeException{
    public UniversalException(){
        super("You are having EXCEPTION");
    }
    
}
