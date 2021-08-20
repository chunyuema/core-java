package com.chunyue.inputouput.output;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOuputStreamDemoMain {
    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream("./test.txt");
            DataOutputStream data = new DataOutputStream(fout);
            data.write(33);
//            data.writeInt(33);
            data.flush();
            data.close();
            fout.close();
            System.out.println("Successfully written...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
