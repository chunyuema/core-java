package com.chunyue.multithreading.executor_service;

public class MyRunnable implements Runnable {
    private String msg;

    public MyRunnable(String msg) {
        this.msg = msg;
    }

    public void run() {
        System.out.println(
                "The current thread is " +
                        Thread.currentThread().getName() + ", currently working on " + this.msg);
        // Introduce a sleep for 1s to mock time take for work to be done
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                "The current thread is " +
                        Thread.currentThread().getName() + " done with work");
    }
}
