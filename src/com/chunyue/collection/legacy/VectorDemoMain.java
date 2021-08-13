package com.chunyue.collection.legacy;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemoMain {

    private static Vector<String> vector = new Vector<>();

    static {
        vector.addElement("Amazon");
        vector.addElement("Google");
        vector.addElement("Facebook");
        vector.addElement("Microsoft");
    }

    public static void main(String[] args) {
        // fastCapacityGrowthVector();
        // enumerateVector();
        iterateVector();
    }

    public static void fastCapacityGrowthVector(){
        Vector<Integer> v = new Vector<>();
        System.out.println(v.capacity());
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        // automatically double the capacity
        System.out.println(v.capacity());
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        // does not automatically reduce the capacity
        System.out.println(v.capacity());
        System.out.println(v);

        ArrayList<Integer> v2 = new ArrayList<>();
        System.out.println(v2.size());
        v2.add(2);
        System.out.println(v2.size());
        v2.add(2);
        System.out.println(v2.size());
        // ArrayList increase the capacity more slowly
        // Only about 50% everytime it increases

        // ArrayList is not thread safe
        // Vector is synchronized (thread safe)
    }

    public static void enumerateVector(){
        Enumeration<String> enumeration = vector.elements();
        System.out.println("Enumerating all elements of the vector: ");
        while (enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();
    }

    public static void iterateVector(){
        Iterator<String> iterator = vector.iterator();
        System.out.println("Iterating all elements of the vector: ");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
