package com.chunyue.lamdaexpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUsingLambdaDemoMain {
    public static void main(String[] args) {
        Employee chunyue = new Employee("Chunyue Ma", 22);
        Employee jack = new Employee("Jack Ma", 42);
        Employee alex = new Employee("Alex Ma", 10);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(chunyue);
        employeeList.add(jack);
        employeeList.add(alex);
        // traditional method of defining the comparator for sorting
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(employeeList);
        Employee bobby = new Employee("Bobby Ma", 16);
        employeeList.add(bobby);
        // use a lambda expression for quick creation of comparator
        Collections.sort(employeeList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(employeeList);


        // use this lambda function to replace the enhanced for loop
        employeeList.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        for(Employee employee: employeeList){
//            System.out.println(employee.getName());
//            // the employee from the lambda expression has access to the employee created for the enhanced forloop
//            new Thread(()-> System.out.println(employee.getAge())).start();
//        }
    }
}

