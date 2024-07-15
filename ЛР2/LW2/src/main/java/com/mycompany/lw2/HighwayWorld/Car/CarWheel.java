package com.mycompany.lw2.HighwayWorld.Car;

public class CarWheel {
    
    private int x = 0;
    private int y = 0;
    private double wheelR = 20;
    private double wheelRotateState = 0;
    
    public CarWheel(){}
    
    public CarWheel(int x, int y, double wheelR){
        this.x = x;
        this.y = y;
        this.wheelR = wheelR;
    }
    
    public double getWheelRotateState() {
        return wheelRotateState;
    }

    public void setWheelRotateState(double wheelRotateState) {
        this.wheelRotateState = wheelRotateState;
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getWheelR() {
        return wheelR;
    }

    public void setWheelR(double wheelR) {
        this.wheelR = wheelR;
    }
    
    public void move(double deltaWidth){
        wheelRotateState += deltaWidth * 360 / (2*3.1415*wheelR);
    }
}
