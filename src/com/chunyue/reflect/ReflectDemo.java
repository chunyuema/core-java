package com.chunyue.reflect;

import java.lang.reflect.Constructor;

public class ReflectDemo {

    private static void getClassDemo() throws Exception {
        Class clazz1 = Dog.class;
        System.out.println(clazz1);

        Class clazz2 = new Dog().getClass();
        System.out.println(clazz2);

        Class clazz3 = Class.forName("com.chunyue.reflect.Dog");
        System.out.println(clazz3);
    }

    private static void getAllConstructors() {
        Class clazz = Dog.class;
        // This will only get public constructors
        for (Constructor c : clazz.getConstructors()) {
            System.out.println(c.getName() + " takes " + c.getParameterCount() + " arguments.");
        }

        // This will get all constructors
        for (Constructor c : clazz.getDeclaredConstructors()) {
            System.out.println(c.getName() + " takes " + c.getParameterCount() + " arguments.");
        }
    }

    private static void getConstructorThroughReflect() throws Exception {
        Class clazz = Class.forName("com.chunyue.reflect.Dog");
        Dog dog = (Dog) clazz.getDeclaredConstructor().newInstance();
        System.out.println(dog);

        Dog dog2 = (Dog) clazz.getConstructor().newInstance();
        System.out.println(dog2);
    }

    public static void main(String[] args) throws Exception {
        // getClassDemo();
        // getConstructorThroughReflect();
        getAllConstructors();
    }
}
