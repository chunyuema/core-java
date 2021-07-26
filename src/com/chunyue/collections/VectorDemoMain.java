package com.chunyue.collections;

import java.util.Vector;

public class VectorDemoMain {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        System.out.println(v.capacity());
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        v.add(1);
        // automatically double the capacity
        System.out.println(v.capacity());
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        v.remove(1);
        // does not automatically reduce the capacity
        System.out.println(v.capacity());
        System.out.println(v);
    }
}
