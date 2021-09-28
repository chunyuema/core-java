package com.chunyue.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemoMain {
    public static void main(String[] args) {
        // HashSet implements Set
        Set<Integer> values = new HashSet<>();
        System.out.println("Adding 6 for the first time: " + values.add(6) + ": " + values);
        // Does not support duplicate values
        System.out.println("Adding 6 for the second time: " + values.add(6) + ": " + values);

        values.add(67);
        values.add(79);
        values.add(54);
        values.add(90);
        // Use hashing, hence the ordering is not preserved
        System.out.println("values = " + values);

        Set<Integer> values2 = new HashSet<>();
        values2.add(67);
        values2.add(54);
        System.out.println("values2 =  " + values2);
        values.removeAll(values2);
        System.out.println("Removing values2 from values: " + values);

        values.removeIf(num -> num % 3 == 0);
        System.out.println("Removing anything that is divisible by 3:  " + values);

        values.clear();
        System.out.println("Removing all from values" + values);


    }
}
