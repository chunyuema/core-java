package com.chunyue.reflect;

public class ReflectDemo {

    private static void getClassDemo() throws Exception {
        Class clazz1 = Dog.class;
        System.out.println(clazz1);

        Class clazz2 = new Dog().getClass();
        System.out.println(clazz2);

        Class clazz3 = Class.forName("com.chunyue.reflect.Dog");
        System.out.println(clazz3);
    }

    private static void getConstructorThroughReflect() throws Exception {
        Class clazz = Class.forName("com.chunyue.reflect.Dog");
        Dog dog = (Dog) clazz.getDeclaredConstructor().newInstance();
        System.out.println(dog);
    }

    public static void main(String[] args) throws Exception {
        // getClassDemo();
        getConstructorThroughReflect();
    }
}
