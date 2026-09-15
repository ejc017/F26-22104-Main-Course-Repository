# Branching with if-else

[Slides for this topic](../../Slides/T06IfElse/IfElse.html)

## Introduction

If-else statements use logical expressions to decide whether a block of code is executed or not. These conditional statements can often be thought of as: "if a condition is true, then scenario A will take place; if the condition is false, then scenario B will execute."

Every program written so far has executed every line, top to bottom, exactly once. The inspection program from the previous chapters could read an operator's answer and clean it up, but it could not yet *act* on it. This chapter introduces the ability to choose. The sections below cover simple if-else statements, the operators used to construct logical conditions, detecting ranges of values, several errors that are easy to make and hard to see, and nested if-else statements.

## Basic Concepts

The use of if-else statements allows for the creation of **branches** within a computer program. Branches represent different paths that a program can take depending on input from the user or the result of an expression evaluated in the program.

Consider the inspector's answer from the previous chapter. If the part passed, a passed counter should increase; otherwise a failed counter should increase. The logic is:

- if the result is `pass`, increase the passed counter
- otherwise, increase the failed counter

The scenario has two, and only two, distinct outcomes (branches). Only one of the branches will execute:

```java
// one counter per outcome, each initialized to zero
int passCount = 0;
int failCount = 0;

String inspectionResult = "pass";

if (inspectionResult.equals("pass")) {   // first branch: the part passed
    passCount += 1;                      // increase passCount by 1
}
else {                                   // second branch: anything else
    failCount += 1;                      // increase failCount by 1
}
```

The branch executed when the result is a pass begins with the `if` keyword, and the branch executed otherwise begins with the `else` keyword. Code in the `else` block executes when the condition in the `if` statement returns `false`. This is the most common implementation when the scenario being modeled has two outcomes.

Note that the two Strings are compared with the `equals()` method from the previous chapter rather than with `==`. That distinction applies inside an if-else condition exactly as it did everywhere else: `==` compares whether two variables refer to the same object, not whether they hold the same characters. A condition written as `inspectionResult == "pass"` will compile and will quietly give the wrong answer.

It is worth noting that this example is easy to predict because only one part is considered. The if-else statement becomes far more powerful when there are hundreds of parts to classify, which requires the ability to iterate through many values. Loops and arrays are studied later in the semester and offer exactly that.

### Common Error: Missing Braces

A common error when implementing if-else statements is the misplacement or omission of one or both braces (`{` or `}`). Consider the following:

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

The `if` block is opened but never closed, so by the time the compiler reaches `else`, there is no open `if` statement for it to attach to. In general, a left (open) and a right (close) brace are needed for each `if` and `else` block in an if-else statement.

## Logical Operators

If-else statements consist of logical expressions that determine which block of code is executed. Logical conditions are composed with the logical operators available in Java. The following table summarizes the most frequently used ones.

| Operator | Description | Example (assume `x` is 5) |
|---|---|---|
| `==` | `a == b` means a is equal to b | `x == 5` is true; `x == 20` is false |
| `!=` | `a != b` means a is not equal to b | `x != 5` is false; `x != 4` is true |
| `>` | `a > b` means a is greater than b | `x > 4` is true; `x > 5` is false |
| `<` | `a < b` means a is less than b | `x < 20` is true; `x < 1` is false |
| `>=` | `a >= b` means a is greater than or equal to b | `x >= 5` is true; `x >= 10` is false |
| `<=` | `a <= b` means a is less than or equal to b | `x <= 16` is true; `x <= 2` is false |
| `&&` | condition 1 AND condition 2 are both true | `x == 5 && x > 0` is true; `x == 5 && x < 0` is false |
| `\|\|` | condition 1 OR condition 2 (or both) are true | `x == 5 \|\| x == 0` is true; `x <= 2 \|\| x == 0` is false |
| `!` | reverses a condition | `!(x == 5)` is false; `!(x == 20)` is true |

## Additional Outcomes in if-else Statements

Returning to the inspection example, a part is rarely just passed or failed. A more realistic process assigns one of three dispositions: **pass**, **rework**, or **scrap**. The disposition is now one of three outcomes. To add a third branch, add a third block to the if-else statement using the keywords `else if`.

