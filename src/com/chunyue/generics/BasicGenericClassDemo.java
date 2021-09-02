package com.chunyue.generics;

public class BasicGenericClassDemo<T> {
    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        generic.setFlag("admin");
        String flag = generic.getFlag();

        Generic<Integer> generic1 = new Generic<>();
        generic1.setFlag(1);
        Integer flag1 = generic1.getFlag();

        System.out.println(flag + "; " + flag1);
    }
}

class Generic<T>{
    private T flag;

    public void setFlag(T flag){
        this.flag = flag;
    }

    public T getFlag(){
        return this.flag;
    }
}
