package com.chunyue.multithreading.thread_creation;

public class ClassImplementsRunnable {

    // Class implements Runnable
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Current thread running is: " + Thread.currentThread().getName());
            System.out.println("This is a runnable I started in addition to the main thread");
        }
    }

    public static void usingMyRunnableClass() {
        Thread t = new Thread(new MyRunnable());
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
        t.start();
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
    }

    public static void usingAnonymousRunnable() {
        // Anonymous Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Current thread running is: " + Thread.currentThread().getName());
                System.out.println("This is a anonymous runnable I started in addition to the main thread");
            }
        };

        Thread t = new Thread(runnable);
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
        t.start();
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
    }

    public static void usingLambdaRunnable() {
        // Runnable defined by lambda
        Runnable runnable = () -> {
            System.out.println("Current thread running is: " + Thread.currentThread().getName());
            System.out.println("This is a anonymous runnable I started in addition to the main thread");
        };

        Thread t = new Thread(runnable);
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
        t.start();
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        usingMyRunnableClass();
        usingAnonymousRunnable();
        usingLambdaRunnable();
    }
}
