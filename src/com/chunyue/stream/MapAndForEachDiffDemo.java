package com.chunyue.stream;

import java.util.*;
import com.chunyue.utilityclasses.Person;

public class MapAndForEachDiffDemo {

    private static void forEachChangesOriginalDataStructure() {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person("Chunyue"));
        pList.add(new Person("Bobby"));
        pList.add(new Person("Max"));

        // forEach can be used to modify the elements
        pList.stream().forEach(p -> p.setName("Nobody"));
        System.out.println(pList);
    }

    private static void mapDoesntChangeOriginalDataStructure() {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person("Chunyue"));
        pList.add(new Person("Bobby"));
        pList.add(new Person("Max"));

        // simply calling map will not have any effect on the pList
        pList.stream().map(p -> p.changeName("Nobody"));
        System.out.println(pList);

        // however, invoking forEach will persist the changes
        pList.stream().map(p -> p.changeName("Nobody")).forEach(s -> System.out.println(s));
        System.out.println(pList);
    }

    public static void main(String[] args) {
        forEachChangesOriginalDataStructure();
        mapDoesntChangeOriginalDataStructure();
    }
}
