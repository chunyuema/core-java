package com.chunyue.multithreading.synchronized_keyword;

public class RentryCounter {
    private int count = 0;

    public synchronized void firstSynchronizedInstanceMethod() {
        System.out.println(
                "This is the first synchronized method, object calling from the second synchronized method is allowed to re-enter");
        this.count++;
    }

    public synchronized int secondSynchronizedInstanceMethod() {
        System.out.println("This is the second synchronized method, calling the first synchronized method now");
        firstSynchronizedInstanceMethod();
        return this.count;
    }
}
