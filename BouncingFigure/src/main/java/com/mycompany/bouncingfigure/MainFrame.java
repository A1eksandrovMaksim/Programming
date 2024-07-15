package com.mycompany.bouncingfigure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

    private volatile Graphics myGraphics = null;
    private volatile boolean[][] workSpace = null;
    private final int workSpaceHeight = 300;
    private final int workSpaceWidth = 300;
    
    private ArrayList<AbstractFigure> figures;
    
    public MainFrame(){
        figures = new ArrayList<>();
        workSpace = new boolean[workSpaceWidth][workSpaceHeight];
        for(int i=0;i<workSpaceWidth;++i)
            workSpace[i] = new boolean[300];
        for(int i = 0; i<workSpaceWidth; ++i){
            workSpace[i][0] = true;
            workSpace[i][workSpaceHeight-1] = true;
        }
        for(int i = 0; i<workSpaceHeight; ++i){
            workSpace[0][i] = true;
            workSpace[workSpaceWidth-1][0] = true;
        }
                
        
        setTitle("BouncingBall");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        
        JButton startButton = new JButton("Пуск");
        startButton.addActionListener((ActionEvent e) -> {
            if(figures.isEmpty())
                return;
            figures.getLast().start();
        });
        
        JButton stopButton = new JButton("Стоп");
        stopButton.addActionListener((ActionEvent e)->{
            dispose();
        });
        
        JButton squareButton = new JButton("Квадрат");
        squareButton.addActionListener((ActionEvent e) -> {
           figures.add(new Square(269, 269, 30, 100, workSpace,  myGraphics));
        });
        
        JButton roundButton = new JButton("Круг");
        roundButton.addActionListener((ActionEvent e) -> {
           figures.add(new Ball(290, 290, 10, 100, workSpace,  myGraphics));
        });
        
        JButton starButton = new JButton("Звезда");
        starButton.addActionListener((ActionEvent e) -> {
           figures.add(new Star(270, 270, 30, 20, 100, workSpace, myGraphics));
        });
        
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                for(var f : figures)
                    f.exit();
            }
        });
        
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(squareButton);
        panel.add(roundButton);
        panel.add(starButton);
        add(panel, BorderLayout.EAST);
        setVisible(true);
        myGraphics = getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        myGraphics.setColor(Color.WHITE);
        myGraphics.fillRect(10, 35, 300, 300);
        myGraphics.setColor(Color.BLACK);
        myGraphics.drawRect(10, 35, 300, 300);
    }
    
    
    
    
    
}
