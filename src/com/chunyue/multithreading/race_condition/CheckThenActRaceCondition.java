package com.chunyue.multithreading.race_condition;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class CheckThenActRaceCondition {

    static Boolean RACE_CONDITION = true;

    public static void main(String[] args) {
        Map<String, String> sharedMap = new ConcurrentHashMap<>();

        Thread t1;
        Thread t2;

        if (RACE_CONDITION) {
            // In this situation, you will encounter cases when one thread removes the key
            // after the other thread has already removed the key. This is because it is
            // possible that both threads will remove the key at the same time
            t1 = new Thread(getRunnable(sharedMap));
            t2 = new Thread(getRunnable(sharedMap));
        } else {
            // In this situation, one thread attempts to remove the key only after the other
            // thread is done with the operations.
            t1 = new Thread(getSynchronizedRunnable(sharedMap));
            t2 = new Thread(getSynchronizedRunnable(sharedMap));
        }

        t1.start();
        t2.start();

    }

    private static Runnable getRunnable(Map<String, String> sharedMap) {
        return () -> {
            for (int i = 0; i < 1000; i++) {
                if (sharedMap.containsKey("key")) {
                    String value = sharedMap.remove("key");
                    if (value == null) {
                        System.out.println("iteration " + i + ": something is wrong because the value is null");
                    }
                } else {
                    sharedMap.put("key", "value");
                }
            }
        };
    }

    private static Runnable getSynchronizedRunnable(Map<String, String> sharedMap) {
        return () -> {
            synchronized (sharedMap) {
                for (int i = 0; i < 1000; i++) {
                    if (sharedMap.containsKey("key")) {
                        String value = sharedMap.remove("key");
                        if (value == null) {
                            System.out.println("iteration " + i + ": something is wrong because the value is null");
                        }
                    } else {
                        sharedMap.put("key", "value");
                    }
                }
            }
        };
    }
}
