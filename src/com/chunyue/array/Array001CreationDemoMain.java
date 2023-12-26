package com.chunyue.array;

import java.util.Arrays;

public class Array001CreationDemoMain {
    public static void main(String[] args) {
        // staticCreation();
        // dynamicCreation();
        // arrayProperties();
    }

    // demo code for static creation of array
    private static void staticCreation(){
        int[] grades = {98, 78, 67, 89, 97, 95};
        int[] grades1 = new int[]{98, 78, 76, 89, 79};
        // implicit conversion
        double[] grades2 = {98.0, 78.8, 89, 80};
        System.out.println(Arrays.toString(grades));
        System.out.println(Arrays.toString(grades1));
        System.out.println(Arrays.toString(grades2));
    }

    // demo code for dynamic creation of array
    private static void dynamicCreation(){
        int[] grades = new int[5];
        grades[1] = 56;
        System.out.println(Arrays.toString(grades));
    }


}
