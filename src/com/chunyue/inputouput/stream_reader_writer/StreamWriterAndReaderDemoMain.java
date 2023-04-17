package com.chunyue.inputouput.stream_reader_writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamWriterAndReaderDemoMain {
    static String myString = "Hello World! Welcome. 春跃 is here!";

    private static void writeFileInGBK() {
        try (FileOutputStream fos = new FileOutputStream("./test.txt", false);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK")) {
            osw.write(myString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try (FileInputStream fis = new FileInputStream("./test.txt");
                InputStreamReader isr = new InputStreamReader(new FileInputStream("./test.txt"), "GBK")) {

            // Read as regular without specifying the charSet used for decoding
            int a;
            while ((a = fis.read()) != -1) {
                System.out.print((char) a);
            }
            System.out.println("");

            // Read with specified charSet for decoding
            int b;
            while ((b = isr.read()) != -1) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        writeFileInGBK();
        readFile();
    }

}
