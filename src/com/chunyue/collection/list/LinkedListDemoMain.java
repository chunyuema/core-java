package com.chunyue.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemoMain {
    public static void main(String[] args) {
        LinkedList<String> values = new LinkedList<>();
        // adding items into linked list
        values.add("Chunyue");
        values.add("Bobby");
        // iterating through linked list
        Iterator<String> iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println("The item is: " + iterator.next());
        }
    }
}
