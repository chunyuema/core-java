package com.chunyue.reflect;

public class Dog {

    private String name;

    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Dog(String name) {
        this.name = name;
        this.age = 1;
    }

    public String toString() {
        return "Dog = { name = " + this.name + ", age = " + this.age + " }";
    }
}
