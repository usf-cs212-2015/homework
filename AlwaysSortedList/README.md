Always Sorted List
=================================================

For this homework, you will create a thread-safe class that always stores `String` objects in sorted order. You must use the `synchronized` keyword and `wait()` and `notifyAll()` methods properly to receive full points for this homework. You must also have [Log4j2](https://github.com/cs212/demos/tree/master/Logging) properly installed to run this code.

## Files ##

The following files are required for this project.

- [`src/AlwaysSortedList.java`](src/AlwaysSortedListTest.java)
- [`src/AlwaysSortedListTest.java`](src/AlwaysSortedListTest.java)
- [`src/log4j2.xml`](src/log4j2.xml) (for logging)

Please download the above files and add them to your Java project in Eclipse to get started. See the [Homework README](../README.md) for details on how to download individual files or subdirectories from this repository.

## Hints ##

Below are some hints that may help with this homework assignment:

- You do _not_ need to create a separate lock object, but you can if you prefer.

- Make sure you synchronize _all_ access to the shared data object. This includes any kind of read or get operation!

- The methods `wait()` and `notifyAll()` need to also be in a `synchronized` block, and should be called on the object used as the lock.

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.
