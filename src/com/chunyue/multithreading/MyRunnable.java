package com.chunyue.multithreading;

import static com.chunyue.multithreading.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from myRunnable.");
    }
}
