package com.mycompany.patterns;

import com.mycompany.patterns.errors.DuplicateModelNameException;
import com.mycompany.patterns.errors.ModelPriceOutOfBoundsException;
import com.mycompany.patterns.errors.NoSuchModelNameException;


public interface Vehicle {
    
    public String getMark();
    
    public void setMark(String mark);
    
    public String[] getModels();
    
    public double getModelPrice(String name)
            throws NoSuchModelNameException;
    
    public void setModelPrice(String name, double price)
            throws ModelPriceOutOfBoundsException,
            NoSuchModelNameException;
    
    public void setModelName(String oldName, String newName)
            throws NoSuchModelNameException,
            DuplicateModelNameException;
    
    public double[] getPrices();
    
    public void addModel(String name, double price)
            throws DuplicateModelNameException,
            ModelPriceOutOfBoundsException;
    
    public void removeModel(String name)
            throws NoSuchModelNameException;
    
    public int countModels();
    
    
    
}
