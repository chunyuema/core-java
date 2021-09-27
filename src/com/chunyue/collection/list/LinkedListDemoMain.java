package com.chunyue.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemoMain {
    public static void main(String[] args) {
        // addToLinkedList();
        // removeFromLinkedList();
        findingIndexFromLinkedList();
        // iterateLinkedList();
        // addElementUsingIteratorDemo();
        // setElementUsingIteratorDemo();
    }

    // add method
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

    // remove method
    public static void removeFromLinkedList(){
        LinkedList<String> names = new LinkedList<>();
        names.add("Ravi");
        names.add("Vijay");
        names.add("Ajay");
        names.add("Anuj");
        names.add("Gaurav");
        names.add("Harsh");
        names.add("Virat");
        names.add("Gaurav");
        names.add("Harsh");
        names.add("Amit");
        names.add("Amit");
        System.out.println("initial list: " +  names);
        names.remove("Amit");
        System.out.println("remove Amit: " + names);

        LinkedList<String> names2 = new LinkedList<>();
        names2.add("Virat");
        names2.add("Amit");
        names.removeAll(names2);
        System.out.println("remove " + names2 + ": " + names);

        names.removeFirst();
        System.out.println("remove first element: " + names);
        names.removeLast();
        System.out.println("remove last element: " + names);

        names.removeFirstOccurrence("Gaurav");
        System.out.println("remove first occurrence of Gaurav: " + names);
        names.removeLastOccurrence("Harsh");
        System.out.println("remove last occurrence of Harsh: " + names);

        names.clear();
        System.out.println("clear everything: " + names);
    }

    // indexOf and lastIndexOf method
    public static void findingIndexFromLinkedList(){
        List<String> names = new LinkedList<>();
        names.add("Amy");
        names.add("Logan");
        names.add("Chunyue");
        names.add("Chunyue");
        names.add("Juliet");
        System.out.println(names.indexOf("Chunyue"));
        System.out.println(names.lastIndexOf("Chunyue"));
    }

    public static void iterateLinkedList(){
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);
        numbers.add(16);

        // Forward Iteration
        Iterator<Integer> iterator = numbers.iterator();
        System.out.println("Forward Iteration");
        while (iterator.hasNext()){
            System.out.println("The number is: " + iterator.next());
        }

        Iterator<Integer> backIterator = numbers.descendingIterator();
        System.out.println("Backwars Iterator");
        while (backIterator.hasNext()){
            System.out.println("The number is: " + backIterator.next());
        }

        System.out.println("Use for loop");
        for (Integer i: numbers){
            System.out.println("For loop number: " +  i);
        }


    }

    public static void addElementUsingIteratorDemo(){
        List<String> names = new LinkedList<>();
        names.add("Amy");
        names.add("Logan");
        names.add("Chunyue");
        ListIterator<String> iterator = names.listIterator();
        iterator.next(); // skipping the first element
        iterator.add("Juliet");
        System.out.println(names);
    }

    public static void setElementUsingIteratorDemo(){
        List<String> names = new LinkedList<>();
        names.add("Amy");
        names.add("Logan");
        names.add("Chunyue");
        ListIterator<String> iterator = names.listIterator();
        iterator.next();
        iterator.set("Tony");
        System.out.println(names);
    }
}
