package com.chunyue.multithreading.executor_service;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private String msg;
    private Integer sleepSecond;

    public MyCallable(String msg, Integer sleepSecond) {
        this.msg = msg;
        this.sleepSecond = sleepSecond;
    }

    @Override
    public String call() throws Exception {
        String successTokenString = "SUCCESS";
        System.out.println(
                "The current thread is " +
                        Thread.currentThread().getName() + ", currently working on " + this.msg);
        // Introduce a sleep for 1s to mock time take for work to be done
        try {
            Thread.sleep(sleepSecond);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
            // e.printStackTrace();
            successTokenString = "FAIL";
            return successTokenString;
        }

        System.out.println(
                "The current thread is " +
                        Thread.currentThread().getName() + " done with work");

        // Callable can return execution result (unlike runnable)
        return Thread.currentThread().getName() + " " + successTokenString;
    }

}
