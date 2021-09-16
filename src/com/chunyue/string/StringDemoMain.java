package com.chunyue.string;

import java.util.Arrays;

public class StringDemoMain {
    public static void main(String[] args) {
        // createString();
        // immutableString();
        // stringComparison();
        // stringConcatenation();
        // subString();
        // stringToIntegerConversion();
        // integerToStringConversion();
        emptyVSNullString();
    }

    public static void createString(){
        char[] chars = {'i', 'o', 'u'};
        String s = new String(chars);
        System.out.println(chars);
        System.out.println("Creating string from char sets: " + s);
        String s1 = "iou";
        String s2 = new String("iou");
        System.out.println(s1 + ": " + s1.getClass());
        System.out.println(s2 + ": " + s2.getClass());
    }

    public static void immutableString(){
        String s = new String("what");
        s.concat(" lol"); // string is immutable, this "what lol" is stored as another instance
        // s = s.concat(" lol"); // unless you reassign it
        System.out.println("After concat: " + s);
    }

    public static void stringComparison(){
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println("compare x and y with ==: " + (x == y));
        System.out.println("compare x and y with equals: " + x.equals(y));
        System.out.println("compare x and y with compareTo: " + x.compareTo(y)); // compare to compares value
        System.out.println("compare x and z with ==: " + (x == z));
        // return false since the reference of x and z are different
        System.out.println("compare x and z with equals: " + x.equals(z));
        // return true since the value of x and z are same; String overwrites the equals to method
        System.out.println("compare x and z with compareTo:  " + x.compareTo(z));
    }

    public static void stringConcatenation(){
        String s1 = new String("lol");
        String s2 = new String("meh");
        System.out.println("use +: " + s1+s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("use concat: " + s1.concat(s2));
        System.out.println(s1);
        System.out.println(s2);
    }

    public static void subString(){
        String s = "Hello World";
        System.out.println(s.substring(3, 8));
        System.out.println("Split produce: " + s.split(" ").getClass());
        System.out.println(Arrays.toString(s.split(" ")));
    }

    public static void stringToIntegerConversion(){
        // using the static parseInt method from the Integer class
        String s = "200";
        System.out.println("Add 100 to String 200: " + (s+100));
        int i = Integer.parseInt(s);
        System.out.println("Add 100 to Integer 200: " + (i+100));
        // using the valueOf method
        System.out.println("Add 150 to Integer 200: " + (Integer.valueOf(s) + 150));
    }

    public static void emptyVSNullString(){
        String str = "";
        System.out.println("Is str null: " + (str == null));
    }

    public static void integerToStringConversion(){
        int i = 10;
        System.out.println("add 10 to integer 10: " + (i+10));
        System.out.println("add 10 to string 10: " + (String.valueOf(i) + 10));
        System.out.println("add 10 to string 10: " + (Integer.toString(i) + 10));
        System.out.println("add 10 to string 10: " + (String.format("%d", i) + 10));
    }
}
