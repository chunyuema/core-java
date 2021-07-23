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
        // ExecutorService service = Executors.newCachedThreadPool();
        // ExecutorService service = Executors.newScheduledThreadPool(10);


        // Submit the tasks for execution
        // Within the service the tasks submitted uses a blocking queue, which is thread safe
        for (int i = 0; i < 100; i++){
            service.execute(new Task());
            //only available if we use the Executors.newScheduledThreadPool(10);
            //service.schedule(new Task(), 10, SECONDS);
            //service.scheduleAtFixedRate(new Task(), 10, SECONDS);
            //service.scheduleWithFixedDelay(new Task(), 10, SECONDS);

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

// TYPE OF POOLS
// Fixed size pool: fixed number of threads getting tasks from the queue
// No fixed size pool: only use synchronous queue, which holds the task, look for free thread to execute, if there
// are threads available, the thread will be used, if not, a new thread is created / also kill threads if it stays
// idle for 60s
// Scheduled pool: execute something after certain delays, holds a delay queue. The tasks are stored based on the delay
// Single Thread Pool: only have one thread in the pool, used to ensure that the tasks on the blocking queue are ran
// sequentially