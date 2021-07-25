package com.chunyue.generics;

public class IntroToGenericsDemoMain {
    public static void main(String[] args) {
        // Generics introduced strong type checking
        // Eliminate explicit casting
        // Enables design of generic algorithm
        Glass<Juice> juiceGlass = new Glass<>();
        Juice juice = new Juice();
        juiceGlass.liquid = juice;

        Glass<Water> waterGlass = new Glass<>();
        Water water = new Water();
        waterGlass.liquid = water;

        Water contentOfWaterGlass = waterGlass.liquid;
    }

}

class Glass<T>{
    public T liquid;
}
class Juice{}
class Water{}

