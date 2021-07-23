package com.chunyue.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemoMain {
    public static void main(String[] args) {
        // one java thread -> one OS thread, creating a java thread is expensive
        // instead of creating them on the fly, we can create a pool of threads

        // create the thread pool: ideally, the size would be == to # of cores in the cpu
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("You have " + coreCount + " cores");
        ExecutorService service = Executors.newFixedThreadPool(10);

        // Submit the tasks for execution
        // Within the service the tasks submitted uses a blocking queue, which is thread safe
        for (int i = 0; i < 100; i++){
            service.execute(new Task());
        }
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run(){
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }
}

// CHOICE OF NUMBER OF CORES
// I/O intensive operation: threads probably spend most of the time waiting,
//        you can have large pool so as increase the chance of threads running
// CPU intensive operations: # of pool size == # of core count of the system
