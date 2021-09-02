package com.chunyue.generics;

public class BasicGenericMethodDemo {
    public static void main(String[] args) {
        // Do not need to specify the generic here
        MethodGeneric methodGeneric = new MethodGeneric();

        // Do not need to specify the type; JVM will infer the type
        methodGeneric.setName("Chunyue");
        methodGeneric.setName(123123);

        String name = methodGeneric.getName("Alex");
        Integer integer = methodGeneric.getName(456456);
        System.out.println(name + ", " + integer);
    }
}


class MethodGeneric {
    // nothing is returned
    public <T> void setName(T name){
        System.out.println(name);
    }

    // have a returned value
    public <T> T getName(T name){
        return name;
    }


}
