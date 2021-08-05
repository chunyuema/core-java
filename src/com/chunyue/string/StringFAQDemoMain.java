package com.chunyue.string;

import java.util.Arrays;

public class StringFAQDemoMain {
    public static void main(String[] args) {
        // reverseStringUsingStringBuilder("hello my love");
        // reverseStringUsingIteration("Hello You!");
        // checkPalindrome("abba");
        // System.out.println("Capitalizing hello my love: " + capitalize("hello my love"));
        // System.out.println("Reveser each word in hello my love: " + reverseEachWord("hello my love"));
        System.out.println("Are keep and peek anagram: " + checkAnagram("peek", "keep"));
        System.out.println("Are Mother In Law and Wo tleh rI man anagram: " + checkAnagram("Mother In Law", "Wo tleh rI man"));
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

    public static boolean checkAnagram(String s1, String s2){
        String str1 = s1.replaceAll(" ", "");
        String str2 = s2.replaceAll(" ", "");
        if (str1.length() != str2.length()){
            return false;
        } else {
            char[] chars1 = str1.toLowerCase().toCharArray();
            char[] chars2 = str2.toLowerCase().toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            System.out.println(chars1);
            System.out.println(chars2);
            return Arrays.equals(chars1, chars2);
        }
    }
}
