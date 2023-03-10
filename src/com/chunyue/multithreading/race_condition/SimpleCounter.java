package com.chunyue.multithreading.race_condition;

class SimpleCounter {
    private int c = 0;

    public int getC() {
        return c;
    }

    public void increment() {
        c++;
    }
}