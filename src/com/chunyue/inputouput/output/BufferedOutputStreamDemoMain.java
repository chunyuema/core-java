package com.chunyue.inputouput.output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemoMain {
    public static void main(String[] args) {
        bufferedOutputWithFlush();
    }

    public static void bufferedOutputWithFlush(){
        try {
            FileOutputStream fout = new FileOutputStream("./testBuffer.txt");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            String s = "Buffered: welcome to core java repo";
            byte[] bytes = s.getBytes();
            bout.write(bytes);
            bout.flush();
            bout.close();
            fout.close();
            System.out.println("Successfully written....");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
