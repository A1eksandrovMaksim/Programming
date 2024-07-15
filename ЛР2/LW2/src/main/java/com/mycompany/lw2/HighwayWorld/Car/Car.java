package com.mycompany.lw2.HighwayWorld.Car;

public class Car {
    private boolean stoped = false;
    private CarColor color;
    private CarType type;
    private int Height;
    private int Width;
    private double speed;
    private CarWheel frontWheels;
    private CarWheel backWheels;
    
    public Car(){
        color = CarColor.BROWN;
        speed = 30;
        this.setType(CarType.PASSENGER);
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public boolean isStoped() {
        return stoped;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public int getWidth() {
        return Width;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }

    public int getHight() {
        return Height;
    }

    public void setHight(int Height) {
        this.Height = Height;
    }

    public CarWheel getFrontWheels() {
        return frontWheels;
    }

    public void setFrontWheels(CarWheel frontWheels) {
        this.frontWheels = frontWheels;
    }

    public CarWheel getBackWheels() {
        return backWheels;
    }

    public void setBackWheels(CarWheel backWheels) {
        this.backWheels = backWheels;
    }
    
    public CarColor getColor(){
        return color;
    }
    
    public void setColor(CarColor color){
        this.color = color;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
        switch(type){
            case CarType.PASSENGER -> {
                frontWheels = new CarWheel(100, 30, 8);
                backWheels = new CarWheel(30, 30, 8);
                Height = 30;
                Width = 130;
            }
            case CarType.BUS -> {
                frontWheels = new CarWheel(130, 50, 9);
                backWheels = new CarWheel(30, 50, 9);
                Height = 50;
                Width = 160;
            }
            case CarType.TRACTOR -> {
                frontWheels = new CarWheel(115, 93, 15);
                backWheels = new CarWheel(35, 85, 23);
                Height = 90;
                Width = 140;
            }
}
    }
    
    public enum CarColor{
        RED,
        BROWN,
        MAGENTA,
        GREEN
    }
    
    public enum CarType{
        PASSENGER,
        BUS,
        TRACTOR
    }
}


