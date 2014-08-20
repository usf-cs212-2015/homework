Multi-Reader Lock
=================================================

For this homework, you will create a custom lock class that allows multiple simultaneous read operations, but disallows multiple simultaneous write or read/write operations. Then, you will use this lock to create a thread-safe path set.

## Files ##

The following files are required for this project.

- [`src/MultiReaderLock.java`](src/MultiReaderLockTest.java)
- [`src/MultiReaderLockTest.java`](src/MultiReaderLockTest.java)

- [`src/ThreadSafePathSet.java`](src/ThreadSafePathSet.java)
- [`src/ThreadSafePathSetTest.java`](src/ThreadSafePathSetTest.java)

Please download the above files and add them to your Java project in Eclipse to get started. See the [Homework README](../README.md) for details on how to download individual files or subdirectories from this repository.

## Hints ##

Below are some hints that may help with this homework assignment:

- Note that all of the methods are `synchronized` (useful for determining how to call `wait()` or `notifyAll()` in the code).

- Most of the code for the `ThreadSafePathSet` has already been provided; you just need to figure out how to use the `lock` object within each method.

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.
