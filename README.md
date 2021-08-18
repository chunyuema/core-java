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

## Java Object-Oriented Programming
### Java Object Class
- object: entity with state and behaviors
- class: collection of object
- ways of creating object: new; clone; new instance; deserialization; factory methods
- anonymous object: objects with no names; no reference pointing to the object; used when objects are only used once
- constructor: method called when object is created with new keyword
  - default constructor is created and used if no constructor is provided; providing default values to the fields
  - constructor overloading: provide different ways to create objects with different parameters
  - return type of constructor: current class instance
- static keyword: 
  - static variable: common variable shared by all the instances of the class; memory efficient
  - static method: method belongs the class; can be invoked without creating an instance; can access static variable
  - static block: initialized static data member; executed before main method; main() is required to run a java program
- this keyword: 
  - used to refer to the class instance variable
  - used to invoke the current class method (added automatically by compiler if absent)
  - used to invoke the current class constructor (constructor chaining and reuse of constructor calls)
  - can be passed in as an argument (used in event handling)
  - can be used in the constructor call 
  - can be used to return an instance of the current class
- equals(): by default compares if two objects are stored at the same memory location
- hashcode: an integer associated with every object in java
- if object1.equals(object2) is true, they must have the same hashcode

### Java Inheritance
- Inheritance: IS-A relationship 
  - extends keyword
  - type of inheritance: single; multilevel; hierarchical
    - single: one class inherit another one
    - multilevel: chain of inheritance
    - hierarchical: >= 2 classes inheritance one class
    - multiple inheritance is not supported in java: class C extends A, B
- Aggregation: HAS-A relationship
  - create a reference of an object in another object
  - when to use aggregation: IS-A relationship is not maintained throughout the lifetime of an object

### Java Polymorphism
- method overloading: same name of the methods but different parameters
  - two ways of overloading: change the number of parameters; change the datatype of parameters
  - type promotion: one type can be promoted to another type implicitly to match the datatype found
- method overriding: subclass declare same method as parent class; used for runtime polymorphism
  - over instance method can be overridden; static method cannot be overridden
  - covariant return types: overriding a method and change its return type (after java5)
- super keyword: 
  - used to refer to the immediate parent class instance variable
  - used to invoke parent class instance method
  - used to invoke parent class constructor (super() is added in each class constructor automatically by compiler if there is no super() or this())
- instance initializer block: 
  - executed when the instance of the object is created
  - executed after the parent constructor; before the current class constructor
- final keyword: 
  - final variable: value cannot be changed
    - blank final variable: a final variable that is not initialized at the time of declaration; but can be 
      initialized through constructor (not change after that)
    - static blank final variable: a final variable that is not initialized at the time of declaration; but can be
      initialized through static block
    - final parameter: cannot modify this parameter in the function 
  - final method: cannot be overridden
  - final class: cannot be extended
- polymorphism:
  - compile time polymorphism: overriding static method will result in this
  - runtime polymorphism (dynamic method dispatch): 
    - overridden method resolved at runtime by JVM
    - data variables are not overridden, hence does not display runtime polymorphism
- Type binding: 
  - everything has a type in java
  - static binding: the type is determined during compile time (private, final or static method)
  - dynamic binding: the type is determined during runtime
- instanceof operator: test if object is an instance of a specified type
- Type Casting: converting one datatype to another
  - up casting: child object typecasted to parent class object (generalization / widening)
  - down casting: parent object typecasted to child class object 

### Java Abstraction
- abstraction: hiding the implementation details
- 2 methods of achieving abstraction: 
  - abstraction class: class declared with abstract; abstract + non-abstract method; cannot be instantiated; 
    designed to be instantiated
    - abstract method: method declared as abstract with no actual implementation
  - interface: a blueprint of classes
- Interface and Abstract class comparison
  
  |-|Abstract Class|Interface|
  |------|----|-----|
  |Method|Abstract + non-abstract method|Non-abstract method only|
  |Variable|Final; Non-final; Static; Non-static variables|Static; Final Variables only|
  |Implementation|Can provide implementation|No implementation|
  |Multiple Implementations|Extends another classes / Implement >=1 interfaces|Extends other interfaces only|

### Java Encapsulation
- Package: a group of similar classes, interfaces or subclasses
  - Built in packages: java = lang + util + awt 
  - Importance of packaging: access protection; avoid naming collision
  - Subpackage: package within another package
- Access modifier: 
  - Private: only available in the class
  - Default: only available in the package
  - Protected: only available in the package or outside the package through child class
  - Public: can be accessed from anywhere

