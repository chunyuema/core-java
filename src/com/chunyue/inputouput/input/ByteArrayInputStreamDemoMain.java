package com.chunyue.inputouput.input;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamDemoMain {
    public static void main(String[] args) {
        byte[] bytes = {77, 35, 67, 89};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        int i;
        while ((i=byteArrayInputStream.read())!=-1){
            char ch = (char) i;
            System.out.println("The ASCII character for " + i + " is " + ch);
        }
    }
}
