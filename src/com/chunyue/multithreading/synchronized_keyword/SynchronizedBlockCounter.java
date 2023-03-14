package com.chunyue.multithreading.synchronized_keyword;

public class SynchronizedBlockCounter extends BasicCounter {
    private int c = 0;

    @Override
    public int getCount() {
        synchronized (this) {
            return c;
        }
    }

    @Override
    public void incrementCount() {
        synchronized (this) {
            c++;
        }
    }
}
