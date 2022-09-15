package com.chunyue.collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemoMain {

    private static final ArrayList<String> techCompanies = new ArrayList<>();
    static {
        techCompanies.add("google");
        techCompanies.add("amazon");
        techCompanies.add("microsoft");
    }

    public static void main(String[] args) {
        Collections.addAll(techCompanies, "facebook", "bytedance");
        System.out.println("add elements into a target collection: " + techCompanies);
        Collections.sort(techCompanies);
        System.out.println("sort elements in the target collection: " + techCompanies);
        Collections.reverse(techCompanies);
        System.out.println("reverse collection: " + techCompanies);
    }
}

