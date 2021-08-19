package com.chunyue.inputouput.output;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class ByteArrayOutputStreamDemoMain {
    public static void main(String[] args) {
        try {
            FileOutputStream fout1 = new FileOutputStream("./file1.txt");
            FileOutputStream fout2 = new FileOutputStream("./file2.txt");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write("I am a common string".getBytes());
            byteArrayOutputStream.writeTo(fout1);
            byteArrayOutputStream.writeTo(fout2);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            fout1.close();
            fout2.close();
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
