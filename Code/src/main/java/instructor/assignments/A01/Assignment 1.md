# Assignment 1

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, August 28, 2026

To submit Assignment 1, commit and push your work to the **main branch of your fork** of the course repository (see `Course Materials/Setup Guides/GitHub and GitHub Desktop/` if you need a refresher).

Where a question below allows AI use, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution -- this applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead.  There's no advantage to skipping the practice now.
- Good uses of AI throughout this course: asking it to explain a Java concept in different words, asking why a general category of error occurs, asking it to quiz you on terminology. 

------

## Question 1 - Print, Println, and Printf

**a.** In your fork, under `Code/src/main/java/student/assignments/`, create a new package named `A01` (right-click `student.assignments` → **New → Package**).

**b.** In the `student.assignments.A01` package, create a new Java class named `Assignment1_Q1`.

**c.** Inside the class body, type `psvm` and press **Tab**. IntelliJ's live template will expand this into an empty `main` method for you:

```java
public static void main(String[] args) {

}
```

**d.** Inside `main`, add three statements:

- One `System.out.print()` statement that prints your first and last name.
- One `System.out.println()` statement that prints your major.
- One `System.out.printf()` statement that prints a sentence containing **two** values: a whole number formatted with `%d` (for example, your expected graduation year) and a decimal number formatted to exactly two decimal places with `%.2f` (for example, a measurement, a GPA, or any number you choose).

**e.** Run the program and confirm your output looks correct.

------

## Question 2 - Variables in an Industrial Engineering Application

Choose one industrial engineering application area — for example **healthcare, logistics, retail, or manufacturing** (you are also welcome to choose a different IE application area not listed here).

The Java class `Assignment1_Q2` in the `instructor.assignments.A01` package contains an empty starter file. Copy it into your own `student.assignments.A01` package using IntelliJ's **Refactor → Copy** (not a plain cut/paste), and do your work in the copy.

**a.** Inside `Assignment1_Q2`, add a `main` method (use the `psvm` shortcut from Question 1 if you'd like).

**b.** Declare one variable of each of the following six types, with a value and name that would plausibly be used in the application area you chose: `int`, `double`, `float`, `String`, `char`, `boolean`.

**c.** Add a single-line comment above each variable explaining what it represents in your chosen application and why you picked that type for it.

**d.** At least one variable's value must be derived from something personal to you (for example, the last two digits of your student ID, or the number of letters in your last name) rather than an arbitrary placeholder value. Note in that variable's comment how you derived it.

**e.** Print all six variables and their values to the console, one per line.

**f.** Run the program and confirm your output looks correct.

------

## Question 3 - Error Identification and Debugging

**AI Usage**: You may copy compiler or runtime error messages from IntelliJ into an AI tool to ask what they mean and what generally causes them, completely independent of this assignment. Do NOT paste your code into an AI tool.

The Java class `Assignment1_Q3` in the `instructor.assignments.A01` package contains code intended to calculate the average number of defects per shift and the cost per unit for a manufacturing line, but it contains three errors: one **syntax error**, one **runtime error**, and one **logic error**. The `main` method is currently wrapped in a block comment (`/* ... */`) so the file compiles as provided.

Copy `Assignment1_Q3` into your own `student.assignments.A01` package using IntelliJ's **Refactor → Copy**, and do your work in the copy. When you are ready to begin, delete the `/*` line and the `*/` line surrounding `main` so the code is no longer commented out.

**Your tasks:**

1. **Fix the syntax error** so the code compiles.
2. **Run the code**, read the exception it throws, and **fix the runtime error** so the program runs to completion. In a comment, briefly explain what caused it.
3. Once the program runs without crashing, compare the printed average defects per shift to what you'd expect by hand. **Identify and fix the logic error** causing the incorrect result, and explain in a comment why the original code compiled and ran without crashing despite being wrong.

------

## Question 4 - Keyboard Input

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I read a decimal number from the keyboard in Java?"), completely independent of this assignment. NOT allowed: describing this assignment to AI, sharing your specific code with it, or asking it to write the calculation for you.

The Java class `Assignment1_Q4` in the `instructor.assignments.A01` package contains a partially completed starter file that reads keyboard input to calculate the total production time for a batch of units. Copy it into your own `student.assignments.A01` package using IntelliJ's **Refactor → Copy**, and do your work in the copy.

The starter file already creates a `Scanner` object for you:

```java
Scanner input = new Scanner(System.in);
```

**a.** Using `System.out.print()`, prompt the user to enter a machine's cycle time in seconds (a decimal value), then read it using the appropriate `Scanner` method.

**b.** Using `System.out.print()`, prompt the user to enter the number of units to produce (a whole number), then read it using the appropriate `Scanner` method.

**c.** Calculate the total production time in minutes: `(cycle time in seconds × number of units) / 60`.

**d.** Using `System.out.printf()`, print the total production time formatted to 2 decimal places.

**e.** Before running, predict what your program will print for a cycle time of `12.5` seconds and `40` units. Write your prediction as a comment above `main`.

**f.** Run the program using those exact values first to check your prediction, then run it again with values of your choosing. If your prediction in (e) didn't match, add a one-line comment explaining why.

------

## Submission Guidelines

1. **Code**: Push all Java files (under `student.assignments.A01`) to your fork's main branch.
2. **Testing**: Make sure all four programs compile and run before submission.
3. **Due Date**: Friday, August 28, 2026 at 5:00 PM.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review and formatting.
