package com.chunyue.inputouput.output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemoMain {
    public static void main(String[] args) {
        writeByte();
        writeString();
    }

    public static void writeByte() {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("./test1.txt");
            /*
             * Use the following code if you want to append to the file instead of
             * overwriting it
             */
            // fout = new FileOutputStream("./test1.txt", ture);
            fout.write(65);
            fout.write('A');
            fout.write("Chunyue".getBytes());
            fout.write("HiMa".getBytes(), 2, 2); // This will write Ma
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
            /*
             * Use the following code if you want to append to the file instead of
             * overwriting it
             */
            // fout = new FileOutputStream("./test.txt", ture);
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
