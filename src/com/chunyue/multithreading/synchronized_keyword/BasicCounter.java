package com.chunyue.multithreading.synchronizedkeyword;

public class BasicCounter {
    private int c = 0;

    public int getCount() {
        return c;
    }

    public void incrementCount() {
        c++;
    }
}