package com.chunyue.oop;

public class StaticVariableDemoMain {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
    }
}

class Counter{
    // static variable shared among all instance variables
    static int count = 0;

    Counter(){
        count ++;
        System.out.println("Total Number of objects created: " + count);
    }
}