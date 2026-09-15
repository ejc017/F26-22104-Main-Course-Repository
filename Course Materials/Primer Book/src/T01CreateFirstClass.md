# Creating Your First Project

[Setup Guide: Creating an IntelliJ Project](../../Setup%20Guides/Create%20First%20IntelliJ%20Project/Creating_Basic_IntelliJ_Project_Instructions.html)

## From Idea to Running Program

Writing a Java program means going through the same basic cycle every time: write source code in a `.java` file, have that code compiled, and then run it to see what it produces. IntelliJ IDEA is the tool this course uses to do all three of those steps -- editing, compiling, and running -- without leaving one application.

## Projects, Packages, and Classes

IntelliJ organizes code into a **project** -- a top-level container for everything related to what you're building. Inside a project, source files are grouped into **packages**, which are just folders that give related classes a shared, unique name. Inside a package, each `.java` file defines one **class**.

For example, the file you'll work with for this topic is organized like this:

```
instructor/demo/topic01/FirstClass.java
```

which corresponds to the class `FirstClass`, in the package `instructor.demo.topic01`. The very first line of the file declares that package membership:

```java
package instructor.demo.topic01;
```

We'll cover exactly what makes up the rest of a class -- braces, the `main` method, semicolons -- in the next topic. For now, the important thing is simply recognizing that a `.java` file's location on disk (its package) and its content (its class) are directly tied together, and IntelliJ manages that relationship for you.

## Running a Program

To run `FirstClass.java`, right-click the file (or the class inside it) and choose **Run**. IntelliJ does two things when you do this: it **compiles** your source code, translating it into a form the computer can execute, and then it **executes** that compiled program. If there's a compile error, you'll never get to the execution step -- IntelliJ will report the problem instead of running anything.

## Reading the Output

Once a program runs, its console output appears in a panel at the bottom of the IntelliJ window. `FirstClass.java` produces one line of output:

```
First Program Success
```

That line comes from a single statement in the program: `System.out.println(...)`, which prints whatever text is inside the parentheses to the console. Getting comfortable with running a program and immediately checking its console output -- does it look like what I expected? -- is a habit you'll use constantly throughout this course.

## Check Your Understanding

1. What are the three steps in going from Java source code to a running program?
2. What is the relationship between a package, a folder on disk, and a class?
3. What does IntelliJ's **Run** command actually do, in what order?
4. If a program has a compile error, will it still produce console output? Why or why not?

## Practice

See `FirstClass.java` for the example discussed above -- try running it yourself and confirming the output matches what's shown here.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
