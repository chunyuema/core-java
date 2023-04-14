package com.chunyue.inputouput.input;

import java.io.FileInputStream;

public class FileInputStreamDemoMain {
    public static void main(String[] args) {
        readOneCharacter();
        // readAllCharacters();
        readByBytes();
    }

    public static void readOneCharacter() {
        try {
            FileInputStream fin = new FileInputStream("./test.txt");
            int i = fin.read();
            System.out.println("The first character is: " + (char) i);
            fin.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readAllCharacters() {
        try {
            FileInputStream fin = new FileInputStream("./test.txt");
            int i;
            System.out.println("Reading from file....");
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * https://www.tutorialspoint.com/java/io/fileinputstream_read_byte.html
     * Note that one alphabet character / punctuation is one byte
     * !ABCDE is therefore 6 bytes
     * But if we have 马 at the end of the file, you see strange behavior because
     * that will map to more than 1 byte (3 bytes in my case)
     */
    public static void readByBytes() {
        try {
            FileInputStream fin = new FileInputStream("./test.txt");
            byte[] bs = new byte[10];
            int i;
            char c;
            // Read bytes into buffer
            i = fin.read(bs);
            System.out.println("The number of bytes read: " + i);
            System.out.println("Bytes read: ");
            for (byte b : bs) {
                c = (char) b;
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
