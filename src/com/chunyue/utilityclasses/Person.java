package com.chunyue.utilityclasses;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String changeName(String name) {
        String originalName = this.name;
        this.name = name;
        return originalName;
    }

    public String toString() {
        return "Person: " + getName();
    }
}
