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
  - static block: initialized static data member; executed before main method; main() is required to run a java program
  
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
  
## Java java.util.lang
- Automatically imported into all programs
- Classes defined by java.util.lang: 
  - Primitive type wrappers: wrap primitive type in a class
    - Number: abstract class defining superclass implemented by Double, Float, Byte, Short, Integer, Long
      - parseInt; parseByte etc defined on the wrapper class: used to convert strings into primitive type numbers
    - Char: wrapper around char / isDigit, isLetter etc used to check the categories of the character
    - Boolean: wrapper around boolean
  - Void: TYPE field holds reference to the Class object for type void
  - Process: primarily used as a superclass for objects created by exec() in Runtime
  - Runtime: class that encapsulate run-time environment; cannot be instantiated
  - Memory Management: totalMemory(), freeMemory() and gc() running garbage collector on demand
  - ProcessBuilder: 
  - System: class that holds static methods and variables such as in, out, err, currentTimeMilis(); arrayCopy();
    - System.getProperty() can be useful to check environmental properties such as user directory
    - System.getSecurityManager(): return SecurityManager object; supports the Java security system; 
  - Object: superclass of all classes
    - class implementing Cloneable interface can be cloned
  - Class: encapsulate the runtime state of a class / interface
    - automatically created when classes are loaded / obtained using getClass() / getSuperClass()
    - Class<?> classObject = x.getClass() / classObject.getClass()
  - ClassLoader: abstract class defining how classes are loaded / can be extended but not normally done
  - Math: class defining floating point functions used for geometry and trigonometry
  - Compiler: class supporting the creation of Java environments to compile java bytecode into executable code
  - Thread, ThreadGroup and Runnable: classes used to support multithreaded programming
  - Package: class encapsulates the version data associated with a package
  - Throwable: class supporting exception handling
  - StackTraceElement: class describing a single stack frame, returned by Throwable.getStackTrace()
  - Enum: a list of named constants
- Interfaces defined by java.util.lang: 
  - CharSequence: interface implemented by String, StringBuffer and StringBuilder
  - Comparable: interface implemented by classes that require meaningful comparison / compareTo()
  - Appendable: interface implemented by classes that can have character / character sequence appended
  - Iterable: interface implemented by classes whose objects will be used by the for-each version of the for loop / 
    forEach()
  - Readable: interface indicating an object that can be used as a source of characters / read()
  - AutoClosable: interface supporting the try with resources statement / close() / IO class which need to close a 
    stream
  - Thread.UncaughtExceptionHandler: implemented by class that wants to handle uncaught exceptions
- Subpackages defined by java.util.lang: 
  - java.lang.annotation: defines Annotation interface
  - java.lang.instrument: add instrumentations to various aspects of program execution
  - java.lang.invoke: supports dynamic languages
  - java.lang.management: management support for JVM and execution environment
  - java.lang.ref: provide flexible control over garbage collection / references to an object
  - java.lang.reflect: provide ability to access field, constructors, methods and modifier of a class
  




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
    
    
