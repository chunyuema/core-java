package com.chunyue.generics;

public class IntroToGenericsDemoMain {
    public static void main(String[] args) {
        // Generics introduced strong type checking
        // Eliminate explicit casting
        // Enables design of generic algorithm

        JuiceGlass<OrangeJuice> juiceGlass = new JuiceGlass<>();
        OrangeJuice juice = new OrangeJuice();
        juiceGlass.liquid = juice;

        // JuiceGlass<Water> will not be valid since water class
        // does not extends Juice and implements Liquid

        Glass<Water> waterGlass = new Glass<>();
        Water water = new Water();
        waterGlass.liquid = water;

        Water contentOfWaterGlass = waterGlass.liquid;
    }

}

