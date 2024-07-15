package com.mycompany.sqlproject.AuxiliaryDialogues.Buildings;

import com.mycompany.sqlproject.DAOs.BuildingsDAO;
import com.mycompany.sqlproject.util.BoxlayoutUtils;
import com.mycompany.sqlproject.util.ConnectionManager;
import com.mycompany.sqlproject.util.GUITools;
import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CreateBuildingDialog extends JDialog{
    public CreateBuildingDialog(JFrame parent){
        super(parent, "Создание строения", true);
        getContentPane().add(createGUI());
        pack();
        setLocation(parent.getX()+270, parent.getY()+150);
        setVisible(true);
    }
    
    public JTextField regNumField, placeField, numOfFloorsField, yearField, mounthField, dayField;
    public JButton okButton, cancelButton;
    
    private JPanel createGUI(){
        JPanel main = BoxlayoutUtils.createVerticalPanel();
        main.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        
        JPanel regNumPanel = BoxlayoutUtils.createHorizontalPanel();
        JLabel regNumLabel = new JLabel("Регистрационный номер: ");
        regNumPanel.add(regNumLabel);
        regNumPanel.add(Box.createHorizontalStrut(12));
        regNumField = new JTextField(25);
        regNumPanel.add(regNumField);
        
        JPanel placePanel = BoxlayoutUtils.createHorizontalPanel();
        JLabel placeLabel = new JLabel("Прощадь: ");
        placePanel.add(placeLabel);
        placePanel.add(Box.createHorizontalStrut(12));
        placeField = new JTextField(25);
        placePanel.add(placeField);
        
        JPanel numOfFloorsPanel = BoxlayoutUtils.createHorizontalPanel();
        JLabel numOfFloorsLabel = new JLabel("Количество этажей: ");
        numOfFloorsPanel.add(numOfFloorsLabel);
        numOfFloorsPanel.add(Box.createHorizontalStrut(12));
        numOfFloorsField = new JTextField(25);
        numOfFloorsPanel.add(numOfFloorsField);
        
        JPanel dateOfConstructionPanel = BoxlayoutUtils.createHorizontalPanel();
        JLabel yearLabel = new JLabel("Год: ");
        dateOfConstructionPanel.add(yearLabel);
        dateOfConstructionPanel.add(Box.createHorizontalStrut(12));
        yearField = new JTextField(4);
        dateOfConstructionPanel.add(yearField);
        dateOfConstructionPanel.add(Box.createHorizontalStrut(17));
        JLabel mounthLabel = new JLabel("Месяц: ");
        dateOfConstructionPanel.add(mounthLabel);
        dateOfConstructionPanel.add(Box.createHorizontalStrut(12));
        mounthField = new JTextField(2);
        dateOfConstructionPanel.add(mounthField);
        dateOfConstructionPanel.add(Box.createHorizontalStrut(17));
        JLabel dayLabel = new JLabel("День: ");
        dateOfConstructionPanel.add(dayLabel);
        dateOfConstructionPanel.add(Box.createHorizontalStrut(12));
        dayField = new JTextField(2);
        dateOfConstructionPanel.add(dayField);
        
        
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0));
        okButton = new JButton("OK");
        okButton.addMouseListener(new OkButtonListener());
        cancelButton = new JButton("CANCEL");
        cancelButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        grid.add(okButton);
        grid.add(cancelButton);
        flow.add(grid);
        
        BoxlayoutUtils.setGroupAligmentX(
                new JComponent[]{regNumPanel, placePanel, numOfFloorsPanel, dateOfConstructionPanel, main, flow},
                    LEFT_ALIGNMENT);
        BoxlayoutUtils.setGroupAligmentY(
                new JComponent[]{regNumLabel, regNumField, placeLabel, placeField, numOfFloorsLabel, numOfFloorsField,
                                    yearLabel, yearField, mounthLabel, mounthField, dayLabel, dayField},
                    CENTER_ALIGNMENT);
        GUITools.makeSomeSize(new JComponent[]{regNumLabel, placeLabel, numOfFloorsLabel, yearLabel, mounthLabel, dayLabel});
        GUITools.createRecommendedMargin(new JButton[]{okButton, cancelButton});
        GUITools.fixTextFieldSize(regNumField);
        GUITools.fixTextFieldSize(placeField);
        GUITools.fixTextFieldSize(numOfFloorsField);
        GUITools.fixTextFieldSize(yearField);
        GUITools.fixTextFieldSize(mounthField);
        GUITools.fixTextFieldSize(dayField);
        
        main.add(regNumPanel);
        main.add(Box.createVerticalStrut(12));
        main.add(placePanel);
        main.add(Box.createVerticalStrut(12));
        main.add(numOfFloorsPanel);
        main.add(Box.createVerticalStrut(12));
        main.add(dateOfConstructionPanel);
        main.add(flow);
        return main;
    }
    class OkButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(!isCorrectData())
                return;
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(yearField.getText()),
                        Integer.parseInt(mounthField.getText()),
                        Integer.parseInt(dayField.getText()));
            
            try(Connection c = ConnectionManager.open()){
                
                int res = new BuildingsDAO().insert(new Object[]{
                    regNumField.getText(),
                    placeField.getText().replaceAll(",", "."),
                    numOfFloorsField.getText(),
                    new java.sql.Date(calendar.getTime().getTime())
                });
                JOptionPane.showMessageDialog(CreateBuildingDialog.this, "Было затронуто "+res+" строк!");
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(CreateBuildingDialog.this, ex.getMessage());
            }
        }
        
        private boolean isCorrectData(){
            try{
                int regNum = Integer.valueOf(regNumField.getText());
                int numOfFloors = Integer.valueOf(numOfFloorsField.getText());
                int place = Integer.valueOf(placeField.getText());
                int year = Integer.valueOf(yearField.getText());
                int mounth = Integer.valueOf(mounthField.getText());
                int day = Integer.valueOf(dayField.getText());
                
                if(regNum<0 || numOfFloors<1 || place<1 || year<1800 || mounth<1 || day<1)
                    return false;
            }catch(NumberFormatException ex){
                return false;
            }
            return true;
        }
    }
}
