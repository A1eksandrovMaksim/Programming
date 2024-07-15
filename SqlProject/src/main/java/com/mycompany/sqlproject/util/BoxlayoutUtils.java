package com.mycompany.sqlproject.util;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class BoxlayoutUtils {
    public static JPanel createVerticalPanel(){
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            return panel;
        }
        
        public static JPanel createHorizontalPanel(){
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            return panel;
        }
        
        public static void setGroupAligmentX(JComponent[] cs, float aligment){
            for(var v : cs)
                v.setAlignmentX(aligment);
        }
        
        public static void setGroupAligmentY(JComponent[] cs, float aligment){
            for(var v : cs)
                v.setAlignmentY(aligment);
        }
}
