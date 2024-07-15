package com.mycompany.smile;


public class Smile {
    public static void main(String[] args) {
        SmileObject smile = new SmileObject();
        ConcreteObserver co = new ConcreteObserver();
        co.setObserveableObject(smile);
        smile.addObserver(co);
        Observer smileView = new SmileView(co);
        smile.addObserver(smileView);
    }
}
