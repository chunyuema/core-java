package com.chunyue.exceptions;

public class ThrowDemoMain {
    public static void main(String[] args) {
        // throwUncheckedException(18);
        // throwCheckedException(18);
        userDefinedException(18);
    }

    public static void throwUncheckedException(int age){
        if (age < 21){
            throw new ArithmeticException("Not old enough to drink");
        }
        System.out.println("Yes you can drink");
    }

    public static void throwCheckedException(int age){
        try {
            throwUncheckedException(age);
        } catch (ArithmeticException e){
            System.out.println(e);
        }
    }

    public static void userDefinedException(int age){
        try {
            if (age<21){
                throw new DrinkingAgeException("Not old enough to drink");
            }
        } catch (DrinkingAgeException e){
            System.out.println(e);
        }
    }
}

class DrinkingAgeException extends Exception{
    public DrinkingAgeException(String message) {
        super(message);
    }
}
