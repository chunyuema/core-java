package com.chunyue.collection.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemoMain {
    // behaves like a simple set with the exception that it stores elements in a sorted format.
    public static void main(String[] args) {
        Set<String> values = new TreeSet<>();
        values.add("grape");
        values.add("pear");
        values.add("apple");
        // TreeSet will impose on some sort of ordering
        System.out.println(values);
        values.remove("grape");
        System.out.println(values);
    }
}
