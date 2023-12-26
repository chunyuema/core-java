package com.chunyue.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List001CreationDemoMain {
    public static void main(String[] args) {
        oneLineInitializationFromArray();
    }

    private static void oneLineInitializationFromArray() {
        String[] array = new String[] {"Hello", "World"};
        System.out.println(Arrays.toString(array));

        List<String> list = Arrays.asList(array);
        System.out.println(list);

        // Note the difference here
        System.out.println(list.getClass() + " - " + ArrayList.class);

        // Changing array will affect the list!
        array[0] = "Aloha";
        System.out.println(list);
    }
}
