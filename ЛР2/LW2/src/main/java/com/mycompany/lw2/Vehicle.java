package com.mycompany.lw2;

import com.mycompany.lw2.Errors.DuplicateModelNameException;
import com.mycompany.lw2.Errors.ModelPriceOutOfBoundsException;
import com.mycompany.lw2.Errors.NoSuchModelNameException;


interface Vehicle extends Cloneable {
    
    public String getBrand();
    
    public void setBrand(String motoBrand);
    
    public void editModelTitle(String oldModelTitle, String newModelTitle)
        throws DuplicateModelNameException,
            NoSuchModelNameException;
    
    public String[] getModelTitles();
    
    public void editModelPrice(String modelTitle, double newPrice)
        throws 
            NoSuchModelNameException;
    
    public double getModelPrice(String modelTitle)
        throws NoSuchModelNameException;

    public double[] getModelPrices();
    
    public void addNewModel(String modelTitle, double modelPrice)
        throws 
            DuplicateModelNameException;

    public void deleteModel(String modelTitle, double modelPrice)
        throws NoSuchModelNameException;
    
    public Object clone() throws CloneNotSupportedException;
    
}