```java
// a third outcome means a third counter
int passCount = 0;
int reworkCount = 0;
int scrapCount = 0;

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

Additional `else if` blocks can be added to account for any number of outcomes. Each `if` or `else if` statement must include a logical condition. The `else` portion of the implementation executes only if all of the `if` and `else if` conditions evaluate to false.

## Detecting Ranges

In practice, a disposition is usually derived from a measurement rather than a typed word. Suppose the rule is:

- 0 defects: the part passes
- 1 to 4 defects: the part is sent for rework
- 5 or more defects: the part is scrapped

The middle case is a **range**, and a range cannot be tested with a single comparison. It requires two comparisons joined with `&&`, which is true only when both of its sides are true:

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

The condition `defectCount >= 1 && defectCount <= 4` is precisely the statement "between 1 and 4, inclusive."

### Java Has No Chained Comparison

Mathematical notation allows a range to be written as a single chained expression, and it is natural to try the same thing in Java:

```java
if (0 <= defectCount <= 4) {
```

This does not compile:

```
error: bad operand types for binary operator '<='
  first type:  boolean
  second type: int
```

The error message explains the problem precisely. Java evaluates `0 <= defectCount` first, which produces a `boolean`. It then tries to compare that `boolean` to the `int` 4, and there is no meaningful way to do so. Ranges must be built with `&&`.

### The NOT Operator

The `!` operator reverses a condition, turning true into false and false into true. It is most useful when the interesting case is the one that fails a test:

```java
if (!inspectionResult.equals("pass")) {
    System.out.println("Part did not pass; routing to review");
}
```

The condition reads as "not a pass."

### Short-Circuit Evaluation

When Java evaluates an `&&`, it stops as soon as the left side turns out to be false, because no value on the right could make the whole expression true. The right side is never evaluated at all. This behavior is called **short-circuit evaluation**, and it can be used deliberately as a guard:

```java
if (partsInspected != 0 && defectsFound / partsInspected > 2) {
    System.out.println("Defect rate above threshold");
}
```

If `partsInspected` is 0, the left side is false, and the division on the right never runs. Without that guard, this line would produce a divide-by-zero runtime error -- the same error introduced back in the chapter on error types. The order of the two conditions is what makes the guard work; reversing them would divide first and crash before the check could help.

## Two Silent Bugs

The missing-brace error above at least stops the compiler. The two mistakes in this section are more dangerous, because the code compiles and runs while doing the wrong thing.

### = Is Not ==

A single character separates assignment from comparison:

```java
boolean batchPassed = false;

if (batchPassed = true) {
    System.out.println("branch taken");
}
System.out.println("batchPassed is now " + batchPassed);
```

```
branch taken
batchPassed is now true
```

The `if` condition used `=`, which **assigns**. It stored `true` in `batchPassed`, then used that stored value as the condition -- so the branch runs every time, and the variable has been silently changed along the way. The comparison intended here is `batchPassed == true`.

### The Stray Semicolon

A semicolon immediately after the condition ends the `if` statement then and there:

```java
int defectCount = 0;

if (defectCount > 5);
{
    System.out.println("scrapped a part with 0 defects");
}
```

```
scrapped a part with 0 defects
```

The block in braces is no longer attached to the `if` at all. It is simply the next thing the program does, so it runs unconditionally. A part with zero defects was scrapped, and nothing in the output suggests why.

## Nested if-else Statements

Implementations often call for multiple logical conditions to be evaluated before an outcome is determined. In this situation, developers can make use of **nested** if-else statements. A nested if-else statement is an if-else statement that is evaluated within a separate if-else statement.

Consider a tool that allows a user to specify a state of residence and an income level. The program uses these two inputs to determine a tax rate and outputs the appropriate value to the screen, using the rules in the following table.

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

```java
Scanner scnr = new Scanner(System.in);
String stateInput;
int income;

System.out.println("Enter State (WI, NC or NV)");
stateInput = scnr.nextLine();
System.out.println("Enter Income");
income = scnr.nextInt();

double taxRate = 0;

// OUTER if-else: which state was entered
if (stateInput.equals("WI")) {
    // NESTED if-else: which income bracket the income falls into
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
else if (stateInput.equals("NC")) {
    if (income > 200000) {
        taxRate = .45;
    }
    else if (income >= 75000) {
        taxRate = .30;
    }
    else {
        taxRate = .20;
    }
}
else if (stateInput.equals("NV")) {
    if (income > 200000) {
        taxRate = .425;
    }
    else if (income >= 75000) {
        taxRate = .325;
    }
    else {
        taxRate = .175;
    }
}
else {
    System.out.println("Invalid State Entered");
}

// taxRate is still 0 for a state that matched none of the branches above,
// so the summary is only printed for a recognized state.
if (stateInput.equals("WI") || stateInput.equals("NC") || stateInput.equals("NV")) {
    System.out.println("Tax rate for " + stateInput + " with income " + income + ": " + taxRate);
}
```

Notice that there is an outer if-else structure corresponding to the three state options. Within each code block of the state if-else structure is a nested if-else statement modeling the three income brackets. Notice also the final `if` statement: because an unrecognized state leaves `taxRate` at 0, printing the summary unconditionally would report a tax rate of 0.0 for a state that was never valid in the first place.

## Check Your Understanding

1. In an if-else statement with an `if`, two `else if` blocks, and an `else`, how many branches execute when the program runs?
2. Under what circumstances does the `else` block execute?
3. Why is `inspectionResult.equals("pass")` used in the condition instead of `inspectionResult == "pass"`?
4. Write the condition that is true when `defectCount` is between 10 and 20, inclusive.
5. Why does `if (0 <= defectCount <= 4)` fail to compile? Explain what the two operand types in the error message refer to.
6. What is printed by the code below, and why is it the wrong answer?
   ```java
   boolean batchPassed = false;
   if (batchPassed = true) {
       System.out.println("passed");
   }
   ```
7. In the guard `partsInspected != 0 && defectsFound / partsInspected > 2`, what would happen if the two conditions were written in the opposite order?
8. In the tax rate example, which branch executes for a WI resident with an income of exactly $200,000, and why?

## Practice

Open `SingleIfElse.java` and `IfElseIfElse.java`, and change `inspectionResult` and `disposition` to confirm that a different branch executes each time.

In `DetectingRanges.java`, change `defectCount` to 0, 3, and 9 and confirm that each disposition is reported correctly.

Run `BranchingTraps.java` and make sure you can explain both lines of wrong output. Then uncomment traps 3 and 4 to see the two compiler errors for yourself.

Finish with `NestedIfElse.java`, running it with several combinations of state and income, including a state that is not WI, NC, or NV.

Two exercises to write yourself:

1. Read an `int` from the user and output whether the value entered is an even or an odd number.
2. Extend the disposition rules in `DetectingRanges.java` so that a part with more than 20 defects is reported as `Disposition: reject supplier lot` rather than `scrap`.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
