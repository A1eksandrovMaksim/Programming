/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sqlproject;

import com.mycompany.sqlproject.Frames.AuntDialog;
import com.mycompany.sqlproject.Frames.MainFrame;

/**
 *
 * @author Maksim
 */
public class SqlProject {
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        new AuntDialog(mf);
    }
}
