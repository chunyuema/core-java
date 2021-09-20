package com.chunyue.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemoMain {

    private static Queue<String> nameQueue = new LinkedList<>();

    public static void main(String[] args){
        addToQueueDemo();
        pollFromQueue(nameQueue);
        removeFromQueue(nameQueue);
    }

    public static void addToQueueDemo(){
        nameQueue.add("chunyue1");
        nameQueue.add("chunyue2");
        nameQueue.add("chunyue3");
        nameQueue.add("chunyue4");
        nameQueue.add("chunyue5");
        System.out.println("The current queue is: " + nameQueue);
    }

    public static void pollFromQueue(Queue<String> q){
        String name = q.poll();
        System.out.println("The name polled from queue is: " + name);
        System.out.println("The current queue is: " + q);
    }

    public static void removeFromQueue(Queue<String> q){
        String name = q.remove();
        System.out.println("The name removed is: " + name);
        System.out.println("The current queue is: " + q);
    }

}
