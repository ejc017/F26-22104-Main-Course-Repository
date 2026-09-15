# INEG 22104: Quiz 2 – Topics and Sample Questions

## University of Arkansas - Fall 2026

------

## Purpose of This Document

**These sample questions are not the actual quiz.** They exist to show you the *type*, *format*, and *difficulty* of questions you can expect on Quiz 2. Studying the topics below and being able to answer questions like these is good preparation, but the real quiz will use different specific examples, values, and code snippets.

Quiz 2 is given in class, is completed in Blackboard, and is timed at approximately 10 minutes. It contains 8 questions, each either multiple choice or fill-in-the-answer.

------

## Topics Covered (T05–T06)

### T05 – Strings

- A `String` is a **sequence of characters**, and an **object** rather than a primitive — which is why it has methods and an `int` does not
- Indexes start at **0**, so the last character is always at `length() - 1`
- Inspecting a String: `length()`, `charAt(int)`, `indexOf(String)` (returns `-1` when not found), `contains(String)`, `isEmpty()`
- Extracting from a String: `substring(int)` and `substring(int, int)` — the two-argument form **stops before** `endIndex`
- An index that does not exist produces a **runtime error**: `StringIndexOutOfBoundsException`
- Strings are **immutable** — every method returns a *new* String and leaves the original unchanged, so the returned value must be stored to be useful
- Transforming a String: `toUpperCase()`, `toLowerCase()`, `trim()`, `replace(String, String)`, `concat(String)`, and chaining calls together
- Comparing Strings with `equals()` and `equalsIgnoreCase()` — **never** with `==`, which compares object identity rather than characters

### T06 – Branching with if-else

- An if-else statement creates **branches**; only one branch executes
- `else` runs when the `if` condition is false; `else if` adds as many outcomes as needed
- Logical operators: `==`, `!=`, `>`, `<`, `>=`, `<=`, `&&`, `||`, `!`
- Detecting a **range** requires two comparisons joined with `&&` — Java has no chained comparison
- **Short-circuit evaluation**: `&&` stops as soon as its left side is false, which makes it useful as a guard
- Comparing Strings inside a condition with `equals()`, not `==`
- Three errors that are easy to make and hard to see:
  - A **missing brace** — `error: 'else' without 'if'`
  - **`=` instead of `==`** — compiles, takes the branch every time, and silently changes the variable
  - A **stray semicolon** after the condition — detaches the block, which then runs unconditionally
- **Nested** if-else statements: an if-else evaluated inside another if-else

------

## Sample Questions

**1. [Multiple Choice] Fundamental Concepts**
```java
String batchId = "LOT-5580";
```
Which expression returns the **last character** of `batchId`?
A) `batchId.charAt(batchId.length())`
B) `batchId.charAt(batchId.length() - 1)`
C) `batchId.charAt(8)`
D) `batchId.length() - 1`

**2. [Fill-in-the-Answer] Predict the Output**
```java
String toolCode = "DRILL-22";
System.out.println(toolCode.indexOf("-"));
```
What does this code print?

**3. [Fill-in-the-Answer] Error Recognition**
```java
String shift = "DAY";
System.out.println(shift.charAt(3));
```
This code compiles without complaint, but the program terminates unexpectedly when it reaches the second line. What type of error is this?

**4. [Multiple Choice] Predict the Output**
```java
String gauge = "CAL-7719";
System.out.println(gauge.substring(4));
```
A) `7719`
B) `-7719`
C) `CAL-`
D) `771`

**5. [Multiple Choice] Predict the Output**
```java
int lineSpeed = 45;

if (lineSpeed < 35 || lineSpeed > 60) {
    System.out.println("Speed out of spec");
}
else {
    System.out.println("Speed in spec");
}
```
A) `Speed out of spec`
B) `Speed in spec`
C) Both lines print
D) Nothing prints

**6. [Fill-in-the-Answer] Fundamental Concepts**
Write the condition that is `true` exactly when the `int` variable `temperature` is between 150 and 200, **inclusive**.

**7. [Multiple Choice] Error Recognition**
```java
boolean lineRunning = false;

if (lineRunning = true) {
    System.out.println("Line is running");
}
```
What happens when this code runs?
A) Nothing prints, because `lineRunning` is `false`
B) `Line is running` prints, and `lineRunning` is changed to `true`
C) The code does not compile
D) The program terminates with a runtime error

**8. [Fill-in-the-Answer] Predict the Output**
```java
String material = "steel";
double thickness = 0.5;

if (material.equals("steel")) {
    if (thickness >= 1.0) {
        System.out.println("Steel: heavy gauge");
    }
    else {
        System.out.println("Steel: light gauge");
    }
}
else {
    System.out.println("Material not supported");
}
```
What does this code print?

------

## Answer Key

| # | Answer |
|---|--------|
| 1 | B – `batchId.charAt(batchId.length() - 1)` |
| 2 | `5` |
| 3 | Runtime error (`StringIndexOutOfBoundsException`) |
| 4 | A – `7719` |
| 5 | B – `Speed in spec` |
| 6 | `temperature >= 150 && temperature <= 200` |
| 7 | B – `Line is running` prints, and `lineRunning` is changed to `true` |
| 8 | `Steel: light gauge` |

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. <https://claude.com/claude-code>

Claude Code was used to draft the topic summary and sample questions in this document, and to verify the sample code snippets by compiling and running them.
