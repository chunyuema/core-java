package com.chunyue.oop;

public class TypeCastingDemoMain {
    public static void main(String[] args) {
        // upcasting();
        // downcasting();
    }

    public static void upcasting(){
        Parent parent = new Child();
        parent.name = "Chunyue";
        System.out.println(parent.name);
        parent.method();
    }

    public static void downcasting(){
        Parent parent = new Child();
        parent.name = "AlexMa";
        Child child = (Child) parent;
        child.name = "ChunyueMa";
        child.id = 1;
        System.out.println(child.name + "; " + child.id);
        child.method();
    }
}


class Parent {
    String name;
    void method(){
        System.out.println("parent method");
    }
}

class Child extends Parent{
    int id;

    @Override
    void method(){
        System.out.println("Child method");
    }
}