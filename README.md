# Core Java Concepts
## Java Basics
- JVM: java virtual machine, abstract machine; provide runtime environment for running java bytecode
  - harware dependent
  - class loader: load class files
  - memory area: classArea + heap + stack + pc register + native method stack
  - execution engine: virtual processor + interpretor(execute streams of bytecode) + Just-In-Time(JIT) compiler
    (improve performance by compile parts of the bytecode)
  - java native interface
- JRE: java runtime environment, implementations of JVM, contain files/libraries used by JVM at runtime
- JDK: java development kit, software environment for developing java applications = JRE + compiler javac + archiver 
  jar

## Java String
- String works the same as Char set
- String implements Serializable, Comparable and CharSequence interface
- String, StringBuffer and StringBuilder all implement the CharSequence interface
- String is immutable: because there could be multiple references on the same pool constant
- Create String 
  - String literal: Check the string constant pool; if present, return reference, if not, create new instance
  - Through new keyword: JVM creates new object on heap; literal put in the constant pool
  - Create string using literals is faster than new keyword: instances are not created all the time
- String concatenation: 
  - Use +: use StringBuilder (or StringBuffer) class and its append method
  - Use concat()
- Mutable String: a string that is modifiable 
  - StringBuffer: mutable string, synchronized, faster than string for concatenation, does not override equals
  - StringBuilder: mutable string, non-synchronized, faster than string buffer, not thread safe

## Java Object
- object: entity with state and behaviors
- class: collection of object
- ways of creating object: new; clone; newinstance; deserialization; factory methods
- anonymous object: objects with no names; no reference pointing to the object; used when objects are only used once
- constructor: method called when object is created with new keyword
  - default constructor is created and used if no constructor is provided; providing default values to the fields
  - constructor overloading: provide different ways to create objects with different parameters
  - return type of constructor: current class instance
- static keyword: 
  - static variable: common variable shared by all the instances of the class; memory efficient
  - static method: method belongs the class; can be invoked without creating an instance; can access static variable
  
- equals(): by default compares if two objects are stored at the same memory location
- hashcode: an integer asscociated with every object in java
- if object1.equals(object2) is true, they must have the same hashcode

## Java Exception Handling
- Exception: event / object thrown at runtime to handle runtime errors
- Exception handling ensures the normal flow of the application
- Exception and Error class both inherit from Throwable
- Checked exception: checked at compile time; directly inherit Throwable: IOException, SQLException etc
- Unchecked exceptions: checked at runtime; inherit from RuntimeException: ArithmeticException, NullPointerException,
  ArrayIndexOutOfBoundsException etc
- Error: irrecoverable: OutOfMemoryError, VirtualMachineError, AssertionError
- Unhandled exception: JVM prints exception description; stack trace and then terminates
- finally block: used to execute important code such as closing the connection
- throw keyword: used to throw an exception explicitly; used in the function; throw one exception at a time
- throws keyword: used in method signature to declare an exception might be thrown; throws >= exception

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
    
    
