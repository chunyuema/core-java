/* Code Adapted From: https://www.geeksforgeeks.org/inter-thread-communication-java/ */
package com.chunyue.multithreading.thread_communication;

public class WaitAndNotifyDemo {

    public static void main(String[] args) {
        final PC pc = new PC();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    public static class PC {
        private int itemNumber = 1;

        public void produce() throws InterruptedException {
            synchronized (this) {
                System.out.println("Producing Item " + itemNumber);
                // Wait will immediately release the lock for the other thread to get them and
                // start working, hence what happens after wait will not be executed right away
                wait();
                System.out.println("Producer resume producing item " + itemNumber);
            }
        }

        public void consume() throws InterruptedException {
            Thread.sleep(1000);
            synchronized (this) {
                System.out.println("Consuming Items " + itemNumber);
                // After calling notify, the lock is not immediately released, therefore the
                // lines after it will be executed, and hence we will increment ther itemNumber
                // here.
                notify();
                System.out.println("Item consumed, incrementing item number");
                itemNumber++;
            }
        }
    }
}
