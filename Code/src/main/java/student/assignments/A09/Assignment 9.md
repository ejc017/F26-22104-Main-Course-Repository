# Assignment 9

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, November 13, 2026

To submit Assignment 9, commit and push your work to the **main branch of your fork** of the course repository.

All of the starter files live in the `instructor.assignments.A09` package. Copy the **entire `A09` package** across in one step: right-click `instructor.assignments.A09`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.assignments.A09`. That package does not exist under `student.assignments` yet. The copy creates it for you, along with all of the Java files. Do all of your work in your copy, and leave the `instructor` version alone.

**Question 2 has no Java at all.** It is a plain-text pseudocode file, `Assignment9_Q2_pseudocode.txt`, that you create yourself in your copy of the package. Create it only **after** the Refactor → Copy step above, and read "Planning With Pseudocode" below before you start. It must be your own work, with no AI of any kind.

**Recorded results** (Questions 1 and 4) go in the comment block at the top of the starter file (the "YOUR RECORDED RESULTS" block), not in this document. Read that block before you start each question, and type your results into it.

This assignment uses no data files and writes no output files. Every value is in the handout or in the starter code.

Where a question below allows AI, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

> **Example of a good disclosure** (at the top of `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Workstation.java`, below the `package` line). Cite the tool and version you actually used.
>
> ```java
> // Anthropic. (2026). Claude (Sonnet 5.5) [Large language model]. https://claude.ai
> //
> // Used Claude for a general Java syntax question, independent of this assignment:
> // I asked "How do I write a method in a class that returns a boolean, and how do I
> // call another method of the same class from inside it?" I then wrote unitsPerHour
> // and meetsDemand myself. I did not describe the workstation scenario or paste
> // any assignment text.
> ```
>
> A good disclosure has the reference, **what you actually asked** (paraphrased), and what you did yourself afterward. "Used AI for help" is not enough.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution. This applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead. There's no advantage to skipping the practice now.

### Planning With Pseudocode (required for Question 2)

Question 2 is graded on the **plan**, so it deserves care. Exam 2 showed that planning with loops and decisions needs more practice, and a plan is only worth credit if someone else could build the program from it: no vague steps, every variable initialized, every loop bound stated. This question is the practice.

**What it is.** Pseudocode is a plan for a program written in plain language instead of Java. Nothing runs it. Its job is to make you decide the structure of your solution before you are also fighting semicolons and compiler errors. Someone who has never seen your code, and who may use a different language, should be able to build a correct program from it.

**The style.** Plain language, **no Java syntax** (no semicolons, braces, `i++`, `new int[10]`, type words like `int`, or `printf` format strings), but **exact** about bounds, order, and special cases. Use these capitalized keywords the same way everywhere, one action per line, and indent everything inside a block. They are the same ones you used on Assignments 7 and 8.

| Keyword | Use |
|---|---|
| `SET x TO ...` | give a variable or array element a value |
| `OPEN` / `READ x FROM ...` / `CLOSE` | file input |
| `WRITE ...` | output (say whether it goes to the console or to a file) |
| `FOR i FROM a TO b` ... `END FOR` | counted loop; **both a and b are included**, and indexes start at 0 |
| `WHILE condition` ... `END WHILE` | loop that ends when the condition is false, such as `WHILE the file has another number` |
| `IF ... THEN` / `ELSE IF ... THEN` / `ELSE` ... `END IF` | decisions, tested top to bottom; **the first true test wins**; `THEN` is required on every `IF` and `ELSE IF` |
| `EXIT LOOP` | leave the nearest `FOR` or `WHILE` right now, without finishing it (this is `break` in Java); put it inside an `IF` |
| `#` | a comment line; use it for notes and for the trace |

Array elements (`counts[b]`) and simple formulas are fine. Types are written in plain words ("whole number", "decimal number", "text", "list of whole numbers"), never as Java types. A few notes for things that come up with arrays:

- **Making a list (array):** write "a list of 30 whole numbers", not `new int[30]`.
- **Sizes and ends:** `.length` is Java. Write "the number of values in `output`" or "the last index of `output`".

**What a full-credit plan shows.** You are graded on whether the plan is complete and would actually work, not on its wording.

