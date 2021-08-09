package com.chunyue.utilLang;

public class CloneableInterfaceDemoMain {
    public static void main(String[] args) {
        TestClone t1 = new TestClone(10, 20.99);
        TestClone t2;
        t2 = t1.cloneTest();
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
    }
}

class TestClone implements Cloneable{
    int a;
    double b;

    public TestClone(int a, double b) {
        this.a = a;
        this.b = b;
    }

    TestClone cloneTest(){
        try{
            // needs to be casted into the appropriate type
            return (TestClone) super.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("Clone is not supported");
            return this;
        }
    }

    @Override
    public String toString() {
        return "TestClone{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}