package com.chunyue.collection.iterators;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndSafeIteratorDemoMain {
    public static void main(String[] args) {
        // failFastDemo();
        failSafeDemo();
    }

    public static void failFastDemo(){
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Chunyue");
        stringArrayList.add("Alex");
        stringArrayList.add("Jane");
        System.out.println(stringArrayList);
        try {
            Iterator<String> iterator = stringArrayList.iterator();
            while (iterator.hasNext()){
                String name = iterator.next();
                if (name.equals("Chunyue")){
                    stringArrayList.remove(stringArrayList.size()-1);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Concuurent Modification Exception has occurred!");
        }
    }

    public static void failSafeDemo(){
        List<String> stringArrayList = new CopyOnWriteArrayList<>();
        stringArrayList.add("Chunyue");
        stringArrayList.add("Alex");
        stringArrayList.add("Jane");
        System.out.println(stringArrayList);
        try {
            Iterator<String> iterator = stringArrayList.iterator();
            while (iterator.hasNext()){
                String name = iterator.next();
                if (name.equals("Chunyue")){
                    stringArrayList.remove(stringArrayList.size()-1);
                }
            }
            System.out.println("After the traversal: " + stringArrayList);
        } catch (ConcurrentModificationException e) {
            System.out.println("Concuurent Modification Exception has occurred!");
        }
    }
}
