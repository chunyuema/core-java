package com.chunyue.collection.iterators;

import java.util.ArrayList;
import java.util.Spliterator;

public class SpliteratorDemoMain {

    public static ArrayList<Double> values = new ArrayList<>();

    static {
        values.add(1.0);
        values.add(2.0);
        values.add(3.0);
    }

    public static void main(String[] args) {
        tryAdvanceMethod();
        forEachRemaining();
    }

    public static void tryAdvanceMethod(){
        // use tryAdvance to display contents of the vals
        Spliterator<Double> spliterator = values.spliterator();
        while(spliterator.tryAdvance(n -> System.out.println(n)));
        System.out.println();
    }

    public static void forEachRemaining(){
        Spliterator<Double> spliterator = values.spliterator();
        System.out.println("Creating a new list from original one: ");
        ArrayList<Double> newVals = new ArrayList<>();
        while(spliterator.tryAdvance(n -> newVals.add(Math.sqrt(n))));
        System.out.println("newVals array is: " + newVals);

        Spliterator<Double> spliterator1 = newVals.spliterator();
        spliterator1.forEachRemaining(n-> System.out.println(n));
    }

}
