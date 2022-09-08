package com.chunyue.array;

import java.util.Arrays;

public class SingleDimensionArrayDemoMain {
    public static void main(String[] args) {
        // arrayCreation();
        // easyArrayDeclaration();
        // loopThroughArray();
        functionalArrayTraversal();
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
        System.out.println("Initial array is: " + Arrays.toString(ints));
        for (int i: ints){
            i = i + 1;
            System.out.println("Current integer is:  " + i);
        }
        System.out.println("Enhanced for loop does not affect original array: " + Arrays.toString(ints));

        for (int i = 0; i < ints.length; i++){
            ints[i] += 1;
        }
        System.out.println("Use regular for loop to affect the original array: " + Arrays.toString(ints));
    }

    public static void functionalArrayTraversal(){
        int[] ints = {1, 2, 3, 4};
        Arrays.stream(ints).forEach(System.out::println);
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
