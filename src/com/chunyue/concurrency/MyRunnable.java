package com.chunyue.concurrency;

import static com.chunyue.concurrency.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from myRunnable.");
    }
}
