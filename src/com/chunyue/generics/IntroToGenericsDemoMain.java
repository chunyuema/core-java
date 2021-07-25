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

interface Liquid{}
class Glass<T extends Liquid>{
    public T liquid;
}

// bound the types allowed to instantiate the glass with to only Juice
class JuiceGlass<T extends Juice & Liquid>{
    public T liquid;
}

class Juice {}
class OrangeJuice extends Juice implements Liquid{};
class AppleJuice extends Juice implements Liquid{}
class Water implements Liquid{}

// since cake and oil do not extend juice and implement liquid
// they cannot be used as a valid type to instantiate glass or juiceglass
class Cake{}
class Oil{}