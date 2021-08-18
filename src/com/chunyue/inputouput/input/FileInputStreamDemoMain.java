package com.chunyue.inputouput.input;

import java.io.FileInputStream;

public class FileInputStreamDemoMain {
    public static void main(String[] args) {
        // readOneCharacter();
        // readAllCharacters();
    }

    public static void readOneCharacter(){
        try {
            FileInputStream fin = new FileInputStream("./test.txt");
            int i = fin.read();
            System.out.println("The first character is: " + (char)i);
            fin.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void readAllCharacters(){
        try {
            FileInputStream fin = new FileInputStream("./test.txt");
            int i;
            System.out.println("Reading from file....");
            while ((i= fin.read())!= -1){
                System.out.print((char)i);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
