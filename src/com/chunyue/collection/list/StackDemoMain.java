package com.chunyue.collection.list;

import java.util.Iterator;
import java.util.Stack;

public class StackDemoMain {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // adding elements to the stack
        stack.push("Ayush");
        stack.push("Garvit");
        stack.push("Amit");
        stack.push("Ashish");
        stack.push("Garima");
        // poping elements from the stack
        System.out.println("Popping one item out: " + stack.pop());

        System.out.println(stack);

        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
