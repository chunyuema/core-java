package com.chunyue.inputouput.input;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamDemoMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("./file1.txt");
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int count = dataInputStream.available();
        byte[] array = new byte[count];
        dataInputStream.read(array);
        for (byte bt: array){
            char ch = (char) bt;
            System.out.print(ch + "-");
        }
    }
}
