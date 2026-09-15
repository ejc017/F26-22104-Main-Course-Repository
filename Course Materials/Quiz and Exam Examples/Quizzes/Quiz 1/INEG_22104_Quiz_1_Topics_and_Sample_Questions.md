# INEG 22104: Quiz 1 – Topics and Sample Questions

## University of Arkansas - Fall 2026

------

## Purpose of This Document

**These sample questions are not the actual quiz.** They exist to show you the *type*, *format*, and *difficulty* of questions you can expect on Quiz 1. Studying the topics below and being able to answer questions like these is good preparation, but the real quiz will use different specific examples, values, and code snippets.

Quiz 1 is given in class, is completed in Blackboard, and is timed at approximately 10 minutes. It contains 8 questions, each either multiple choice or fill-in-the-answer.

------

## Topics Covered (T01–T03)

### T01 – Development Environment (Git, GitHub, GitHub Desktop, IntelliJ)

- The difference between **Git** (tracks changes to files), **GitHub** (stores repositories online), **GitHub Desktop** (a graphical app for using Git without the command line), and **IntelliJ** (the IDE used to write, compile, and run Java code)

### T02 – Introduction to Java

- The role of the `main` method
- Matching braces (`{ }`) and semicolons (`;`)
- Whitespace, indentation, and comments (`//` single-line, `/* */` multi-line)
- The three categories of errors:
  - **Syntax errors** – prevent the code from compiling
  - **Logic errors** – the code compiles and runs, but produces the wrong result
  - **Runtime errors** – the code compiles, but terminates unexpectedly during execution

### T03 – Variables

- Every variable has a **type** and a **name**
- Common types: `int`, `double`, `float`, `char`, `String`, `boolean`
- Variable naming rules (must start with a letter, `_`, or `$`; case-sensitive; cannot be a reserved word) and `camelCase` convention
- The assignment operator (`=`) vs. mathematical equality
- `final` constants
- Printing variable values with `System.out.println` and string concatenation (`+`)

------

## Sample Questions

**1. [Multiple Choice] Fundamental Concepts**
Which data type would be most appropriate for storing whether a machine passed inspection (`yes`/`no`)?
A) `int`
B) `String`
C) `boolean`
D) `double`

**2. [Fill-in-the-Answer] Fundamental Concepts**
Which of the following is the only *legal* Java variable name: `1stPlace`, `first place`, `int`, `_temp`?

**3. [Multiple Choice] Error Recognition**
```java
public class Demo {
    public static void main(String[] args) {
        int x = 5
        System.out.println(x);
    }
}
```
What type of error is present in this code?
A) Syntax error
B) Logic error
C) Runtime error
D) No error — this is valid code

**4. [Fill-in-the-Answer] Error Recognition**
```java
int length = 4;
int width = 5;
int area = length + width;
System.out.println("Area: " + area);
```
The code compiles and runs to completion, printing `Area: 9` — but the programmer intended to calculate the *area* of a rectangle. What type of error is this?

**5. [Fill-in-the-Answer] Predict the Output**
```java
public class Shop {
    public static void main(String[] args) {
        int batchSize = 250;
        System.out.println("Batch size: " + batchSize);
    }
}
```
What does this program print?

**6. [Multiple Choice] Predict the Output**
```java
int batchSize = 250;
int defectCount = 12;
int goodUnits = batchSize - defectCount;
System.out.println("Good units: " + goodUnits);
```
A) `Good units: 238`
B) `Good units: 262`
C) `Good units: goodUnits`
D) Compile error

**7. [Multiple Choice] GitHub vs. GitHub Desktop vs. IntelliJ**
Which tool would you use to write, compile, and run your Java code?
A) GitHub
B) GitHub Desktop
C) IntelliJ
D) Git

**8. [Fill-in-the-Answer] GitHub vs. GitHub Desktop vs. IntelliJ**
Which tool provides a graphical interface for committing and pushing your changes without typing Git commands into a terminal?

------

## Answer Key

| # | Answer |
|---|--------|
| 1 | C – `boolean` |
| 2 | `_temp` |
| 3 | A – Syntax error |
| 4 | Logic error |
| 5 | `Batch size: 250` |
| 6 | A – `Good units: 238` |
| 7 | C – IntelliJ |
| 8 | GitHub Desktop |

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. <https://claude.com/claude-code>

Claude Code was used to draft the topic summary and sample questions in this document, and to verify the sample code snippets by compiling and running them.
