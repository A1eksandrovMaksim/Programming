package com.mycompany.smile;


public class ConcreteObserver implements Observer{
    
    private SmileObject mySmile;

    @Override
    public void toSmile() {
        mySmile.toSmile(this);
    }

    @Override
    public void toPressNose() {
        mySmile.toPressNose(this);
    }

    @Override
    public void toOpenRightEye() {
        mySmile.toOpenRightEye(this);
    }

    @Override
    public void toCloseRightEye() {
        mySmile.toCloseRightEye(this);
    }

    @Override
    public void toOpenLeftEye() {
        mySmile.toOpenLeftEye(this);
    }

    @Override
    public void toCloseLeftEye() {
        mySmile.toCloseLeftEye(this);
    }
    
    public void setObserveableObject(SmileObject smile){
        mySmile = smile;
    }
}
