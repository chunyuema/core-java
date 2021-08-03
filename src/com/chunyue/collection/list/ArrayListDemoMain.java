package com.chunyue.collection.list;

import com.chunyue.collection.comparator.LastDigitComparator;

import java.util.*;

public class ArrayListDemoMain {
    public static void main(String[] args) {
        // List interface extends the Collection interface
        List<Integer> values = new ArrayList<>();

        // Check ArrayList empty
        System.out.println(values.isEmpty());

        values.add(36);
        values.add(44);
        values.add(55);
        // Not possible with collection interface
        values.add(2, 567);
        System.out.println(values);

        // Get the size of the ArrayList
        System.out.println(values.size());

        // Iterating through the array list
        Iterator<Integer> itrator = values.iterator();
        while (itrator.hasNext()){
            System.out.println("The item is: " + itrator.next());
        }

        // Iterating through the array list with for loop
        for (Integer i: values){
            System.out.println("The number is: " + i);
        }

        // accessing the elements
        System.out.println("The value at position 3 is: " + values.get(2));
        values.set(2, 333);
        System.out.println("The value at position 3 is: " + values.get(2));


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

        // Adding the elements from another list
        ArrayList<Integer> values2 = new ArrayList<>();
        values2.add(444);
        values2.add(568);
        values.addAll(values2);
        System.out.println(values);

        // Removing elements from the list
        values.remove(4);
        System.out.println(values);
        values.removeAll(values2);
        System.out.println(values);
    }
}
