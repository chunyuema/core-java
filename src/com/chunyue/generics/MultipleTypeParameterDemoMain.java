package com.chunyue.generics;

public class MultipleTypeParameterDemoMain {
    public static void main(String[] args) {

        Red red = new Red();
        Green green = new Green();
        Blue blue = new Blue();
        Color color = new Color(red, green, blue);
        System.out.println(color.blue.getClass());
    }
}


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

class Red{}
class Green{}
class Blue{}