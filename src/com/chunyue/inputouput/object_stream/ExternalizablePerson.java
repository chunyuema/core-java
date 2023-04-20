package com.chunyue.inputouput.object_stream;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizablePerson implements Externalizable {

    private String name;
    private Integer age;
    // transient is not needed as how this object is serializable can be controlled
    // by the implementation of overridable methods below
    private String secret;

    public ExternalizablePerson(String name, Integer age, String secret) {
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

    public ExternalizablePerson() {
    }

    @Override
    public String toString() {
        return "{ Name: " + this.name +
                ", Age: " + this.age +
                ", Secret: " + this.secret + " }";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
}
