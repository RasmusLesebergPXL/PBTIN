# Guts-DotNetEssentials

In this repository you can find (Visual Studio) starter solutions for the exercises of the **.NET Essentials** course of **PXL-Digital**.

![alt text][img_book]

The exercises are grouped by chapter. There is a (Visual Studio) solution for each chapter.
A chapter solution contains multiple projects:

- A WPF project for each exercise. E.g. *Exercise01*
- A test project for each WPF project. E.g. *Exercise01.Tests*

![alt text][img_projects]

The WPF projects are (mostly) empty and waiting for you to complete them.
The matching test projects contain **automated tests** that can be run to check if your solution is correct.

## Getting Started

First you need to clone the files in this repository on your local machine.
You will use the Visual Studio **git** capabilities to accomplish this.

### Clone the repository

Start Visual Studio and select "Clone or check out code".

- Click on the *Clone or Download* button in the upper right corner of this webpage
- Copy the url of this repository

![alt text][img_clone_url]

- Paste the url you copied earlier into the field "Repository Location"
- Choose a local path, this is a local folder where the files will be copied to
- Click on the *Clone* button

![alt text][img_clone_vs]

Now you have a local copy of the online repository in which you can complete your exercises.

![alt text][img_cloned_repo_overview]

Double click the solution that contains the chapter exercises you want to work on. Alternatively, you can just double click a solution file (.sln) from an explorer window to start up Visual Studio with the solution opened up.

### Register on [guts-web.pxl.be](https://guts-web.pxl.be)

To be able to send your tests results to the Guts servers you need to register via [guts-web.pxl.be](https://guts-web.pxl.be/register).
After registration you will have the credentials you need to succesfully run automated tests for an exercise.

#### Start working on an exercise

Let's assume you want to make exercise 5 of chapter 5.

1. Open the solution in the folder "Chapter 5". You can do this by doubleclicking on the **.sln** file from an explorer window or by opening visual studio, clicking on *File &rightarrow; Open a project or solution* and selecting the **.sln** file.

2. **Build the solution** (Menu: Build &rightarrow; Build Solution or Ctrl+Shift+B)
3. Locate the project "Exercise 5" and set it as your startup project

![alt text][img_startup_project]

4. Write the code you need to write

#### Run the automated tests

Let's assume you are working on exercise 5 of chapter 5.

1. Open the *Test Explorer* window (Menu: Test &rightarrow; Test Explorer)
2. In the top right corner, click on the *group by* button and make sure the automated tests are grouped by project (see the picture below). If you don't see any tests appearing, you probably should (re)build your solution.

![alt text][img_group_tests]

3. Right click on the project that matches your exercise and click on *Run* to execute the tests.
4. The first time you run a test a browser window will appear asking you to log in. You should fill in your credentials from [guts-web.pxl.be](https://guts-web.pxl.be).

![alt text][img_login_vs]

##### FAQ

**Why won't my tests run?**

The first time it can happen that you see the tests in the *Test Explorer* but if you run the tests, nothing happens. 
Try to clean your solution (**Build &rightarrow; Clean Solution**) and then to rebuild your solution (**Build &rightarrow; Rebuild solution**).

**Why can't I see my test results on the Guts website? Locally all my tests are green.**

After the tests are run, the testrunner will try to send your results to the server. In the *Output Window* you can see a log of the steps that are taken.
If anything goes wrong, you should be able to find more info in the *Output Window*.

The test results will only be sent to the server when you run all te tests of an exercise at once. If you run the tests one by one the results will not be sent to the servers.

#### Inspect the test results

Tests that pass will be green. Tests that don't pass will be red.

The *name of the test* gives an indication of what is tested in the automated test.
If you click on a test you can also read more detailed messages that may help you to find out what is going wrong.

![alt text][img_test_detail]

Although it is not a guarantee, having all tests green is a good indication that you completed the exercise correctly.

#### Check your results online

Test results of all students are sent to the Guts servers.
You can check your progress and compare with the averages of other students via [guts-web.pxl.be](https://guts-web.pxl.be).
Login, go to ".NET Essentials" in the navigation bar and select the chapter you want to view.

![alt text][img_chapter_contents]

#### Save (commit) your work

It could happen that the code in the online repository changes and that you need to pull (download) a new version of the start code in your local repository.
The online repository does not contain your solutions. Pulling a new version of the code could result in you losing your work.

To avoid this you should regularly commit (save) your work in your local git database. If you have commited your work an you pull a new version, git will be able to automatically merge your work with the online changes.
It is recommended to **do a git commit every time you complete an exercise**.

- Go to *Git Changes* 

![alt text][img_git_changes]

- In the *Git Changes* screen you get an overview of the changes you made locally. Fill in a commit message (describing what you did) and click on the *Commit All* button. Your changes are now saved in your local git database.

![alt text][img_commit_your_work]

- By clicking on the *Solution Explorer* tab you go back to the main view for this local repository

#### Get a new version of the start code

It could happen that the lecturers fix bugs in the automated tests of the startcode or add new exercises and/or tests.
Follow the steps below to get the new version of the code:

- Commit your work locally (see previous section)
- Go to *Git Changes*
- In the upper right corner, click the three dots *...*
- Select *Pull from* &rightarrow; origin. This will merge your saved commit with the online commit in your local repository.

[img_book]:Images/book.png "Handboek 'Programmeren in C#'"
[img_projects]:Images/projects.png "Solution for chapter five with its projects"
[img_clone_vs]:Images/clone_vs.png "Clone a project in Visual Studio"
[img_clone_url]:Images/clone_url.png "Copy repository url"
[img_cloned_repo_overview]:Images/cloned_repo_overview.png "Cloned repository overview"
[img_startup_project]:Images/startup_project.png "Choose startup project"
[img_group_tests]:Images/group_tests.png "Group tests by project"
[img_test_detail]:Images/test_detail.png "Details of a test result"
[img_login_vs]:Images/login_vs.png "Visual studio login"
[img_chapter_contents]:Images/chaptercontents.png "Chapter contents"
[img_commit_your_work]:Images/commit_your_work.png "Commit your work"
[img_git_changes]:Images/git_changes.png "Git Changes"
