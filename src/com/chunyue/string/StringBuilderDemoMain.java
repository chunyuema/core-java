package com.chunyue.string;

public class StringBuilderDemoMain {
    public static void main(String[] args) {
        StringBuilder stringBuffer = new StringBuilder("Hello");
        System.out.println(stringBuffer);
        stringBuffer.append(" Java");
        System.out.println("Adding Java: " + stringBuffer);
        System.out.println("Capcity of stringBuffer: "+ stringBuffer.capacity());

        stringBuffer.insert(0, "OMG ");
        System.out.println("Inserting OMG: " + stringBuffer);

        stringBuffer.replace(0, 3, "OOO");
        System.out.println("Replacing OMG with OOO: " + stringBuffer);

        stringBuffer.delete(0,4);
        System.out.println("Deleting OOO: " + stringBuffer);

        stringBuffer.reverse();
        System.out.println("Reversing the string: " + stringBuffer);
    }
}
