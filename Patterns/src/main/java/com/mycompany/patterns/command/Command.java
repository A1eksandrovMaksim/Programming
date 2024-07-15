package com.mycompany.patterns.command;

import com.mycompany.patterns.Vehicle;
import java.io.Writer;

public interface Command {
    
    public void print(Vehicle vehicle, Writer writer);
    
}
