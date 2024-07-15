package com.mycompany.bouncingfigure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Star extends AbstractFigure{

    private final int externalRadius;
    private final int internalRadius;
    private int[] shiftX;
    private int[] shiftY;
    private int[] shiftXforDrawing;
    private int[] shiftYforDrawing;
    private int shiftArraysLength = 0;

    public Star(float x, float y, int externalRadius, int internalRadius, long timeToLeap, boolean[][] workSpace, Graphics graphics) {
        super(x, y, timeToLeap, workSpace, graphics);
        this.externalRadius = externalRadius;
        this.internalRadius = internalRadius;
        shiftXforDrawing = new int[11];
        shiftYforDrawing = new int[11];
        initShiftArrays();
    }
    
    @Override
    protected boolean existCollision(int newX, int newY) {
        int oldX = (int)this.x;
        int oldY = (int)this.y;
        
        if(newX+externalRadius > workSpace.length || newX-externalRadius < 0
                || newY+externalRadius > workSpace[0].length || newY-externalRadius < 0)
            return true;
        
        boolean existCollision = false;
        
        for(int i=0; i < shiftArraysLength; ++i)
            workSpace[oldX + shiftX[i]][oldY + shiftY[i]] = false;
            
        for(int i=0; i < shiftArraysLength; ++i)
            if(workSpace[newX + shiftX[i]][newX + shiftY[i]] == true)
                existCollision = true;
        
        
        for(int i=0; i < shiftArraysLength; ++i)
            workSpace[oldX + shiftX[i]][oldY + shiftY[i]] = true;
        
        return  existCollision;
    }

    @Override
    protected void redraw(int newX, int newY) {
        if(newX+externalRadius > workSpace.length || newX-externalRadius < 0
                || newY+externalRadius > workSpace[0].length || newY-externalRadius < 0)
            return;
        
        
        int oldX = (int)this.x;
        int oldY = (int)this.y;
        
        for(int i = 0; i < shiftArraysLength; ++i){
            workSpace[oldX + shiftX[i]][oldY + shiftY[i]]=false;
        }
        
        for(int i = 0; i < shiftArraysLength; ++i){
            workSpace[newX + shiftX[i]][newY + shiftY[i]]=true;
        }
        
        Polygon oldPolygon = new Polygon();
        for(int i = 0; i < 11; ++i){
            oldPolygon.addPoint(oldX + shiftXforDrawing[i]+10, oldY - shiftYforDrawing[i]+36);
        }
        graphics.setColor(Color.WHITE);
        graphics.fillPolygon(oldPolygon);
        
        Polygon newPolygon = new Polygon();
        for(int i = 0; i < 11; ++i){
            newPolygon.addPoint(newX + shiftXforDrawing[i]+10, newY - shiftYforDrawing[i]+36);
        }
        graphics.setColor(Color.BLACK);
        graphics.fillPolygon(newPolygon);
    }
    
    private void initShiftArrays(){
        
        
        shiftX = new int[(2*externalRadius)*(2*externalRadius)];
        shiftY = new int[(2*externalRadius)*(2*externalRadius)];
        
        int x0 = externalRadius;
        int y0 = externalRadius;
        for(int i=0; i < 2*externalRadius; ++i)
            for(int j=0; j < 2*externalRadius; ++j){
                double pixelAngle;
                if(j-y0==0)
                    pixelAngle = 0;
                else if(i-x0==0)
                    if(j-y0 > 0)
                        pixelAngle=90;
                    else
                        pixelAngle=-90;
                else
                    pixelAngle = Math.toDegrees(Math.atan((j-y0)/(double)(i-x0)));
                
                if(i-x0 >= 0){
                    if(pixelAngle >= 54){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        internalRadius + 
                                                (((double)externalRadius-internalRadius)/36)
                                                    *(pixelAngle-54)
                                , 2))
                        { 
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                           
                           if(i-x0<shiftXforDrawing[0]){
                               shiftXforDrawing[0] = i-x0;
                               shiftYforDrawing[0] = j-y0;
                           }else if(i-x0==shiftXforDrawing[0] && j-y0>shiftYforDrawing[0]){
                               shiftXforDrawing[0] = i-x0;
                               shiftYforDrawing[0] = j-y0;
                           }
                               
                        }      
                    }
                    else if (pixelAngle >= 18){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        externalRadius - 
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle-18)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                           
                           if(j-y0==i-x0 && j-y0>shiftYforDrawing[1]){
                               shiftXforDrawing[1] = i-x0;
                               shiftYforDrawing[1] = j-y0;
                           }
                           
                           if(i-x0>shiftXforDrawing[2]){
                               shiftXforDrawing[2] = i-x0;
                               shiftYforDrawing[2] = j-y0;
                           }
                           
                        }      
                    }
                    else if (pixelAngle >= -18){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        internalRadius +  
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle+18)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                           
                           
                           
                           if(j-y0<shiftYforDrawing[3]){
                               shiftXforDrawing[3] = i-x0;
                               shiftYforDrawing[3] = j-y0;
                           }else if(j-y0==shiftYforDrawing[3] && i-x0>shiftXforDrawing[3]){
                               shiftXforDrawing[3] = i-x0;
                               shiftYforDrawing[3] = j-y0;
                           }
                        }      
                    }
                    else if (pixelAngle >= -54){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        externalRadius -  
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle+54)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                        }      
                    }
                    else{
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        internalRadius + 
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle+90)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                           
                           
                           if(i-x0>shiftXforDrawing[4]){
                               shiftXforDrawing[4] = i-x0;
                               shiftYforDrawing[4] = j-y0;
                           }else if(i-x0==shiftXforDrawing[4] && j-y0<shiftYforDrawing[4]){
                               shiftXforDrawing[4] = i-x0;
                               shiftYforDrawing[4] = j-y0;
                           }
                           
                           if(i-x0<shiftXforDrawing[5]){
                               shiftXforDrawing[5] = i-x0;
                               shiftYforDrawing[5] = j-y0;
                           }else if(i-x0==shiftXforDrawing[5] && j-y0<shiftYforDrawing[5]){
                               shiftXforDrawing[5] = i-x0;
                               shiftYforDrawing[5] = j-y0;
                           }
                        }   
                    }
                }
                else{
                    if(pixelAngle >= 54){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        externalRadius - 
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle-54)
                                , 2))
                        {
                            shiftX[shiftArraysLength]=i-x0;
                            shiftY[shiftArraysLength++]=y0-j;
                        }      
                    }
                    else if (pixelAngle >= 18){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        internalRadius + 
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle-18)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                           
                        }      
                    }
                    else if (pixelAngle >= -18){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        externalRadius -  
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle+18)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                        }      
                    }
                    else if (pixelAngle >= -54){
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        internalRadius +  
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle+54)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                        }      
                    }
                    else{
                        if(Math.pow(i-x0, 2)+Math.pow(j-y0, 2)<=
                                Math.pow(
                                        externalRadius -
                                                ((double)externalRadius-internalRadius)/36
                                                        * (pixelAngle+90)
                                , 2))
                        {
                           shiftX[shiftArraysLength]=i-x0;
                           shiftY[shiftArraysLength++]=y0-j;
                        }   
                    }
                }
            }
        shiftXforDrawing[10]=shiftXforDrawing[0];
        shiftYforDrawing[10]=shiftYforDrawing[0];
        shiftXforDrawing[9]= -shiftXforDrawing[1];
        shiftYforDrawing[9]=shiftYforDrawing[1];
        shiftXforDrawing[8]= -shiftXforDrawing[2];
        shiftYforDrawing[8]=shiftYforDrawing[2];
        shiftXforDrawing[7]= -shiftXforDrawing[3];
        shiftYforDrawing[7]=shiftYforDrawing[3];
        shiftXforDrawing[6]= -shiftXforDrawing[4];
        shiftYforDrawing[6]=shiftYforDrawing[4];
    }
    
}
