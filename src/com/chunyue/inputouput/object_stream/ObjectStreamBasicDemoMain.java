package com.chunyue.inputouput.object_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamBasicDemoMain {

    private static void writeSerializabelPerson(SerializablePerson sp, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sp);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readSerializablePerson(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            SerializablePerson sp = (SerializablePerson) obj;
            System.out.println("Person: " + sp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SerializablePerson sp = new SerializablePerson("Chunyue Ma", 25);
        String fileName = "./personInfo.dat";
        writeSerializabelPerson(sp, fileName);
        readSerializablePerson(fileName);
    }
}
