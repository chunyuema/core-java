package com.chunyue.concurrency.livelock;

public class LiveLockDemoMain {
    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);
        final SharedResource sharedResource = new SharedResource(worker1);

        // since worker 2 is active, worker 1 will confer the common resource to worker 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        // since worker 1 is active, worker 2 will confer the common resource back to worker 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();

        // the live stock: they just keep giving the common resource back to each other

    }
}
