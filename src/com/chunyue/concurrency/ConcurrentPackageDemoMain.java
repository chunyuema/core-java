package com.chunyue.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.chunyue.concurrency.ConcurrentPackageDemoMain.EOF;

public class ConcurrentPackageDemoMain {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        // ArrayList is not thread safe, will encounter thread interference
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        // Using the executorService when there is a large number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProvider provider = new MyProvider(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);


        // without using the executor service
        // new Thread(provider).start();
        // new Thread(consumer1).start();
        // new Thread(consumer2).start();

        // using the executorService
        executorService.execute(provider);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        // need to manually shutdown the executorService


        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_PURPLE + "I am being printed from the callable class");
                return "This is the callable result";
            }
        });

        // This will not be run if we only pass 3 into executorService
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProvider implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProvider(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums){
            try {
                System.out.println(color + "Adding... " + num);
                bufferLock.lock();
                try {
                    // include the critical code block here
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        // acquire the lock
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            // manually release the lock
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;
    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        while(true){
            // acquire the lock
            bufferLock.lock();
            // can use if(bufferLock.tryLock()){...} to test if we can get the lock

            // include the critical code block in the try block
            try {
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
            } finally {
                bufferLock.unlock();
            }
        }
    }
}