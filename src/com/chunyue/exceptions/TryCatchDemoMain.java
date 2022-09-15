package com.chunyue.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchDemoMain {
    public static void main(String[] args) {
        // System.out.println(basicErrorHandling(3, 2));
        // System.out.println(basicErrorHandling(3, 0));
        // System.out.println(checkUserIntegerInputNoTry());
        // tryUntilUserEntersValidInput();
        // simpleCheckUserIntegerInputWithTry();
        // tryCatchException();
        // tryCatchArithmeticException();
        // tryCatchWrongException();
        // multiCatchException();
        // multiCatchExceptionWrongSequence();

    }

    private static int basicErrorHandling(int x, int y){
        try {
            return x / y;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    private static int checkUserIntegerInputNoTry(){
        System.out.println("Enter an integer: ");
        Scanner s = new Scanner(System.in);
        String x = s.next();
        for (int i = 0; i < x.length(); i++){
            if (!Character.isDigit((x.charAt(i)))){
                System.out.println("Input invalid, return 0 by default");
                return 0;
            }
        }
        System.out.println("Valid input: " + x);
        return Integer.parseInt(x);
    }

    private static int simpleCheckUserIntegerInputWithTry(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter integer: ");
        try {
            int x = s.nextInt();
            System.out.println("User entered " + x);
            return x;
        } catch (InputMismatchException e){
            System.out.println("Invalid input");
            return 0;
        }
    }

    private static int tryUntilUserEntersValidInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        while (true){
            try {
                int x = s.nextInt();
                System.out.println("Valid user input: " + x);
                return x;
            } catch (InputMismatchException e){
                s.nextLine();
                System.out.println("Please only use digit 0 to 9");
            }
        }
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

    public static void multiCatchException(){
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
