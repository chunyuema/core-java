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


        List<StudentNew> newStudents = new ArrayList<>();
        newStudents.add(new StudentNew(1, 55));
        newStudents.add(new StudentNew(2, 88));
        newStudents.add(new StudentNew(3, 45));
        newStudents.add(new StudentNew(4, 67));
        newStudents.add(new StudentNew(5, 78));
        Collections.sort(newStudents);
        // This works since studentnew class implements the comparable interface
        for (StudentNew s: newStudents){
            System.out.println(s);
        }
    }
}

// The student class does not implement comparable interface
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

// The new student class will implement comparable interface
class StudentNew implements Comparable<StudentNew>{
    int rollno;
    int mark;

    public StudentNew(int rollno, int mark) {
        this.rollno = rollno;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "StudentNew{" +
                "rollno=" + rollno +
                ", mark=" + mark +
                '}';
    }

    @Override
    public int compareTo(StudentNew o) {
        return this.mark > o.mark ? -1 : this.mark < o.mark ? 1: 0;
    }
}
