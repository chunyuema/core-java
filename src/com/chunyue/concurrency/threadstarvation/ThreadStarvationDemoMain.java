package com.chunyue.concurrency.threadstarvation;

import com.chunyue.concurrency.ThreadColor;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadStarvationDemoMain {

    // all the thread will be competing for this lock
    // private static Object lock = new Object();

    // use a re-entrant lock set up the fair lock: first come first serve
    // might slow down the program when there are many threads
    // whether to use a fair lock depends on the tasks that the threads are performing
    // it might be okay to have the thread waiting instead of using a fairlock
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        // note that priority is not a binding that os has to follow, it is just the suggestion
        // the highest priority thread will hold the lock for way long time
        // lower priority might probably be starved (rarely given a time to run)
        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run(){
            for (int i = 0; i<100; i++){
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(),
                            runCount++);
                } finally {
                    lock.unlock();
                }

//                synchronized (lock) {
//                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(),
//                            runCount++);
//                    // execute critical section of code
                }
            }
        }
}
