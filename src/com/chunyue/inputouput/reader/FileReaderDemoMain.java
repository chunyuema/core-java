package com.chunyue.inputouput.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReaderDemoMain {
    public static void main(String[] args) {
        // basicFileReader();
        // fileReaderTryWithResource();
        readIntoCharBuffer();
    }

    /*
     * Compare this with the output from FileInputStream, because we are reading
     * char instead of reading buffer, the last char 马 can be read
     */
    public static void readIntoCharBuffer() {
        try {
            FileReader fr = new FileReader("./test.txt");
            char[] charBuffer = new char[10];
            int i = fr.read(charBuffer);
            System.out.println("Number of char read: " + i);
            for (char c : charBuffer) {
                System.out.println(c);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void basicFileReader() {
        Scanner scanner = null;
        Map<Integer, String> res = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("./text/file.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int num = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                res.put(num, description);
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // scanner.close will close the FileReader as well since it is an instance of
            // Closable
            if (scanner != null)
                scanner.close();
        }
    }

    // simplify the above code using try with resources
    public static void fileReaderTryWithResource() {
        Map<Integer, String> res = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader("./text/file.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int num = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                res.put(num, description);
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
