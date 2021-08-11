package com.chunyue.collection.map;

import java.util.TreeMap;

public class TreeMapDemoMain {
    public static TreeMap<String, Double> treeMap = new TreeMap<>();

    static {
        treeMap.put("Chunyue Ma", 33.44);
        treeMap.put("John Ma", 5.54);
        treeMap.put("Alex Ma", 34.67);
        treeMap.put("Bobby Ma", 42.58);
    }

    public static void main(String[] args) {
        System.out.println(treeMap);
    }
}
