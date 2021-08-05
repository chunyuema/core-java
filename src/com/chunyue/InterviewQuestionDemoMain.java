package com.chunyue;

public class InterviewQuestionDemoMain {
    public static void main(String[] args) {
        // equalsDemo();
        sameHashCodeButNotEqual();
    }

    public static void equalsDemo(){

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

    public static void sameHashCodeButNotEqual(){
        // same hash code does not mean equality
        String s1 = new String("通话");
        String s2 = new String("重地");
        String s3 = "love";
        System.out.println("Hashcode for s1: " + s1.hashCode());
        System.out.println("Hashcode for s2: " + s2.hashCode());
        System.out.println("Hashcode for s3: " + s3.hashCode());
        System.out.println(s1.equals(s2) + " | " + s1.equals(s3) + " | " + s2.equals(s3));
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