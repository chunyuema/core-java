package com.chunyue.inputouput;

import java.io.Console;

public class ConsoleDemoMain {
    public static void main(String[] args) {
        readLineDemo();
    }

    public static void readLineDemo(){
        Console console =System.console();
        if (console == null) {
            System.out.println("No console available :(");
            return;
        }
        String n = console.readLine("Enter your name: ");
        System.out.println("Welcome "+n);
    }
}
