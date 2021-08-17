package com.chunyue.oop.abstraction;


abstract class Bank {
    abstract int getInterestRate();
}

class Bank1 extends Bank {
    @Override
    int getInterestRate() {
        return 8;
    }
}

class Bank2 extends Bank {
    @Override
    int getInterestRate() {
        return 7;
    }
}

public class AbstractClassDemoMain {
    public static void main(String[] args) {
        Bank b1 = new Bank1();
        Bank b2 = new Bank2();
        if (b1.getInterestRate() > b2.getInterestRate()){
            System.out.println("b1 is better with rate " + b1.getInterestRate());
        } else {
            System.out.println("b2 is better with rate " + b2.getInterestRate());
        }
    }
}
