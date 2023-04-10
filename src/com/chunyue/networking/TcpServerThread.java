package com.chunyue.networking;

import java.net.Socket;

public class TcpServerThread extends Thread {
    private String message;

    public TcpServerThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(
                "Current thread: " + Thread.currentThread().getName() + "; working on request: " + this.message);
    }
}
