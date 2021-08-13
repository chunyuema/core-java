package com.chunyue.utilityclasses;

import java.util.BitSet;

public class BitSetDemoMain {
    private static BitSet bitSet1 = new BitSet(16);
    private static BitSet bitSet2 = new BitSet(16);
    static {
        for (int i=0; i<16; i++){
            if (i%2 == 0) bitSet1.set(i);
            if (i%5 != 0) bitSet2.set(i);
        }
        System.out.println("initial bitset1:  " + bitSet1);
        System.out.println("initial bitset2:  " + bitSet2);
    }

    public static void main(String[] args) {
        operationAnd();
        operationOR();
        operationXOR();
    }

    private static void operationAnd(){
        bitSet1.and(bitSet2);
        System.out.println("AND of bitset1 and 2:  " + bitSet1);
    }

    private static void operationOR(){
        bitSet1.or(bitSet2);
        System.out.println("OR of bitset1 and 2:  " + bitSet1);
    }

    private static void operationXOR(){
        bitSet1.xor(bitSet2);
        System.out.println("XOR of bitset1 and 2:  " + bitSet1);
    }
}
