package com.chunyue.multithreading.thread_creation;

public class ClassExtendsThread {

    public static class MyThread extends Thread {
        public void run() {
            System.out.println("Current thread running is: " + Thread.currentThread().getName());
            System.out.println("This is a thread I started in addition to the main thread");
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
        t1.start();
        System.out.println("Current thread running is: " + Thread.currentThread().getName());
    }
}
