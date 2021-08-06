package com.chunyue.exceptions;

public class TryCatchDemoMain {
    public static void main(String[] args) {
        // tryCatchException();
        // tryCatchArithmeticException();
        // tryCatchWrongException();
    }

    public static void tryCatchException(){
        try{
            int data = 50/0;
        } catch (Exception e){
            System.out.println("Exception occurred: " + e);
        }
        System.out.println("The rest of the code will proceed");
    }

    public static void tryCatchArithmeticException(){
        try {
            int data = 50/0;
        } catch (ArithmeticException e){
            System.out.println("Exception occurred: " + e);
        }
        System.out.println("The rest of the code will proceed");
    }

    public static void tryCatchWrongException(){
        try {
            int data = 50/0;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception occurred: " + e);
        }
        System.out.println("The rest of the code will proceed");
    }
}
