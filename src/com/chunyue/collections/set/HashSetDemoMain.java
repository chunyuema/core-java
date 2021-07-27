package com.chunyue.collections.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemoMain {
    public static void main(String[] args) {
        // Set is an interface
        // HashSet implements Set
        Set<Integer> values = new HashSet<>();
        System.out.println(values.add(6));
        // Does not support duplicate values
        System.out.println(values.add(6));
        values.add(67);
        values.add(79);
        values.add(54);
        values.add(90);
        // Use hashing, hence the ordering is not preserved
        System.out.println(values);
    }
}
