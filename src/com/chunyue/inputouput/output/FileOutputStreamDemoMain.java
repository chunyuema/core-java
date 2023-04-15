package com.chunyue.inputouput.output;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.catalog.Catalog;

public class FileOutputStreamDemoMain {
    public static void main(String[] args) {
        // writeByte();
        writeString();
    }

    public static void writeByte() {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("./test1.txt");
            fout.write(65);
            fout.close();
            System.out.println("Successfully written...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeString() {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("./test.txt");
            String s = "Welcome to core java repo";
            byte[] bytes = s.getBytes();
            fout.write(bytes);
            fout.close();
            System.out.println("Successfully written....");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
