package com.chunyue.inputouput.writer;

import java.io.FileWriter;

public class FileWriterDemoMain {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("./text/filewriter.txt");
            fileWriter.write("Hello World");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }
}
