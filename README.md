Homework Assignments
=================================================

These are the required template and test code for programming homework assignments in CS 212 Software Development at the University of San Francisco. Please note that the exact homework assigned may differ by semester.

<!--
## Spring 2014 ##

These are the assignments for Spring 2014. Please see the specific assignment for template code, test code, and any necessary input files. See below for general requirements and submission instructions.

| Homework ## | Homework Name                      | Deadline             |
|-------------|------------------------------------|:---------------------|
| Homework 01 | [Project Euler](ProjectEuler/)     | Fri Jan 31 @ 11:59pm |
| Homework 02 | [Word Parser](WordParser/)         | Fri Feb 07 @ 11:59pm |
| Homework 03 | [Argument Parser](ArgumentParser/) | Fri Feb 14 @ 11:59pm |
| Homework 04 | Pending                            | Fri Feb 21 @ 11:59pm |
| Homework 05 | Pending                            | Fri Feb 28 @ 11:59pm |
| Homework 06 | Pending                            | Fri Mar 07 @ 11:59pm |
| Homework 07 | Custom Lock                        | Fri Mar 28 @ 11:59pm |
| Homework 08 | HREF Parser                        | Fri Apr 04 @ 11:59pm |
| Homework 09 | HTML Cleaner                       | Fri Apr 11 @ 11:59pm |
| Homework 10 | HTML Fetcher                       | Fri Apr 18 @ 11:59pm |

The deadlines may be out of date. Check the course website for the most recent information. In general, all homework is due the following Friday that it was assigned at 11:59pm. No late homework is accepted!
//-->

## Requirements ##

Fill in any method with the `// TODO` comment. Please remove the `// TODO` comments once you are finished filling in the missing code. When completing this homework, you may modify the following:

- You may modify any code within the `// TODO` methods, including the `return` statement.

- You may modify any code provided within the `main()` function for debugging.

- You may add additional members and methods as necessary.

However, you may **NOT** modify the following:

- Do **not** modify the name, parameters, or exceptions thrown for any of the provided methods (including the ones you must fill in).

- Do **not** modify the code for any of the fully provided methods.

- Do **not** modify the provided unit tests, including the exceptions expected or not expected by those unit tests.

You must pass all of the provided unit tests and pass code inspection by the teacher assistant to receive full credit on this homework assignment.


## Submission ##

Submit your work to SVN at the following location:

```
https://www.cs.usfca.edu/svn/username/cs212/homework##/
```

where `username` is your CS username and `##` is the homework number you are submitting. If you submit correctly using Eclipse, your source files will be located in the `src` subdirectory.

For example, suppose username `sjengle` is submitting [Project Euler](ProjectEuler/) as Homework 01. Then the source code files should be located at:

```
https://www.cs.usfca.edu/svn/sjengle/cs212/homework01/src/ProjectEuler06.java
https://www.cs.usfca.edu/svn/sjengle/cs212/homework01/src/ProjectEuler06Test.java
```

We use scripts to test homework, so your SVN repository must follow the above guidelines exactly. Failure to submit your homework properly may result in a 0% score.

## Eclipse Setup ##

These steps show you how to setup an Eclipse project using this repository to make sure you have all the files necessary for the homework assignment in the correct locations.

You may also download individual files or subdirectories and manually setup your Eclipse project. See the [Updating Files](#updating-files) section for details.

#### Checkout Files ####

The first steps are to checkout the necessary files as a new Eclipse project. To do this, follow these steps:

1.  If you haven't already, add the following repository URL to your "SVN Repository Exploring" perspective in Eclipse:

    > https://github.com/cs212/homework

2.  In the "SVN Repository Exploring" perspective, open the `trunk` subdirectory within the `homework` repository, and find the subdirectory you wish to checkout. Right-click the subdirectory and select "Checkout..." from the menu.

3.  Make sure "Check out as a new project configured using the New Project Wizard" option is selected, and then click the "Finish" button.

4.  On the next dialog window, select "Java Project" and click the "Next" button.

5.  Give your project a meaningful name, and click the "Finish" button.

At this point, you will have the necessary template and test files in the appropriate subdirectories for the homework.

*:warning: You are not done! Make sure you continue on to the next steps!*

#### Build Path Setup ####

You will likely also need to add Junit 4 to the build path. To do this, follow these steps:

1.   Right-click the root directory for your new Java project and select "Build Path" and "Add Libraries" from the menu.

2.  Select "JUnit" in the dialog window and click the "Next" button.

3.  Make sure "JUnit 4" is selected and click the "Finish" button.

You can follow similar steps to add any additional third-party libraries necessary for the particular homework.

#### Submission Setup ####

At this point, while you will have the necessary files, your project is not connected to the correct SVN repository. To fix this, follow these steps:

1.  Right-click the root directory for your Java project, and select "Team" and "Disconnect" from the menu. Make sure you select "Also delete the SVN meta information from the file system" from the window that appears and click the "Yes" button.

3.  Next, right-click the root directory again and select "Team" and "Share" from the menu. Select "SVN" on the dialog window and click the "Next" button. Select the SVN repository for your CS account.

5.  When prompted, make sure you specify the folder name based on the homework number. For example, `ProjectEuler` is usually the first homework. Therefore, you would make sure the folder name is `cs212/homework01/' within your repository.

6. Commit your project by right-clicking the root directory, and select "Team" and "Commit" from the menu. At this point, your homework is ready for submission.

You can double-check your submission by viewing to your SVN repository in a web browser. The URL will be:

```
https://www.cs.usfca.edu/svn/sjengle/
```

where `username` is your CS account username. You will be prompted to login with your CS account username and password. From there, you can click on the folders to make sure your setup looks correct.

## Updating Files ##

If you need to only download or update a single file or small set of files, use these setups intead of the [Eclipse Setup](#eclipse-setup) above.

- You may download any individual (small-sized) file by opening that file in GitHub, clicking the "Raw" button, and saving the file from your browser.

- You may follow the steps in the [GitHub Help Guide](https://help.github.com/articles/downloading-files-from-the-command-line) for downloading individual files.

- You may use the `svn export` command to download a single file (or all files in a subdirectory). Use the following command:

    ```
    svn export https://github.com/cs212/homework/trunk/subdirectory
    ```

    where `subdirectory` is the homework subdirectory or file path you wish to download. For example, the following will download all of the files for the [Project Euler](ProjectEuler/) assignment:

    ```
    svn export https://github.com/cs212/homework/trunk/ProjectEuler
    ```

    To download a single file within the `ProjectEuler/src` subdirectory, the command would be:

    ```
    svn export https://github.com/cs212/homework/trunk/ProjectEuler/src/ProjectEuler06.java
    ```

Please see the [CS Tutoring Center Resources](http://tutoringcenter.cs.usfca.edu/resources/) for help using SVN via the command-line.

After downloading the files, you can import the files in a new Eclipse Java Project. Make sure to place the source code files in the `src` subdirectory within the default package.

