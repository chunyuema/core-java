package com.chunyue.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomTypeComparatorDemoMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 55));
        students.add(new Student(2, 88));
        students.add(new Student(3, 45));
        students.add(new Student(4, 67));
        students.add(new Student(5, 78));

        for(Student s: students){
            System.out.println(s);
        }

        // sort using a customized comparator
        Collections.sort(students, (s1, s2)->{
            return s1.mark > s2.mark ? -1 : s1.mark < s2.mark ? 1 : 0;
        });

        for(Student s: students){
            System.out.println(s);
        }

    }
}

class Student{
    int rollno;
    int mark;

    public Student(int rollno, int mark) {
        this.rollno = rollno;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", mark=" + mark +
                '}';
    }
}