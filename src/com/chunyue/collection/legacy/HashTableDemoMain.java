package com.chunyue.collection.legacy;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTableDemoMain {
    public static Hashtable<String, Double> balance = new Hashtable<>();
    static {
        balance.put("Chunyue", 2324.45);
        balance.put("Alex", 2324.45);
        balance.put("Jane", 23545.45);
        balance.put("John", 344.45);
    }

    public static void main(String[] args) {
        // System.out.println(balance);
        // iterateUsingEnumeration();
        iterateUsingIterator();
    }

    public static void iterateUsingEnumeration(){
        Enumeration<String> names;
        String str;
        double bal;
        names = balance.keys();
        while (names.hasMoreElements()){
            str = names.nextElement();
            System.out.println(str + ": " + balance.get(str));
        }
    }

    public static void iterateUsingIterator(){
        Iterator<String> iterator = balance.keySet().iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name + ": " + balance.get(name));
        }
        System.out.println();
    }
}
