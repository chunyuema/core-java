package com.chunyue.lamdaexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
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

        // original for loop for grabbing employees age over 20
        System.out.println("Empolyees over 20: ");
        System.out.println("===================");
        employeeList.forEach(employee -> {
            if (employee.getAge() > 20){
                System.out.println(employee.getName());
            }
        });

        // use predicate: the employee here is infered to have the Employee
        printEmployeesByAge(employeeList, "Employee over 20", employee -> employee.getAge() > 20);

        // use anonymous class to write predicate
        printEmployeesByAge(employeeList, "Employee over 15", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 15;
            }
        });

        // original method without lambda expressions
        employeeList.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(" ") + 1);
            System.out.println("Last name is: " + lastName);
        });

        // set up function interface <Argument Type, Return Type>
        Function<Employee, String> getLastName = (Employee employee) ->{
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(" "));
        };

        // use apply to call the function on the object
        String firstName = getFirstName.apply(employeeList.get(2));
        String lastName = getLastName.apply(employeeList.get(2));
        System.out.println(firstName + " " + lastName);

        // randomly getting first and last name
        Random random1 = new Random();
        for (Employee employee: employeeList){
            if (random1.nextBoolean()){
                System.out.println(getName(getFirstName, employee));
            } else {
                System.out.println(getName(getLastName, employee));
            }
        }
    }

    // organize different lambda functions together
    private static String getName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
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
