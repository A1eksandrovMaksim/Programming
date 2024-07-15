package com.mycompany.sqlproject.Panels;

import com.mycompany.sqlproject.Beans.BuildingBean;
import com.mycompany.sqlproject.Frames.MainFrame;
import com.mycompany.sqlproject.JasperReportsGenerator;
import com.mycompany.sqlproject.util.ConnectionManager;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;


public class ReportsPanel extends JPanel{
    private final String[] patterns = new String[]{"Шаблон \"Отчет по ставкам\"", "Шаблон \"Отчет по зданиям\""};
    private MainFrame mainFrame;
    public ReportsPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel choosePatternLabel = new JLabel("Выберите шаблон: ");
        JComboBox patternsList = new JComboBox(this.patterns);
        patternsList.setMinimumSize(new Dimension(200, 20));
        patternsList.setMaximumSize(new Dimension(200, 20));
        patternsList.setPreferredSize(new Dimension(200, 20));
        JButton createReportButton = new JButton("Создать отчет");
        createReportButton.addActionListener(new ReportButtonListener());
        panel.add(choosePatternLabel);
        panel.add(Box.createHorizontalStrut(12));
        panel.add(patternsList);
        panel.add(Box.createHorizontalStrut(12));
        panel.add(createReportButton);
        panel.add(Box.createRigidArea(new Dimension(10, 100)));
        add(panel);
    }
    
    private class ReportButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from building")){
                
                ArrayList<BuildingBean> list = new ArrayList<>();
                
                while(rs.next()){
                    String regNumString = rs.getObject(1).toString();
                    String placeString = rs.getObject(2).toString();
                    String numOfFloorsString = rs.getObject(3).toString();
                    String dateString = rs.getObject(4).toString();
                    list.add(new BuildingBean(regNumString, placeString, numOfFloorsString, dateString));
                }
                
                JasperReportsGenerator.generatePdfReport(list);
                
                JOptionPane.showMessageDialog(mainFrame, "Отчет создан");
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(mainFrame, "Ошибка при обращении к базе данных!\n"+ex.getMessage());
            }catch(JRException ex){
                JOptionPane.showMessageDialog(mainFrame, "Ошибка при формирования отчета!\n"+ex.getMessage());
            }catch(Exception ex){
                JOptionPane.showMessageDialog(mainFrame, "Ошибка при выводе данных в таблицу!\n"+ex.getMessage());
            }
        }
    }
}
