package com.chunyue.exceptions;

public class FinallyDemoMain {
    public static void main(String[] args) {
        // finallyAlwaysExecution();
    }

    public static void finallyAlwaysExecution(){
        try {
            System.out.println("Inside try block");
            int data = 10/0;
        } catch (NullPointerException e){
            // wont execute since it is not the right exception
            System.out.println("null pointer");
        } finally {
            System.out.println("Finally block is always executed");
        }
    }
}
