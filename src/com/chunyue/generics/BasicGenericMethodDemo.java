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

        MethodGeneric.setFlag("What?");
        MethodGeneric.setFlag(123456);

        String flag = MethodGeneric.getFlag("If?");
        System.out.println(flag);
        Integer flag1 = MethodGeneric.getFlag(123);
        System.out.println(flag1);
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

    public static <T> void setFlag(T flag){
        System.out.println(flag);
    }

    public static <T> T getFlag(T flag){
        return flag;
    }
}
