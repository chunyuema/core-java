package com.chunyue.lamdaexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceDemoMain {
    public static void main(String[] args) {
        Employee chunyue = new Employee("Chunyue Ma", 22);
        Employee jack = new Employee("Jack Ma", 42);
        Employee alex = new Employee("Alex Ma", 10);
        Employee bobby = new Employee("Bobby Ma", 16);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(chunyue);
        employeeList.add(jack);
        employeeList.add(alex);
        employeeList.add(bobby);

        // use this lambda function to replace the enhanced for loop
        // internally, iterator calls the consumer.accept method, which evaluates the lambda
        employeeList.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        System.out.println("Empolyees over 20: ");
        System.out.println("===================");

//        employeeList.forEach(employee -> {
//            if (employee.getAge() > 20){
//                System.out.println(employee.getName());
//            }
//        });

        // use predicate
        printEmployeesByAge(employeeList, "Employee over 20", employee -> employee.getAge() > 20);

    }
    private static void printEmployeesByAge(List<Employee> employeeList, String ageText,
                                            Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("===============");
        employeeList.forEach(employee -> {
            if (ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        });
    }
}
