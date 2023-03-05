package com.chunyue.multithreading.thread_state;

public class ThreadStateTIMEDWAITINGState {
    public static void threadInTIMEDWAITINGState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                // Sleep this thread for 1000L
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        while (thread.isAlive()) {
            System.out.println("The current thread has state " + thread.getState());
            // This sleeps the main thread so we do not get too many lines of outputs on the
            // console
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        threadInTIMEDWAITINGState();
    }
}
