package com.chunyue.utilLang;

public class ClassObjectDemoMain {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        System.out.println("Type of x.getClass(): " + x.getClass().getClass());

        Class<?> classObject = x.getClass();
        System.out.println("x is of type: " + classObject.getName());

        System.out.println("y is of type: " + y.getClass().getName());
        System.out.println("y's super class is: " + y.getClass().getSuperclass().getName());
    }
}

class X{
    int a;
    float b;
}

class Y{
    double c;
}
