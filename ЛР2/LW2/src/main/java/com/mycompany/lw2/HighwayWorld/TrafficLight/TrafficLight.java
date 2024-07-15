package com.mycompany.lw2.HighwayWorld.TrafficLight;

public class TrafficLight {

    private TrafficLightColor color = TrafficLightColor.RED;
    private int height = 130;
    private int width = 20;
    private int delay = 3000;
    
    
    public TrafficLightColor getColor() {
        return color;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setColor(TrafficLightColor color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public void changeSignal(){
        switch(color){
            case RED -> color = TrafficLightColor.YELLOW;
            case YELLOW -> color = TrafficLightColor.GREEN;
            case GREEN -> color = TrafficLightColor.RED;
        }
    }
    
    public enum TrafficLightColor{
        RED,
        GREEN,
        YELLOW
    }
}


