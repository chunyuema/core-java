/* Code adapted from: https://tobebetterjavaer.com/io/Serializbale.html#_02%E3%80%81%E5%86%8D%E6%9D%A5%E7%82%B9%E5%AE%9E%E6%88%98 */
package com.chunyue.inputouput.object_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamBasicDemoMain {

    private static void writeSerializabelPerson(SerializablePerson sp, String fileName) {
        // The secret of this person's information is accessible before serialization
        System.out.println("Write Person Info: " + sp);
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
            // The person's secret is not accessible after serialization
            SerializablePerson sp = (SerializablePerson) obj;
            System.out.println("Read Person Info: " + sp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SerializablePerson sp = new SerializablePerson("Chunyue Ma", 25, "Chunyue's Secret");
        String fileName = "./personInfo.dat";
        writeSerializabelPerson(sp, fileName);
        readSerializablePerson(fileName);
    }
}
