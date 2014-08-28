Word Parser
=================================================

For this homework assignment, you will create a class that parses words from `String` objects and text files.

Assume words are separated by whitespaces, and convert text to a consistent format by converting it to lowercase and replacing special characters with a single space. Consider the following text:

```
Sally *** Sue sells __76__

   sea-shells, by


       the

   sea#shore.
```

The resulting words from parsing the above text should be:

```
[sally, sue, sells, 76, sea, shells, by, the, sea, shore]
```

See the Javadoc comments in the [`WordParser.java`](src/WordParser.java) template code for additional details.

## Files ##

The following files are required for this project.

- [`src/WordParser.java`](src/WordParser.java)
- [`src/WordParserTest.java`](src/WordParserTest.java)
- [`seashells.txt`](seashells.txt)

Please download the above files and add them to your Java project in Eclipse to get started. 

## Requirements ##

The official name of this homework is `WordParser`. This should be the name you use for your Eclipse Java project, the subdirectory used in your private GitHub homework repository, and the name you use when running the homework test script.

You must pass all unit tests when running the `/home/public/cs212/homework` script on the lab computers to receive a 100% on this homework assignment.

## Hints ##

Below are some hints that may help with this homework assignment:

- The [`String`](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html) class has several helpful methods for this assignment.

- The [`Pattern`](http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html) class has regular expressions for whitespaces and non-word characters. If you are unfamiliar with basic regular expressions, see the official [Java Tutorials: Regular Expressions](http://docs.oracle.com/javase/tutorial/essential/regex/index.html) lesson.

- The official [Java Tutorials: Basic I/O](http://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles) lesson shows example code on how to read and write files using a `try-with-resources` block.

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.
