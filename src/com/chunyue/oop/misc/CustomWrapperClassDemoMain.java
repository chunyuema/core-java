package com.chunyue.oop.misc;

class MyIntegerWrapper{
    private int i;

    public MyIntegerWrapper(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class CustomWrapperClassDemoMain {
    public static void main(String[] args) {
        MyIntegerWrapper integerWrapper = new MyIntegerWrapper(10);
        System.out.println(integerWrapper);
    }

}
