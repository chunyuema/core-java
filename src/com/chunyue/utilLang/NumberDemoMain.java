package com.chunyue.utilLang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberDemoMain {
    public static void main(String[] args) {
        try {
            parseStringToNumberDemo();
        } catch (IOException e){
            System.out.println("IO exception occurred");
        }
    }

    public static void parseStringToNumberDemo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int i;
        int sum = 0;
        System.out.println("Enter numbers, 0 to quit: ");
        do {
            s = br.readLine();
            try{
                i = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Invalid Input for a number!");
                i = 0;
            }
            sum += i;
            System.out.println("Current Sum is: " + sum);
        } while (i != 0);
    }
}
