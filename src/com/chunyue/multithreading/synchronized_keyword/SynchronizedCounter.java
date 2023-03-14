package com.chunyue.multithreading.synchronizedkeyword;

// SynchronizedCounter extends BasicCounter and add synchronization to the method
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