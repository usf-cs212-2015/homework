HTML Cleaner
=================================================

Motivation
-------------------------------------------------

Eventually, we want to be able to crawl the web and parse the words from web pages. As such, we must be able to remove all of the HTML tags in the web page. This assignment is a step towards this functionality.

Background
-------------------------------------------------

You can assume the HTML to parse validates. As a result, the `<` less than and `>` greater than symbols will only appear as HTML tags, and will be entities `&lt;` or `&gt;` if they are symbols in the text instead.

Files
-------------------------------------------------

The following files are required for this assignment:

- [`src/HTMLCleaner.java`](src/HTMLCleanerTest.java)
- [`src/HTMLCleanerTest.java`](src/HTMLCleanerTest.java)

Please download the above files and add them to your Java project in Eclipse to get started. See the [Homework README](../README.md) for details on how to download individual files or subdirectories from this repository.

Hints
-------------------------------------------------

The following example Java classes from the [Sockets](https://github.com/cs212/lectures/tree/fall2014/Sockets) lecture may be helpful for this assignment:

- [`HTTPFetcher`](https://github.com/cs212/lectures/blob/fall2014/Sockets/src/HTTPFetcher.java)

There are two URLs that the tests expect you can download via a socket connection and parse. These test cases are:

- <http://www.cs.usfca.edu/~sjengle/crawltest/a.html>
- <http://www.cs.usfca.edu/~sjengle/crawltest/parsetest.html>

You can use the "View Source" functionality in any browser to see the HTML being parsed by these tests.
