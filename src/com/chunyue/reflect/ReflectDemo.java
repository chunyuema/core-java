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

    private static void createInstances() throws Exception {
        Class clazz = Class.forName("com.chunyue.reflect.Dog");

        // Use *public* argument constructor to create instance
        Dog dog = (Dog) clazz.getConstructor(String.class, int.class)
                .newInstance("Ray", 3);
        System.out.println(dog);

        // If use *private* constructor, need to use getDeclaredConstructors
        Constructor dogConstructor = clazz.getDeclaredConstructor(String.class);
        dogConstructor.setAccessible(true);
        Dog dog2 = (Dog) dogConstructor.newInstance("Ray");
        System.out.println(dog2);
    }

    public static void main(String[] args) throws Exception {
        // getClassDemo();
        // getAllConstructors();
        createInstances();
    }
}
