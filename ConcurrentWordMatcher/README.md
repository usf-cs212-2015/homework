Concurrent Word Matcher
=================================================

For this homework assignment, you must fill in the missing code in `ConcurrentWordMatcher` to create a multi-threaded version of the `TextFileWordMatcher` class using a `WorkQueue`.

The `ConcurrentWordMatcher` class accumulates the number of matches found per regular expression searched for. Specifically, every time `parseTextFiles()` is called, it looks for all text files within the provided path, parses those text files into words, and counts the number of times those words match the regular expression. See `TextFileWordMatcher` for a single-threaded implementation of this functionality.

The method `getCount()` will return the current count for the specified regular expression. If `parseTextFiles()` has not yet been called, there will be no data in our map and this will return 0. Otherwise, it will return the number of matches found so far (after, of course, all of the pending work is complete).

It is important that all of your multithreading is handled by a `WorkQueue`. You should not directly create any worker threads in `ConcurrentWordMatcher`. Instead, you'll be creating "work" or "tasks" that get added to the work queue.

## Files ##

The following files are required for this project:

- [`src/ConcurrentWordMatcher.java`](src/ConcurrentWordMatcher.java)
- [`src/ConcurrentWordMatcherTest.java`](src/ConcurrentWordMatcherTest.java)
- [`src/WorkQueue.java`](src/WorkQueue.java)
- [`text/*.txt`](text/)

The following files are useful, but not required for this project:

- [`src/TextFileWordMatcher.java`](src/TextFileWordMatcher.java)
- [`src/TextFileWordMatcherTest.java`](src/TextFileWordMatcherTest.java)

Please download the above files and add them to your Java project in Eclipse to get started. 

## Requirements ##

The official name of this homework is `ConcurrentWordMatcher`. This should be the name you use for your Eclipse Java project, the subdirectory used in your private GitHub homework repository, and the name you use when running the homework test script.

You must pass all unit tests when running the `/home/public/cs212/homework` script on the lab computers to receive a 100% on this homework assignment.

## Hints ##

Below are some hints that may help with this homework assignment:

- The `TextFileWordMatcher` is provided for two reasons. First, you are welcome to call `TextFileWordMatcher.countWords()` from `ConcurrentWordMatcher` to count the words in an individual file. Second, the `TextFileWordMatcher.parseTextFiles()` method gives you an idea of what your `ConcurrentWordMatcher.parseTextFiles()` methods should roughly look like, except for the changes necessary to make the method multithreaded.

- Make sure you understand the [`MultithreadedDirectorySizeCalculator`](https://github.com/cs212/lectures/blob/fall2015/Advanced%20Multithreading/src/MultithreadedDirectorySizeCalculator.java) example first. You can follow a similar patter for this homework.

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.