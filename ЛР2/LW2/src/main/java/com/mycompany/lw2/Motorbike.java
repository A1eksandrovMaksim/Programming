package com.mycompany.lw2;

import com.mycompany.lw2.Errors.DuplicateModelNameException;
import com.mycompany.lw2.Errors.ModelPriceOutOfBoundsException;
import com.mycompany.lw2.Errors.NoSuchModelNameException;

/**
 *
 * @author Maksim
 */
public class Motorbike implements Vehicle{
        
    private final String brand;
    
    private Model headModel;
    
    public Motorbike(String motoBrand, int modelsQuantity){
        
        brand = motoBrand;
        
        headModel = new Model("MotoModel-0", 0);
        headModel.size = modelsQuantity;
        
        Model next = headModel;
        Model prev = headModel;
        
        for(Integer i=1; i<modelsQuantity; ++i){
            next = new Model("MotoModel-"+i.toString(), i);
            next.setPrev(prev);
            prev.setNext(next);
            prev = next;
        }
        
        next.setNext(headModel);
        headModel.setPrev(next);
    }
    
    @Override
    public String getBrand(){
        return brand;
    }
    
    
    @Override
    public void setBrand(String brand){
        brand = brand;
    }
    
    private class Model implements Cloneable{
        private String title;
        private double price;
        private Model prev;
        private Model next;
        private int size;
        
        Model(String modelTitle, double modelPrice){
            title = modelTitle;
            price = modelPrice;
        }

        public void editTitle(String modelTitle){
            title = modelTitle;
        }
       
        public String getTitle(){
            return title;
        }
        
        public void editPrice(double modelPrice){
            price = modelPrice;
        }
    
        public double getPrice(){
            return price;
        }

        public void setNext(Model modelNext){
            next = modelNext;
        }
        
        public Model getNext(){
            return next;
        }
        
        public void setPrev(Model modelPrev){
            prev = modelPrev;
        }
        
        public Model getPrev(){
            return prev;
        }
        
        public void setSize(int modelSize){
            size = modelSize;
        }
        
        public int getSize(){
            return size;
        }
        
        @Override
        public Object clone() throws CloneNotSupportedException{
            return super.clone();
        }
    }
    
    /**
     *
     * @param oldModelTitle
     * @param newModelTitle
     * @throws DuplicateModelNameException
     * @throws NoSuchModelNameException
     */
    @Override
    public void editModelTitle(String oldModelTitle, String newModelTitle)
        throws DuplicateModelNameException,
            NoSuchModelNameException{

        Model next = headModel;
        Model oldModel = null;
        boolean oldTitleExist = false;
        for(int i=0; i<headModel.getSize(); ++i)
            if(next.getTitle().equals(newModelTitle))
                throw new DuplicateModelNameException();
            else if(next.getTitle().equals(oldModelTitle)) {
                oldModel = next;
                oldTitleExist = true;
                next = next.getNext();
            }
            else
                next = next.getNext();
               
        if(!oldTitleExist)
            throw new NoSuchModelNameException();
        else
            oldModel.editTitle(newModelTitle);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String[] getModelTitles(){
        
        String[] titles = new String[headModel.getSize()];
        Model next = headModel;
        for(int i=0; i<headModel.getSize(); ++i){
            titles[i] = next.getTitle();
            next = next.getNext();
        }
        
        return titles;
    }
    
    /**
     *
     * @param modelTitle
     * @param newPrice
     * @throws ModelPriceOutOfBoundsException
     * @throws NoSuchModelNameException
     */
    @Override
    public void editModelPrice(String modelTitle, double newPrice)
        throws 
            NoSuchModelNameException{
        
        if(newPrice < 0)
            throw new ModelPriceOutOfBoundsException();
        
        Model next = headModel;
        for(int i=0; i<headModel.getSize(); ++i)
            if(next.getTitle().equals(modelTitle)){
                next.editPrice(newPrice);
                return;
            }
        
        throw new NoSuchModelNameException();
    }
    
    /**
     *
     * @param modelTitle
     * @return
     * @throws NoSuchModelNameException
     */
    @Override
    public double getModelPrice(String modelTitle)
        throws NoSuchModelNameException{
        
        Model next = headModel;
        for(int i=0; i<headModel.getSize(); ++i)
            if(next.getTitle().equals(modelTitle))
                return next.getPrice();
            else
                next = next.getNext();
        
        throw new NoSuchModelNameException();
    }

    @Override
    public double[] getModelPrices(){
        
        double[] prices = new double[headModel.getSize()];
        Model next = headModel;
        for(int i=0; i<headModel.getSize(); ++i){
            prices[i] = next.getPrice();
            next = next.getNext();
        }
        
        return prices;
    }
    
    /**
     *
     * @param modelTitle
     * @param modelPrice
     * @throws ModelPriceOutOfBoundsException
     * @throws DuplicateModelNameException
     */
    @Override
    public void addNewModel(String modelTitle, double modelPrice)
        throws 
            DuplicateModelNameException{
        
        if(modelPrice < 0)
            throw new ModelPriceOutOfBoundsException();
           
        Model next = headModel;
        for(int i=0; i<headModel.getSize(); ++i)
            if(next.getTitle().equals(modelTitle))
                throw new DuplicateModelNameException();
            else
                next = next.getNext();
        
        Model newModel = new Model(modelTitle, modelPrice);
        newModel.setNext(headModel);
        newModel.setPrev(headModel.getPrev());
        headModel.setPrev(newModel);
        newModel.getPrev().setNext(newModel);
        headModel.setSize(headModel.getSize()+1);
    }

    /**
     *
     * @param modelTitle
     * @param modelPrice
     * @throws NoSuchModelNameException
     */
    @Override
    public void deleteModel(String modelTitle, double modelPrice)
        throws NoSuchModelNameException{
        
        Model next = headModel;
        for(int i=0; i<headModel.getSize(); ++i)
            if(next.getTitle().equals(modelTitle) && next.getPrice() == modelPrice){
                next.getPrev().setNext(next.getNext());
                next.getNext().setPrev(next.getPrev());
                headModel.size--;
                return;
            }
            else
                next = next.getNext();
        
        throw new NoSuchModelNameException();
        
    }
    
    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        Motorbike clone = (Motorbike)super.clone();
        
        clone.headModel = (Model)headModel.clone();
        Model thisNext = headModel;
        Model clonePrev = clone.headModel;
        for(int i=1; i<headModel.getSize(); ++i){
            thisNext = thisNext.next;
            Model cloneNext = (Model)thisNext.clone();
            cloneNext.prev = clonePrev;
            clonePrev.next = cloneNext;
            clonePrev = cloneNext;
        }
        clonePrev.next = clone.headModel;
        clone.headModel.prev = clonePrev;
        
        return clone;
    }
}
