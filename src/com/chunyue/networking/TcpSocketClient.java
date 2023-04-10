package com.chunyue.networking;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpSocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            for (int i = 0; i < 5; i++) {
                pw.write("Hello World " + i + System.getProperty("line.separator"));
                pw.flush();
            }
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String message = null;
            while ((message = br.readLine()) != null) {
                System.out.println("Client received message from server: " + message);
            }
            br.close();
            is.close();
            os.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
