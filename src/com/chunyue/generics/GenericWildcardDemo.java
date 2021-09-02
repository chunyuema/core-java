package com.chunyue.generics;

public class GenericWildcardDemo {

    public static void main(String[] args) {
        ShowMsg showMsg = new ShowMsg();

        Generic<Integer> generic = new Generic<>();
        generic.setFlag(25);
        showMsg.showFlag(generic);
        // showMsg.showFlag2(generic); // lower bound restriction

        Generic<Number> generic1 = new Generic<>();
        generic1.setFlag(34);
        showMsg.showFlag(generic1);
        showMsg.showFlag2(generic1);

        Generic<String> generic2 = new Generic<>();
        generic2.setFlag("Chunyue");
        // showMsg.showFlag(generic2); // upper bound restriction
    }
}

class ShowMsg {
    // support any types in the generic
    public void showFlag(Generic<? extends Number> generic){
        System.out.println(generic.getFlag());
    }

    public void showFlag2(Generic<? super Number> generic){
        System.out.println(generic.getFlag());
    }
}