### Java OOP Misc
- Clone objects
- Wrapper Class: convert primitive types into objects and from objects into primitive types
  - convert primitive types into objects to pass in methods by reference
  - objects are required to convert into streams and perform serialization
  - only objects can work with synchronization
  - collection framework only works with objects only

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

## Java java.lang
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
  - Cloneable: objects with implementing clonable interface can be cloned / not recommended to be implemented
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
  
## Java Util: Collection Framework
- Generics: explicitly specify the type of data stored in the collection; increase in type safety and reduce
  run-time type mismatch errors
- Autoboxing/unboxing: automatically perform boxing of primitive types with the wrapper so that they can be stored
  in the collections
- Iterable Interface: root interface for all the collection classes; allow for loop and forEach
- Interfaces defined by Collection framework:
  - Collection Interface: interface extends Iterable; implemented by all the classes in collection
    framework; all collections can be cycled through by using for each style for loop
    - List Interface: interface extends Collection; inhibits list data structure
    - Queue Interface: interface extends Collection; list with first-in-first-out order
      - Deque Interface: interface extends Queue; double ended queue
    - Set Interface: interface extends Collection; represents unordered set of elements; no duplicates
      - SortedSet Interface: interface extends Set; handled sorted set
      - NavigableSet Interface: interface extends SortedSet; handle retrieval of elements based on closet match searches
  - Map Interface: maps unique keys to values
    - SortedMap Interface: extends Map; ensure ordering of entries based on keys
    - NavigableMap Interface: interface extends SortedMap; handle retrieval of elements based on closet match searches
    - Map.Entry Interface: support working with a map entry
- Classes defined by Collection framework:
  - Collection classes
    - List Classes: 
      - ArrayList: implements List interface using a dynamic array
      - LinkedList: implements List, Deque, Queue interface using a doubly linked list
      - Vector: similar to ArrayList but synchronized; legacy classes made fully compatible with the modern 
        collection framework
        - Stack: a subclass of Vector
    - Queue Classes:
      - PriorityQueue: implements Queue interface; creates a queue prioritized based on the queue's comparator
      - ArrayDeque: implements Deque interface; dynamic array with no capacity restrictions; faster than ArrayList and Stack
      - LinkedList: implements List, Deque, Queue interface using a doubly linked list
    - Set Classes:
      - HashSet: implements Set interface; use hashtable for storage; cannot be indexed
        - use HashMap for implementation; keys used to store the elements; values are all PRESENT
      - LinkedHashSet: extends HashSet with linked list; maintain insertion order
      - TreeSet: implements NavigableSet interface with a tree; fast access and retrieval of element
      - EnumSet: implements Set interface, specifically used for elements of enum type
  - Map Classes: 
    - AbstractMap: implement most of the Map Interface; super class for map implementations
    - EnumMap: extends AbstractMap to use with enum keys
    - HashMap: extends AbstractMap to use a hashtable
      - LinkedHashMap: extends HashMap to allow insertion order iterations
    - TreeMap: extends AbstractMap to use a tree
    - WeakHashMap: extends AbstractMap to use a hashtable with weak keys
    - IdentityHashMap: extends AbstractMap to use reference equality when comparing documents
- Iteration of Collection:
  - Use iterator: lightweight object; iterate through collection without the need to understand how the 
    data structure is implemented
    - iterator: only traverse forward; for all collection classes
    - list iterator: allow traverse forward and backwards; only for list classes; allow modification of array items
    - spliterator: parallel iteration of portions of the sequences
  - Use forEach: for can cycle through any collection of objects that implement Iterable interface
- Collection Algorithm: 
  - static method of the Collections class; can be applied to collections and map
  - checkedCollection ensures type safety of the collection
  - synchronizedList/Set used to obtain the synchronized version of the collections
- Legacy Classes and Interfaces: 
  - Collection classes are not synchronized but legacy classes are synchronized
  - Enumeration Interface: superseded by Iterator
  - Vector: synchronized, dynamic array; Stack has Vector as superclass
  - Dictionary: abstract class fully superseded by Map
    - Hashtable: concrete implementation of dictionary; integrated into the Collection framework by implementing the 
      Map interface; since it is synchronized, it is less efficient than HashMap
      - HashMap allows null but Hashtable does not allow null
      - Properties: a subclass of Hashtable; String key and String values
- Collection is an interface; Collections is a utility class which defines utility methods that can be used on 
  collection; Collections only contain static methods
  
