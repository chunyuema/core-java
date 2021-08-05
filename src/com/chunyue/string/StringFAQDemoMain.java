package com.chunyue.string;

public class StringFAQDemoMain {
    public static void main(String[] args) {
        //reverseStringUsingStringBuilder("hello my love");
        // reverseStringUsingIteration("Hello You!");
        // checkPalindrome("abba");
        // System.out.println("Capitalizing hello my love: " + capitalize("hello my love"));
        System.out.println("Reveser each word in hello my love: " + reverseEachWord("hello my love"));
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

    public static String capitalize(String s){
        String[] words = s.split(" ");
        String newString = "";
        for (String word: words){
            newString += word.substring(0,1).toUpperCase() + word.substring(1)+" ";
        }
        return newString.trim();
    }

    public static String reverseEachWord(String s){
        String[] words = s.split(" ");
        String newString = "";
        for (String word: words){
            StringBuilder sb = new StringBuilder(word);
            newString += sb.reverse().toString() + " ";
        }
        return newString.trim();
    }
}
