package com.chunyue.generics;

public interface BasicGenericInterfaceDemo<T> {
    public static void main(String[] args) {
        // 对象类型修饰对象引用
        IGenericImpl iGeneric = new IGenericImpl();
        String name = iGeneric.getName("Chunyue");
        System.out.println(name);

        // 接口类型修饰对象引用
        IGeneric<String> iGeneric1 = new IGenericImpl();
        String name1 = iGeneric1.getName("Alex");
        System.out.println(name1);
    }
}

class IGenericImpl implements IGeneric<String>{
    @Override
    public String getName(String name) {
        return name;
    }
}

interface IGeneric<T>{
    T getName(T name);
}

