package com.chunyue.exceptions;

import java.io.IOException;

public class ThrowsDemoMain {
    // throws in the method signature
    void method1() throws IOException {
        // throw in the method
        throw new IOException("Device Error");
    }

    void method2() throws IOException {
        method1();
    }

    void calledMethod(){
        try {
            method2();
        } catch (IOException e){
            System.out.println(e +  " is handled here");
        }
    }

    public static void main(String[] args) {
        ThrowsDemoMain obj = new ThrowsDemoMain();
        obj.calledMethod();
        System.out.println("resume normal flow... ");
    }
}
