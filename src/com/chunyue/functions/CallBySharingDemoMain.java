package com.chunyue.functions;

import java.util.ArrayList;
import java.util.List;

public class CallBySharingDemoMain {
    private static void mutateVariableInFunctionBody(List<Integer> list) {
        System.out.println("Inside the function body (before incrementing): " + list);
        list.add(999);
        System.out.println("Inside the function body (after incrementing): " + list);
    }

    private static void assignValueInFunctionBody(List<Integer> list) {
        System.out.println("Inside the function body (before incrementing): " + list);
        list = new ArrayList<>();
        System.out.println("Inside the function body (after incrementing): " + list);
    }

    private static void passByValue(int x) {
        System.out.println("Inside the function body (before incrementing): " + x);
        x += 1;
        System.out.println("Inside the function body (after incrementing): " + x);
    }

    public static void main(String[] args) {
        int x = 0;
        System.out.println("Outside the function body (before invoking): " + x);
        passByValue(x);
        System.out.println("Outside the function body (after invoking): " + x);

        System.out.println("====================");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Mutation of the object will be visible to the caller
        System.out.println("Outside the function body (before invoking): " + list);
        mutateVariableInFunctionBody(list);
        System.out.println("Outside the function body (after invoking): " + list);

        // Assignment will not be visible to the caller
        System.out.println("Outside the function body (before invoking): " + list);
        assignValueInFunctionBody(list);
        System.out.println("Outside the function body (after invoking): " + list);
    }
}
