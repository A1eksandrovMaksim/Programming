package com.mycompany.sqlproject.util;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


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
    
    
    
    public static void alignTable(JTable table){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        //int maxColumnWidth = 0;
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
//            int headerWidth = columnModel.getColumn(i).getHeaderValue().toString().length() * 10;
//            if (headerWidth > maxColumnWidth)
//                maxColumnWidth = headerWidth;
        }
//        for (int i = 0; i < columnModel.getColumnCount(); i++)
//            columnModel.getColumn(i).setMinWidth(maxColumnWidth);
    }
}
