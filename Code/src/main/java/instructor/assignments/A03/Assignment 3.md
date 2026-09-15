# Assignment 3

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, September 11, 2026

To submit Assignment 3, commit and push your work to the **main branch of your fork** of the course repository (see `Course Materials/Setup Guides/GitHub and GitHub Desktop/` if you need a refresher).

All three starter files live in the `instructor.assignments.A03` package. Copy the **entire `A03` package** across in one step: right-click `instructor.assignments.A03`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.assignments.A03`. That package does not exist under `student.assignments` yet -- the copy creates it for you, along with all three files. Do all of your work in your copy, and leave the `instructor` version alone.

Where a question below allows AI use, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution -- this applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Question 3 asks you to **predict output before running the program**, then record what actually happened. Write the prediction first and leave it alone. A prediction that was wrong, followed by a correct explanation of why, earns full credit.
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead. There's no advantage to skipping the practice now.

### What You May Use

The concepts you can use on this assignment are:

- **Scanner**: `next()`, `nextLine()`, `nextInt()`, `nextDouble()`, `nextBoolean()`, `close()`
- **Output**: `print()`, `println()`, `printf()` with `%s`, `%d`, `%f`, `%n`, and `%.Xf`
- **String methods**: `length()`, `charAt()`, `indexOf()`, `contains()`, `isEmpty()`, `substring()`, `toUpperCase()`, `toLowerCase()`, `trim()`, `replace()`, `concat()`, `equals()`, `equalsIgnoreCase()`, `isBlank()`, `startsWith()`, `endsWith()`, `lastIndexOf()`, `indexOf(String, int)`, `repeat()`
- **Operators**: `+ - * / %`, `=`, `==`, `!=`, `>`, `<`, `>=`, `<=`, `&&`, `||`, `!`
- **Branching**: `if`, `else if`, `else`, and **nested** `if` statements
- **Random numbers**: `Math.random()`, and `java.util.Random` with `nextInt(bound)`, `nextDouble()`, `nextBoolean()`, and seeding via `new Random(seed)`

We have **not** covered the following, and solutions that rely on them will not receive credit: the conditional (ternary) `?:` operator, `compareTo()`, `split()`, `try`/`catch`, loops, arrays, and methods you write yourself other than `main`.

Every validity check on this assignment is done with `if` statements. You are **not** expected to catch exceptions -- if a question says to reject a bad value, that means testing it with a condition and printing a message, not handling an error after it happens.

**Assume throughout that the user types the right kind of value**: a whole number when a question asks for a whole number, and so on. Guarding against someone typing `four` at a prompt expecting `4` takes tools we have not covered yet. The checks you write here are about whether a value makes **sense** -- a blank label, a count below zero -- not about whether it is the right type.

------

## Question 1 - Validating and Unpacking a Pallet Label

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "What is the difference between `isEmpty()` and `isBlank()` in Java?"), completely independent of this assignment. NOT allowed: describing this label format to AI, pasting this question, or asking it to write the validation logic.

A distribution center's receiving dock labels every inbound pallet with a code in the format `PLT-CCC-DD-X`:

| Field | What it means |
|---|---|
| `PLT` | a fixed prefix on every pallet label |
| `CCC` | the carrier's three-letter code |
| `DD` | the two-digit dock number the pallet was assigned |
| `X` | a single check letter |

So `PLT-USF-14-K` is a pallet from carrier `USF`, assigned to dock `14`, with check letter `K`.

Receiving clerks type these in by hand at the end of a shift, so the program has to assume the entry is wrong until it proves otherwise.

**a.** In `Assignment3_Q1`, prompt for and read a pallet label. Read the **entire line** the clerk typed -- leading and trailing spaces included, and an empty line if that is all they gave you. Store it, exactly as typed, in a String named `rawEntry`. Then create a second String named `label` holding `rawEntry` trimmed and converted to upper case, so that a clerk who types `  plt-usf-14-k  ` is not punished for it.

**b.** Find the positions of the first dash, the second dash, and the last dash in `label`, and store each in its own `int` variable. Use appropriate String methods related to finding indices -- **do not type in a position number you counted yourself**.

**c.** Write a single `if` / `else if` / `else` chain that applies these four rules **in this order**. Each rejected label prints its message and nothing else.

| # | The label is rejected when... | Message to print |
|---|---|---|
| 1 | `rawEntry` is blank | `Error: no label entered` |
| 2 | `label` does not begin with `PLT-` | `Error: label must begin with PLT-` |
| 3 | `label` ends with a dash | `Error: label is missing its check letter` |
| 4 | there is no second dash, **or** the second dash is also the last dash | `Error: label is missing a field` |

Rule 1 is the reason you saved `rawEntry` separately.

**d.** In the final `else` -- the branch reached only when all four rules pass -- print the cleaned-up label and then its four fields, each on its own line with a short label, in this form:

```
========================================
Label: PLT-USF-14-K
Prefix: PLT
Carrier: USF
Dock: 14
Check letter: K
========================================
```

Every field must be pulled out of `label` with `substring` and the dash positions from part (b). The two divider lines are forty `=` characters produced with `repeat`, not forty characters you typed.

**e.** Run your program five times, entering the values below, and record the output of each run in the comment block at the top of the file. Four of the five are supposed to be rejected, and each one should trip a different rule.

| Run | What to type |
|---|---|
| 1 | press Enter without typing anything |
| 2 | `SHIP-USF-14-K` |
| 3 | `PLT-USF-14-` |
| 4 | `PLT-USF-14` |
| 5 | `  plt-usf-14-k  ` |

------

## Question 2 - Simulating a Shipping Method

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I generate a random integer in a range in Java?"), completely independent of this assignment. NOT allowed: pasting the decision rules below, describing this scenario, or asking AI to write or check the branching.

The same distribution center wants to estimate how its outbound volume splits across shipping methods. Before anyone collects real data, you are going to simulate one package at a time.

**a.** In `Assignment3_Q2`, generate two random values, using a different tool for each:

- `packageWeight`, an `int` from **1 to 70** pounds, inclusive, generated with `Math.random()` -- scaled and cast, with no `Random` object involved
- `distanceMiles`, an `int` from **10 to 3000** miles, inclusive, generated with the `Random` object already declared in the starter file, using the `min + rand.nextInt(max - min + 1)` pattern from class

Print both values before anything else, so you can check them against the shipping method your program picks.

**b.** Use a **nested** `if` structure to decide the shipping method from those two values. Store the result in a `String` named `shippingMethod`.

The outer decision is the weight. Everything else happens inside it:

- **A package over 50 pounds** is freight, and only the distance matters after that:
    - over 500 miles -> `Freight - LTL`
    - otherwise -> `Freight - Local Truck`
- **A package of 50 pounds or less** is sorted by distance first, and one of those distance bands then looks at the weight a second time:
    - over 1500 miles, the package flies, and the weight decides how:
        - 5 pounds or less -> `Air - Express`
        - otherwise -> `Air - Standard`
    - over 300 miles but not over 1500 -> `Ground - Regional`
    - otherwise -> `Courier - Same Day`

Note that the two halves are **not** the same shape. Once a package is on the heavy side, one more question settles it. On the light side, more than 1 additional question is needed in one case. That asymmetry is the normal case for nested branching, and it is why a single flat `if` / `else if` chain does not express these rules well.

**c.** Report the result with a single `printf` in this form:

```
A 62 lb package going 1840 miles ships via Freight - LTL
```

**d.** Run the program **ten** times and record the summary line from each run in the comment block at the top of the file. Then answer, in the same block: which of the six shipping methods showed up most often, and which ones did you see once or not at all? Give a reason based on the ranges in part (a) and the cutoffs in part (b) -- not just "it was random." One of the six is far rarer than the others because reaching it takes *two* narrow conditions at once; name it and say what both conditions are.

**e.** Change your `Random` object to `new Random(2026)` and run the program twice more, and record both runs. **Only one of the two random values settles down.** Say which one now repeats and which one still changes from run to run, and explain why seeding the `Random` object had no effect on the other one. Then change it back to `new Random()` before you submit.

------

## Question 3 - The `else` That Attached to the Wrong `if`

**AI Usage**: **No AI use of any kind on this question.** This one is short, and the entire point is whether *you* can predict and explain the behavior.

At the packing station, a scanner counts the items actually placed in a box and compares that against the number of items the order called for. `Assignment3_Q3` is supposed to report one of three things: an empty order, a complete order, or a mismatch that needs a recount.

It compiles, it runs, and it is wrong. The indentation in the starter file describes what the programmer meant. The compiler ignores indentation entirely.

Your written answers for parts (a) through (d) go in the comment block at the top of the file.

**a.** **Before running anything**, read the branching in the starter file and predict every line the program prints for each of these three pairs of entries. Write all three predictions in block **(a)**. If you think a pair prints no message at all, say so -- that is a valid prediction.

| Run | items scanned | items ordered |
|---|---|---|
| 1 | 4 | 4 |
| 2 | 3 | 5 |
| 3 | 0 | 0 |

**b.** Run the program three times, once per pair, and record the actual output in block **(b)**. Leave your predictions unchanged.

**c.** Two of those three runs are plainly wrong for a packing station. In block **(c)**, explain **which `if` the `else` actually belongs to** and state the rule Java uses to decide that. Then say, for run 1 and run 2 specifically, why the wrong thing happened.

**d.** Fix the branching by adding braces so the program behaves the way the messages claim. Keep it a nested `if`: the outer question is whether the two counts match, and the inner question is only asked when they do.

- counts match and the count is 0 -> `Empty order - nothing to pack`
- counts match and the count is above 0 -> `Order complete - 4 items packed` (with the real count)
- counts do not match -> `MISMATCH - send to recount`

Re-run all three pairs and record the corrected output in block **(d)**.

**e.** A scanner that loses its connection can report a negative count, and the current program will happily pack a box for `-3` items. Add a validity check around your fixed branching: if **either** count is below zero, print `Error: item counts cannot be negative` and print none of the three messages from part (d). Use the `||` operator, and do this with an `if` -- not with `try`/`catch`. Assume both counts are typed as whole numbers; a negative count is the only bad value you are guarding against here.

Run the program once with `-1` and `4`, and record the output in block **(d)** alongside the others.

------

## Submission Guidelines

1. **Code**: Push all three Java files (under `student.assignments.A03`) to your fork's main branch.
2. **Comments**: Every question asks for written answers in comments. A program that runs correctly but is missing its predictions, recorded runs, or explanations will not receive full credit.
3. **Leave the files runnable**: Question 2 part (e) asks you to change something temporarily. Change it back before you push.
4. **Due Date**: Friday, September 11, 2026 at 5:00 PM.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review and formatting.
