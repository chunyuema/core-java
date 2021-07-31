package com.chunyue.lamdaexpression;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

public class PredicateAndSupplierInterfaceDemoMain {
    public static void main(String[] args) {
        // create an integer predicate using lambda expression
        IntPredicate greaterThan15 = i -> i > 15;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        // predicate can also be used repeatedly
        System.out.println(greaterThan15.test(a-2));

        // chain of predicates
        IntPredicate lessThan100 = i -> i < 100;
        int b = 77;
        System.out.println(greaterThan15.and(lessThan100).test(b));
        System.out.println(greaterThan15.and(lessThan100).test(b-99));

        Random random = new Random();
        for (int i=0; i<10; i++){
            System.out.println(random.nextInt(1000));
        }

        // use lambda expression to create supplier
        Random random1 = new Random();
        Supplier<Integer> randomSupplier = () -> random1.nextInt(1000);
        for (int i=0; i<10; i++){
            System.out.println(randomSupplier.get());
        }

        // int unary operator
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));
    }
}
