package com.chunyue.oop;

public class StaticMethodDemoMain {
    public static void main(String[] args) {
        // testStudent();
        // testCalculator();
    }

    public static void testStudent(){
        Student s1 = new Student("chunyue");
        System.out.println(s1 +  " is from " + s1.college);
        // calling static method
        Student.changeCollege("MIT");
        Student s2 = new Student("chunyue2");
        System.out.println(s2 + " is from " + s2.college);
    }

    public static void testCalculator(){
        int x = 5;
        int y = Calculator.cube(x);
        System.out.println("y is: " + y);
    }
}

class Student{
    private String name;
    static String college = "Wesleyan";

    public static void changeCollege(String collegeName){
        college = collegeName;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Calculator{
    static int cube(int x){
        return x*x*x;
    }
}