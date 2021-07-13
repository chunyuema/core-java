package com.chunyue.concurrency;

import static com.chunyue.concurrency.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hi from main thread!");
        // create another thread
        Thread anotherThread = new AnotherThread();
        // this runs the new thread we created: we can only start it once
        anotherThread.start();

        // this gives: java.lang.IllegalThreadStateException
        // anotherThread.start();

        // anonymous class thread
        new Thread() {
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread");
            }
        }.start();

        Thread myRunnable = new Thread(new MyRunnable());

        Thread myNewRunnable = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous runnable thread");
            }
        });

        myNewRunnable.start();
        myRunnable.start();
        System.out.println(ANSI_PURPLE + "Hello again from the main thread");
    }
}
