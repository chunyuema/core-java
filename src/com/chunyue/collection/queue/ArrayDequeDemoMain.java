package com.chunyue.collection.queue;

import java.util.ArrayDeque;

public class ArrayDequeDemoMain {
    public static void main(String[] args) {
        stackWithArrayDeque();
    }

    public static void stackWithArrayDeque(){
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("A");
        stack.push("D");
        stack.push("Q");
        System.out.println("Popping the stack!");
        while(stack.peek()!=null){
            System.out.println(stack.pop() + " ");
        }
        System.out.println();
    }
}
