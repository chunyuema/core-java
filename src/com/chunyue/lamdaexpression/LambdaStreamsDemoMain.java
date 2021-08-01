package com.chunyue.lamdaexpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaStreamsDemoMain {
    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O29");
        List<String> gNumbers = new ArrayList<>();
        bingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")){
                // gNumbers is effectively final since the reference will not change
                gNumbers.add(number);
            }
        });

        // using lambda functions to sort
        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        System.out.println(gNumbers);

        // ===============================================================================
        // use streams to perform the same task
        bingoNumbers.stream() //sets up the stream containing all the items from bingoNumbers
                // intermediate operations: return something to be passed on
                .map(String::toUpperCase) // map the function to the argument
                .filter(s->s.startsWith("G"))
                .sorted()
                // terminal operation: return void, nothing to pass on
                .forEach(System.out::println); // we will get G64 instead of g64


        // no changes to the original bingoNumbers
        System.out.println(bingoNumbers);
        // ===============================================================================

        List<String> sortedGNumbers = bingoNumbers
                .stream()
                .map(String::toUpperCase) // map the function to the argument
                .filter(s->s.startsWith("G"))
                .sorted()
                // another option of collecting the output and store them in a variable
                .collect(Collectors.toList());
        System.out.println(sortedGNumbers);

        List<String> sortedGNumbers2 = bingoNumbers
                .stream()
                .map(String::toUpperCase) // map the function to the argument
                .filter(s->s.startsWith("G"))
                .sorted()
                // specify the data structure for the collect
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(sortedGNumbers2);

        // ===============================================================================
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "071", "I26");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("------------------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out:: println) // need to use peek since it does not terminate the stream
                .count());

        // ===============================================================================
        Employee chunyue = new Employee("Chunyue Ma", 23);
        Employee john = new Employee("John Ma", 24);
        Employee jane = new Employee("Jane Ma", 24);
        Employee alex = new Employee("Alex Ma", 33);

        Department hr = new Department("HR");
        hr.addEmployee(jane);
        hr.addEmployee(john);
        hr.addEmployee(alex);
        Department swe = new Department("SWE");
        swe.addEmployee(chunyue);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(swe);

        departments.stream()
                // flatten nested list
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                // group the employees with the same age
                .collect(Collectors.groupingBy(employee -> employee.getAge()));
        System.out.println(groupByAge);

        // ===============================================================================
        // use reduce to reduce a map into one element
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        // ===============================================================================
        // This is not evaluated at all since there is no terminal operations: lazy evaluation
        Stream.of("ABC", "AC", "BAA", "CCC")
                .filter(s->{
                    System.out.println(s);
                    return s.length() == 3;
                });
        // Only evalucate when there is a terminal operations
        Stream.of("ABC", "AC", "BAA", "CCC")
                .filter(s->{
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}
