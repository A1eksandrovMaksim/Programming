package com.mycompany.lw2.HighwayWorld;

import com.mycompany.lw2.HighwayWorld.Car.Car;
import com.mycompany.lw2.HighwayWorld.Car.CarPresenter;
import com.mycompany.lw2.HighwayWorld.TrafficLight.TrafficLight;
import com.mycompany.lw2.HighwayWorld.TrafficLight.TrafficLightPresenter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class WorldPresenter extends Application{
    
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        
        Rectangle ground = new Rectangle(0,500, 800, 100);
        ground.setFill(Color.GREEN);
        root.getChildren().add(ground);
        
        Car car = new Car();
        car.setType(Car.CarType.TRACTOR);
        car.setColor(Car.CarColor.MAGENTA);
        car.setSpeed(200);
        CarPresenter carPresenter = new CarPresenter(car, 500, 800);
        carPresenter.show(root);
        
        TrafficLight trafficLight = new TrafficLight();
        TrafficLightPresenter trafficLightPresenter = new TrafficLightPresenter(trafficLight, 450, 500);
        trafficLightPresenter.show(root);
        
        stage.setScene(scene);
        stage.show();
        
        Timeline timelineOne = new Timeline();
        timelineOne.getKeyFrames().add(new KeyFrame(Duration.millis(10), (ActionEvent event) -> {
            root.getChildren().clear();
            root.getChildren().add(ground);
            if(trafficLight.getColor() == TrafficLight.TrafficLightColor.RED
                    && carPresenter.getCarWorldPositionX() < trafficLightPresenter.getTrafficLightWorldPositionX()
                    && carPresenter.getCarWorldPositionX()+car.getWidth() +5 
                        > trafficLightPresenter.getTrafficLightWorldPositionX()
                    
                    ||  trafficLight.getColor() == TrafficLight.TrafficLightColor.YELLOW
                    && car.isStoped())
            {
                carPresenter.show(root);
                car.setStoped(true);
            }   
            else
                carPresenter.moveCar(root, 0.01);
            trafficLightPresenter.show(root);
        }));
        timelineOne.setCycleCount(Timeline.INDEFINITE);
        timelineOne.play();
        
        Timeline timelineTwo = new Timeline();
        timelineTwo.getKeyFrames().add(new KeyFrame(Duration.millis(trafficLight.getDelay()), (ActionEvent event) -> {
            root.getChildren().clear();
            root.getChildren().add(ground);
            carPresenter.show(root);
            trafficLightPresenter.changeSignal(root);
            if(trafficLight.getColor() == TrafficLight.TrafficLightColor.GREEN)
                car.setStoped(false);
        }));
        timelineTwo.setCycleCount(Timeline.INDEFINITE);
        timelineTwo.play();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
