package com.chunyue.multithreading.volatile_keyword;

public class LackAtomicSupportDemo {
    public static void main(String[] args) {
        final SimpleVolatileCounter svc = new SimpleVolatileCounter();
        final SimpleAtomicCounter sac = new SimpleAtomicCounter();

        // Start 10 different threads to count with the simple volatile counter and also
        // simple atomic counter
        for (int tn = 0; tn < 10; tn++) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    svc.increment();
                    sac.increment();
                }
            }).start();
        }

        while (Thread.activeCount() > 1)
            Thread.yield();

        // The final outcome of SVC may not be 10000 because count++ is not an
        // atomic operation, but the final outcome of SAC will be 10000 because we used
        // atomic integer rather than regular integer
        System.out.println("Final svc count: " + svc.getCount());
        System.out.println("Final sac count: " + sac.getCount());
    }
}
