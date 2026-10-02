# Assignment 5

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, October 2, 2026

To submit Assignment 5, commit and push your work to the **main branch of your fork** of the course repository.

All three starter files live in the `instructor.assignments.A05` package. Copy the **entire `A05` package** across in one step: right-click `instructor.assignments.A05`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.assignments.A05`. That package does not exist under `student.assignments` yet -- the copy creates it for you, along with all three files. Do all of your work in your copy, and leave the `instructor` version alone.

Where a question below allows AI use, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution -- this applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead. There's no advantage to skipping the practice now.

### What You May Use

The concepts you can use on this assignment are:

- **Scanner**: `next()`, `nextLine()`, `nextInt()`, `nextDouble()`, `nextBoolean()`, `hasNext()`, `hasNextInt()`, `hasNextDouble()`, `hasNextBoolean()`, `close()`
- **Output**: `print()`, `println()`, `printf()` with `%s`, `%d`, `%f`, `%n`, and `%.Xf`
- **Operators**: `+ - * / %`, `=`, `==`, `!=`, `>`, `<`, `>=`, `<=`, `&&`, `||`, `!`, `++`, `--`, `+=`
- **Branching**: `if`, `else if`, `else`, and nested `if`
- **Loops**: `while`, and `for` (including a `for` loop nested inside another `for` loop)

We have **not** covered the following, and solutions that rely on them will not receive credit: `switch`, the conditional (ternary) `?:` operator, `do`-`while` loops, `continue`, arrays, and methods you write yourself other than `main`.

Every validity check on this assignment is still done with `if` statements, not `try`/`catch`. **Assume the user types the right kind of value** everywhere on this assignment.

------

## Question 1 - Building a Promotional Pallet Display

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "In a nested `for` loop, how does the inner loop's bound depend on the outer loop's variable?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the nested loop.

A distribution center is building a triangular pallet display for a promotional endcap. Row 1 holds one pallet, row 2 holds two, row 3 holds three, and so on, up to however many rows the display needs.

**a.** In `Assignment5_Q1`, prompt with `Enter the number of rows for the display: ` and read a positive whole number named `rows` (assume the value typed is valid).

**b.** Using a `for` loop nested inside another `for` loop, reproduce the display below for whatever `rows` the user entered, using `* ` for each pallet. In the same nested loop, accumulate a running total, in an `int`, of how many pallets were printed across every row.

For `rows` equal to 4, the display looks like this:

```
Enter the number of rows for the display: 4
* 
* * 
* * * 
* * * * 
```

**c.** Report the total with a single `printf` in this form:

```
Total pallets: 10
```

**d.** Run the program twice, once with `rows` equal to `4` and once equal to `6`, and record both full runs (every line printed, plus the final total) in the comment block at the top of the file.

------

## Question 2 - Screening Packages for a Weight Limit

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "Can a `for` loop's body contain an `if`/`else` statement?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the loop or the check.

A shipping dock needs to screen a fixed batch of outgoing packages against a maximum shipping weight before they go on the truck.

**a.** In `Assignment5_Q2`, using a `for` loop that runs exactly `NUM_PACKAGES` times (the constant is already declared in the starter file), prompt for and read each package's weight as a `double`, in this form:

```
Enter weight for package 1 (lbs): 18.5
```

**b.** In the **same loop**, use an `if`/`else` to compare each weight against `WEIGHT_LIMIT` (also already declared) and print one line per package:

- if the weight is over the limit: `Package 1: OVERWEIGHT (18.5 lbs)`
- otherwise: `Package 1: OK (18.5 lbs)`

**c.** In the same loop, accumulate two running totals: the sum of every package's weight (a `double`), and a count of how many packages were overweight (an `int`).

**d.** After the loop ends, report both totals with a single `printf` in this form:

```
Total weight: 154.0 lbs (2 overweight)
```

**e.** Run the program once, entering these five weights in order: `18.5`, `42.0`, `12.25`, `51.2`, `30.0`. Record the full run (every line printed, plus the final totals) in the comment block at the top of the file.

------

## Question 3 - Logging Downtime Events Until Shift End

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "What's a common pattern for reading values in a loop when you don't know ahead of time how many there will be?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the loop.

A production supervisor logs each unplanned downtime event, in minutes, as it happens during a shift. There is no way to know ahead of time how many events a given shift will have.

**a.** In `Assignment5_Q3`, prompt with `Enter downtime duration in minutes (-1 to end shift): ` and read the **first** value into an `int`, before the loop starts. Assume every value typed is a valid whole number -- the only special value is `-1`.

**b.** Keep prompting for and reading additional durations until `-1` is entered. `-1` itself is a signal to stop, not a downtime event -- do not count it or add it to any total. You will need to prompt and read again at the **bottom** of the loop body so the next value is ready by the time the condition is checked again.

For every duration that is **not** the stop value, accumulate three things:

- a running total of downtime minutes (an `int`)
- a count of how many events were entered (an `int`)
- the single longest duration seen so far -- a running maximum (an `int`)

**c.** After the stop value is entered, report all three values with a single `printf` in this form:

```
Shift downtime: 47 minutes across 3 events (longest single event: 25 minutes)
```

This has to produce a sensible line even if `-1` is entered immediately, with zero events logged. Think about what the running maximum should start out as, so that case doesn't need a special check of its own before the `printf`.

**d.** Run the program twice and record both full runs (every line printed, plus the final totals) in the comment block at the top of the file:

- Run 1: enter `10`, then `25`, then `12`, then `-1`
- Run 2: enter `-1` immediately

------

## Submission Guidelines

1. **Code**: Push all three Java files (under `student.assignments.A05`) to your fork's main branch.
2. **Comments**: Every question asks for recorded runs in comments. A program that runs correctly but is missing its recorded runs will not receive full credit.
3. **Due Date**: Friday, October 2, 2026 at 5:00 PM.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review and formatting.
