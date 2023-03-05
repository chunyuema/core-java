package com.chunyue.multithreading.thread_state;

public class ThreadStateNEW {

    private static void threadInNewState() {
        Thread thread = new Thread(() -> {
        });
        System.out.println(
                "A newly created thread has state: " +
                        thread.getState());
    }

    public static void main(String[] args) {
        threadInNewState();
    }
}
