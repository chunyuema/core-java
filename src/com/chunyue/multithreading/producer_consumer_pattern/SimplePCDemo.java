package com.chunyue.multithreading.producer_consumer_pattern;

public class SimpleConsumerProducer {
    public static void main(String[] args) {
        Message message = new Message();
        Thread writer = new Thread(new Writer(message));
        Thread reader = new Thread(new Reader(message));
        System.out.println("Consumer thread: " + writer.getName());
        System.out.println("Producer thread: " + reader.getName());
        writer.start();
        reader.start();
    }
}

// This is the producer class Writer
class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    // Producer's run method writes a message and then sleep for 1000ms
    public void run() {
        String messages[] = {
                "this is the first msg",
                "this is the second msg",
                "this is the third msg",
                "this is the fourth msg"
        };

        // Write one message, then sleep for 1000 ms
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(1000);
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

    // Consumer's run method reads one piece of message and then sleep for 1000 ms
    public void run() {
        for (String lateMessage = message.read(); !lateMessage.equals("Finished"); lateMessage = message.read()) {
            System.out.println(lateMessage);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}

class Message {
    private String message;
    private boolean empty = true;

    // consumers will read from the message
    public synchronized String read() {
        // wait until the message is no longer empty, then begain reading
        while (empty) {
            try {
                wait();
                System.out
                        .println("Consumer called wait(), the current thread is: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {

            }
        }
        // after read, mark the message as empty, then wake up the producer thread
        empty = true;
        notifyAll();
        System.out.println("Consumer called notifyAll(), the current thread is: " + Thread.currentThread().getName());
        return message;
    }

    // producer will write into the message
    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
                System.out
                        .println("Producer called wait(), the current thread is: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {

            }
        }

        // after write, mark the message as non-empty, then wake up the consumer thread
        empty = false;
        this.message = message;
        notifyAll();
        System.out.println("Producer called notifyAll(), the current thread is: " + Thread.currentThread().getName());
    }
}