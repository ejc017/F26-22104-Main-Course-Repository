# Assignment 2

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, September 4, 2026

To submit Assignment 2, commit and push your work to the **main branch of your fork** of the course repository (see `Course Materials/Setup Guides/GitHub and GitHub Desktop/` if you need a refresher).

All four starter files live in the `instructor.assignments.A02` package. Copy the **entire `A02` package** across in one step: right-click `instructor.assignments.A02`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.assignments.A02`. That package does not exist under `student.assignments` yet -- the copy creates it for you, along with all four files. Do all of your work in your copy, and leave the `instructor` version alone.

Where a question below allows AI use, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution -- this applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Two questions ask you to **predict output before running the program**, then record what actually happened. Write the prediction first and leave it alone. A prediction that was wrong, followed by a correct explanation of why, earns full credit.
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead. There's no advantage to skipping the practice now.

### What You May Use

The concepts you can use on this assignment are: 

- **Scanner**: `next()`, `nextLine()`, `nextInt()`, `nextDouble()`, `nextBoolean()`, `close()`
- **Output**: `print()`, `println()`, `printf()` with `%s`, `%d`, `%f`, `%n`, and `%.Xf`, where X is the number of decimal places you want (`%.2f` gives two)
- **String methods**: `length()`, `charAt()`, `indexOf()`, `contains()`, `isEmpty()`, `substring()`, `toUpperCase()`, `toLowerCase()`, `trim()`, `replace()`, `concat()`, `equals()`, `equalsIgnoreCase()`
- **Operators**: `+ - * / %`, `=`, `==`, `!=`, `>`, `<`, `>=`, `<=`, `&&`, `||`, `!`
- **Branching**: `if`, `else if`, `else`

We have **not** covered the following, and solutions that rely on them will not receive credit: `switch`, the conditional (ternary) `?:` operator, `compareTo()`, `split()`, loops, arrays, and methods you write yourself other than `main`. 

------

## Question 1 - Keyboard Input and the Order of Scanner Calls

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "What is the difference between `next()` and `nextLine()` in Java?"), completely independent of this assignment. NOT allowed: describing this assignment to AI, sharing your code or output with it, or asking it to explain what your specific program does.

The starter file `Assignment2_Q1` collects three pieces of information from an emergency department intake worker, in this order: the patient's age, their temperature, and their presenting complaint. The code compiles and runs, but it does not behave the way it appears to.

All of your written answers for this question go in the comment block at the top of the file, which is already laid out for you.

**a.** **Before running anything**, read the code carefully and predict what will happen when you enter `34` for the age and `101.2` for the temperature, and then try to enter `chest pain` for the complaint. Be specific: say what each of the three prompts will do, and what each of the three output lines will show. Write this in block **(a)**.

**b.** Run the program and enter those values. Paste the actual console output into block **(b)**, exactly as it appeared. **Leave your prediction in (a) unchanged**, even if it turned out to be wrong.

**c.** Fix the program so the presenting complaint is actually read from the keyboard. Then, in block **(c)**, explain what the original code did wrong.

**d.** Replace the three `println` statements with a **single** `printf` statement that prints one summary line in this form, with the temperature shown to exactly one decimal place:

```
Patient age 34 presented with chest pain at 101.2 degrees F
```

------

## Question 2 - Working with an Encounter Code

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I get the last character of a String in Java?"), completely independent of this assignment. NOT allowed: pasting this question, your encounter code, or your code into an AI tool.

Emergency departments label each patient visit with an **encounter code** in the format `XX-####-P`, made up of three fields:

| Field | What it means | What to use for this assignment |
|---|---|---|
| `XX` | the intake clerk's initials | your own first and last initials, capitalized |
| `####` | the visit number | the number of letters in your first name as two digits, followed by the number of letters in your last name as two digits |
| `P` | the priority letter | the first letter of the month you were born, capitalized |

Jordan Alvarez, born in March, would have the encounter code `JA-0607-M`: the initials `JA`, then `06` because `Jordan` has six letters, then `07` because `Alvarez` has seven, then `M` for March.

**a.** In `Assignment2_Q2`, declare a `String` named `encounterCode` holding **your** encounter code.

**b.** Print each of the following on its own line, each with a short label so the output is readable (for example, `Code length: 9`):

