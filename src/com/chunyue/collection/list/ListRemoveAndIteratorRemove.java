package com.chunyue.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemoveAndIteratorRemove {
    private static void useListRemove(){
        List<String> sList = new ArrayList<>();
        sList.add("Hello");
        sList.add("Hello");
        sList.add("World");
        for (int i = 0; i < sList.size(); i++) {
            String s = sList.get(i);
            if ("Hello".equals(s)) {
                sList.remove(s);
            }
        }
        System.out.println(sList);
    }

    private static void useIteratorRemove(){
        List<String> sList = new ArrayList<>();
        sList.add("Hello");
        sList.add("Hello");
        sList.add("World");
        Iterator<String> iterator = sList.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("Hello".equals(s)) {
                iterator.remove();
            }
        }
        System.out.println(sList);
    }

    public static void main(String[] args) {
        // Note that this will miss one of the "Hello"
        useListRemove();

        // Note that this will not miss any of the "Hello"
        useIteratorRemove();

    }
}
