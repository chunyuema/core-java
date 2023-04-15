package com.chunyue.inputouput.java_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemoMain {

    private static String fileContent = "Hello World! 春跃 here";
    private static String filePath = "/Users/chunyuema/Desktop/dev/pro-java/core-java/src/com/chunyue/inputouput/java_file/test_dir/raf.txt";

    public static void main(String[] args) {
        writeFile(filePath, fileContent);
        System.out.println(readFile(filePath));
    }

    private static void writeFile(String filePath, String fileContent) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // Start writing the file at the end of the file
            raf.seek(raf.length());
            raf.writeUTF(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            // Start reading the file at the beginning of the file
            raf.seek(0);
            sb.append(raf.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
