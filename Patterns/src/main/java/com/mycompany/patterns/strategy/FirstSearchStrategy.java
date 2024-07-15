package com.mycompany.patterns.strategy;

import java.util.HashMap;



public class FirstSearchStrategy implements SearchStrategy{

    @Override
    public HashMap<Integer, Integer> search(int[] array) {
        
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        
        for(int i = 0; i < array.length; ++i){
            
            if(resultMap.containsKey(array[i]))
                resultMap.put(array[i], resultMap.get(array[i]) + 1);
            else
                resultMap.put(array[i], 1);
                
        }
        
        return resultMap;
    }
}
