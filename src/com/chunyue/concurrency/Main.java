package com.chunyue.concurrency;

import static com.chunyue.concurrency.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hi from main thread!");
        // create another thread
        Thread anotherThread = new AnotherThread();
        anotherThread.setName(" ==Another Thread== ");
        // this runs the new thread we created: we can only start it once
        anotherThread.start();
        // anotherThread.run();

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
                try {
                    anotherThread.join(5000);
                    System.out.println(ANSI_CYAN + "Another thread is terminated or timedout, I am awake to do more" +
                            " stuff");
                } catch (InterruptedException e){
                    System.out.println(ANSI_CYAN + "Sorry I cannot wait!");
                }

            }
        });

        myNewRunnable.start();
        myRunnable.start();
        // anotherThread.interrupt();
        System.out.println(ANSI_PURPLE + "Hello again from the main thread");
    }
}
