package com.chunyue.multithreading.synchronizedkeyword;

public class SynchronizedBlockDemoMain {
    public static void main(String[] args) {
        Table2 table = new Table2();
        Thread1 t1 = new Thread1(table);
        Thread2 t2 = new Thread2(table);
        t1.start();
        t2.start();
    }
}

class Table2 {
    void printTable(int n){
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

class Thread3 extends Thread {
    Table2 t;

    public Thread3(Table2 t) {
        this.t = t;
    }

    public void run(){
        t.printTable(5);
        System.out.println(Thread.currentThread().getName() + "'s task is completed, releasing the lock");
    }
}

class Thread4 extends Thread {
    Table2 t;

    public Thread4(Table2 t) {
        this.t = t;
    }

    public void run(){
        t.printTable(100);
    }
}
