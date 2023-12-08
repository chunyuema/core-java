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

    public static void main(String[] args) throws Exception {
        getClassDemo();
    }
}
