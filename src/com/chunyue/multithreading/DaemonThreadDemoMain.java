package com.chunyue.multithreading;


class TestDaemonThread extends Thread{
    @Override
    public void run() {
        if (Thread.currentThread().isDaemon()){
            System.out.println("daemon thread working");
        } else {
            System.out.println("user thread working");
        }
    }
}

public class DaemonThreadDemoMain {
    public static void main(String[] args) {
        TestDaemonThread t1 = new TestDaemonThread();
        TestDaemonThread t2 = new TestDaemonThread();
        TestDaemonThread t3 = new TestDaemonThread();
        t1.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
    }
}