1. **The data.** Each variable and list, with a meaningful name, its type in plain words, its size, and its starting value.
2. **Initialization.** Every counter, total, and "best so far" is set **before** the loop that uses it.
3. **Every loop, with exact bounds.** Where it starts, where it stops, whether the end is included. For a `WHILE`, the condition and what makes it false.
4. **Every decision**, with the exact comparison (`>` or `>=`, `<` or `<=`).
5. **What is updated inside the loop.** Totals, counts, run lengths, the best so far.
6. **What is output**, to where, and in what order.

**Good, vague, and code-like.** For the step "find the largest value in a list of 24 temperatures":

- **Good:**
  ```
  SET highest TO temps[0]
  FOR i FROM 1 TO 23
      IF temps[i] > highest THEN
          SET highest TO temps[i]
      END IF
  END FOR
  ```
  Bounds stated, what is compared, what is remembered.
- **Too vague:** "Look through the temperatures and find the biggest." No loop, no comparison, nothing remembered, so nothing has been planned.
- **Too code-like:** `for (int i = 1; i < temps.length; i++) { if (temps[i] > highest) highest = temps[i]; }` That is Java. If you could paste it into a program unchanged, it is not pseudocode.

**Creating and submitting the file in IntelliJ and GitHub Desktop.** The file must be a plain `.txt` file, because it opens on any computer (Windows or Mac) with no special software.

1. Check that you have already done **Refactor → Copy...** so that the package `student.assignments.A09` exists in your project. If it does not, stop and do that first.
2. In the Project panel, expand `src` → `main` → `java` → `student` → `assignments` and right-click **`A09`** (the one under `student.assignments`).
3. Choose **New → File**. In the box that appears, type exactly `Assignment9_Q2_pseudocode.txt` and press Enter. If IntelliJ asks whether to add the file to Git, click **Add**.
4. The file opens in the editor. Write your pseudocode and save.
5. **Do NOT create the file in the `instructor` package**, and do not put it in the project's `data` or `output` folders. The file must appear directly under `student.assignments.A09`, next to your Java files.
6. Open **GitHub Desktop**. The new file appears in the list of changed files. Leave it checked so it is committed and pushed along with your Java files.

### What You May Use

The concepts you can use on this assignment are:

- **Classes and objects**: `private` fields, default and parameterized constructors, accessors, mutators, `toString`, non-static (instance) methods, `this`, `new`, the dot operator
- **Methods**: `public static` methods, `return`, parameters (including arrays of objects), methods that call other methods
- **Arrays**: arrays of objects such as `Workstation[]`, `arr[i]`, `arr.length`, array initializer lists
- **Output**: `printf()` with `%s`, `%d`, `%f`, `%n`, `%%`, and widths and precisions such as `%-6s` and `%.2f`
- **Everything from earlier assignments**: `if`/`else if`/`else`, `for` and `while` loops, `break` to leave a loop early, `final` constants, casting, `boolean` values, and the arithmetic (including `%`), comparison, and logical operators

We have **not** covered the following, and solutions that rely on them will not receive credit: `ArrayList`, the enhanced (for-each) `for` loop, writing your own `equals` or `compareTo`, inheritance, `String.format`, the conditional (ternary) `?:` operator, `try`/`catch`, `continue`, and recursion.

------

## Question 1 - Pallets in the Warehouse

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I write a constructor?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the class.

A warehouse keeps track of its pallets. Each pallet has an **id** number, the name of the **product** on it, the number of **cases** stacked on it, and its total **weight in kilograms**. You write the `Pallet` class in `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Pallet.java`. The program that uses it, `main` in `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Assignment9_Q1.java`, is already written for you.

You edit two files: write the class in `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Pallet.java`, and record your output in the comment block at the top of `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Assignment9_Q1.java`. Do not change `main`. The fields of `Pallet` and the header of every method are given and must not change. Until you replace the placeholders, the program compiles but prints nothing useful.

**a.** In `Pallet`, write:

- the **default constructor**, which gives every field a value (id `0`, product `"Empty"`, `0` cases, weight `0.0`);
- the **fully parameterized constructor**, whose parameters come in the same order as the fields (`id`, `product`, `cases`, `weightKg`);
- the four **accessors**;
- the **mutator** `setCases`;
- **`toString`**, which **returns** (it does not print) a `String` in exactly this form:

```
Pallet 1042: 24 cases of Brake Pads, 310.5 kg
```

