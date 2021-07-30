package com.chunyue.lamdaexpression;

public class LambdaExpressionDemoMain {
    public static void main(String[] args) {
        // quick thread creation with lambda expression
        // lambda match the run() function into the lambda expression below
        new Thread(() -> {
            System.out.println("Printing from Runnable");
            System.out.println("This is line 2");
            System.out.println("This is line 3");
        }).start();


    }
}


