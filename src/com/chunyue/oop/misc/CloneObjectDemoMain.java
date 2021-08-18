package com.chunyue.oop.misc;

class Student implements Cloneable {
    int rollNum;
    String name;

    public Student(int rollNum, String name) {
        this.rollNum = rollNum;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


public class CloneObjectDemoMain {
    public static void main(String[] args) {
        try {
            Student s1 = new Student(1, "ChunyueMa");
            Student s2 = (Student) s1.clone();
            System.out.println(s1);
            System.out.println(s2);
        } catch (CloneNotSupportedException e){
            System.out.println("Clone Error: " + e.getMessage());
        }
    }
}
