package com.chunyue.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.chunyue.concurrency.ConcurrentPackageDemoMain.EOF;

public class ConcurrentPackageDemoMain {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        // ArrayList is not thread safe, will encounter thread interference
        List<String> buffer = new ArrayList<>();
        MyProvider provider = new MyProvider(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);

        new Thread(provider).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProvider implements Runnable {
    private List<String> buffer;
    private String color;

    public MyProvider(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums){
            try {
                System.out.println(color + "Adding... " + num);
                // have to synchronize the buffer
                synchronized (buffer) {
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while(true){
            // everything in the critical section
            synchronized (buffer){
                if (buffer.isEmpty()){
                    continue;
                }
                // do not remove the EOF since if it is removed
                // all the other consumers will run indefinitely
                if (buffer.get(0).equals(EOF)){
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }
        }
    }
}