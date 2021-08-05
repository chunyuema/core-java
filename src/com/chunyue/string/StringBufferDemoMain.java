package com.chunyue.string;

public class StringBufferDemoMain {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello");
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

        StringBuffer s1 = new StringBuffer("HI");
        StringBuffer s2 = new StringBuffer("HI");
        System.out.println("string buffer does not override equals to: " + s1.equals(s2));
        System.out.println(s1.hashCode() + " is different from " + s2.hashCode());
    }
}
