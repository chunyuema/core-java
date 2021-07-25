package com.chunyue.generics;

public class GenericsMethodDemoMain {
    public static void main(String[] args) {
        Bartender bartender = new Bartender();
        Juice juice = new Juice();
        Water water = new Water();
        // No need to specify the type since java can do type inference
        bartender.mix(juice, water);
        // We can also specify the types:
        bartender.<Juice, Water>mix(juice, water);
    }
}


