package com.chunyue.lamdaexpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "071", "I26");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("------------------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out:: println) // need to use peek since it does not terminate the stream
                .count());
    }
}
