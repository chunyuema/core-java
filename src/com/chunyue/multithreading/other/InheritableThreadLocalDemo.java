package com.chunyue.multithreading.other;

public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread t1 = new Thread(() -> {
            System.out.println("t1 is setting the ThreadLocal variable");
            threadLocal.set("t1-threadlocal");
            System.out.println("t1 is setting the InheritableThreadLocal variable ");
            inheritableThreadLocal.set("t1-inheritablethreadlocal");
            System.out.println(threadLocal.get() + ", " + inheritableThreadLocal.get());

            System.out.println("t1 is starting a child thread ct1");

            Thread ct1 = new Thread(() -> {
                System.out.println("For ct1, ThreaLocal variable set by its parent is invisible: " + threadLocal.get());

                System.out.println("For ct1, InheritableThreadLocal variable set by its parent is visible: "
                        + inheritableThreadLocal.get());
            });
            ct1.start();
        });

        t1.start();
    }
}
