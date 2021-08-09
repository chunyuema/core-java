package com.chunyue.utilLang;

public class MemoryManagementDemoMain {
    public static void main(String[] args) {
        manualMemoryManagementDemo();
    }

    public static void manualMemoryManagementDemo(){
        Runtime r = Runtime.getRuntime();
        Integer[] integers = new Integer[1000];
        System.out.println("Total Memory now is: " + r.totalMemory());
        System.out.println("Total Free memory before gc is: " + r.freeMemory());
        r.gc();
        System.out.println("Total Free memory after gc is: " + r.freeMemory());

        for (int i = 0; i<1000; i++){
            integers[i] = i;
        }
        System.out.println("Total free memory after initializing the array: " + r.freeMemory());
    }
}
