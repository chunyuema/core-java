package com.chunyue.multithreading.producer_consumer_pattern;

import java.util.concurrent.*;

import com.chunyue.multithreading.ThreadColor;

public class PCWithBlockingQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(6);

        Producer producer = new Producer(buffer, ThreadColor.ANSI_RED);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_BLUE);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_GREEN);

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}

class Producer implements Runnable {
    private ArrayBlockingQueue<Integer> buffer;
    private String color;

    public Producer(ArrayBlockingQueue<Integer> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Integer i = 0;
        while (i < 100) {
            try {
                System.out.println(color + Thread.currentThread().getName() + " added " + i);
                buffer.put(i);
                i++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
        System.out.println(color + "Adding NULL and exiting");
        try {
            buffer.put(null);
        } catch (InterruptedException e) {
        }
    }
}

class Consumer implements Runnable {
    private ArrayBlockingQueue<Integer> buffer;
    private String color;

    public Consumer(ArrayBlockingQueue<Integer> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.peek().equals(null)) {
                    System.out.println(color + Thread.currentThread().getName() + " is exiting");
                    break;
                } else {
                    System.out
                            .println(color + Thread.currentThread().getName() + " removed " + buffer.take());
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
            }
        }
    }

}
