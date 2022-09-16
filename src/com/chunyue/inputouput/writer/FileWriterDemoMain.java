package com.chunyue.inputouput.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemoMain {
    public static void main(String[] args) {
        /* comment out the methods below for testing */
        // simpleFileWriter();
        // betterFileWriter();
        /*
        try {
            tryWithResourceFileWriter();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        */

        try {
            tryWithMultipleResource();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void simpleFileWriter(){
        // need to wrap it in try block as file exceptions are checked exceptions
        try {
            FileWriter fileWriter = new FileWriter("./text/filewriter.txt");
            fileWriter.write("Hello World");
            // important to close the fileWrite to avoid corruption / locked file
            fileWriter.close();
        } catch (IOException e) {
            System.out.println( e.getMessage());
            e.printStackTrace();
        }
    }

    // defensive programing example
    public static void betterFileWriter(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("./text/betterFileWriter.txt");
            fileWriter.write("I am a better file writer");
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("It is better to close the file writer from the finally block");
            // need to wrap the close in a try block as well
            try {
                if (fileWriter!=null) fileWriter.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // actively throw exceptions
    public static void activeThrowExceptions() throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("./text/betterFileWriter.txt");
            fileWriter.write("I am a better file writer");
        } finally {
            System.out.println("It is better to close the file writer from the finally block");
            // need to wrap the close in a try block as well
            if (fileWriter!=null) fileWriter.close();
        }
    }

    // use try with resource to simplify the method above
    public static void tryWithResourceFileWriter() throws IOException {
        // try with resource ensures the closing of the file writer
        try (FileWriter fileWriter = new FileWriter("./text/conciseFileWriter.txt")){
            fileWriter.write("I am the try with resource file writer, I am very simple");
        }
    }

    public static void tryWithMultipleResource() throws IOException {
        try (FileWriter fileWriter1 = new FileWriter("./text/conciseFileWriter1.txt");
             FileWriter fileWriter2 = new FileWriter("./text/conciseFileWriter2.txt")){
            fileWriter1.write("Writing to the first file");
            fileWriter2.write("Writing to the second file");
        }
    }
}
