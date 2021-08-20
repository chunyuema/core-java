package com.chunyue.inputouput.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWritterDemoMain {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("./text/bufferedwritter.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Welcome to the core java repository");
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
}
