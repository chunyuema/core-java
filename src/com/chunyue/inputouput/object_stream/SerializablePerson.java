package com.chunyue.inputouput.object_stream;

import java.io.Serializable;

public class SerializablePerson implements Serializable {
    private String name;
    private Integer age;
    // Using transient can prevent data access after serialization
    private transient String secret;

    public SerializablePerson(String name, Integer age, String secret) {
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

    public String toString() {
        return "{ Name: " + this.name +
                ", Age: " + this.age +
                ", Secret: " + this.secret + " }";
    }
}
