package com.chunyue.multithreading.synchronized_keyword;

public class SynchronizedStaticCounter {
    private static int c = 0;

    public static synchronized int getCount() {
        return c;
    }

    public static synchronized void incrementCount() {
        c++;
    }
}