- the total number of characters in the code
- the initials
- the visit number
- the priority letter

Each value must be calculated from `encounterCode` using String methods. Do not count the characters yourself and type the answers in by hand. At least one of the four must use `indexOf()` to locate a dash and work out the position from there, rather than you writing in a position number you counted.

**c.** The starter file already declares the unit name below, which arrives from another system with inconsistent spacing and capitalization:

```java
String rawUnitName = "   emergency  department   ";
```

Print it cleaned up so that it appears in the console exactly as `[EMERGENCY DEPARTMENT]` -- capitalized, with no spaces on either end and exactly one space between the two words. Include the square brackets in your output. They make it visible that no stray spaces are left. Read the raw value carefully before you start: `trim()` reaches only the two ends of a String, and the ends are not the only place this value has a problem.

**d.** After part (c), print `rawUnitName` one more time, again wrapped in square brackets. In a comment, state what this second line shows and explain what it tells you about how String methods behave in Java.

------

## Question 3 - Comparing What Someone Typed

**AI Usage**: **No AI use of any kind on this question.** This one is short, and the entire point is whether *you* can predict and explain the behavior. 

The starter file `Assignment2_Q3` asks for a **disposition** -- the decision about what happens to a patient, either `admit` (keep them at the hospital) or `discharge` (send them home) -- and then prints the result of three different comparisons against whatever was typed.

Your written answers for parts (a), (b), and (c) go in the comment block at the top of the file.

**a.** **Before running anything**, predict what each of the three `println` statements prints when the user types `admit`, in lower case. Write all three predictions in block **(a)**.

**b.** Run the program, type `admit`, and record the three lines of actual output in block **(b)**. Leave your predictions unchanged.

**c.** One of those three lines surprises most people. In block **(c)**, explain **why the first line printed what it did** -- what `==` actually compares when both sides are Strings, and why the answer came out that way even though every character matches.

**d.** Add one `System.out.println(...)` statement that prints `true` when the user typed **either** valid disposition -- `admit` or `discharge` -- in any capitalization and with any stray spaces around it, and `false` for anything else. So `admit`, `ADMIT`, `  Admit  `, and `  DISCHARGE  ` all print `true`, while `transfer` prints `false`. One statement on one line; you do not need an `if` for this, but you will need `||`.

------

## Question 4 - Assigning a Triage Level

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I check whether a number falls between two values in Java?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, pasting the table below, or asking it to write the branching logic.

An emergency department assigns each arriving patient a **triage level**, based on an **acuity score** between 0 and 100 that measures how urgently the patient needs care:

| Acuity score | Triage level |
|---|---|
| 90 to 100 | Level 1 - Immediate |
| 70 to 89 | Level 2 - Emergent |
| 40 to 69 | Level 3 - Urgent |
| 0 to 39 | Level 4 - Non-urgent |

**a.** In `Assignment2_Q4`, prompt for and read an acuity score as a whole number.

**b.** Before assigning a level, check whether the score is valid. A score below 0 or above 100 is invalid: print `Invalid acuity score` and do not print a triage level line at all. Your validity check must use the `||` operator.

**c.** For a valid score, use an `if` / `else if` / `else` statement to determine the triage level, then report it with a `printf` statement in this form:

```
Acuity score 72 maps to Level 2 - Emergent
```

Write the **Level 3** test as an explicit range using the `&&` operator, in the form `score >= ___ && score <= ___`, even though the structure of your branches might let you get away with a shorter condition. Part (d) will ask you to determine whether you got the boundaries right.

**d.** Run your program eight times, entering `-1`, `39`, `40`, `69`, `70`, `89`, `90`, and `101`. Record the output of each run in the comment block at the top of the file. These values sit on the boundaries -- between one level and the next, and between a valid score and an invalid one -- which is where branching logic almost always breaks. Note that six of the eight come in pairs straddling a single boundary: if the two values in a pair report the same level, one of them is in the wrong branch. If any of the eight surprised you, add a sentence about what you changed.

------

## Submission Guidelines

1. **Code**: Push all four Java files (under `student.assignments.A02`) to your fork's main branch.
2. **Comments**: Every question asks for written answers in comments. A program that runs correctly but is missing its predictions, recorded output, or explanations will not receive full credit.
3. **Due Date**: Friday, September 4, 2026 at 5:00 PM.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review and formatting.
