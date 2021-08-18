package com.chunyue.oop.misc;

class ValueCallObject {
    int i = 30;
    void change(int i){
        i = i + 30;
        System.out.println("In the function change, i is now: " + i);
    }
}

class ReferenceCallObject {
    int i = 30;
    void change(ReferenceCallObject obj){
        obj.i = obj.i + 30;
        System.out.println("In the function change, i is now: " + obj.i);
    }
}

public class CallByReferenceOrValueDemoMain {

    public static void main(String[] args) {
        callByValue();
        callByReference();
    }

    public static void callByValue(){
        ValueCallObject valueFunctionCallObject = new ValueCallObject();
        System.out.println("Before: i= " + valueFunctionCallObject.i);
        valueFunctionCallObject.change(valueFunctionCallObject.i);
        System.out.println("After: i= " + valueFunctionCallObject.i);

    }

    public static void callByReference(){
        ReferenceCallObject referenceCallObject = new ReferenceCallObject();
        System.out.println("Before: i= " + referenceCallObject.i);
        referenceCallObject.change(referenceCallObject);
        System.out.println("After: i= " + referenceCallObject.i);
    }

}
