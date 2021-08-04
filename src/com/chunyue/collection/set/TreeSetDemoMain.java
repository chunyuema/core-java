package com.chunyue.collection.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemoMain {
    // behaves like a simple set with the exception that it stores elements in a sorted format.
    public static void main(String[] args) {
        // treeSetKeepsElementInSortedOrder();
        // accessLargestAndSmallestValue();
        navigateSet();
    }

    public static void treeSetKeepsElementInSortedOrder(){
        Set<String> friuitSet = new TreeSet<>();
        friuitSet.add("grape");
        friuitSet.add("pear");
        friuitSet.add("apple");
        // TreeSet will keep track of the ordering from added items
        System.out.println(friuitSet);
        friuitSet.remove("grape");
        System.out.println(friuitSet);
    }

    public static void accessLargestAndSmallestValue() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(9);
        numbers.add(2);
        numbers.add(34);
        numbers.add(12);
        System.out.println("numbers = " + numbers);
        System.out.println("smallest number is " + numbers.pollFirst());
        System.out.println("largest number is " + numbers.pollLast());
    }

    public static void navigateSet(){
        TreeSet<String> set=new TreeSet<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");
        System.out.println("set: " + set);
        System.out.println("reverse set " + set.descendingSet());
        System.out.println("head set including C: " + set.headSet("C", true));
        System.out.println("head set excluding C: " + set.headSet("C"));
        System.out.println("tail set including C: " + set.tailSet("C", true));
        System.out.println("tail set excluding C: " + set.tailSet("C"));
        System.out.println("subset including A, excluding E: " + set.subSet("A", "E"));
        System.out.println("subset including A, including E: " + set.subSet("A",true, "E", true));
    }
}
