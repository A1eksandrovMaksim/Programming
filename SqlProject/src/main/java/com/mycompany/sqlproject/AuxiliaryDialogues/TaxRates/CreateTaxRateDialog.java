package com.mycompany.sqlproject.AuxiliaryDialogues.TaxRates;

import com.mycompany.sqlproject.DAOs.TaxRatesDAO;
import com.mycompany.sqlproject.util.BoxlayoutUtils;
import com.mycompany.sqlproject.util.ConnectionManager;
import com.mycompany.sqlproject.util.GUITools;
import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.Date;
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


public class CreateTaxRateDialog extends JDialog{
    public CreateTaxRateDialog(JFrame parent){
        super(parent, "Создание процентной ставки", true);
        getContentPane().add(createGUI());
        pack();
        setLocation(parent.getX()+270, parent.getY()+150);
        setVisible(true);
    }
    
    public JTextField initPriceField, finalPriceField, dateField, taxRateField;
    public JButton okButton, cancelButton;
    
    private JPanel createGUI(){
        JPanel main = BoxlayoutUtils.createVerticalPanel();
        main.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        
        JPanel initPrice = BoxlayoutUtils.createHorizontalPanel();
        JLabel initPriceLabel = new JLabel("Начальная цена: ");
        initPrice.add(initPriceLabel);
        initPrice.add(Box.createHorizontalStrut(12));
        initPriceField = new JTextField(25);
        initPrice.add(initPriceField);
        
        JPanel finalPrice = BoxlayoutUtils.createHorizontalPanel();
        JLabel finalPriceLabel = new JLabel("Конечная цена: ");
        finalPrice.add(finalPriceLabel);
        finalPrice.add(Box.createHorizontalStrut(12));
        finalPriceField = new JTextField(25); 
        finalPrice.add(finalPriceField);
        
        JPanel taxRate = BoxlayoutUtils.createHorizontalPanel();
        JLabel taxRateLabel = new JLabel("Процентная ставка: ");
        taxRate.add(taxRateLabel);
        taxRate.add(Box.createHorizontalStrut(12));
        taxRateField = new JTextField(25); 
        taxRate.add(taxRateField);
        
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
                new JComponent[]{initPrice, finalPrice, taxRate, main, flow},
                    LEFT_ALIGNMENT);
        BoxlayoutUtils.setGroupAligmentY(
                new JComponent[]{initPriceField, finalPriceField, initPriceLabel, finalPriceLabel},
                    CENTER_ALIGNMENT);
        GUITools.makeSomeSize(new JComponent[]{initPriceLabel, initPriceLabel});
        GUITools.createRecommendedMargin(new JButton[]{okButton, cancelButton});
        GUITools.fixTextFieldSize(initPriceField);
        GUITools.fixTextFieldSize(finalPriceField);
        GUITools.fixTextFieldSize(taxRateField);
        
        main.add(initPrice);
        main.add(Box.createVerticalStrut(12));
        main.add(finalPrice);
        main.add(Box.createVerticalStrut(12));
        main.add(taxRate);
        main.add(flow);
        return main;
    }
    class OkButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(!isCorrectData())
                return;
            
            try(Connection c = ConnectionManager.open()){
                int res = new TaxRatesDAO().insert(new Object[]{
                    initPriceField.getText().replaceAll(",", "."),
                    finalPriceField.getText().replaceAll(",", "."),
                    new java.sql.Date(new Date().getTime()),
                    taxRateField.getText().replaceAll(",", ".")
                });
                JOptionPane.showMessageDialog(CreateTaxRateDialog.this, "Было затронуто "+res+" строк!");
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(CreateTaxRateDialog.this, ex.getMessage());
            }
        }
        
        private boolean isCorrectData(){
            try{
                double initPrice = Double.parseDouble(initPriceField.getText());
                double finalPrice = Double.parseDouble(finalPriceField.getText());
                double tax = Double.parseDouble(taxRateField.getText());
                
                if(initPrice<0 || finalPrice<0)
                    return false;
                if(initPrice >= finalPrice)
                    return false;
                if(tax<0)
                    return false;
            }catch(NumberFormatException ex){
                return false;
            }
            return true;
        }
    }
}
