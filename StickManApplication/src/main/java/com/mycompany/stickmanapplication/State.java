package com.mycompany.stickmanapplication;

import java.awt.Graphics;

public interface State {
    public default void doDuringSemester(Graphics g, MainFrame mainFrame){};
    public default void doDuringSession(Graphics g, MainFrame mainFrame){};
    public default void doDuringHolidays(Graphics g, MainFrame mainFrame){};
}
