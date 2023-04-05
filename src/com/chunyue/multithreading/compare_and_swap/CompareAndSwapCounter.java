package com.chunyue.multithreading.compare_and_swap;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSwapCounter {
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        boolean incrementSuccess = false;
        while (!incrementSuccess) {
            int preVal = this.count.get();
            int newVal = preVal + 1;
            incrementSuccess = this.count.compareAndSet(preVal, newVal);
        }
    }

    public int getCount() {
        return this.count.get();
    }
}
