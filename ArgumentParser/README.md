Argument Parser
=================================================

For this homework, you will create a parser for command-line arguments that parses flag/value pairs and stores them in a map. For example, consider the following command-line arguments:

```
"-a", "ant", "-b", "bat", "cat", "-d", "-e", "elk", "-f"
```

In this case, `-a` `-b` `-d` `-e` and `-f` are all flags while `ant` `bat` `cat` and `elk` are values. Not all flags have values, and not all values have associated flags. For example, flag `-a` has value `ant` and flag `-b` has value `bat`, but value `cat` has no associated flag and is ignored. The flags `-d` and `-f` have no associated value, but are still stored by the argument parser.

See the Javadoc comments in the [`ArgumentParser.java`](src/ArgumentParser.java) template code for additional details.

## Files ##

The following files are required for this project.

- [`src/ArgumentParser.java`](src/ArgumentParser.java)
- [`src/ArgumentParserTest.java`](src/ArgumentParserTest.java)

Please download the above files and add them to your Java project in Eclipse to get started. See the [Homework README](../README.md) for details on how to download individual files or subdirectories from this repository.

## Hints ##

Below are some hints that may help with this homework assignment:

- Many methods may be implemented with one line of code if you are familar with the methods in [HashMap](http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html) or [TreeMap](http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html).

- The `parseArguments(...)` method is actually easier if you use a traditional `for` loop instead of an enhanced `for` loop. 

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.

## Optional ##

If you want a _really_ useful argument parser for your future projects, I recommend you also add the following methods:

- A method `getInteger(String flag)` that retrieves the value of a flag as an `Integer` or `int` value instead of a `String`

- A method `getPath(String flag)` that retrieves the value of a flag as an `Path` object instead of a `String`

Note this is completely optional, and not necessary for this homework.
