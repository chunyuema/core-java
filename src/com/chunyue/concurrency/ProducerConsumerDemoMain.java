package com.chunyue.concurrency;

import java.util.Random;

public class ProducerConsumerDemoMain {
    public static void main(String[] args) {
        Message message = new Message();
        // start the producer thread
        (new Thread(new Writer(message))).start();
        // start the consumer thread
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    // consumers will read from the message
    public synchronized String read(){
        // always call wait in a loop to ensure that
        // it is indeed waiting for some condition has changed
        while (empty){
            try {
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = true;
        // we cannot notify a specific thread
        notifyAll();
        return message;
    }

    // producer will write into the message
    public synchronized void write(String message){
        while (!empty){
            try {
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

// This is the producer class Writer
class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "this is the first msg",
                "this is the second msg",
                "this is the third msg",
                "this is the fourth msg"
        };

        // generating random delay for the writer class to write msg
        Random random = new Random();

        // loop through the msgs, sleep for a random period of
        // time after writing one message
        for (int i = 0; i < messages.length; i++){
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

// This is the consumer class Reader
class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    // read one piece of message and then sleep for a random period of time
    public void run() {
        Random random = new Random();
        for (String lateMessage = message.read();
             ! lateMessage.equals("Finished");
             lateMessage = message.read()) {
            System.out.println(lateMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
    }
}


// Atomic operations
// - thread cannot be suspended in the process of primitive datatype (except double / long)
// - arrayList from the collection framework is not thread safe, have to synchronize manually
// - thread cannot be suspended while copying the object reference