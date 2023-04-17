package com.chunyue.inputouput.object_stream;

import java.io.Serializable;

public class SerializablePerson implements Serializable {
    private String name;
    private Integer age;

    public SerializablePerson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String toString() {
        return "{ Name: " + this.name + ", Age: " + this.age + " }";
    }
}
