package com.chunyue.inputouput.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDemoMain {
    public static void main(String[] args) {
        // useSequenceInputStream();
        sequenceInputStreamWithEnum();
    }

    public static void useSequenceInputStream(){
        try {
            FileInputStream fin1 = new FileInputStream("./test.txt");
            FileInputStream fin2 = new FileInputStream("./testBuffer.txt");
            FileOutputStream fout = new FileOutputStream("./combine.txt");
            SequenceInputStream sin = new SequenceInputStream(fin1, fin2);
            int i;
            while ((i=sin.read())!= -1){
                System.out.print((char)i);
                fout.write(i);
            }
            sin.close();
            fout.close();
            fin1.close();
            fin2.close();
            System.out.println("Successfully combined the files..");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void sequenceInputStreamWithEnum(){
        try {
            FileInputStream fin1 = new FileInputStream("./test.txt");
            FileInputStream fin2 = new FileInputStream("./testBuffer.txt");
            Vector v = new Vector();
            v.add(fin1);
            v.add(fin2);
            Enumeration enumeration = v.elements();
            SequenceInputStream sin = new SequenceInputStream(enumeration);
            int i;
            while ((i=sin.read())!=-1){
                System.out.print((char) i);
            }
            sin.close();
            fin1.close();
            fin2.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
