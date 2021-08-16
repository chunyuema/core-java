package com.chunyue.multithreading;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("The current thread name is: " + Thread.currentThread().getName());
        System.out.println("run() method is executed");
    }
}
public class StartVSRunDemoMain {
    public static void main(String[] args) {
        // startCreateNewThread();
        // runDoesNotCreateNewThread();
    }

    public static void startCreateNewThread(){
        System.out.println("Use start() will create a new thread: ");
        MyThread t = new MyThread();
        t.start();
    }

    public static void runDoesNotCreateNewThread(){
        System.out.println("Directly use run() will not create a new thread: ");
        MyThread t = new MyThread();
        t.run();
    }
}


