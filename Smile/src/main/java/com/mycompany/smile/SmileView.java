package com.mycompany.smile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class SmileView extends JFrame
        implements Observer, MouseListener {

    private Observer myObserver;

    private MyEyeComponent leftEyeComponent;
    private MyEyeComponent rightEyeComponent;
    private MyBodyComponent bodyComponent;
    private MyNoseComponent noseComponent;
    private MyMouthComponent mouthComponent;

    public SmileView(Observer observer) {
        this.myObserver = observer;
        setSize(300, 300);
        setLocation(400, 300);
        setTitle("Smile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bodyComponent = new MyBodyComponent();
        leftEyeComponent = new MyEyeComponent(80, 80);
        rightEyeComponent = new MyEyeComponent(175, 80);
        noseComponent = new MyNoseComponent();
        mouthComponent = new MyMouthComponent();

        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        bodyComponent.paint(g);
        leftEyeComponent.paint(g);
        rightEyeComponent.paint(g);
        noseComponent.paint(g);
        mouthComponent.paint(g);
    }

    @Override
    public void toSmile() {
        mouthComponent.toSmile();
    }

    @Override
    public void toPressNose() {
        noseComponent.toPressNose();
    }

    @Override
    public void toOpenRightEye() {
        rightEyeComponent.toOpen();
    }

    @Override
    public void toCloseRightEye() {
        rightEyeComponent.toClose();
    }

    @Override
    public void toOpenLeftEye() {
        leftEyeComponent.toOpen();
    }

    @Override
    public void toCloseLeftEye() {
        leftEyeComponent.toClose();
    }

    public class MyBodyComponent extends JComponent {

        @Override
        public void paint(Graphics g) {
            Color oldColor = g.getColor();
            g.setColor(new Color(255, 215, 0));
            g.fillOval(22, 32, 260, 260);
            g.setColor(oldColor);
        }

    }

    public class MyMouthComponent extends JComponent {

        private boolean isSmiling = false;

        public void toSmile() {
            isSmiling = true;
        }

        @Override
        public void paint(Graphics g) {
            if (isSmiling) {
                paintSmilingMouth(g);
            } else {
                paintSmimpleMouth(g);
            }
        }

        private void paintSmilingMouth(Graphics g) {
            Color oldColor = g.getColor();

            g.setColor(Color.WHITE);
            g.fillArc(80, 170, 140, 70, 0, -180);

            g.setColor(oldColor);
        }

        private void paintSmimpleMouth(Graphics g) {
            Color oldColor = g.getColor();

            g.setColor(Color.BLACK);
            g.drawLine(100, 210, 210, 210);

            g.setColor(oldColor);
        }

    }

    public class MyNoseComponent extends JComponent {

        private Color noseColor = Color.black;

        public void toPressNose() {
            noseColor = new Color(128, 0, 128);
        }

        public void toReleseNose() {
            noseColor = Color.BLACK;
        }

        @Override
        public void paint(Graphics g) {
            Color oldColor = g.getColor();

            g.setColor(noseColor);
            g.fillOval(124, 130, 60, 50);

            g.setColor(oldColor);
        }

    }

    public class MyEyeComponent extends JComponent {

        private final int X;
        private final int Y;

        private boolean isClosed = true;

        public boolean isIsClosed() {
            return isClosed;
        }

        public MyEyeComponent(int x, int y) {
            this.X = x;
            this.Y = y;
        }

        public void toClose() {
            isClosed = true;
        }

        public void toOpen() {
            isClosed = false;
        }

        @Override
        public void paint(Graphics g) {
            if (isClosed) {
                paintCloseEye(g);
            } else {
                paintOpenEye(g);
            }
        }

        public void paintOpenEye(Graphics g) {
            Color oldColor = g.getColor();

            g.setColor(Color.WHITE);
            g.fillOval(X, Y, 50, 60);
            g.setColor(Color.BLACK);
            g.fillOval(X + 5, Y + 10, 40, 40);

            g.setColor(oldColor);
        }

        public void paintCloseEye(Graphics g) {
            Color oldColor = g.getColor();

            g.setColor(Color.BLACK);
            g.fillOval(X, Y + 30, 50, 10);

            g.setColor(oldColor);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (x > 81 && x < 126 && y > 98 && y < 127) {
            if (leftEyeComponent.isIsClosed()) {
                myObserver.toOpenLeftEye();
            } else {
                myObserver.toCloseLeftEye();
            }
        }
        
        if (x > 174 && x < 223 && y > 98 && y < 130) {
            if (rightEyeComponent.isIsClosed()) {
                myObserver.toOpenRightEye();
            } else {
                myObserver.toCloseRightEye();
            }
        }
        
        if (x > 132 && x < 174 && y > 138 && y < 170) {
            myObserver.toPressNose();
        }
        
        if (x > 79 && x < 215 && y > 194 && y < 240) {
            myObserver.toSmile();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
