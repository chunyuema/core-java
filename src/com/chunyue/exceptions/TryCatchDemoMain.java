package com.chunyue.exceptions;

public class TryCatchDemoMain {
    public static void main(String[] args) {
        // tryCatchException();
        // tryCatchArithmeticException();
        // tryCatchWrongException();
        // multiCatchExceptionn();
        // multiCatchExceptionWrongSequence();
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

    public static void multiCatchExceptionn(){
        try {
            int[] a = {1, 2, 4, 5};
            System.out.println(a[2]);
            System.out.println(a[6]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bounds!");
        } catch (ArithmeticException e){
            System.out.println("Arithmetic exceptions: " + e);
        } catch (Exception e){
            System.out.println("Parent Exception is handling this");
        }
        System.out.println("The rest of the code....");
    }

    // this one will not compile
    public static void multiCatchExceptionWrongSequence(){
        try {
            int[] a = {1, 2, 4, 5};
            System.out.println(a[2]);
            System.out.println(a[6]);
        } catch (Exception e){
            System.out.println("Parent exception handling this!");}
//        } catch (ArithmeticException e){
//            System.out.println("Arithmetic exceptions: " + e);
//        } catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Array index out of bounds");
//        }
//        System.out.println("The rest of the code....");
    }
}
