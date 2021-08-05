package com.chunyue.string;

public class StringFAQDemoMain {
    public static void main(String[] args) {
        reverseStringUsingStringBuilder("Hello World");
        reverseStringUsingIteration("Hello You!");
        checkPalindrome("abba");
    }

    public static String reverseStringUsingStringBuilder(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println("Reversed String is: " + sb);
        System.out.println(sb.getClass());
        return sb.toString();
    }

    public static String reverseStringUsingIteration(String s){
        char[] chars = s.toCharArray();
        String newString = "";
        for (int i=s.length()-1; i>=0; i--){
            newString += chars[i];
        }
        System.out.println("Reversed String is: " + newString);
        return newString;
    }

    public static boolean checkPalindrome(String s){
        String reversedString = reverseStringUsingIteration(s);
        if (s.equals(reversedString)){
            System.out.println("Found the palindrome!");
            return true;
        }
        return false;
    }
}
