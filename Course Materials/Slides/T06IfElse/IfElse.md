---
title: Branching with if-else
subtitle: INEG 22104 -- Computing Methods for Industrial Engineers I
date: "Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code. Claude Code was used to draft, revise, and design these lecture slides."
---

## Before We Start

Every program written so far has run every line, top to bottom, exactly once.

Now the inspector needs the program to **act** on what they typed:

- if they typed `pass`, add one to the passed count
- otherwise, add one to the failed count

**The program has to choose which line to run. How does it decide?**

## if-else Statements

- An `if-else` statement uses a logical expression to decide whether a block of code is executed
- Read one as: **if a condition is true, scenario A takes place; if the condition is false, scenario B executes**
- Each path the program can take is called a **branch**
- Branches depend on input from the user or on the result of an expression evaluated in the program

## The Inspection Scenario

- if the result is `pass`, increase the passed counter
- otherwise, increase the failed counter

Two distinct outcomes, so two branches. **Only one of them executes.**

## The Scenario in Code

```java
// one counter per outcome, each initialized to zero
int passCount = 0;
int failCount = 0;

String inspectionResult = "pass";

if (inspectionResult.equals("pass")) {   // first branch: the part passed
    passCount += 1;
}
else {                                   // second branch: anything else
    failCount += 1;
}
```

Note the `equals()` from last topic -- comparing these Strings with `==` would be a bug.

## Anatomy of an if-else

- The branch taken when the condition is true begins with the `if` keyword
- The branch taken when it is false begins with the `else` keyword
- Code in the `else` block executes when the `if` condition returns `false`
- Braces `{` and `}` mark the start and end of each block

This is the standard shape when a scenario has exactly two outcomes.

## Only One Part?

This example is easy to predict because only **one** part is considered.

An if-else statement becomes far more powerful with hundreds of parts to classify -- which needs the ability to iterate through many values.

Loops and arrays come later this semester. Branching comes first.

## Trap: Missing Braces

Every `if` and `else` block needs a left `{` **and** a right `}`.

```java
if (defectCount > 5) {
    System.out.println("scrap");
else
    System.out.println("keep");
}
```

```
error: 'else' without 'if'
```

The `if` block is opened but never closed, so by the time the compiler reaches `else`, there is no open `if` for it to attach to.

## Logical Operators

| Operator | Description | Example (assume x is 5) |
|---|---|---|
| `==` | `a == b` means a is equal to b | `x == 5` is true, `x == 20` is false |
| `!=` | `a != b` means a is not equal to b | `x != 5` is false, `x != 4` is true |
| `>` | `a > b` means a is greater than b | `x > 4` is true, `x > 5` is false |
| `<` | `a < b` means a is less than b | `x < 20` is true, `x < 1` is false |

## Logical Operators, continued

| Operator | Description | Example (assume x is 5) |
|---|---|---|
| `>=` | a is greater than or equal to b | `x >= 5` is true, `x >= 10` is false |
| `<=` | a is less than or equal to b | `x <= 16` is true, `x <= 2` is false |
| `&&` | condition 1 AND condition 2 are both true | `x == 5 && x > 0` is true |
| <code>&#124;&#124;</code> | condition 1 OR condition 2 (or both) are true | <code>x == 5 &#124;&#124; x == 0</code> is true |
| `!` | reverses a condition | `!(x == 5)` is false |

## Adding a Third Branch

A part is no longer just pass or fail. Now it is one of three dispositions: **pass**, **rework**, or **scrap**.

To add a third branch, add a block with the keywords `else if`.

## Three Branches in Code

```java
String disposition = "rework";

if (disposition.equals("pass")) {          // first branch
    passCount += 1;
}
else if (disposition.equals("rework")) {   // second branch
    reworkCount += 1;
}
else {                                     // third branch: anything else
    scrapCount += 1;
}
```

## How else if Behaves

- Additional `else if` blocks can be added to account for any number of outcomes
- Each `if` or `else if` must include a logical condition
- The `else` block executes only if **every** `if` and `else if` condition evaluated to false

## Detecting a Range

Dispositions usually come from a measurement, not a typed word:

- `0` defects, the part passes
- `1` to `4` defects, the part is reworked
- `5` or more, the part is scrapped

The middle case is a **range**, and a range needs **two** comparisons.

## Ranges in Code

```java
if (defectCount == 0) {
    System.out.println("Disposition: pass");
}
else if (defectCount >= 1 && defectCount <= 4) {
    System.out.println("Disposition: rework");
}
else {
    System.out.println("Disposition: scrap");
}
```

