HTML Link Parser
=================================================

Eventually, we want to be able to crawl the web and parse web pages. As such, we must be able to find the links embedded in the HTML code of the web pages. This assignment is a step towards this functionality.

See the Javadoc comments in [`HTMLLinkParser`](src/HTMLLinkParser.java) and [`HTMLLinkParserExtraTest`](src/HTMLLinkParserExtraTest.java) for additional details.

Background
-------------------------------------------------

We do not explicitly cover HTML in this class. However, this markup language should be easy to pickup for any programmer. Some resources include:

* [Mozilla Developer Network](https://developer.mozilla.org/en-US/docs/Web/HTML)
* [W3C Markup Validation](http://validator.w3.org/)
* [Web Design Group](http://htmlhelp.com/)
* [W3 Schools](http://www.w3schools.com/)

You will need to be familiar with the anchor tag `<a>` for this assignment. This is the tag used to create links on web pages. For example:

```html
<a href="http://www.cs.usfca.edu/">USF CS</a>
```

The above code will generate the link <a href="http://www.cs.usfca.edu/">USF CS</a>, where the link text is `USF CS` and the link destination is `http://www.cs.usfca.edu/`. The link will always be placed in the `href` attribute of the `a` tag, but not all `a` tags will have this attribute.

Files
-------------------------------------------------

The following files are required for this project:

- [`HTMLLinkParser`](src/HTMLLinkParser.java)
- [`HTMLLinkParserTest`](src/HTMLLinkParserTest.java)
- [`HTMLLinkParserExtraTest`](src/HTMLLinkParserExtraTest.java)

Please download the above files and add them to your Java project in Eclipse to get started. See the [Homework README](../README.md) for details on how to download individual files or subdirectories from this repository.

Hints
-------------------------------------------------

Below are some hints that may help with this homework assignment:

- Most people will only need to modify the `REGEX` in `HTMLLinkParser`. If you use an *unusual* regular expression, you may have to change the `GROUP` as well. 

- You will likely want to use one or more [flags](http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#field.summary) in your regular expression.

- You can write the unit tests for `HTMLLinkParserExtraTest` BEFORE completing the regular expression in `HTMLLinkParser`.

You are not required to use these hints in your solution. There may be multiple approaches to solving this homework.
