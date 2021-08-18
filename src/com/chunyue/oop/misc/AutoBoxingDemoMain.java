package com.chunyue.oop.misc;

public class AutoBoxingDemoMain {
    public static void main(String[] args) {
        integerAutoBoxing();
    }

    public static void integerAutoBoxing(){
        int i = 3;

        // explicitly converting i into integer
        Integer integer = Integer.valueOf(i);
        System.out.println(integer);

        // autoboxing of i into integer1
        Integer integer1 = i;
        System.out.println(integer1);
    }
}
