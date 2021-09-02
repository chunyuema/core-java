package com.chunyue.generics;

public class GenericWildcardDemo {

    public static void main(String[] args) {
        ShowMsg showMsg = new ShowMsg();

        Generic<Integer> generic = new Generic<>();
        generic.setFlag(25);
        showMsg.showFlag(generic);

        Generic<Number> generic1 = new Generic<>();
        generic1.setFlag(34);
        showMsg.showFlag(generic1);

        Generic<String> generic2 = new Generic<>();
        generic2.setFlag("Chunyue");
        // showMsg.showFlag(generic2);
    }
}

class ShowMsg {
    // support any types in the generic
    public void showFlag(Generic<? extends Number> generic){
        System.out.println(generic.getFlag());
    }
}