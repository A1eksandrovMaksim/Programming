package com.mycompany.stickmanapplication;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    private State myState;
    private Graphics myGraphics;
    
    public MainFrame(State initialState){
        myState = initialState;
        
        setSize(400, 300);
        setLocation(300, 200);
        setTitle("StickMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JButton holidayButton = new JButton("Каникулы");
        holidayButton.setSize(20, 93);
        holidayButton.addActionListener((ActionEvent e) -> {
            beginHolidays();
        });
        JButton semesterButton = new JButton("Семестр");
        semesterButton.setSize(20, 93);
        semesterButton.addActionListener((ActionEvent e) -> {
            beginSemester();
        });
        JButton sessionButton = new JButton("Сессия");
        sessionButton.setSize(20, 93);
        sessionButton.addActionListener((ActionEvent e) -> {
            beginSession();
        });
        panel.add(semesterButton);
        panel.add(sessionButton);
        panel.add(holidayButton);
        add(panel, BorderLayout.EAST);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() +" "+ e.getY());
            }
        });
        
        setVisible(true);
        myGraphics = getGraphics();
    }
    
    
    
    public void beginSemester(){
        myState.doDuringSemester(myGraphics, this);
    }
    public void beginSession(){
        myState.doDuringSession(myGraphics, this);
    }
    public void beginHolidays(){
        myState.doDuringHolidays(myGraphics, this);
    }
    
    public void setState(State newState){
        myState = newState;
    }
    
}
