package com.chunyue.debugger;

public class StringUtilities {
    private StringBuilder stringBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder stringBuilder, char c){
        stringBuilder.append(c);
        charsAdded++;
    }
}
