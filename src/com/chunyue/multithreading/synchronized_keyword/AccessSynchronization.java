package com.chunyue.multithreading.synchronized_keyword;

public class AccessSynchronization {

    public static void synchronizationDemo(BasicCounter c) {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            // System.out.println("t1 incrementing counter");
                            c.incrementCount();
                        }
                    }
                });

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            // System.out.println("t2 incrementing counter");
                            c.incrementCount();
                        }
                    }
                });

        t1.start();
        t2.start();
        // Waiting for child threads to finish
        try {
            t1.join();
            t2.join();
            System.out.println("t1 & t2 finished");
            System.out.println("final count is: " + c.getCount());
        } catch (InterruptedException e) {
            // Handling the exception
            System.out.println("Interrupted Exception");
        }
    }

    public static void staticSynchronizationDemo() {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            // System.out.println("t1 incrementing counter");
                            BasicStaticCounter.incrementCount();
                            SynchronizedStaticCounter.incrementCount();
                        }
                    }
                });

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            // System.out.println("t2 incrementing counter");
                            BasicStaticCounter.incrementCount();
                            SynchronizedStaticCounter.incrementCount();
                        }
                    }
                });

        t1.start();
        t2.start();
        // Waiting for child threads to finish
        try {
            t1.join();
            t2.join();
            System.out.println("t1 & t2 finished");
            System.out.println("final non synchronized count is: " + BasicStaticCounter.getCount());
            System.out.println("final synchronized count is: " + SynchronizedStaticCounter.getCount());
        } catch (InterruptedException e) {
            // Handling the exception
            System.out.println("Interrupted Exception");
        }
    }

    public static void main(String[] args) {
        // Using a nonsynchronized counter, you might not be able to count to 20000
        BasicCounter nsc = new BasicCounter();
        synchronizationDemo(nsc);

        // Using a synchronized counter (synchronized instance method), you make sure to
        // count to 20000
        SynchronizedCounter sc = new SynchronizedCounter();
        synchronizationDemo(sc);

        // Using a synchronized counter (synchronized block), you make sure to count to
        // 20000
        SynchronizedBlockCounter sbc = new SynchronizedBlockCounter();
        synchronizationDemo(sbc);

        staticSynchronizationDemo();
    }
}
