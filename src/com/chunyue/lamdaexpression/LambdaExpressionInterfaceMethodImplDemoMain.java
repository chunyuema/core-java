package com.chunyue.lamdaexpression;

public class LambdaExpressionInterfaceMethodImplDemoMain {
    public final static String concat(UpperConcat uc, String s1, String s2){
        return uc.upperConcat(s1, s2);
    }

    public static void main(String[] args) {
        String s1 = "Chunyue";
        String s2 = "Ma";

        // implement the method provided by the interface
        String concatString1 = concat(new UpperConcat() {
            @Override
            public String upperConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, s1, s2);
        System.out.println(concatString1);

        // use a lambda expression to simplify interface method implementation
        UpperConcat uc = (a, b) -> a.toUpperCase() + b.toUpperCase();
        String concatString2 = concat(uc, s1, s2);
        System.out.println(concatString2);

    }
}

interface UpperConcat {
    public String upperConcat(String s1, String s2);
}