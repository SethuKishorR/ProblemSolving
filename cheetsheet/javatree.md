```java
java.lang.Object
│
├── java.lang.Throwable
│   ├── java.lang.Error
│   │   ├── VirtualMachineError
│   │   │   ├── OutOfMemoryError
│   │   │   └── StackOverflowError
│   │   └── LinkageError
│   └── java.lang.Exception
│       ├── Checked Exceptions (must handle)
│       │   ├── IOException
│       │   ├── SQLException
│       │   ├── ClassNotFoundException
│       │   └── InterruptedException
│       └── Unchecked Exceptions (RuntimeException)
│           ├── RuntimeException
│           │   ├── NullPointerException
│           │   ├── ArithmeticException
│           │   ├── ArrayIndexOutOfBoundsException
│           │   └── IllegalArgumentException
│           └── Other runtime exceptions
│
├── java.lang.String / StringBuilder / StringBuffer
├── java.lang.Thread
├── Wrapper Classes (for primitives)
│   ├── Integer, Double, Float, Long, Short, Byte, Boolean, Character
│
├── Arrays (all types)
│   ├── int[], Object[], CustomClass[]
│
├── Java Collections Framework
│   ├── Iterable (interface)
│   │   └── Collection (interface)
│   │       ├── List → ArrayList, LinkedList
│   │       ├── Set  → HashSet, TreeSet
│   │       └── Queue → LinkedList, ArrayDeque
│   └── Map → HashMap, TreeMap
│
├── Interfaces / Utilities
│   ├── Cloneable
│   ├── Serializable
│   ├── Math / StrictMath
│   ├── Date / Calendar
│   ├── Optional
│   └── java.util.concurrent.* (Executor, Future, etc.)
