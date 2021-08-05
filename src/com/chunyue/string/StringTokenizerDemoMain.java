package com.chunyue.string;

import java.util.StringTokenizer;

public class StringTokenizerDemoMain {
    public static void main(String[] args) {
        // deprecated now, recommended to use split
        simpleTokenizerDemo();
    }

    public static void simpleTokenizerDemo(){
        String s = "Hello World";
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()){
            System.out.println("The token now is: " + st.nextToken());
        }
    }
}
