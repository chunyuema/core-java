package com.chunyue.multithreading.volatile_keyword;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleAtomicCounter {
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.getAndIncrement();
    }

    public int getCount() {
        return count.get();
    }
}
