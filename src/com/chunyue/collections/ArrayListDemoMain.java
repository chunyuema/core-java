package com.chunyue.collections;

import com.chunyue.collections.comparator.LastDigitComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListDemoMain {
    public static void main(String[] args) {
        // List interface extends the Collection interface
        List<Integer> values = new ArrayList<>();
        values.add(36);
        values.add(44);
        values.add(55);
        // Not possible with collection interface
        values.add(2, 567);
        System.out.println(values);
        // Not possible is values is a Collection
        // since index does not exist for Collection
        Collections.sort(values);
        System.out.println(values);
        Collections.reverse(values);
        System.out.println(values);

        // Use the comparator we defined to sort the list
        // The list will be sorted with the magnitude of the last digit
        Comparator<Integer> com = new LastDigitComparator();
        Collections.sort(values, com);
        System.out.println(values);

        // Define annnoynous comparator
        Comparator<Integer> com2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 100 > o2 % 100){
                    return 1;
                }
                return -1;
            }
        };
        Collections.sort(values, com2);
        System.out.println(values);

        // Define comparator through lambda comparison
        Collections.sort(values, (o1, o2) ->{
            return o1 * -1 > o2 * -1 ? 1 : -1;
        });
        System.out.println(values);


        // Stream API
        values.forEach(System.out::println);
    }
}