**b.** Run `Assignment9_Q1`. Check each line of the output against the `toString` format in part a and against what `main` does to the pallets. Record the full console output in the comment block at the top of `Assignment9_Q1`.

------

## Question 2 - Planning the Line 4 Report

**AI Usage**: **None, of any kind.** This question is entirely your own work. Do not use AI to write, check, or reword your pseudocode.

**There is no Java in this question.** You will write a plan, trace it by hand, and stop. Do the plan the way you would on an exam: on its own, from a blank file.

Line 4 produces finished units, and the plant keeps a file of the number of units finished each day for the last **30 days**: 30 whole numbers, one per line, the first line being day 1. A planner wants a program to answer two questions from that file:

1. **When did the month's total first reach the order size?** The plant owes a customer **1000** units. Report the **day number** (counting from 1) on which the running total, from day 1 up to and including that day, first reaches **at least 1000**. If the total never reaches 1000, report that instead. Once you have found the day, you have your answer; do not keep adding (leave the loop with `EXIT LOOP`, or write a `WHILE` whose condition also stops when the target is reached; either is fine).
2. **How bad was the worst slump?** A **slow day** is a day with **fewer than 30** units. A **slump** is a stretch of one or more consecutive slow days (a single slow day between two normal days is a slump of length 1). Report the **length of the longest slump** and the **day number on which it began**. If two or more slumps are equally long, the start day of any one of them is an acceptable answer. If there are no slow days at all, report that instead.

Both reports go to the console. The answer to question 2 must look at all 30 days, even if the answer to question 1 was found early.

Create `Assignment9_Q2_pseudocode.txt` (see "Planning With Pseudocode" above) and write the plan using this layout:

```
INPUT   what is read, and from where
OUTPUT  what is written, and where

DATA
  (one line per variable or list: name, type in plain words, size, starting value, meaning)

STEPS
  1. (a heading for the step)
       (the pseudocode for it, indented)
  2. ...

# TRACE ...
```

The file must show:

**a. The data.** Every variable and list you use, each with a plain-words type, a meaningful name, a size where it is a list, and a **starting value**. Say what each one means.

**b. The steps.** Number them. They must include, in order: loading the file; finding the day the total first reaches 1000; finding the longest slump; and the reports. For each loop, state the **starting and stopping index** and which ends are included (for a `WHILE`, the condition and what makes it false). For each decision, write the exact comparison. The plan must handle the special cases: a total that never reaches 1000, and no slow days.

**c. A trace.** A trace is you acting as the computer: you follow your own pseudocode by hand on a small example and write down what each variable holds as it goes. If the trace gives a wrong answer, your plan has a bug, so fix the plan first.

A full run has 30 days, which is too long to follow by hand. So trace a **7-day version**. Use your plan exactly as you wrote it, but picture the 30 days replaced by 7 (your loops now stop at index 6 instead of 29) and the target of 1000 replaced by **100**. A slow day is still fewer than 30 units. The 7 daily outputs are:

```
45  20  25  10  60  28  40
```

At the bottom of `Assignment9_Q2_pseudocode.txt`, below your steps, in `#` comment lines, write the following.

1. **A table with one row per day.** Copy this layout into the bottom of `Assignment9_Q2_pseudocode.txt` and fill in the blanks (it is plain text, so keep the `#` at the start of every line):

```
# Day | Units | Running total | Slow day? | Current slump | Longest slump so far | Longest began on day
# ----|-------|---------------|-----------|---------------|----------------------|---------------------
#  1  |  45   |               |           |               |                      |
#  2  |  20   |               |           |               |                      |
#  3  |  25   |               |           |               |                      |
#  4  |  10   |               |           |               |                      |
#  5  |  60   |               |           |               |                      |
#  6  |  28   |               |           |               |                      |
#  7  |  40   |               |           |               |                      |
```

   Your plan stops adding up the units as soon as the running total reaches the target. In the Running total column, fill in the total for each day up to and including the day it reaches the target, and write `stopped` for every day after that. The other columns are filled in for all 7 days.

2. **The output.** `#` lines stating exactly what your plan writes to the console for these 7 days, one line per report, in the same `WRITE` style as your steps. It might look like this (the numbers here are made up and are **not** the answer for this data):

```
# OUTPUT: WRITE "Total reached 100 on day 6" to the console
#         WRITE "Longest slump: 2 days, starting on day 5" to the console
```

------

