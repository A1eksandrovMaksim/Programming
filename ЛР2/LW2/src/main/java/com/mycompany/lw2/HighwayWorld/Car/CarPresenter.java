package com.mycompany.lw2.HighwayWorld.Car;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;


public class CarPresenter extends Car{
    
    private Car car = null;
    private double carWorldPositionY = 0;
    private double carWorldPositionX = 0;
    private int worldWidth = 0;
    
    public CarPresenter(Car car, int worldGroundPosition, int worldWidth){
        this.car = car;
        carWorldPositionY = worldGroundPosition - car.getBackWheels().getWheelR() - car.getBackWheels().getY();
        this.worldWidth = worldWidth;
    }
    
     public void moveCar(Group root, double deltaTime){
        double deltaDistance = deltaTime * car.getSpeed();
        carWorldPositionX += deltaDistance;
        if(carWorldPositionX + car.getWidth() > worldWidth)
            carWorldPositionX = 0 - car.getWidth();
        car.getBackWheels().move(deltaDistance);
        car.getFrontWheels().move(deltaDistance);
        show(root);
    }
    
    public void show(Group root){
        Polygon polygonCar = new Polygon();
        switch(car.getType()){
            case Car.CarType.PASSENGER -> polygonCar.getPoints().addAll(PASSENGER_POLYGON);
            case Car.CarType.BUS -> polygonCar.getPoints().addAll(BUS_POLYGON);
            case Car.CarType.TRACTOR -> polygonCar.getPoints().addAll(TRACTOR_POLYGON);
                
        }
        switch(car.getColor()){
            case Car.CarColor.BROWN -> polygonCar.setFill(Color.BROWN);
            case Car.CarColor.GREEN -> polygonCar.setFill(Color.GREEN);
            case Car.CarColor.MAGENTA -> polygonCar.setFill(Color.MAGENTA);
            case Car.CarColor.RED -> polygonCar.setFill(Color.RED);
        }
        
        polygonCar.setLayoutX(carWorldPositionX);
        polygonCar.setLayoutY(carWorldPositionY);
        root.getChildren().add(polygonCar);
        
        showCarWheel(root, car.getBackWheels());
        showCarWheel(root, car.getFrontWheels());
    }
    
   
    
    private void showCarWheel( Group root, CarWheel wheel){
        
        int wheelCenterX = (int)carWorldPositionX + wheel.getX();
        int wheelCenterY = (int)carWorldPositionY + wheel.getY();
        
        Circle circle = new Circle();
        circle.setCenterX(wheelCenterX);
        circle.setCenterY(wheelCenterY);
        circle.setRadius(wheel.getWheelR());
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        Line line1 = new Line();
        line1.setStartX(wheelCenterX - wheel.getWheelR());
        line1.setStartY(wheelCenterY);
        line1.setEndX(wheelCenterX + wheel.getWheelR());
        line1.setEndY(wheelCenterY);
        
        Line line2 = new Line();
        line2.setStartX(wheelCenterX);
        line2.setStartY(wheelCenterY - wheel.getWheelR());
        line2.setEndX(wheelCenterX);
        line2.setEndY(wheelCenterY + wheel.getWheelR());
        
        line1.setRotate(wheel.getWheelRotateState());
        line2.setRotate(wheel.getWheelRotateState());
        
        root.getChildren().addAll(circle, line1, line2);
    }
    
    
    final static Double[] PASSENGER_POLYGON = new Double[]{
        0.0, 10.0,
        20.0, 10.0,
        40.0, 0.0,
        70.0, 0.0,
        90.0, 10.0,
        120.0, 10.0,
        130.0, 20.0,
        130.0, 30.0,
        110.0, 30.0,
        110.0, 20.0,
        90.0, 20.0,
        90.0, 30.0,
        40.0, 30.0,
        40.0, 20.0,
        20.0, 20.0,
        20.0, 30.0,
        0.0, 30.0,
        0.0, 10.0
    };
    
    final static Double[] BUS_POLYGON = new Double[]{
        0.0, 0.0,
        160.0, 0.0,
        160.0, 50.0,
        140.0, 50.0,
        140.0, 40.0,
        120.0, 40.0,
        120.0, 50.0, 
        40.0, 50.0,
        40.0, 40.0,
        20.0, 40.0,
        20.0, 50.0,
        0.0, 50.0,
        0.0, 0.0
    };
    
    final static Double[] TRACTOR_POLYGON = new Double[]{
        0.0, 50.0,
        10.0, 40.0,
        10.0, 0.0,
        60.0, 0.0,
        60.0, 40.0,
        130.0, 40.0,
        140.0, 60.0,
        140.0, 90.0,
        130.0, 90.0,
        130.0, 80.0,
        120.0, 70.0,
        110.0, 70.0,
        100.0, 80.0,
        100.0, 90.0,
        60.0, 90.0,
        60.0, 70.0,
        50.0, 60.0,
        20.0, 60.0,
        10.0, 70.0,
        10.0, 90.0,
        0.0, 90.0, 
        0.0, 50.0
    };
    
    

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    public double getCarWorldPositionY() {
        return carWorldPositionY;
    }

    public void setCarWorldPositionY(double carWorldPositionY) {
        this.carWorldPositionY = carWorldPositionY;
    }

    public double getCarWorldPositionX() {
        return carWorldPositionX;
    }

    public void setCarWorldPositionX(double carWorldPositionX) {
        this.carWorldPositionX = carWorldPositionX;
    }
    
}
