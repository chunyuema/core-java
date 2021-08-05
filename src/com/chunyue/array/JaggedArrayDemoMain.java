package com.chunyue.array;

import java.util.Arrays;

public class JaggedArrayDemoMain {
    public static void main(String[] args) {
        jaggedArrayCreation();
    }

    public static void jaggedArrayCreation(){
        int[][] arr = new int[3][];
        arr[0] = new int[3];
        arr[1] = new int[4];
        arr[2] = new int[5];
        for (int[] a: arr){
            System.out.println(Arrays.toString(a));
        }

        int count = 0;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++) {
                arr[i][j] = count++;
            }
        }

        for (int[] i: arr){
            System.out.println(Arrays.toString(i));
        }

    }
}
