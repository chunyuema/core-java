package com.chunyue.utilLang;

public class CharacterDemoMain {
    public static void main(String[] args) {
        isDemo();
    }

    public static void isDemo(){
        char[] chars = {'1', 'a', 'A', '?', ' '};
        for (char c: chars){
            if (Character.isDigit(c)) System.out.println(c +  " is a digit!");
            if (Character.isAlphabetic(c)) System.out.println(c + " is an alphabet");
            if (Character.isLetter(c)) System.out.println(c + " is a letter");
            if (Character.isWhitespace(c)) System.out.println(c + " is a whitespace");
            if (Character.isUpperCase(c)) System.out.println(c + " is upper case");
        }
    }
}
