package com.chunyue.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemoMain {
    public static void main(String[] args) {
        addToLinkedList();
    }

    public static void addToLinkedList(){
        LinkedList<String> values = new LinkedList<>();
        // ============================================
        // adding items into linked list
        values.add("Chunyue");
        values.add("Bobby");
        values.add(1, "Alex");

        LinkedList<String> values2 = new LinkedList<>();
        values2.add("John");
        values2.add("Sam");

        values.addAll(values2);

        LinkedList<String> values3 = new LinkedList<>();
        values3.add("Jane");
        values3.add("Mariam");

        values.addAll(1, values3);

        values.addFirst("Start");
        values.addLast("End");

        // =============================================
        // iterating through linked list
        Iterator<String> iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println("The item is: " + iterator.next());
        }
    }
}
