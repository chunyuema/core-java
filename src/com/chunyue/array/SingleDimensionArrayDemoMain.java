package com.chunyue.array;

import java.util.Arrays;

public class SingleDimensionArrayDemoMain {
    public static void main(String[] args) {
        // arrayCreation();
        // easyArrayDeclaration();
        // loopThroughArray();
        // anonymousArray(new int[]{10, 22, 33, 44});
        // classNameOfArray();
        // copyArray();
        // deepCloneOfArray();
    }

    public static void arrayCreation(){
        int[] a = new int[5];
        System.out.println("No initialization a: " + Arrays.toString(a));
        a[0] = 1;
        a[3] = 34;
        a[4] = 77;
        System.out.println("With initialization a: " + Arrays.toString(a));
    }

    public static void easyArrayDeclaration(){
        int[] ints = {1, 2, 34, 5, 67};
        System.out.println("Easy initialization of array: " + Arrays.toString(ints));
    }

    public static void loopThroughArray(){
        int[] ints = {3, 5, 67, 87, 43};
        for (int i: ints){
            System.out.println("Current integer is:  " + i);
        }
    }

    public static void anonymousArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void classNameOfArray(){
        int[] arr = {4, 5, 6};
        System.out.println("class of an array: " + arr.getClass());
        System.out.println("class name of an array: " + arr.getClass().getName());
    }

    public static void copyArray(){
        char[] originalChars = {'a','b','c','d','r'};
        char[] newChars = new char[3];
        // use arraycopy provided by the System class
        System.arraycopy(originalChars, 1, newChars, 0, 3);
        System.out.println(newChars);
        System.out.println(Arrays.toString(newChars));
    }

    public static void deepCloneOfArray(){
        int[] arr = {1, 2, 3};
        System.out.println("original array: " + Arrays.toString(arr));
        // clone method does deep copy for the single dimension array
        int[] clone = arr.clone();
        System.out.println("cloned array: " + Arrays.toString(clone));
        System.out.println("they are not equal: " + (arr==clone));
        clone[2] = 100;
        System.out.println("change cloned array: " + Arrays.toString(clone) + " does not affect original array" + Arrays.toString(arr));
    }
}
