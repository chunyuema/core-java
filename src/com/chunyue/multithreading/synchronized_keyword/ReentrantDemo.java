package com.chunyue.multithreading.synchronized_keyword;

public class ReentrantDemo {
    public static void main(String[] args) {
        RentryCounter rc = new RentryCounter();
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(rc.secondSynchronizedInstanceMethod());
                    }
                });
        thread.start();
    }
}
