package com.chunyue.array;

import java.util.Arrays;

public class Array002BasicMethodDemoMain {
    public static void main(String[] args) {
        arrayProperties();
    }

    // indexing & length of the array
    private static void arrayProperties(){
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
