package com.chunyue.multithreading.synchronized_keyword;

// SynchronizedCounter extends BasicCounter and add synchronization to the instance method
public class SynchronizedCounter extends BasicCounter {
    private int c = 0;

    @Override
    public synchronized int getCount() {
        return c;
    }

    @Override
    public synchronized void incrementCount() {
        c++;
    }
}