## Java Util: utility classes: 
- StringTokenizer: implement the Enumberation interface, tokenize a string based on delimiter
- BitSet: creates a special type of array that holds bit values in the form of boolean values; all bits are 
  initialized to be zero
- Optional: utility classes to handle situations when a value may or maynot be present; no defined constructor; need 
  to create an instance
- Date: class encapsulate the current date and time 
- Calendar: an abstract class providing a set of methods that helps with converting time
  - GregorianCalendar: concrete implementation of a Calendar
- Timezone: an abstract class to work with timezone offset
  - SimpleTimeZone: subclass of timezone
- Locale: class describing a geographical or cultural region
- Random: class used to generate pseudorandom numbers
- Observable: class used to create subclasses that other parts of the program can observe
- Time/Timetask: schedule a task for execution at future time
- Currency: class encapsulates information about currency
- Formatter: class supporting creation of formatted output
- Scanner: read formatter input and converts it into its binary form
- Java util subpackages: 
  - concurrent
  - concurrent.atomic
  - concurrent.locks
  - function
  - jar
  - logging
  - prefs
  - regex
  - spi
  - stream
  - zip
  
## Java Multithreading
- Thread Creation: extends Thread; implements Runnable; use Callable & Future
- Life Cycle of a thread: new -> runnable -> running -> blocked -> terminated
  - new: create a new thread; before calling the start()
  - runnable: a thread is in the runnable state if start() is called but not yet getting selected
  - running: thread selected by the scheduler to run
  - blocked: thread is alive but not eligible to run
  - terminated: after the run() is finished or stop() is called
- Daemon Thread: service provider thread which provides services to user thread; life depends on the user thread
  - examples of daemon threads: finalizer; gc
  - daemon thread needs to be set before the thread starts
- sleep() and wait(): 
  - sleep: static method on Thread; does not change the lock on the object
  - wait: method on Object; release the lock; can be wakened up through notify;notifyAll
- notify() and notifyAll():
- run() and start(): 
  - thread creation: start creates new thread and then run gets executed; run does not create a new thread, just 
    execute on the current thread -> hence not multithreading
  - multiple invocation: start cannot be called tice but run can since it is just a normal method calling
- Synchronization: prevent thread intervention and consistency problem: every object has a lock/monitor; a thread 
  that needs consistent access to an object's fields has to acquire the lock (enter the monitor) first, and then release the lock after they are done; 
  all other threads attempting to enter the monitor has to wait
  - method 1 of obtaining lock: synchronized method (suitable for small code amount)
    - automatically does its job when wrapped in synchronized block
    - a thread cannot be interrupted
    - not guarantee particular access order
    - lock should be released in the same order of acquiring
  - method 2 of obtaining lock: reentrant lock (suitable for larger amount of code)
    - needs to explicitly call lock and unlock method
    - use lockInterruptibly() to interrupt a thread
    - fairness parameter can favor the longest waiting thread
    - lock can be released in any order
- Synchronized method: thread acquires the lock for shared resource; release the lock when done
- Synchronized block: synchronization on any specific resource of the method; smaller scope than synchronized method
- **DeadLock**: 
  - A deadlock occurs when two or more threads wait forever for a lock or resource held by another of the threads.
  - An application may stall or fail as the deadlocked threads cannot progress.
- **LiveLock**: 
  - Two or more threads keep on transferring states between one another instead of waiting infinitely.
  - None of the thread can perform their tasks properly 
- LiveLock:
- Data inconsistency: synchronized only applicable for methods; not for variable/classes; data inconsistency happens 
  when multiple threads try to access the same java object
  - use synchronized keyword to lock the variable; might incur performance issue
  - use volatile keyword: read and write back to the RAMs instead of cache; better performance
- Atomic Action: 
  - A thread can be suspended in the middle of performing some tasks
  - Atomic actions cannot be suspended in the middle
      - Reading and writing reference variables: myObj1 = myObj2
      - Reading and writing reference primitive variables except longs and doubles
      - Reading and writing reference variable that is declared as volatile
  - `java.util.concurrent.atomic`: can be used for making reading and writing variable atomic
      - `AtomicInteger`, `AtomicLong` are available
- ThreadLocal: local variable not shared outside the thread; memory leak might happen
- Thread Pool: 
  - newFixedThreadPool: every new task creates a new thread until max
  - newCachedThreadPool: automatically recycle the free threads
  - newSingleThreadExecutor: only single thread; execute the tasks based on the sequence in queue
  - newScheduledThreadPool: fixed size thread pool; tasks can be timed