`&&` requires **both** sides to be true, which is exactly what "between 1 and 4" means.

## Trap: Java Has No Chained Comparison

This looks reasonable, and it does not compile:

```java
if (0 <= defectCount <= 4) {
```

```
error: bad operand types for binary operator '<='
  first type:  boolean
  second type: int
```

`0 <= defectCount` produces a **boolean**, and a boolean cannot be compared to the `int` 4. Build ranges with `&&`.

## The NOT Operator

`!` reverses a condition, turning true into false and false into true.

```java
if (!inspectionResult.equals("pass")) {
    System.out.println("Part did not pass; routing to review");
}
```

Read it as "**not** a pass." Useful when the interesting case is the one that fails the test.

## Short-Circuit Evaluation

`&&` stops as soon as its left side is false -- the right side is never evaluated.

```java
if (partsInspected != 0 && defectsFound / partsInspected > 2) {
```

If `partsInspected` is 0, the division on the right **never runs**. Without that guard, this is a divide-by-zero runtime error.

Order matters: put the guard on the left.

## Trap: = Is Not ==

```java
boolean batchPassed = false;

if (batchPassed = true) {
    System.out.println("branch taken");
}
```

**Predict the output.**

## Trap: = Is Not == (Answer)

```
branch taken
batchPassed is now true
```

`=` **assigns**, `==` **compares**. The condition assigned `true` to `batchPassed`, then used that value, so the branch runs every time -- and the variable was silently changed.

This compiles without an error. The comparison meant here is `batchPassed == true`.

## Trap: The Stray Semicolon

```java
int defectCount = 0;

if (defectCount > 5);
{
    System.out.println("scrapped a part with 0 defects");
}
```

**Predict the output.**

## Trap: The Stray Semicolon (Answer)

```
scrapped a part with 0 defects
```

The semicolon ends the `if` statement immediately. The block that follows is no longer attached to the condition, so it runs unconditionally.

## Nested if-else Statements

Implementations often call for multiple logical conditions to be evaluated before an outcome is determined.

A **nested** if-else statement is an if-else statement evaluated inside a separate if-else statement.

## Tax Rate Example

A tool takes a state of residence and an income level, then reports the tax rate.

| State | Income | Tax Rate |
|---|---|---|
| WI | > $200,000 | 50% |
| WI | [$75,000, $200,000] | 35% |
| WI | < $75,000 | 25% |
| NC | > $200,000 | 45% |
| NC | [$75,000, $200,000] | 30% |
| NC | < $75,000 | 20% |
| NV | > $200,000 | 42.5% |
| NV | [$75,000, $200,000] | 32.5% |
| NV | < $75,000 | 17.5% |

## The Outer Branch: Which State?

```java
if (stateInput.equals("WI")) {
    ...
}
else if (stateInput.equals("NC")) {
    ...
}
else if (stateInput.equals("NV")) {
    ...
}
else {
    System.out.println("Invalid State Entered");
}
```

Three states, plus an `else` for anything that isn't one of them.

## The Nested Branch: Which Bracket?

Inside each state's block sits a second if-else structure for the income brackets:

```java
if (stateInput.equals("WI")) {
    if (income > 200000) {
        taxRate = .5;
    }
    else if (income >= 75000) {
        taxRate = .35;
    }
    else {
        taxRate = .25;
    }
}
```

An outer structure for the three states, and a nested structure inside each one for the three brackets.

## Recap

- An if-else statement creates **branches** -- different paths a program can take
- Only one branch of an if-else statement executes
- `else` runs when the `if` condition is false; `else if` adds as many outcomes as needed
- Ranges need two comparisons joined with `&&` -- Java has no chained comparison
- `&&` short-circuits, which makes it useful as a guard
- Compare Strings inside a condition with `equals()`, never with `==`
- Watch for the three silent bugs: a missing brace, `=` in place of `==`, and a stray semicolon

## Practice

Open `SingleIfElse.java` and `IfElseIfElse.java` and change `inspectionResult` and `disposition` to make a different branch run each time.

Then `DetectingRanges.java` -- change `defectCount` to 0, 3, and 9 and confirm each disposition.

Run `BranchingTraps.java` and explain both lines of wrong output. Then uncomment traps 3 and 4 to see the two compiler errors.

Finish with `NestedIfElse.java`, including a state that is not WI, NC, or NV.
