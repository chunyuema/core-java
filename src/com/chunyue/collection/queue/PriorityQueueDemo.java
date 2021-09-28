package com.chunyue.collection.queue;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    private static PriorityQueue<LocalDate> dates = new PriorityQueue<>();
    static {
        dates.add(LocalDate.of(1998, 6, 19));
        dates.add(LocalDate.of(1999, 4, 19));
        dates.add(LocalDate.of(1973, 5, 16));
        dates.add(LocalDate.of(1983, 7, 23));
    }

    public static void main(String[] args) {
        // iteratingPQ();
        // removingFromPQ();
    }

    public static void iteratingPQ(){
        System.out.println("Iterating PQ does not give any fixed order...");
        for (LocalDate date: dates){
            System.out.println(date);
        }
    }

    public static void removingFromPQ(){
        System.out.println("Removing from PQ follows certain order based on the priority...");
        while (!dates.isEmpty()){
            System.out.println("Removing: " + dates.remove());
        }
    }
}
