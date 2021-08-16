package com.chunyue.multithreading;

public class SayHelloDeadLockDemoMain {

    public static void main(String[] args) {
        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson john = new PolitePerson("John");

        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(john);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john.sayHello(jane);
            }
        }).start();

        // thread 1 acquires jane lock to say hello to john
        // thread 2 acquires john lock to say hello to jane
        // thread 1 tries to acquire john lock to say hello back but the lock is held by thread 2
        // thread 2 tries to acquire jane lock to say hello back but the lock is held by thread 1
        // both thread1 and thread 2 end up suspending
    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s : %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s : %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
