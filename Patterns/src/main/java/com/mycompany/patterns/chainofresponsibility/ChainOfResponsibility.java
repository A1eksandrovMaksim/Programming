package com.mycompany.patterns.chainofresponsibility;

import com.mycompany.patterns.Vehicle;

public interface ChainOfResponsibility {
    
    public void setNext(ChainOfResponsibility next);
    
    public void print(Vehicle vehicle);
}
