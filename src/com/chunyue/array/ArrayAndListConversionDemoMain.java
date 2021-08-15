package com.chunyue.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndListConversionDemoMain {
    private static ArrayList<String> techCompaniesList = new ArrayList<>();
    private static String[] techCompaniesArray = {"google", "amazon", "microsoft"};

    static {
        techCompaniesList.add("microsoft");
        techCompaniesList.add("amazon");
        techCompaniesList.add("google");
    }

    public static void main(String[] args) {
        // listToArray();
        // arrayToList();
    }

    public static void listToArray(){
        System.out.println("converting from array to list: ");
        System.out.println("the list is: " + techCompaniesList);
        String[] techCompaniesListToArray = techCompaniesList.toArray(new String[techCompaniesList.size()]);
        System.out.println("the converted array is: " + techCompaniesListToArray);
        for (String s: techCompaniesListToArray) System.out.println("company in array: " + s);
    }

    public static void arrayToList(){
        System.out.println("the array is:  " + techCompaniesArray);
        for (String s: techCompaniesArray) System.out.println("the company from the array is: " + s);
        List<String> techCompaniesArrayToList = Arrays.asList(techCompaniesArray);
        System.out.println("the converted list is: " + techCompaniesArrayToList);
    }
}
