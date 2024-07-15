package com.mycompany.stickmanapplication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SemesterState implements State {

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

    @Override
    public void doDuringHolidays(Graphics g, MainFrame mainFrame) {
        mainFrame.setState(new HolidaysState());
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 300, 300);
        g.setColor(Color.BLACK);
        g.fillOval(145, 73, 30, 30);
        g.fillRoundRect(140, 100, 40, 100, 50, 50);
        Polygon rightHand = new Polygon();
        rightHand.addPoint(171, 114);
        rightHand.addPoint(175, 118);
        rightHand.addPoint(218, 72);
        rightHand.addPoint(213, 71);
        rightHand.addPoint(170, 110);
        rightHand.addPoint(171, 114);
        g.fillPolygon(rightHand);
        Polygon leftHand = new Polygon();
        leftHand.addPoint(145, 114);
        leftHand.addPoint(141, 118);
        leftHand.addPoint(98, 72);
        leftHand.addPoint(103, 71);
        leftHand.addPoint(146, 110);
        leftHand.addPoint(145, 114);
        g.fillPolygon(leftHand);
        Polygon rightLeg = new Polygon();
        rightLeg.addPoint(166, 194);
        rightLeg.addPoint(192, 290);
        rightLeg.addPoint(211, 290);
        rightLeg.addPoint(213, 287);
        rightLeg.addPoint(212, 286);
        rightLeg.addPoint(202, 284);
        rightLeg.addPoint(175, 187);
        g.fillPolygon(rightLeg);
        Polygon leftLeg = new Polygon();
        leftLeg.addPoint(153, 194);
        leftLeg.addPoint(127, 290);
        leftLeg.addPoint(108, 290);
        leftLeg.addPoint(106, 287);
        leftLeg.addPoint(107, 286);
        leftLeg.addPoint(117, 284);
        leftLeg.addPoint(144, 187);
        g.fillPolygon(leftLeg);
    }

}
