package com.chunyue.inputouput.output;

import java.io.FileOutputStream;

public class FileOutputStreamDemoMain {
    public static void main(String[] args) {
        // writeByte();
        writeString();
    }

    public static void writeByte(){
        try {
            FileOutputStream fout = new FileOutputStream("./test1.txt");
            fout.write(65);
            fout.close();
            System.out.println("Successfully written...");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeString(){
        try {
            FileOutputStream fout = new FileOutputStream("./test.txt");
            String s = "Welcome to core java repo";
            byte[] bytes = s.getBytes();
            fout.write(bytes);
            fout.close();
            System.out.println("Successfully written....");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
