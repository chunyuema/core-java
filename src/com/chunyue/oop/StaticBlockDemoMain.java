package com.chunyue.oop;

public class StaticBlockDemoMain {

    static {
        System.out.println("Static Block code running before Main");
    }

    public static void main(String[] args) {
        System.out.println("Hello World From Main");
    }
}
