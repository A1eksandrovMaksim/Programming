package com.mycompany.sqlproject.Panels;

import com.mycompany.sqlproject.DatabaseTableModel;
import com.mycompany.sqlproject.util.ConnectionManager;
import com.mycompany.sqlproject.util.GUITools;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ParamRequestPanel extends JPanel {
    private JFrame mainFrame;
    private DatabaseTableModel tableModel = null;
    private JTable table = null;
    private JTextArea textArea;
    private JTextField paramField_1,
            paramField_2,
            paramField_3,
            paramField_4,
            paramField_5,
            paramField_6,
            paramField_7;
    
    public ParamRequestPanel(JFrame mainFrame){
        this.mainFrame = mainFrame;
        tableModel = new DatabaseTableModel(false);
        this.setLayout(new BorderLayout());
        
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(600);
        textArea = new JTextArea();
        textArea.setMinimumSize(new Dimension(300, 300));
        textArea.setMaximumSize(new Dimension(300, 300));
        textArea.setPreferredSize(new Dimension(300, 300));
        splitPane.setLeftComponent(new JScrollPane(textArea));
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        JButton requestButton = new JButton("Выполнить запрос");
        requestButton.addActionListener((e)->{
            setTableData();
            GUITools.alignTable(table);
        });
        
        JPanel paramPanel_1 = new JPanel();
        paramPanel_1.setLayout(new BoxLayout(paramPanel_1, BoxLayout.X_AXIS));
        JLabel paramlabel_1 = new JLabel("Первый параметр: ");
        paramField_1 = new JTextField(15);
        paramPanel_1.add(paramlabel_1);
        paramPanel_1.add(Box.createHorizontalStrut(12));
        paramPanel_1.add(paramField_1);
        
        JPanel paramPanel_2 = new JPanel();
        paramPanel_2.setLayout(new BoxLayout(paramPanel_2, BoxLayout.X_AXIS));
        JLabel paramlabel_2 = new JLabel("Второй параметр: ");
        paramField_2 = new JTextField(15);
        paramPanel_2.add(paramlabel_2);
        paramPanel_2.add(Box.createHorizontalStrut(12));
        paramPanel_2.add(paramField_2);
        
        JPanel paramPanel_3 = new JPanel();
        paramPanel_3.setLayout(new BoxLayout(paramPanel_3, BoxLayout.X_AXIS));
        JLabel paramlabel_3 = new JLabel("Третий параметр: ");
        paramField_3 = new JTextField(15);
        paramPanel_3.add(paramlabel_3);
        paramPanel_3.add(Box.createHorizontalStrut(12));
        paramPanel_3.add(paramField_3);
        
        JPanel paramPanel_4 = new JPanel();
        paramPanel_4.setLayout(new BoxLayout(paramPanel_4, BoxLayout.X_AXIS));
        JLabel paramlabel_4 = new JLabel("Четвертый параметр: ");
        paramField_4 = new JTextField(15);
        paramPanel_4.add(paramlabel_4);
        paramPanel_4.add(Box.createHorizontalStrut(12));
        paramPanel_4.add(paramField_4);
        
        JPanel paramPanel_5 = new JPanel();
        paramPanel_5.setLayout(new BoxLayout(paramPanel_5, BoxLayout.X_AXIS));
        JLabel paramlabel_5 = new JLabel("Пятый параметр: ");
        paramField_5 = new JTextField(15);
        paramPanel_5.add(paramlabel_5);
        paramPanel_5.add(Box.createHorizontalStrut(12));
        paramPanel_5.add(paramField_5);
        
        JPanel paramPanel_6 = new JPanel();
        paramPanel_6.setLayout(new BoxLayout(paramPanel_6, BoxLayout.X_AXIS));
        JLabel paramlabel_6 = new JLabel("Шестой параметр: ");
        paramField_6 = new JTextField(15);
        paramPanel_6.add(paramlabel_6);
        paramPanel_6.add(Box.createHorizontalStrut(12));
        paramPanel_6.add(paramField_6);
        
        JPanel paramPanel_7 = new JPanel();
        paramPanel_7.setLayout(new BoxLayout(paramPanel_7, BoxLayout.X_AXIS));
        JLabel paramlabel_7 = new JLabel("Седьмой параметр: ");
        paramField_7 = new JTextField(15);
        paramPanel_7.add(paramlabel_7);
        paramPanel_7.add(Box.createHorizontalStrut(12));
        paramPanel_7.add(paramField_7);
        
        
        GUITools.fixTextFieldSize(paramField_1);
        GUITools.fixTextFieldSize(paramField_2);
        GUITools.fixTextFieldSize(paramField_3);
        GUITools.fixTextFieldSize(paramField_4);
        GUITools.fixTextFieldSize(paramField_5);
        GUITools.fixTextFieldSize(paramField_6);
        GUITools.fixTextFieldSize(paramField_7);
        
        rightPanel.add(requestButton);
        rightPanel.add(Box.createVerticalStrut(17));
        rightPanel.add(paramPanel_1);
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(paramPanel_2);
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(paramPanel_3);
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(paramPanel_4);
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(paramPanel_5);
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(paramPanel_6);
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(paramPanel_7);
        rightPanel.add(Box.createVerticalGlue());
        
        splitPane.setRightComponent(rightPanel);
        
        table = new JTable(tableModel);
        GUITools.alignTable(table);
        mainSplitPane.setBottomComponent(new JScrollPane(table));
        mainSplitPane.setTopComponent(splitPane);
        add(mainSplitPane, BorderLayout.CENTER);
    }
    
    public void setTableData(){
        String queryString = "";
        
        Integer paramId = 0;
        for(char c : textArea.getText().toCharArray()){
            if(c != '?')
                queryString += c;
            else{
                if(++paramId > 7){
                    JOptionPane.showMessageDialog(mainFrame, "Неверное число параметров!");
                    return;
                }else{
                    queryString += switch(paramId){
                        case 1 -> paramField_1.getText();
                        case 2 -> paramField_2.getText();
                        case 3 -> paramField_3.getText();
                        case 4 -> paramField_4.getText();
                        case 5 -> paramField_5.getText();
                        case 6 -> paramField_6.getText();
                        case 7 -> paramField_7.getText();
                        default -> "";
                    };
                }
            }
        }
        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(queryString)){
            tableModel.setDataSource(rs);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(mainFrame, "Ошибка при обращении к базе данных!\n"+ex.getMessage());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(mainFrame, "Ошибка при выводе данных в таблицу!\n"+ex.getMessage());
        }
    }
}
