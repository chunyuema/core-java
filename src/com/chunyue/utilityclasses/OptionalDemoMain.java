package com.chunyue.utilityclasses;

import java.util.Optional;

public class OptionalDemoMain {
    public static void main(String[] args) {
        Optional<String> noString = Optional.empty();
        Optional<String> yesString = Optional.of("A string is present here");

        if (noString.isPresent()){
            System.out.println("Have content");
        } else {
            System.out.println("noString has no content");
        }

        if (yesString.isPresent()){
            System.out.println("Have content: " + yesString);
        }

        String defStr = yesString.orElse("Default");
        String defStr2 = noString.orElse("Defualt");
        System.out.println(defStr + "; " + defStr2);
    }
}