## Question 3 - Choosing the Bottleneck

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I return a `boolean` from a method?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write any of the methods.

An assembly line has four workstations in a row, and every unit passes through all four. A station is described by its **name** and its **cycle time**, the number of seconds it takes to finish one unit. A station that needs 60 seconds per unit can finish 3600 / 60 = 60 units in an hour. The **bottleneck** is the station that can finish the fewest units per hour, because it limits what the whole line can deliver. The line must deliver **55 units per hour**.

You edit two files: write the class in `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Workstation.java`, and in `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Assignment9_Q3.java` write the two `static` methods below `main`. Do not change `main`. In `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Workstation.java`, the fields and every constructor and method header are given. `toString` for `Workstation` is also already written. Until you replace the placeholders, the program compiles but prints nothing useful.

**a.** In `Workstation`, write the default constructor (name `"Unassigned"`, cycle time `60.0`; it must not be `0.0`, because `unitsPerHour` divides by it), the parameterized constructor, the two accessors, and the mutator `setCycleTimeSec`.

**b.** In `Workstation`, write two methods of your own. `unitsPerHour()` takes no parameters and returns how many units the station can finish in an hour, which is `3600.0` divided by its cycle time. `meetsDemand(demandPerHour)` returns `true` if the station can finish **at least** the demand per hour (exactly meeting it counts) and `false` otherwise. It must **call `unitsPerHour()`** rather than repeat the formula.

**c.** In `Assignment9_Q3`, write two `static` methods. `indexOfBottleneck(stations)` takes the array of `Workstation` objects and returns the **index** of the station that can finish the fewest units per hour (the first, if two tie). To find it, begin by assuming the station at index `0` is the bottleneck, and keep that index in a variable. Then loop over the rest of the stations, starting at index `1`. Whenever the station at index `i` finishes fewer units per hour (`<`) than the station at the index you are keeping, replace the kept index with `i`. When the loop ends, return the kept index. Using `<` rather than `<=` is what makes the first station win a tie. `countMeetingDemand(stations, demandPerHour)` takes the same array and the required number of units per hour, and returns how many of the stations meet that demand. It must **call `meetsDemand`** for each station.

------

## Question 4 - Fix the Batch Inspector

**AI Usage**: AI allowed for general Java syntax questions only, completely independent of this assignment. NOT allowed: pasting this code, or describing it, to an AI tool and asking it to find or fix the bugs. Finding the bugs is the skill being practiced.

A quality group tracks **batches** of parts. For each batch it records the id, the number of units, and the number of defective units found. A `Batch` can report its defect rate as a percent and whether it is acceptable. The program also finds the worst batch, counts the acceptable batches, and averages the defect rates.

**The code you are given compiles and runs, but it is wrong.** There are **exactly five bugs**: three in `Batch` and two in `Assignment9_Q4`. Every one of them is a mistake the compiler cannot catch. The headers of the methods are right and must not change. `main` is right and must not change. Nothing is missing; the code just does the wrong thing.

You edit two files: fix the bugs in `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Batch.java` and in `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Assignment9_Q4.java`, and record your buggy output and bug list in the comment block at the top of `../../../../../../../../F26-22104-Main-Course-Repository-main 11/Code/src/main/java/instructor/assignments/A09/Assignment9_Q4.java`.

**a.** Run the program **before changing anything**. Record the first four lines of its output in the comment block of `Assignment9_Q4`. Compare them with the correct output below. What you see is wrong in several ways at once, so do not expect one fix to repair everything. Fix the bugs one at a time and run again after each one. The output improves as you go, and that tells you which bug you just fixed.

**b.** Find and fix all five bugs. Fix them where they are; do not delete a method and write a different one. When the program is fixed, it prints these lines:

```
B-101: 8 defects in 500 units -> 1.60%
B-102: 8 defects in 400 units -> 2.00%
B-103: 10 defects in 250 units -> 4.00%
B-104: 12 defects in 800 units -> 1.50%
B-105: 14 defects in 200 units -> 7.00%
Worst batch: B-105
Acceptable at 2.0%: 3 of 5
Average defect rate: 3.22%
B-103: 4 defects in 250 units -> 1.60%
Acceptable at 2.0%: 4 of 5
```

In the comment block, record the bug list: for each bug, the class and method it was in, what was wrong, and the corrected line.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5.5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review, formatting, and the generation of the starter code.
