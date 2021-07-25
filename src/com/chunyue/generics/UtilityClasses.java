package com.chunyue.generics;

public class UtilityClasses {
}

// ======== generics method demo utility classes =====
class Bartender{
    public<T1, T2> void mix(T1 juice, T2 water){
        System.out.println("Mixing right now!");
    }
}


// ======== intro to generics demo utility classes =====
interface Liquid{}
class Glass<T>{
    public T liquid;
}

// bound the types allowed to instantiate the glass with to only Juice
class JuiceGlass<T extends Juice & Liquid>{
    public T liquid;
}
// WineGlass<Juice> is a relation with Glass<Juice>

class WineGlass<T> extends Glass<T>{}
class Juice implements Liquid{}
class OrangeJuice extends Juice implements Liquid{};
class Water implements Liquid{}

// since cake and oil do not extend juice and implement liquid
// they cannot be used as a valid type to instantiate glass or juiceglass
class Cake{}
class Oil{}


// ======== mutilple type parameters demo utility classes =====
class Color<R,G,B> {
    public R red;
    public G green;
    public B blue;

    public Color(R red, G green, B blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color() {
    }
}
// These are the type arguments
class Red{}
class Green{}
class Blue{}