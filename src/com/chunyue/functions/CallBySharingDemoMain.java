package com.chunyue.functions;

import java.util.ArrayList;
import java.util.List;

public class CallBySharingDemoMain {
    private static void passByValue(List<Integer> list) {
        System.out.println("Inside the function body (before incrementing): " + list);
        list.add(999);
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

        System.out.println("Outside the function body (before invoking): " + list);
        passByValue(list);
        System.out.println("Outside the function body (after invoking): " + list);
    }
}
