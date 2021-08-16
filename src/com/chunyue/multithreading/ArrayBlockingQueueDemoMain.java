package com.chunyue.concurrency;

import java.util.Random;
import java.util.concurrent.*;

import static com.chunyue.concurrency.ConcurrentPackageDemoMain.EOF;

public class ArrayBlockingQueueDemoMain {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        // Using the executorService when there is a large number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProviderABQ provider = new MyProviderABQ  (buffer, ThreadColor.ANSI_RED);
        MyConsumerABQ consumer1 = new MyConsumerABQ (buffer, ThreadColor.ANSI_BLUE);
        MyConsumerABQ consumer2 = new MyConsumerABQ (buffer, ThreadColor.ANSI_GREEN);

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

class MyProviderABQ implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProviderABQ (ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums){
            try {
                System.out.println(color + "Adding... " + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch(InterruptedException e ){
        }
    }
}

class MyConsumerABQ implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;
    public MyConsumerABQ(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        synchronized (buffer){
            while(true){
                try {
                    if (buffer.isEmpty()){ continue;}
                    if (buffer.peek().equals(EOF)){
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch(InterruptedException e) {
                }
            }
        }
    }
}
