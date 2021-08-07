package com.chunyue.exceptions;

public class ThrowDemoMain {
    public static void main(String[] args) {
        // throwUncheckedException(18);
        // throwCheckedException(18);
        // userDefinedException(18);
        // userDefinedException(22);
        emptyMsgException();
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
            // when calling the validateAge, we hence needs to handle this potential exception
            validateAge(age);
        } catch (DrinkingAgeException e){
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }

    public static void emptyMsgException(){
        try {
            throw new EmptyMessageException();
        } catch (EmptyMessageException e){
            System.out.println("Error occured with the message: " + e.getMessage());
        }
    }

    // validateAge is created with the possibility of throwing a DrinkingAgeExcpetion
    public static void validateAge(int age) throws DrinkingAgeException{
        if (age < 21){
            throw new DrinkingAgeException("Not old enough to drink sorry");
        } else {
            System.out.println("Welcome to the drinking club");
        }
    }
}

class DrinkingAgeException extends Exception{
    public DrinkingAgeException(String message) {
        super(message);
    }
}

class EmptyMessageException extends Exception{}
