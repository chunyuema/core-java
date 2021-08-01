package com.chunyue.lamdaexpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        // use streams to perform the same task
        bingoNumbers.stream() //sets up the stream
                .map(String::toUpperCase) // map the function to the argument
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
    }
}
