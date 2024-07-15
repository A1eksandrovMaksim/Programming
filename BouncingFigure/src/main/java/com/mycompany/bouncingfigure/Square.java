package com.mycompany.bouncingfigure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Square extends AbstractFigure{

    private int squareLength;

    public Square(float x, float y, int squareLength, 
                    long timeToLeap, boolean[][] workSpace, Graphics graphics) 
    {
        super(x, y, timeToLeap, workSpace, graphics);
        this.squareLength = squareLength;  
    }

    @Override
    protected boolean existCollision(int newX, int newY) {
        
        int oldX = (int)this.x;
        int oldY = (int)this.y;
        
        if(newX+squareLength >= workSpace.length || newX < 0
                || newY+squareLength >= workSpace[0].length || newY < 0)
            return true;
        
        boolean existCollision = false;
        
        for(int i=oldX; i < oldX+squareLength; ++i)
           for(int j=oldY; j < oldY+squareLength; ++j)
                workSpace[i][j]=false;
        
        checking:for(int i=newX; i < newX+squareLength; ++i)
            for(int j=newY; j < newY+squareLength; ++j)
                if(workSpace[i][j]==true )
                {
                    existCollision = true;
                    break checking;
                }
        
        for(int i=oldX; i < oldX+squareLength; ++i)
           for(int j=oldY; j < oldY+squareLength; ++j)
                workSpace[i][j]=true;
        
        return  existCollision;
    }

    @Override
    protected void redraw(int newX, int newY) {
        if(newX+squareLength >= workSpace.length || newX < 0
                || newY+squareLength >= workSpace[0].length || newY < 0)
            return;
        
        int oldX = (int)this.x;
        int oldY = (int)this.y;
        
        for(int i=oldX; i < oldX+squareLength; ++i)
           for(int j=oldY; j < oldY+squareLength; ++j)
                workSpace[i][j]=false;
        
        for(int i=newX; i < newX+squareLength; ++i)
           for(int j=newY; j < newY+squareLength; ++j)
                workSpace[i][j]=true;
        
        
        graphics.setColor(Color.WHITE);
        graphics.fillRect(oldX+11, oldY+36, squareLength, squareLength);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(newX+11, newY+36, squareLength, squareLength);
    }
    
}
