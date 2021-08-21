package com.chunyue.inputouput.writer;

import java.io.CharArrayWriter;
import java.io.FileWriter;

public class CharArrayWriterDemoMain {
    public static void main(String[] args) {
        try {
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            charArrayWriter.write("Welcome to the java core concepts repository!");
            FileWriter fileWriter1 = new FileWriter("./text/chararraywriter1.txt");
            FileWriter fileWriter2 = new FileWriter("./text/chararraywriter2.txt");
            charArrayWriter.writeTo(fileWriter1);
            charArrayWriter.writeTo(fileWriter2);
            fileWriter1.close();
            fileWriter2.close();
            charArrayWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
