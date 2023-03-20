package com.chunyue.multithreading.race_condition;

class NonSynchronizedCounterThread extends Thread {
    SimpleCounter nsc;

    public NonSynchronizedCounterThread(SimpleCounter nsc) {
        this.nsc = nsc;
    }

    public void run() {
        System.out.println(nsc);
        for (int i = 0; i <= 1000; i++) {
            nsc.increment();
        }
        System.out.println(
                Thread.currentThread().getName() + " finished, the synchronized counter counts to " + nsc.getC());
    }
}

public class SimpleRaceCondition {

    private static void nonSynchronizedMethod() {
        // Two threads share the same nonsynchronized counter
        SimpleCounter nsc = new SimpleCounter();
        NonSynchronizedCounterThread t1 = new NonSynchronizedCounterThread(nsc);
        NonSynchronizedCounterThread t2 = new NonSynchronizedCounterThread(nsc);
        // After the threads are started, both will attempt to increment the counter,
        // this hence results in the race condition, and the program does not
        // necessarily count to 2002
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        nonSynchronizedMethod();
    }
}
