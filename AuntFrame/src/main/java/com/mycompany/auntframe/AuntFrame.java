
package com.mycompany.auntframe;

import com.mycompany.auntframe.BoxlayoutUtils;
import com.mycompany.auntframe.GUITools;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuntFrame extends JDialog{
    
    public AuntFrame(JFrame parant){
        super(parant, "Вход в систему");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                dispose();
                System.exit(0);
            }
        });
        getContentPane().add(createGUI());
        pack();
        setVisible(true);
    }
    
    public JTextField nameField, passwordField;
    public JButton okButton, cancelButton;
    
    private JPanel createGUI(){
        JPanel main = BoxlayoutUtils.createVerticalPanel();
        main.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        JPanel name = BoxlayoutUtils.createHorizontalPanel();
        JLabel nameLabel = new JLabel("Name: ");
        name.add(nameLabel);
        name.add(Box.createHorizontalStrut(12));
        nameField = new JTextField(25);
        name.add(nameField);
        JPanel password = BoxlayoutUtils.createHorizontalPanel();
        JLabel passwrdLabel = new JLabel("Password: ");
        password.add(passwrdLabel);
        password.add(Box.createHorizontalStrut(12));
        passwordField = new JTextField(15); 
        password.add(passwordField);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0));
        okButton = new JButton("OK");
        cancelButton = new JButton("CANCEL");
        grid.add(okButton);
        grid.add(cancelButton);
        flow.add(grid);
        
        BoxlayoutUtils.setGroupAligmentX(
                new JComponent[]{name, password, main, flow},
                    LEFT_ALIGNMENT);
        BoxlayoutUtils.setGroupAligmentY(
                new JComponent[]{nameField, passwordField, nameLabel, passwrdLabel},
                    CENTER_ALIGNMENT);
        GUITools.makeSomeSize(new JComponent[]{nameLabel, passwrdLabel});
        GUITools.createRecommendedMargin(new JButton[]{okButton, cancelButton});
        GUITools.fixTextFieldSize(nameField);
        GUITools.fixTextFieldSize(passwordField);
        
        main.add(name);
        main.add(Box.createVerticalStrut(12));
        main.add(password);
        main.add(Box.createVerticalStrut(12));
        main.add(flow);
        return main;
    }
        
    
    
    

    public static void main(String[] args) {
        new AuntFrame(new JFrame());
    }
}
