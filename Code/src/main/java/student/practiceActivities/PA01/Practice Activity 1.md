# Practice Activity 1 - Strings

## INEG 22104 Computing Methods for INEG I | Fall 2026 | In-Class Practice, ~30 Minutes

This is practice, not a graded assignment. There is nothing to submit and no due date. It exists so that the String work on Assignment 2 is your second pass at these ideas instead of your first.

All three starter files live in the `instructor.practiceActivities.PA01` package. Copy the **entire `PA01` package** across in one step: right-click `instructor.practiceActivities.PA01`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.practiceActivities`. Do all of your work in your copy, and leave the `instructor` version alone.

Work through the questions in order. Question 1 and Question 3 both ask you to **write a prediction before you run anything**. Write it, then leave it alone. Being wrong and then understanding why is the entire point of the exercise -- a prediction you quietly edit after seeing the output teaches you nothing.

**AI use**:  The person sitting next to you is a better first resource than a chat window for this.

### What You May Use

- **String methods**: `length()`, `charAt()`, `indexOf()`, `contains()`, `isEmpty()`, `substring()`, `toUpperCase()`, `toLowerCase()`, `trim()`, `replace()`, `concat()`, `equals()`, `equalsIgnoreCase()`
- **Output**: `print()`, `println()`
- **Operators**: `+`, `==`, `-`

You will not need `if` / `else` anywhere in this activity, and you should not use `switch`, `compareTo()`, `split()`, loops, or arrays.

## Question 1 - What a String Method Gives Back

Open `PracticeActivity1_Q1_Practice`. It declares a String with stray spaces around it, then calls a series of String methods on it and prints the result of each one. Every printed line is wrapped in square brackets so that leftover spaces are visible.

**a.** **Before running anything**, read the code and predict all six output lines. Write them in block **(a)** at the top of the file, brackets and all.

**b.** Run the program and record the six actual lines in block **(b)**. Leave your prediction unchanged.

**c.** The code just above output lines 5 and 6 calls `concat(" A")` both times, and yet the two lines print different things. In block **(c)**, explain why in a sentence or two.

**d.** Add one `println` that prints `rawEntry` with **every** space removed, wrapped in square brackets, so the console shows:

```
[Line7]
```

Do not change the declaration of `rawEntry` to do this. `trim()` alone will not get you there -- think about which method removes characters from anywhere in a String, not just off the ends.

------

## Question 2 - Pulling Pieces Out of a Line of Text

Open `PracticeActivity1_Q2_Practice`. It holds one line from a maintenance log:

```java
String logEntry = "Press 12 cleared inspection";
```

Each part below is one or two statements. Give every printed value a short label so your output is readable, for example `Length: 27`.

**a.** Print how many characters are in `logEntry`.

**b.** Print the first character of `logEntry`, then the last character. Get the last one from `length()` rather than from a position you counted by hand -- your code should still find the right character if the log entry changes.

**c.** Print the index where the word `cleared` begins.

**d.** Two prints here, both starting from the value `indexOf` gave you in part (c). Do not type in a number you counted yourself.

First, everything from `cleared` to the end of the line:

```
cleared inspection
```

Then the word `cleared` on its own, with nothing after it:

```
cleared
```

The second one needs the **two-argument** form of `substring`, which stops *before* the index you give it. You can find that second index with `indexOf` as well -- there is more than one thing in this line you can search for.

**e.** Print whether `logEntry` contains the word `scrapped`.

**f.** The file also declares `operatorNote`, which the technician left blank. Print whether `operatorNote` is empty, then print whether `logEntry` is empty.

**g.** At the bottom of the file is a commented-out line that asks for the character at index `length()`. Predict what will happen, then uncomment it and run. Record the name of the error in a comment, and explain in a few words why the last character is not at `length()`. Put the `//` back when you are done, so the file is left in a runnable state.

------

## Question 3 - Why `==` Lies About Text

Open `PracticeActivity1_Q3_Practice`. It asks for a disposition code, then asks for it a second time to confirm -- the way a signup form makes you type a password twice -- and compares the two entries.

**a.** **Before running anything**, predict all three output lines, assuming you type `SHIP` in capital letters at **both** prompts. Write them in block **(a)**.

**b.** Run the program, typing `SHIP` at both prompts, and record the three actual lines in block **(b)**. Leave your predictions unchanged.

**c.** Line 1 compares two entries that you typed identically, and reports one answer. Line 3 compares two Strings written directly into the code, also identical, and reports the opposite. In block **(c)**, explain what `==` is actually comparing, and why that makes it the wrong tool for comparing text.

**d.** Add one `println` that prints `true` when `firstEntry` is the code `SHIP` in **any** capitalization -- `SHIP`, `ship`, `ShIp` -- and `false` otherwise. One statement, no `if` needed.

**e.** Run the program two more times: once typing `ship` at both prompts, and once typing `ship` and then `hold`. Record both sets of output in a comment at the bottom of the file, and check that your statement from (d) behaved the way you expected.

------

## If You Finish Early

Try these in whichever file you like. Predict each answer before you run it.

1. What does `"Press 12".indexOf("z")` return, and what does that tell you about how `indexOf` reports a word it cannot find?
2. `logEntry.substring(6, 8)` and `logEntry.charAt(6)` both reach into the same neighborhood of the String. Print both. Why is one of them a `String` and the other a `char`, and where does each one stop?
3. `trim()` removes spaces from the ends of a String. What does it do to a String that is nothing but spaces? Predict, then check with `isEmpty()`.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this practice activity, including content review and formatting.
