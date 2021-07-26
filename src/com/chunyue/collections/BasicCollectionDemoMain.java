package com.chunyue.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BasicCollectionDemoMain {
    public static void main(String[] args) {
        // Using collection interface
        // Using integer as generics to specify types
        Collection<Integer> values = new ArrayList<Integer>();
        values.add(2);
        values.add(3);
        values.add(4);

        // Use an iterator to traverse through the list
        Iterator<Integer> i = values.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        // Use an enhanced for loop to traverse through the list
        for (int v: values){
            System.out.println(v);
        }

        // Unable tp add a number in between 2 and 3 or 3 and 4.
        // We are using the Colleciton interface, which does not support
        // the insertion
    }
}
