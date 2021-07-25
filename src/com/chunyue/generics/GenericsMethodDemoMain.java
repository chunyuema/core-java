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

class Bartender{
    public<T1, T2> void mix(T1 juice, T2 water){
        System.out.println("Mixing right now!");
    }
}
