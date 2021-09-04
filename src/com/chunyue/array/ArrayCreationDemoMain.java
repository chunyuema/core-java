package com.chunyue.array;

import java.util.Arrays;

public class ArrayCreationDemoMain {
    public static void main(String[] args) {
        // staticCreation();
        // dynamicCreation();
        // arrayProperties();
    }

    // demo code for static creation of array
    public static void staticCreation(){
        int[] grades = {98, 78, 67, 89, 97, 95};
        int[] grades1 = new int[]{98, 78, 76, 89, 79};
        // implicit conversion
        double[] grades2 = {98.0, 78.8, 89, 80};
        System.out.println(Arrays.toString(grades));
        System.out.println(Arrays.toString(grades1));
        System.out.println(Arrays.toString(grades2));
    }

    // demo code for dynamic creation of array
    public static void dynamicCreation(){
        int[] grades = new int[5];
        grades[1] = 56;
        System.out.println(Arrays.toString(grades));
    }

    // indexing & length of the array
    public static void arrayProperties(){
        int[] grades = {23, 4, 5, 66};
        // cast into a double
        double grade = grades[3];
        System.out.println("Getting the element at index: " + grades[2]);
        System.out.println(grade);
        grades[2] = 1000;
        System.out.println(Arrays.toString(grades));
        System.out.println("Length of the array: " + grades.length);
    }
}
