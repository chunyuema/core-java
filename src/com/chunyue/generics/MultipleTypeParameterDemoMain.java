package com.chunyue.generics;

public class MultipleTypeParameterDemoMain {
    public static void main(String[] args) {

        Red red = new Red();
        Green green = new Green();
        Blue blue = new Blue();
        Color color = new Color(red, green, blue);
        System.out.println(color.blue.getClass());

        // The following is okay due to Java's type inference
        Color<Red, Green, Blue>color2 = new Color<>();
        System.out.println(color2.blue);
    }
}


