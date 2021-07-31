package com.chunyue.lamdaexpression;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierInterfaceDemoMain {
    public static void main(String[] args) {
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
    }
}
