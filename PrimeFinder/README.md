Prime Finder
=================================================

For this homework, you will create a method that finds primes using multithreading and trial division. To receive full points, your program **MUST** use worker threads and the provided methods to calculate primes.

## Files ##

The following files are required for this project.

- [`src/PrimeFinder.java`](src/PrimeFinder.java)
- [`src/PrimeFinderTest.java`](src/PrimeFinderTest.java)

Please download the above files and add them to your Java project in Eclipse to get started. See the [Homework README](../README.md) for details on how to download individual files or subdirectories from this repository.

## Hints ##

Below are some hints that may help with this homework assignment:

- The approach should be very similar to the [`RandomArrayTotal`](https://github.com/cs212/demos/blob/master/Multithreading%2C%20Part%201/src/RandomArrayTotal.java) code demo.

- Do not forget to wait for your worker threads to complete before you collect final results.

- Do not worry about sophisticated synchronization or the inefficiency caused by creating and destroying threads every time the method is called.

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.
