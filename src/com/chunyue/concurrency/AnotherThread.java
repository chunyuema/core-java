package com.chunyue.concurrency;
import static com.chunyue.concurrency.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from another thread!");
    }
}
