package com.chunyue.multithreading.volatile_keyword;

public class SimpleVolatileCounter {
    private volatile int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
