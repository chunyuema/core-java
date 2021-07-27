package com.chunyue.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListInterfaceDemoMain {
    public static void main(String[] args) {
        // Three different implementations of list interface
        List<Integer> v1 = new ArrayList<>();
        v1.add(2);
        System.out.println(v1.size());
        List<Integer> v2 = new Vector<>();
        v2.add(3);
        System.out.println(v2.size());
        // the following only works if you do Vector<Integer> = new Vector<Integer>
        // System.out.println(v2.capacity());

        List<Integer> v3 = new LinkedList<>();
        v3.add(4);
        System.out.println(v3.size());
    }

}
