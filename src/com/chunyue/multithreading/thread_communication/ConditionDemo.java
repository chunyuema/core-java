/* Code is adapted from: https://tobebetterjavaer.com/thread/condition.html#%E4%B8%80%E4%B8%AA%E4%BE%8B%E5%AD%90 */
package com.chunyue.multithreading.thread_communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean canProceed = false;

    static class Waiter implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (!canProceed) {
                    System.out.println(Thread.currentThread().getName() + " will wait as it cannot proceed");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(
                        Thread.currentThread().getName() + " will run as it was notified on the lock condition to run");
            } finally {
                lock.unlock();
            }
        }
    }

    static class Signaler implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                canProceed = true;
                System.out.println(
                        Thread.currentThread().getName() + " signals all threads waiting on the lock condition");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread waiterThread = new Thread(new Waiter());
        Thread signalerThread = new Thread(new Signaler());
        waiterThread.start();
        signalerThread.start();
    }
}
