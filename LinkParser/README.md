HTML Link Parser
=================================================

Motivation
-------------------------------------------------

Eventually, we want to be able to crawl the web and parse web pages. As such, we must be able to find the links embedded in the HTML code of the web pages. This assignment is a step towards this functionality.

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
