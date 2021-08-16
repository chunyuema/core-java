package com.chunyue.multithreading;

public class DeadLockDemoMain {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
        // thread 1 and thread 2 are blocking each other
    }

    private static class Thread1 extends Thread {
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1: has lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){

                }
                System.out.println("Thread 1: waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread 1: has lock1 and lock2");
                }
                System.out.println("Thread 1: released lock 2");
            }
            System.out.println("Thread 1: released lock 1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 2: has lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){

                }
                System.out.println("Thread 2: waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread 2: has lock1 and lock2");
                }
                System.out.println("Thread 2: released lock 2");
            }
            System.out.println("Thread 2: released lock 1. Exiting...");
        }
    }
}


