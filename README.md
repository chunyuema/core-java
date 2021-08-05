# Core Java Concepts

## Java String
- String works the same as Char set
- String implements Serializable, Comparable and CharSequence interface
- String, StringBuffer and StringBuilder all implement the CharSequence interface
- String is immutable: becasue there could be multiple references on the same pool constant
- Create String 
  - String literal: Check the string constant pool; if present, return reference, if not, create new instance
  - Through new keyword: JVM creates new object on heap; literal put in the constant pool
- String concatenation: 
  - Use +: use StringBuilder (or StringBuffer) class and its append method
  - Use concat()
- Mutable String: a string that is modifiable 
  - StringBuffer: mutable string, synchronized, faster than string for concatenation, does not override equals
  - StringBuilder: mutable string, non-synchronized
## Java Objects
- equals(): by default compares if two objects are stored at the same memory location
- hashcode: an integer asscociated with every object in java
- if object1.equals(object2) is true, they must have the same hashcode

## Java Collection Framework
- Iterable Interface: root interface for all the collection classes
- Collection Interface: interface extends Iterable; implemented by all the classes in collection 
  framework
- List Interface: interface extends Collection; inhibits list data structure
    - ArrayList: implements List interface using a dynamic array
    - LinkedList: implements List using a doubly linked list
    - Vector: similar to ArrayList but synchronized
        - Stack: a subclass of Vector
- Queue Interface: interface extends Collection; list with first-in-first-out order
    - PriorityQueue: class implements Queue; no null values
    - Deque: interface which extends Queue; add and remove elements from both sides
        - ArraryDeque: class implements Deque; faster than ArrayList and Stack
- Set Interface: interface extends Collection; represents unordered set of elements; no duplicates
    - HashSet: class implements Set; use hashtable for storage
    - LinkedHashSet: class implements Set with linked list; maintain insertion order
    - SortedSet: interface extends Set
        - TreeSet: class implements Set with a tree; fast access and retreval of elements
  
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
    
    
