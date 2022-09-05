package com.chunyue.array;

import java.util.Arrays;

public class MultidimensionalArrayDemoMain {
    public static void main(String[] args) {
        // multidimensionalArrayCreation();
        // easyMultidimensionalArrayCreation();
        // shallowCopyOfArray();
        printingMultiDimensionalArray();
    }

    public static void multidimensionalArrayCreation(){
        int[][] arr = new int[3][3];
        System.out.println("Initial multidimensional array: ");
        System.out.println(Arrays.toString(arr));
        for (int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("--------");
        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;
        arr[1][0]=4;
        arr[1][1]=5;
        arr[1][2]=6;
        arr[2][0]=7;
        arr[2][1]=8;
        arr[2][2]=9;
        System.out.println("After initialization: ");
        System.out.println(Arrays.toString(arr));
        for (int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
    }

    public static void easyMultidimensionalArrayCreation(){
        int[][] arr = {{1, 2, 3},{3, 4, 6},{5, 7, 8}};
        // using the enhanced for loop from below
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void shallowCopyOfArray(){
        int[][] a = {{1,3,4},{3,4,5}};
        System.out.println("original array: " + Arrays.toString(a));
        // clone only produces a shallow copy fo the original matrices
        int[][] b = a.clone();
        System.out.println("b and a are different: " + a + " | " + b);
        System.out.println("but b's content is the same as a's: " + Arrays.toString(b));
    }

    public static void printingMultiDimensionalArray(){
        int[][][] threeDArray = {{{0, 1}, {1, 2}}, {{2, 3}, {3, 4}}};
        System.out.println(Arrays.deepToString(threeDArray));
    }
}
