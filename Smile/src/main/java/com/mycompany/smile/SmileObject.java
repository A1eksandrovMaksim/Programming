package com.mycompany.smile;

import java.util.ArrayList;


public class SmileObject {
    
    private final ArrayList<Observer> observers;
    
    public SmileObject(){
        observers = new ArrayList<>();
    }
    
    public void toSmile(Observer observer){
        for(var o : observers)
            if(!o.equals(observer))
                o.toSmile();
    }
    
    public void toPressNose(Observer observer){
        for(var o : observers)
            if(!o.equals(observer))
                o.toPressNose();
    }
    
    public void toCloseRightEye(Observer observer){
        
       for(var o : observers)
            if(!o.equals(observer))
                o.toCloseRightEye();
    }
    
    public void toOpenRightEye(Observer observer){
       for(var o : observers)
            if(!o.equals(observer))
                o.toOpenRightEye();
    }
    
    public void toCloseLeftEye(Observer observer){
        for(var o : observers)
            if(!o.equals(observer))
                o.toCloseLeftEye();
    }
    
    public void toOpenLeftEye(Observer observer){
        for(var o : observers)
            if(!o.equals(observer))
                o.toOpenLeftEye();
    }
    
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
