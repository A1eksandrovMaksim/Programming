/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.patterns.strategy;

import java.util.HashMap;

/**
 *
 * @author Maksim
 */
public interface SearchStrategy {
    
    public HashMap<Integer, Integer> search(int[] array);
    
}
