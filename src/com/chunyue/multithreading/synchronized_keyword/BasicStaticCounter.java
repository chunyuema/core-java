package com.chunyue.multithreading.synchronized_keyword;

public class BasicStaticCounter {
    private static int c = 0;

    public static int getCount() {
        return c;
    }

    public static void incrementCount() {
        c++;
    }
}
