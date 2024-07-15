package com.mycompany.stickmanapplication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class HolidaysState implements State{

    @Override
    public void doDuringSemester(Graphics g, MainFrame mainFrame) {
        mainFrame.setState(new SemesterState());
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 300, 300);
        g.setColor(Color.BLACK);
        g.fillOval(7, 247, 30, 30);
        g.fillRoundRect(31, 270, 100, 20, 10, 50);
        g.fillRoundRect(131, 280, 100, 10, 10, 50);
    }

    @Override
    public void doDuringSession(Graphics g, MainFrame mainFrame) {
        mainFrame.setState(new SessionState());
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 300, 300);
        g.setColor(Color.BLACK);
        g.fillOval(265, 165, 30, 30);
        g.fillRoundRect(280, 190, 20, 100, 10, 50);
        g.fillRoundRect(200, 280, 100, 10, 10, 50);
        Polygon p = new Polygon();
        p.addPoint(286, 198);
        p.addPoint(293, 203);
        p.addPoint(263, 218);
        p.addPoint(268, 188);
        p.addPoint(274, 188);
        p.addPoint(270, 208);
        p.addPoint(286, 198);
        g.fillPolygon(p);
    }
    
}
