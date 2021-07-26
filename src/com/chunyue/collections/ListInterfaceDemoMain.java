package com.chunyue.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListInterfaceDemoMain {
    public static void main(String[] args) {
        // List interface extends the Collection interface
        List<Integer> values = new ArrayList<>();
        values.add(33);
        values.add(44);
        values.add(55);
        // Not possible with collection interface
        values.add(2, 567);
        System.out.println(values);
        // Not possible is values is a Collection
        // since index does not exist for Collection
        Collections.sort(values);
        System.out.println(values);

        // Stream API
        values.forEach(System.out::println);
    }
}
