package com.mycompany.bouncingfigure;

import java.awt.Graphics;
import java.util.Date;
import java.util.Random;

public abstract class AbstractFigure extends Thread{
    
    protected boolean exit = false;
    
    protected float x;
    protected float y;
    protected long lastHandlingTime;
    protected long timeToLeap;
    protected double motionAngle;
    protected boolean[][] workSpace;
    protected Graphics graphics;
    
    public AbstractFigure(float x, float y, long timeToLeap, boolean[][] workSpace, Graphics graphics){
        this.x = x;
        this.y = y;
        this.timeToLeap = timeToLeap;
        this.graphics = graphics;
        this.workSpace = workSpace;
        motionAngle = new Random().nextDouble(90, 180);
    }
    
    
    @Override
    public void run(){
        lastHandlingTime = new Date().getTime();
        for(;!exit;){
            if(new Date().getTime() - lastHandlingTime >= timeToLeap){
                templateMethod();
                lastHandlingTime = new Date().getTime();
            }
        }
    }
    
    public void templateMethod() {
        float[] newCoords = calculateNextPosition();
        redraw((int)newCoords[0], (int)newCoords[1]);
        this.x = newCoords[0];
        this.y = newCoords[1];
    }
    
    protected float [] calculateNextPosition(){
        float[] newCoords = new float[2];
        
        newCoords[0] = x+(float)(Math.cos(Math.toRadians(motionAngle))*5);
        newCoords[1] = y-(float)(Math.sin(Math.toRadians(motionAngle))*5);
        
        while(existCollision((int)newCoords[0], (int)newCoords[1])){
            motionAngle += new Random().nextDouble(135, 235);
            newCoords[0] = x+(float)(Math.cos(Math.toRadians(motionAngle))*5);
            newCoords[1] = y-(float)(Math.sin(Math.toRadians(motionAngle))*5);
        }
        
        return newCoords;
    }
    
    
    protected abstract boolean existCollision(int nexX, int newY);

    protected abstract void redraw(int newX, int newY);
    
    protected void exit(){
        exit = true;
    }
    
}
