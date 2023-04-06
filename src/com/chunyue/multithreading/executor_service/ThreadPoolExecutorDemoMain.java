package com.chunyue.multithreading.executor_service;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemoMain {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1, 5, 1,
            TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(3));

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                threadPoolExecutor.submit(new MyRunnable("Task " + i));
            }
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
