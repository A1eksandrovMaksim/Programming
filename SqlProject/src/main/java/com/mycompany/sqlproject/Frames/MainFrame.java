package com.mycompany.sqlproject.Frames;

import com.mycompany.sqlproject.Panels.OperationDataPanel;
import com.mycompany.sqlproject.Panels.ParamRequestPanel;
import com.mycompany.sqlproject.Panels.ReferenceDataPanel;
import com.mycompany.sqlproject.Panels.ReportsPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private JPanel mainPanel = null;

    public MainFrame() {
        super("SqlProject");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setJMenuBar(createMenu());

        setLocation(300, 200);
        setSize(900, 500);
        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu referenceDataMenu = new JMenu("Справочные данные");
        JMenuItem taxRatesMenuItem = new JMenuItem("Процентные ставки");
        JMenuItem addressesMenuItem = new JMenuItem("Адреса");
        JMenuItem privatizedBuildingsMenuItem = new JMenuItem("Приватизированные здания");
        JMenuItem buildingsAtAuctionsMenuItem = new JMenuItem("Здания на аукционах");
        referenceDataMenu.add(taxRatesMenuItem);
        referenceDataMenu.add(addressesMenuItem);
        referenceDataMenu.addSeparator();
        referenceDataMenu.add(privatizedBuildingsMenuItem);
        referenceDataMenu.add(buildingsAtAuctionsMenuItem);

        JMenu operationalDataMenu = new JMenu("Оперативные данные");
        JMenuItem buildingsMenuItem = new JMenuItem("Здания");
        JMenuItem buyersMenuItem = new JMenuItem("Покупатели");
        JMenuItem auctionsMenuItem = new JMenuItem("Аукционы");
        operationalDataMenu.add(buildingsMenuItem);
        operationalDataMenu.add(buyersMenuItem);
        operationalDataMenu.add(auctionsMenuItem);

        JMenuItem requestsMenuItem = new JMenuItem("Параметрический запрос");
        JMenuItem reportsMenuItem = new JMenuItem("Отчеты");
        
        JMenu users = new JMenu("Пользователи");
        JMenuItem user1 = new JMenuItem("Пользователь 1");
        JMenuItem user2 = new JMenuItem("Пользователь 2");
        JMenuItem user3 = new JMenuItem("Пользователь 3");
        users.add(user1);
        users.add(user2);
        users.add(user3);

        menuBar.add(referenceDataMenu);
        menuBar.add(operationalDataMenu);
        menuBar.add(users);
        menuBar.add(requestsMenuItem);
        menuBar.add(reportsMenuItem);

        taxRatesMenuItem.addActionListener(new MenuListener());
        addressesMenuItem.addActionListener(new MenuListener());
        buildingsMenuItem.addActionListener(new MenuListener());
        requestsMenuItem.addActionListener(new MenuListener());
        reportsMenuItem.addActionListener(new MenuListener());

        return menuBar;
    }

    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mainPanel != null) {
                getContentPane().remove(mainPanel);
            }

            switch (((JMenuItem) e.getSource()).getText()) {
                case "Процентные ставки" -> {
                    mainPanel = new ReferenceDataPanel(MainFrame.this, ReferenceDataPanel.DataType.TaxRates);
                    getContentPane().add(mainPanel, BorderLayout.CENTER);
                }
                case "Адреса" -> {
                    mainPanel = new ReferenceDataPanel(MainFrame.this, ReferenceDataPanel.DataType.Addresses);
                    getContentPane().add(mainPanel, BorderLayout.CENTER);
                }
                case "Здания" -> {
                    mainPanel = new OperationDataPanel(MainFrame.this, OperationDataPanel.DataType.Buildings);
                    getContentPane().add(mainPanel, BorderLayout.CENTER);
                }
                case "Параметрический запрос" -> {
                    mainPanel = new ParamRequestPanel(MainFrame.this);
                    getContentPane().add(mainPanel, BorderLayout.CENTER);
                }
                case "Отчеты" -> {
                    mainPanel = new ReportsPanel(MainFrame.this);
                    getContentPane().add(mainPanel, BorderLayout.CENTER);
                }
            }
            revalidate();
        }
    }
}
