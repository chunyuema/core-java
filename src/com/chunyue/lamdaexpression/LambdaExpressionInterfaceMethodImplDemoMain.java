package com.chunyue.lamdaexpression;

public class LambdaExpressionInterfaceMethodImplDemoMain {
    public final static String concat(UpperConcat uc, String s1, String s2) {
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

        MyClass myClass = new MyClass();
        String s = myClass.doSomething();
        System.out.println(s);

        String sNew = myClass.doSomething2();
        System.out.println(sNew);

        // String sNewNew = myClass.doSomething3();
        myClass.printValue();
    }
}

interface UpperConcat {
    public String upperConcat(String s1, String s2);
}

class MyClass {
    public String doSomething() {
        System.out.println("The MyClass class's name is: " + getClass().getSimpleName());

        return LambdaExpressionInterfaceMethodImplDemoMain.concat(
                new UpperConcat() {
                    @Override
                    public String upperConcat(String s1, String s2) {
                        // the following line gives us no name since it is anonymous class
                        System.out.println("The anonymous class' name is: " + getClass().getSimpleName());
                        return s1.toUpperCase() + s2.toUpperCase();
                    }
                }, "String1", "String2");
    }

    public String doSomething2() {
        System.out.println("The MyClass class's name is: " + getClass().getSimpleName());
        // There is no new anonymous class created, the lambda shared the same scope
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression class is: " + getClass().getSimpleName());
            return s1.toUpperCase() + s2.toUpperCase();
        };
        return LambdaExpressionInterfaceMethodImplDemoMain.concat(uc, "String3", "String4");
    }

    public String doSomething3() {
        // need to declare this as final for it to be used
        int i = 0;
        // the line of code will cause an error since local variables referenced from an inner class must be final or effectively final
        // i++;
        UpperConcat uc = new UpperConcat() {
            @Override
            public String upperConcat(String s1, String s2) {
                // trying to reference a local variable from inner anonymous class
                System.out.println("i accessed from within anonymous class: " + i);
                return s1.toUpperCase() + s2.toUpperCase();
            }
        };
        System.out.println("The MyClass class's name is: " + getClass().getSimpleName());
        return LambdaExpressionInterfaceMethodImplDemoMain.concat(uc, "Stirng5", "String6");
    }

    public void printValue(){
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            // This has access to the number variable we have declared
            System.out.println("Value is: " + number);
        };
        new Thread(r).start();
    }
}

