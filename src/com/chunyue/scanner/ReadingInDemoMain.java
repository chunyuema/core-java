package com.chunyue.scanner;

import java.util.Scanner;

public class ReadingInDemoMain {
    public static void main(String[] args) {
        // create a scanner object attached to system.in
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = in.nextLine();

        System.out.println("How old are you? ");
        int age = in.nextInt();

        System.out.println("Hello, you are " + name + " and you are " + age + " years old.");
    }
}
