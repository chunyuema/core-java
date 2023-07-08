package com.chunyue.collection.iterators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachLoop {
    private static void defineConsumerInForEach() {
        List<String> sList = new LinkedList<>(Arrays.asList("Chunyue", "Bobby"));
        sList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    private static void useLambdaForConsumer() {
        List<String> sList = new LinkedList<>(Arrays.asList("Chunyue", "Bobby"));
        sList.forEach(s -> {
            System.out.println(s);
        });
    }

    private static void useMethodReference() {
        List<String> sList = new LinkedList<>(Arrays.asList("Chunyue", "Bobby"));
        sList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        defineConsumerInForEach();
        useLambdaForConsumer();
        useMethodReference();
    }
}
