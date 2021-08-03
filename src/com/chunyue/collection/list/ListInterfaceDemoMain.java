package com.chunyue.collection.list;

import java.util.*;

public class ListInterfaceDemoMain {
    public static void main(String[] args) {

        // Three different implementations of list interface
        List<Integer> v1 = new ArrayList<>();
        v1.add(2);
        System.out.println(v1.size());

        List<Integer> v2 = new Vector<>();
        v2.add(3);
        System.out.println(v2.size());
        // the following only works if you do Vector<Integer> = new Vector<Integer>
        // System.out.println(v2.capacity());

        List<Integer> v3 = new LinkedList<>();
        v3.add(4);
        System.out.println(v3.size());

        arrayToList();
    }

    public static void arrayToList(){
        String[] programmingLanguages = {"Java", "Python", "C++"};
        System.out.println(programmingLanguages.getClass());

        String programmingLanguagesListString = Arrays.toString(programmingLanguages);
        System.out.println(programmingLanguagesListString);

        List<String> programmingLanguagesList = new ArrayList<>();
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("C++");
        String[] array = programmingLanguagesList.toArray(new String[programmingLanguagesList.size()]);
        System.out.println("Printing the array: " + array);
        System.out.println("Printing the class of the array: " + array.getClass());
        System.out.println("Printing the list: " + programmingLanguagesList);
        System.out.println("Printing the class of the list: " + programmingLanguagesList.getClass());

    }

}
