package com.chunyue.concurrency;

public class Countdown {
    // this does not work with multithreading since it is stored on the heap
    // which all the threads would have the access => race condition
    // private int i;

    // it would work, with synchronization
    private int i;
    // synchronize the whole method:
    // public synchronized void doCountDown()
    public void doCountDown(){
        String color;
        switch(Thread.currentThread().getName()){
            case "Thread1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread2":
                color = ThreadColor.ANSI_BLUE;
                break;
            default:
                color = ThreadColor.ANSI_RED;
        }

        // declaring the int i here will force the i to be stored on the stack
        // for (i = 10; i>0; i--){
        //     System.out.println(color + Thread.currentThread().getName() + ": i= " + i);
        // }

        // synchronize the code block with object all the threads would share
        synchronized (this) {
            for (i=10; i>0; i--){
                System.out.println(color + Thread.currentThread().getName() + ": i= " + i);
            }
        }
    }
}


class CountdownThread extends Thread {


    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown){
        this.threadCountdown = countdown;
    }

    public void run(){
        this.threadCountdown.doCountDown();
    }
}