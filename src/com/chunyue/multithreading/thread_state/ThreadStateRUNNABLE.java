package com.chunyue.multithreading.thread_state;

public class ThreadStateRUNNABLE {

    private static void threadInRUNNABLEState() {
        Thread thread = new Thread(() -> {
            System.out.println("Thread has started working...");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            System.out.println("Thread has finished working...");
        });
        System.out.println("A recently created thread has state: " + thread.getState());
        thread.start();
        System.out.println("A running thread has state: " + thread.getState());
    }

    public static void main(String[] args) {
        threadInRUNNABLEState();
    }
}
