package com.casestudydraft.tools;

import java.util.HashMap;
import java.util.Map;

public class FormHelper {
//    private Map<Integer, Integer> nutrientMap = new HashMap<>();
//    public Map<Integer, Integer> getNutrientMap(){
//        return nutrientMap;
//    }
//
//    public void setNutrientMap(Map<Integer, Integer> nutrientMap) {
//        this.nutrientMap = nutrientMap;
//    }

    private Map<String, KeyValuePair> nutrientMap = new HashMap<>();

    public Map<String, KeyValuePair> getNutrientMap() {
        return nutrientMap;
    }

    public void setNutrientMap(Map<String, KeyValuePair> nutrientMap) {
        this.nutrientMap = nutrientMap;
    }

    @Override
    public String toString() {
        return "FormHelper{" +
                "nutrientMap=" + nutrientMap +
                '}';
    }
}
