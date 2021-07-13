package com.chunyue.concurrency;

import static com.chunyue.concurrency.ThreadColor.ANSI_GREEN;
import static com.chunyue.concurrency.ThreadColor.ANSI_PURPLE;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hi from main thread!");
        // create another thread
        Thread anotherThread = new AnotherThread();
        // this runs the new thread we created: we can only start it once
        anotherThread.start();
        System.out.println("Hello again from the main thread");

        // this gives: java.lang.IllegalThreadStateException
        // anotherThread.start();

        // anonymous class thread
        new Thread() {
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread");
            }
        }.start();
    }
}
