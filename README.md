# CS 212 Homework

This guide will walk you through the steps to setup and submit homework assignments. You can [view a video](https://youtu.be/UqbBnKWofII) of the entire process as well.

:movie_camera: View a walkthrough of this process on [YouTube](https://youtu.be/UqbBnKWofII).

:warning: This guide assumes you have already been through the [Getting Started](https://github.com/cs212/lectures/tree/fall2015/Getting%20Started) guides.

## Table of Contents

| # | Step | Description |
|---|:-----|:------------|
| 1 | [Repository Setup](#repository-setup) | Setup your Github repositories in Eclipse. |
| 2 | [Homework Template](#homework-template) | Grab the latest homework template files. |
| 3 | [Homework Project](#homework-project) | Copy the template files into a new Eclipse project. |
| 4 | [Homework Repository](#homework-repository) | Connect your Eclipse project to Github. |
| 5 | [Homework Submission](#homework-submission) | Commit and push your changes to Github. |
| 6 | [Homework Testing](#homework-testing) | Verify your homework submission is correct. |

## Repository Setup

You should have the following repositories cloned on your computer:

- `https://github.com/cs212/homework`
- `https://github.com/cs212/cs212-username-homework`

Replace `username` above with your myUSF username. Place these in a `Repositories` subfolder within your `CS 212` folder for best results.

:information_source: Visit [Git Configuration](https://github.com/cs212/lectures/blob/fall2015/Getting%20Started/Git%20Configuration.md) for how to get this setup in Eclipse.

## Homework Template

You need to first make sure you have the latest homework templates:

  1. In Eclipse, use the [Open Perspective](http://help.eclipse.org/mars/topic/org.eclipse.platform.doc.user/tasks/tasks-9f.htm) dialog to open the "Git Perspective".

  2. Right-click the `homework` repository and select "Pull" from the menu.

  :warning: If there is a conflict you have to stop and resolve the conflict first. The easiest way is to [Revert Changes](http://wiki.eclipse.org/EGit/User_Guide#Reverting_Changes), but you will lose any work you saved in this repository.

  3. Verify you see the homework template code in the "Working Directory" folder in the "Git Repositories" view.

Now, you should have the latest templates from the instructor. Next, you'll need to copy these into a new Eclipse project.

## Homework Project

You should treat the `homework` repository as a read-only repository of homework templates. You will need copy the template files into a new Eclipse project before you start working:

  1. In Eclipse, open the "Java (default) Perspective".

  2. Select "Import..." from the "File" menu. This will open up a dialog window.

  3. Under "General" select "Existing Projects into Workspace" and click the "Next >" button.

  4. Click the "Browse" button next to "Select root directory:" and select the `homework` repository on your computer.

  5. Select the project(s) you want to import. (You cannot re-import projects you already added to this workspace.)

  6. **Select "Copy projects into workspace" under "Options" and click the "Finish" button.**

You should now have a fresh copy of the project in your Eclipse workspace. You can start making modifications to this code.

:warning: If there are errors, you may need to add the JRE or JUnit to your build path. Right-click your project folder, select "Build Path » Configure Build Path..." and make sure "JRE System Library" and "JUnit 4" show up in the "Libraries" tab.

## Homework Repository

You need to connect your new Eclipse project to your `cs212-username-homework` repository (where `username` is your myUSF username):

  1. Right-click your project folder. Select "Team » Share Project..." from the menu.

  2. Select your homework submission repository **NOT** the template repository. It will have a name like `cs212-username-homework` where `username` is your myUSF username.

  3. Leave everything else with the default values. This means the "Use or create repository in parent folder of project" should **NOT** be checked, and the "Working directory" should show your local repository directory and **NOT** your workspace directory.

  4. Click the "Finish" button. Right-click your project folder and select "Refresh" to update your view.

This only configures your project to use Github. This does **NOT** push your code to your Github repository automatically!

## Homework Submission

You submit homework by committing your changes and pushing your commits to Github. You should do this *frequently* throughout the development cycle, not just when you want to submit your code!

There are two ways to do this. The first uses the "Git Staging" view:

  1. Open the "Git Staging" view. You can open this by selecting "Window » Show View" and selecting "Other" from the menu. In the dialog that opens up, open the "Git" category and select the "Git Staging" view.

  2. Drag the files you want to add to this commit from the "Unstaged Changes" window to the "Staged Changes" window. Usually this is all of the changed files, but sometimes you might want to break your changes up into multiple commits.

Alternatively, you can use the "Commit" dialog:

  1. Right-click your project folder, and select "Team » Commit" from the menu.

  2. Select the files you want to add to this commit. Usually this is all of the changed files, but sometimes you might want to break your changes up into multiple commits.

From here, the steps are the same:

  3. Enter a **useful** commit message. You will thank yourself later when there is a conflict or a bug and you need to revert your code to an older revision!

  4. If you are going to make another commit right away, just click the "Commit" button. Otherwise, go ahead and click "Commit and Push" to both make the commit and push the changes to your Github repository.

:octocat: At this point, I recommend you double-check your changes are showing up in your Github repository by logging into Github.

## Homework Testing

You can (and should) run the JUnit tests provided for each homework locally. However, even though the tests pass on your computer, they might not on a lab computer. To make sure your code runs properly *and* test that you submitted your homework properly, run the `homework` script on the lab computers:

  1. Log into a lab computer. Make sure you are on a lab computer, and not our gateway `stargate.cs.usfca.edu`. (Our gateway may not have the latest version of Java installed!)

  :information_source: See the [Logging in Remotely](http://tutoringcenter.cs.usfca.edu/resources/logging-in-remotely.html) guide for how to login to a lab computer while off campus. Even better, check out [Logging in Without a Password](http://tutoringcenter.cs.usfca.edu/resources/logging-in-without-a-password.html) for how to avoid entering your password every time you want to login.

  2. Run the `homework` command as follows:

  ```
  /home/public/cs212/homework -g gituser HomeworkName
  ```

  Replace `gituser` with your Github username, and `HomeworkName` with the name of the homework you are testing. You may be prompted to enter your Github password.

  :information_source: Even better, create an alias! Add the following line to your `.bashrc` file:

  ```
  alias homework="/home/public/cs212/homework -g gituser"
  ```

  Replace `gituser` with your Github username. If you do this, the *next* time you login you will be able to do the following instead:

  ```
  homework HomeworkName
  ```

  This will automatically use your alias and fill in the homework path and Github username for you!

  3. If there are any problems, then you should debug what is going wrong. You can use the `-r` flag to save a report file somewhere that you can access. I recommend you do something like:

  ```
  /home/public/cs212/homework -g gituser -r ~/report.txt HomeworkName
  ```

  This will save a report of the test output to your home directory. You can either go through that output yourself, or post it on Piazza in a private post for help from the instructor and TA.

Once all of the tests are passing, you should be set!

## Troubleshooting

Remember, your code now lives in multiple places. The `git` version control system is more distributed and modern than `svn`, but that distributed nature can mean bigger headaches when your code gets out of sync.

To avoid this issue, remember to always `pull`, 'commit', and `push` (in that order). Specifically:

  - The `pull` operation fetches the latest version of the code in the remote repository, and then merges it into your local clone. This operation breaks if there are changes in your local clone that are not yet saved to your remote repository. This won't happen if you *always pull before you make changes*!

  - The `commit` operation creates a checkpoint in your local clone. This basically gives you the ability to undo changes by reverting your code back to an old checkpoint. You should *always commit your code often*. However, this does not push those changes to your remote repository!

  - The `push` operation takes your latest commits and pushes them to your remote repository.This operation breaks if there are changes on your remote repository that are not yet in your local clone. This won't happen if you *always push after you make changes*!

When your local clone gets out of sync with the remote repository, you will have a conflict. Those usually require manual intervention to resolve. See [Resolving a Merge Conflict](http://wiki.eclipse.org/EGit/User_Guide#Resolving_a_merge_conflict) for detailed steps. Do not be afraid to ask the instructor, TA, or CS Tutors for help!

