# Core Java Concepts

## Java Concurrency
- **DeadLock**: 
  - A deadlock occurs when two or more threads wait forever for a lock or resource held by another of the threads.
  - An application may stall or fail as the deadlocked threads cannot progress.
- **LiveLock**: 
  - Two or more threads keep on transferring states between one another instead of waiting infinitely.
  - None of the thread can perform their tasks properly 
- LiveLock: 
- A thread can be suspended in the middle of performing some tasks
- **Atomic Action**: 
    - An action that cannot be suspended in the middle
        - Reading and writing reference variables: myObj1 = myObj2
        - Reading and writing reference primitive variables except longs and doubles
        - Reading and writing reference variable that is declared as volatile
    - `java.util.concurrent.atomic`: can be used for making reading and writing variable atomic
        - `AtomicInteger`, `AtomicLong` are avaible
- **Memory Consistency Error**: 
    - Threads can run on difference CPUs
    - Memory inconsistency can happen if the cache for even CPU is not synced
    - A volatile variable is written back to the main memory by JVM for cache consistency
        - Volatile variables do not completely prevent memory inconsistency 
    
    
