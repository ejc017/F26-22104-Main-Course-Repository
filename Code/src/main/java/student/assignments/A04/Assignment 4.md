# Assignment 4

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, September 18, 2026

To submit Assignment 4, commit and push your work to the **main branch of your fork** of the course repository.

All four starter files live in the `instructor.assignments.A04` package. Copy the **entire `A04` package** across in one step: right-click `instructor.assignments.A04`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.assignments.A04`. That package does not exist under `student.assignments` yet -- the copy creates it for you, along with all four files. Do all of your work in your copy, and leave the `instructor` version alone.

Where a question below allows AI use, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution -- this applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Question 4 asks you to debug a program that is already broken. AI use there is limited to asking what an error message or exception means **in general** -- see that question's own AI Usage line. Identifying and fixing the actual bugs, on your own, is the point.
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead. There's no advantage to skipping the practice now.

### What You May Use

The concepts you can use on this assignment are:

- **Scanner**: `next()`, `nextLine()`, `nextInt()`, `nextDouble()`, `nextBoolean()`, `hasNext()`, `hasNextInt()`, `hasNextDouble()`, `hasNextBoolean()`, `close()`
- **Output**: `print()`, `println()`, `printf()` with `%s`, `%d`, `%f`, `%n`, and `%.Xf`
- **String methods**: any covered so far, including `length()`, `charAt()`, `indexOf()`, `contains()`, `isEmpty()`, `substring()`, `toUpperCase()`, `toLowerCase()`, `trim()`, `replace()`, `concat()`, `equals()`, `equalsIgnoreCase()`, `isBlank()`, `startsWith()`, `endsWith()`, `repeat()`
- **Operators**: `+ - * / %`, `=`, `==`, `!=`, `>`, `<`, `>=`, `<=`, `&&`, `||`, `!`, `++`, `--`, `+=`
- **Branching**: `if`, `else if`, `else`, nested `if`, and `switch` (with `case`, `default`, and `break`)
- **Random numbers**: `Math.random()`, and `java.util.Random` with `nextInt(bound)`, `nextDouble()`, `nextBoolean()`, and seeding via `new Random(seed)`
- **Loops**: `while` loops only

We have **not** covered the following, and solutions that rely on them will not receive credit: `for` loops, the conditional (ternary) `?:` operator, `compareTo()`, `split()`, `try`/`catch`, arrays, and methods you write yourself other than `main`.

Every validity check on this assignment is still done with `if` statements, not `try`/`catch`. **Assume the user types the right kind of value** everywhere **except Question 2**, which is specifically about what to do when they don't.

------

## Question 1 - Simulating a Quality Test Assignment

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "What's the difference between a `switch` statement and an `if`/`else` chain in Java?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the switch or pick the random calls.

A quality lab wants to randomly assign each incoming sample to one of five tests.

**a.** In `Assignment4_Q1`, using the `Random` object already declared in the starter file, generate `testNumber`, an `int` from **0 to 4**, inclusive. Print the raw value before anything else.

**b.** Use a `switch` statement on `testNumber` to set a `String` named `testName`:

| `testNumber` | `testName` |
|---|---|
| 0 | `Visual Inspection` |
| 1 | `Weight Check` |
| 2 | `Dimensional Scan` |
| 3 | `Hardness Test` |
| 4 | `Surface Finish Check` |

Include a `default` case that sets `testName` to `Unexpected test number` -- it should be unreachable given how `testNumber` was generated, but every `switch` should still account for the case it doesn't expect.

**c.** Report the result with a single `printf` in this form:

```
Test selected: Weight Check
```

**d.** Run the program **eight** times and record the result line from each run in the comment block at the top of the file. Then answer, in the same block: across your eight runs, was any one of the five tests noticeably more or less common than the others, or did they seem about evenly spread out? Explain what generating an `int` in a fixed range from 0 to 4 guarantees about the values you can get back.

------

## Question 2 - Validating a Sensor Reading

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "What Scanner methods exist for checking whether the next token is a number before reading it?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the validation.

A calibration station reads a voltage reading typed in by a technician. Technicians occasionally mistype the entry and enter something that isn't a number at all, and reading it as a `double` crashes with an exception the moment that happens. Your job is to check **before** you read, so that never happens.

**a.** In `Assignment4_Q2`, prompt with `Enter the sensor voltage reading: `.

**b.** Before reading anything else, call the appropriate `hasNextXXX` method -- where `XXX` names the data type you're checking for -- and use its result as the condition of an `if`/`else`.

**c.** In the `if` branch (a valid reading is waiting), read the value into a `double` named `voltage`, then report it with a `printf` in this form:

```
Voltage reading accepted: 4.75 V
```

**d.** In the `else` branch (not a valid reading), print `Error: voltage reading must be numeric` -- and do **not** attempt to read it as a `double` in this branch, since you already know that would crash. Instead, make sure you still consume whatever token was actually typed, so it doesn't sit unread in the Scanner's buffer waiting to trip up the next prompt. (Hint: there's a Scanner method that reads and discards a single token without caring what type it is.)

**e.** Run the program twice and record both runs in the comment block at the top of the file: once entering `4.75`, and once entering `abc`. Then answer: what specifically does the method you used in part (b) check before your program ever tries to read anything, and why does checking first avoid the crash that reading `abc` directly as a `double` would cause?

------

## Question 3 - Counting Up Production Totals

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I accumulate a running total inside a `while` loop?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the loop.

A line supervisor wants a quick tool that lists every unit produced so far in a shift, flags the ones that need a quality recheck, and totals things up at the end. Every 4th unit off the line gets pulled for a routine recheck, no exceptions.

**a.** In `Assignment4_Q3`, prompt for and read a positive whole number named `unitsProduced` (assume the value typed is valid -- a positive whole number -- for this question).

**b.** Using a `while` loop, process every whole number from 1 to `unitsProduced`. For each one:

- if the unit number is a multiple of 4, print `Unit N pulled for recheck` (with the actual unit number in place of `N`)
- otherwise, print `Unit N complete`

In the same loop, accumulate two running totals in `int` variables: the sum of every unit number from 1 to `unitsProduced`, and a separate count of how many units were pulled for recheck.

**c.** After the loop ends, report both totals with a single `printf` in this form:

```
Sum of units 1 through 8: 36 (2 pulled for recheck)
```

**d.** Run the program twice, once with `unitsProduced` equal to `5` and once equal to `12`, and record both full runs (every line printed, plus the final totals) in the comment block at the top of the file.

------

## Question 4 - Debugging the Furnace Monitor

**AI Usage**: AI allowed **only** to help you understand what a specific error message or exception means in general (e.g., "What does `IllegalFormatConversionException` mean and when does Java throw it?"). NOT allowed for anything specific to this program: do not paste your code, your exception's actual text, this assignment's scenario, or the snippet in part (e) into an AI tool, and do not ask it to find or fix the bugs for you.

`Assignment4_Q4` is supposed to read a furnace temperature and classify it using this table:

| Temperature | Status |
|---|---|
| below 500°F | `Normal` |
| 500°F to 900°F, inclusive | `Elevated - increase monitoring` |
| above 900°F | `Critical - shutdown required` |

It doesn't do that yet. As provided, it doesn't even finish running.

**a.** Run the starter file once, entering any temperature you like. It throws an exception before it finishes. In block **(a)** of the comment header, paste the **first line** of the exception (the exception's class name and message -- you do not need the rest of the stack trace), and explain in your own words what that line is telling you went wrong.

**b.** `printf` fills in its format specifiers with the arguments **that follow, in the same order** -- the first `%` placeholder consumes the first argument after the format string, the second placeholder consumes the second argument, and so on, and each argument has to be a type that specifier can actually format. Fix the call so it runs without throwing. Do not change what information is printed or its wording -- only fix the ordering/typing problem.

**c.** With that fixed, run the program **five** times, entering `499`, `500`, `900`, `901`, and `1000`. Record all five runs in block **(c)**. Compare each result against the table above -- exactly one of the five doesn't match what the table says it should.

**d.** Fix the remaining bug so all five values from part (c) match the table, and explain in block **(d)** what was wrong with the original condition and why that specific input was the one that exposed it. Re-run all five values and confirm each now matches the table, and record these corrected runs in block **(d)** as well.

**e.** The snippet below is unrelated to the file you're fixing -- do not create it or try to run it, it is not part of what you submit as code. A classmate wrote it to greet a machine operator based on a shift number, and it does not compile:

```java
Scanner input = new Scanner(System.in)
System.out.print("Enter shift number (1, 2, or 3): ");
int shift = input.nextInt();

String shiftName;
if (shift == 1) {
    shiftName = "Day Shift";
} else if (shift == 2 {
    shiftName = "Swing Shift";
} else {
    shiftName = "Night Shift";
}

System.out.printf("Welcome to %s%n", shiftName);
```

In block **(e)**, identify **both** syntax errors -- name the line and what's wrong with it -- and write out the corrected snippet.

------

## Submission Guidelines

1. **Code**: Push all four Java files (under `student.assignments.A04`) to your fork's main branch.
2. **Comments**: Every question asks for written answers in comments. A program that runs correctly but is missing its recorded runs or explanations will not receive full credit.
3. **Due Date**: Friday, September 18, 2026 at 5:00 PM.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review and formatting.
