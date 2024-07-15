package com.mycompany.lw2.HighwayWorld.TrafficLight;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class TrafficLightPresenter {
    
    private TrafficLight trafficLight = null;
    private int trafficLightWorldPositionY = 0;
    private int trafficLightWorldPositionX = 0;
    
    public TrafficLightPresenter(TrafficLight trafficLight, int trafficLightWorldPositionX, int trafficLightWorldPositionY){
        this.trafficLight = trafficLight;
        this.trafficLightWorldPositionY = trafficLightWorldPositionY;
        this.trafficLightWorldPositionX = trafficLightWorldPositionX;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public int getTrafficLightWorldPositionY() {
        return trafficLightWorldPositionY;
    }

    public void setTrafficLightWorldPositionY(int trafficLightWorldPositionY) {
        this.trafficLightWorldPositionY = trafficLightWorldPositionY;
    }

    public int getTrafficLightWorldPositionX() {
        return trafficLightWorldPositionX;
    }

    public void setTrafficLightWorldPositionX(int trafficLightWorldPositionX) {
        this.trafficLightWorldPositionX = trafficLightWorldPositionX;
    }
    
    public void changeSignal(Group root){
        trafficLight.changeSignal();
        show(root);
    }
    
    public void show(Group root){
        Rectangle rectangle = new Rectangle();
        rectangle.setX(trafficLightWorldPositionX - trafficLight.getWidth()/2);
        rectangle.setY(trafficLightWorldPositionY - trafficLight.getHeight());
        rectangle.setWidth(trafficLight.getWidth());
        rectangle.setHeight(trafficLight.getHeight()/2);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        
        Line line = new Line();
        line.setStartX(trafficLightWorldPositionX);
        line.setStartY(trafficLightWorldPositionY);
        line.setEndX(trafficLightWorldPositionX);
        line.setEndY(trafficLightWorldPositionY - trafficLight.getHeight()/2);
        line.setStroke(Color.BLACK);
        
        Circle redCircle = new Circle();
        redCircle.setCenterX(trafficLightWorldPositionX);
        redCircle.setCenterY(trafficLightWorldPositionY - 11*trafficLight.getHeight()/12);
        redCircle.setRadius(trafficLight.getWidth()/2);
        redCircle.setStroke(Color.BLACK);
        
        Circle yellowCircle = new Circle();
        yellowCircle.setCenterX(trafficLightWorldPositionX);
        yellowCircle.setCenterY(trafficLightWorldPositionY - 9*trafficLight.getHeight()/12);
        yellowCircle.setRadius(trafficLight.getWidth()/2);
        yellowCircle.setStroke(Color.BLACK);
        
        Circle greenCircle = new Circle();
        greenCircle.setCenterX(trafficLightWorldPositionX);
        greenCircle.setCenterY(trafficLightWorldPositionY - 7*trafficLight.getHeight()/12);
        greenCircle.setRadius(trafficLight.getWidth()/2);
        greenCircle.setStroke(Color.BLACK);
        
        switch(trafficLight.getColor()){
            case TrafficLight.TrafficLightColor.GREEN -> greenCircle.setFill(Color.GREEN);
            case TrafficLight.TrafficLightColor.RED -> redCircle.setFill(Color.RED);  
            case TrafficLight.TrafficLightColor.YELLOW -> yellowCircle.setFill(Color.YELLOW);
        }
        
        root.getChildren().addAll(
                rectangle, 
                line,
                redCircle,
                greenCircle,
                yellowCircle
        );
    }
    
}
