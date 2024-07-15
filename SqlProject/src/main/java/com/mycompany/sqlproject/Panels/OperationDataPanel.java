/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sqlproject.Panels;

import com.mycompany.sqlproject.AuxiliaryDialogues.Buildings.CreateBuildingDialog;
import com.mycompany.sqlproject.AuxiliaryDialogues.Buildings.UpdateBuildingDialog;
import com.mycompany.sqlproject.DAOs.BuildingsDAO;
import com.mycompany.sqlproject.DAOs.ObjectDAO;
import com.mycompany.sqlproject.DatabaseTableModel;
import com.mycompany.sqlproject.Frames.MainFrame;
import com.mycompany.sqlproject.util.GUITools;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

/**
 *
 * @author Maksim
 */
public class OperationDataPanel extends JPanel{
    private DatabaseTableModel tableModel = null;
    private JTable table = null;
    private DataType dataType;
    private MainFrame mainFrame;
    
    public OperationDataPanel(MainFrame mainFrame, DataType dataType){
        this.mainFrame = mainFrame;
        this.dataType = dataType;
        
        setLayout(new BorderLayout());
        
        tableModel = new DatabaseTableModel(false);
        setTableData();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(780);
        table = new JTable(tableModel);
        GUITools.alignTable(table);
        splitPane.setLeftComponent(new JScrollPane(table));
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        JButton createButton = new JButton("Создать");
        createButton.addActionListener(new CreateButtonListener());
        JButton updateButton = new JButton("Изменить");
        updateButton.addActionListener(new UpdateButtonListener());
        JButton deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(new DeleteButtonListener());
        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(createButton);
        buttonsPanel.add(Box.createVerticalStrut(12));
        buttonsPanel.add(updateButton);
        buttonsPanel.add(Box.createVerticalStrut(12));
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(Box.createVerticalGlue());
        splitPane.setRightComponent(buttonsPanel);
        add(splitPane, BorderLayout.CENTER);
        
        Dimension d = new Dimension(100, 30);
        updateButton.setPreferredSize(d);
        updateButton.setMinimumSize(d);
        
        GUITools.makeSomeSize(new JButton[]{
            updateButton,
            createButton,
            deleteButton
        });
    }
    
    private class CreateButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(dataType){
                case Buildings -> new CreateBuildingDialog(mainFrame);
            }
            setTableData();
            GUITools.alignTable(table);
        }
    }
    
    private class UpdateButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(table.getSelectedRow() == -1)
                return;
            int selectedRow = table.getSelectedRow();
            switch(dataType){
                case Buildings -> new UpdateBuildingDialog(mainFrame,
                                        table.getValueAt(selectedRow, 0).toString(),
                                        table.getValueAt(selectedRow, 1).toString(),
                                        table.getValueAt(selectedRow, 2).toString(),
                                        table.getValueAt(selectedRow, 3).toString());
            }
            setTableData();
            GUITools.alignTable(table);
        }
    }
    
     private class DeleteButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                for(int rowId : table.getSelectedRows()){
                    switch(dataType){
                        case Buildings -> new BuildingsDAO().delete(new Object[]{table.getValueAt(rowId, 0).toString(),
                                                table.getValueAt(rowId, 1).toString(),
                                                table.getValueAt(rowId, 2).toString(),
                                                table.getValueAt(rowId, 3).toString()});
                    }
                }
                setTableData();
            GUITools.alignTable(table);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(mainFrame, ex);
            }
        }
    }
    
    public void setTableData(){
        try{
            ObjectDAO dao = switch(dataType){
                case DataType.Buildings -> new BuildingsDAO();
                default -> new BuildingsDAO();
            };

            dao.selectAllAndInsertIntoTable(tableModel);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(mainFrame, ex.getMessage());
        }
    }
    
    public enum DataType{
        Auctions,
        Buildings,
        Buyers
    }
}
