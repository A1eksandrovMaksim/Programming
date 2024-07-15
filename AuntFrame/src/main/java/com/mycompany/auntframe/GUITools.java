package com.mycompany.auntframe;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;


public class GUITools {
    public static void createRecommendedMargin(JButton[] buttons){
        for(var b : buttons){
            Insets margin = b.getMargin();
            margin.left = 12;
            margin.right = 12;
            b.setMargin(margin);
        }  
    }
    
    public static void makeSomeSize(JComponent[] components){
        int[] sizes = new int[components.length];
        for(int i=0; i < sizes.length; ++i)
            sizes[i] = components[i].getPreferredSize().width;
        int maxSizePos = maxElementPosition(sizes);
        Dimension maxSize = components[maxSizePos].getPreferredSize();
        for(var c : components){
            c.setPreferredSize(maxSize);
            c.setMinimumSize(maxSize);
            c.setMaximumSize(maxSize);
        }
            
        
    }
    
    public static void fixTextFieldSize(JTextField field) {
        Dimension size = field.getPreferredSize();
        size.width = field.getMaximumSize().width;
        field.setMaximumSize(size);
    }
    
    private static int maxElementPosition(int[] array) {
        int maxPos=0;
        for (int i=1; i < array.length; i++)
            if (array[i] > array[maxPos])
                maxPos = i;
        return maxPos;
    } 
}
