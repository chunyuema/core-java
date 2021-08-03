package com.chunyue;

public class InterviewQuestionDemoMain {
    public static void main(String[] args) {
        equalsDemo();
    }

    public static void equalsDemo(){
        String x = "string";
        String y = "string";
        System.out.println(x == y);
        System.out.println(x.equals(y));

        String z = new String("string");
        System.out.println(z);
        System.out.println(x == z); // return false since the reference of x and z are different
        System.out.println(x.equals(z)); // return true since the value of x and z are same; String overwrites the
        // equals to method

        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b); // return false since the reference of a and b are different
        System.out.println(a.equals(b)); // return true since the value of a and b are same, Integer overwrites the
        // equals method

        Cat c1 = new Cat("chunyue");
        Cat c2 = new Cat("chunyue");
        System.out.println(c1 == c2); // return false since c1 and c2 are two different references
        System.out.println(c1.equals(c2)); // return false since c1 and c2 arw two different references, Cat class
        // does not override the equals method
    }
}


class Cat{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}