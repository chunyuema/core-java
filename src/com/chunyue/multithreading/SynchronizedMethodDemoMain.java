package com.chunyue.multithreading;

class Table {
    // synchronized method: lock the object for shared resource
    synchronized void printTable(int n){
        for (int i=1; i<=5; i++){
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class Thread1 extends Thread {
    Table t;

    public Thread1(Table t) {
        this.t = t;
    }

    public void run(){
        t.printTable(5);
        System.out.println(Thread.currentThread().getName() + "'s task is completed, releasing the lock");
    }
}

class Thread2 extends Thread {
    Table t;

    public Thread2(Table t) {
        this.t = t;
    }

    public void run(){
        t.printTable(100);
    }
}

public class SynchronizedMethodDemoMain {
    public static void main(String[] args) {
        Table table = new Table();
        Thread1 t1 = new Thread1(table);
        Thread2 t2 = new Thread2(table);
        t1.start();
        t2.start();
    }

}
