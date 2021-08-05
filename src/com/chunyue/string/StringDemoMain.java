package com.chunyue.string;

import java.util.Arrays;

public class StringDemoMain {
    public static void main(String[] args) {
        // createString();
        // immutableString();
        // stringComparison();
        // stringConcatenation();
        // subString();
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
}
