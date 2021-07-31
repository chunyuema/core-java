package com.chunyue.lamdaexpression;

import java.util.function.Consumer;

public class ConsumerInterfaceDemoMain {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World!");
    }
}
