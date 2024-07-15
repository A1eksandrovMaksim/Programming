
package com.mycompany.sqlproject.Frames;

import com.mycompany.sqlproject.util.BoxlayoutUtils;
import com.mycompany.sqlproject.util.GUITools;
import com.mycompany.sqlproject.util.ConnectionManager;

import java.sql.Connection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AuntDialog extends JDialog{
    
    public AuntDialog(JFrame parent){
        super(parent, "Вход в систему", true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
                dispose();
                System.exit(0);
            }
        });
        getContentPane().add(createGUI());
        pack();
        setLocation(parent.getX()+270, parent.getY()+150);
        setVisible(true);
    }
    
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton okButton, cancelButton;
    
    
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
        passwordField = new JPasswordField(25); 
        password.add(passwordField);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0));
        okButton = new JButton("OK");
        okButton.addMouseListener(new OkButtonListener());
        cancelButton = new JButton("CANCEL");
        cancelButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                System.exit(0);
            }
        });
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
    
    class OkButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            try(Connection c = ConnectionManager.open(nameField.getText(), passwordField.getText())){
                ConnectionManager.setUsername(nameField.getText());
                ConnectionManager.setPassword(passwordField.getText());
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(AuntDialog.this, ex.getMessage());
            }
        }
    }
}
