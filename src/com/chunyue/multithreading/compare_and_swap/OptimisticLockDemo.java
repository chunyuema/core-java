package com.chunyue.multithreading.compare_and_swap;

import com.chunyue.multithreading.race_condition.SimpleCounter;

public class OptimisticLockDemo {
    static SimpleCounter sc = new SimpleCounter();
    static CompareAndSwapCounter casc = new CompareAndSwapCounter();

    static Runnable runnable = () -> {
        for (int i = 0; i < 100000; i++) {
            sc.increment();
            casc.increment();
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("t1 & t2 finished");
            // sc won't count to 200000 due to race condition
            System.out.println("final count of sc is: " + sc.getC());
            // casc will count to 200000 due to use of CAS optimistic lock
            System.out.println("final count of casc is: " + casc.getCount());
        } catch (InterruptedException e) {
            // Handling the exception
            System.out.println("Interrupted Exception");
        }
    }
}
