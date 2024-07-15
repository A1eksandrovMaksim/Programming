package com.mycompany.patterns.strategy;

import java.util.HashMap;



public class SecondSearchStrategy implements SearchStrategy{
    
    @Override
    public HashMap<Integer, Integer> search(int[] array) {
        
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        
        for(int i = array.length-1; i >= 0; --i){
            
            if(resultMap.containsKey(array[i]))
                resultMap.put(array[i], resultMap.get(array[i]) + 1);
            else
                resultMap.put(array[i], 1);
                
        }
        
        return resultMap;
    }
    
}
