package com.mycompany.bouncingfigure;

import java.awt.Color;
import java.awt.Graphics;


public final class Ball extends AbstractFigure{
    
    private final int radius;

    public Ball(float x, float y, int radius, long timeToLeap, boolean[][] workSpace, Graphics graphics) {
        super(x, y, timeToLeap, workSpace, graphics);
        this.radius = radius;
    }
    
    @Override
    protected boolean existCollision(int newX, int newY){
        
        int oldX = (int)this.x;
        int oldY = (int)this.y;
        
        if(newX+radius > workSpace.length || newX-radius < 0
                || newY+radius > workSpace[0].length || newY-radius < 0)
            return true;
        
        boolean existCollision = false;
        
        for(int i=oldX-radius; i < oldX+radius; ++i)
           for(int j=oldY-radius; j < oldY+radius; ++j)
               if(Math.pow(i-oldX-radius, 2)+Math.pow(j-oldY-radius, 2)<=Math.pow(radius, 2))
                   workSpace[i][j]=false;
        
        checking:for(int i=newX-radius; i < newX+radius; ++i)
            for(int j=newY-radius; j < newY+radius; ++j)
                if(Math.pow(i-newX-radius, 2)+Math.pow(j-newY-radius, 2)<=Math.pow(radius, 2) 
                        && workSpace[i][j]==true )
                {
                    existCollision = true;
                    break checking;
                }
        
        for(int i=oldX-radius; i < oldX+radius; ++i)
           for(int j=oldY-radius; j < oldY+radius; ++j)
               if(Math.pow(i-oldX-radius, 2)+Math.pow(j-oldY-radius, 2)<=Math.pow(radius, 2))
                   workSpace[i][j]=true;
        
        return  existCollision;
    }

    @Override
    protected void redraw(int newX, int newY) {
        if(newX+radius > workSpace.length || newX-radius < 0
                || newY+radius > workSpace[0].length || newY-radius < 0)
            return;
        
        int oldX = (int)this.x;
        int oldY = (int)this.y;
        
        for(int i=oldX-radius; i < oldX+radius; ++i)
            for(int j=oldY-radius; j < oldY+radius; ++j)
                if(Math.pow(i-oldX-radius, 2)+Math.pow(j-oldY-radius, 2)<=Math.pow(radius, 2))
                    workSpace[i][j]=false;
        
        for(int i=newX-radius; i < newX+radius; ++i)
            for(int j=newY-radius; j < newY+radius; ++j)
                if(Math.pow(i-newX-radius, 2)+Math.pow(j-newY-radius, 2)<=Math.pow(radius, 2))
                    workSpace[i][j]=true;
        
        
        graphics.setColor(Color.WHITE);
        graphics.fillOval(oldX-radius+10, oldY-radius+36, radius*2, radius*2);
        graphics.setColor(Color.BLACK);
        graphics.fillOval(newX-radius+10, newY-radius+36, radius*2, radius*2);
    }
    
}
