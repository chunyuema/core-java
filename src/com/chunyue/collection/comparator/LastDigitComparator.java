package com.chunyue.collection.comparator;

import java.util.Comparator;

// create this comparator class which implements the comparator interface
public class LastDigitComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 10 > o2 % 10){
            return 1;
        } return -1;
    }
}
