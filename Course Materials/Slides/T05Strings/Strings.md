---
title: Strings
subtitle: INEG 22104 -- Computing Methods for Industrial Engineers I
date: "Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code. Claude Code was used to draft, revise, and design these lecture slides."
---

## Before We Start

Last time you read an inspector's answers from the keyboard:

- Operator ID: `OP-1042`
- Part number: `AR-4471-B`
- Did the batch pass? `pass`

Now the plant wants more out of that text: **which facility made the part, what lot it came from, and whether the operator's answer counts as a pass -- even if they typed `PASS`.**

Storing the text isn't enough. Today we work with it.

## What Is a String?

- A `String` is a **sequence of characters**
- `"AR-4471-B"`, `"pass"`, `"z"`, and `""` are all Strings
- Double quotes make a `String`; single quotes make a `char`

```java
String revision = "B";   // a String, one character long
char revisionChar = 'B'; // a char
```

## String Is an Object, Not a Primitive

- `int`, `double`, `boolean`, `char` are **primitives** -- they hold a value and nothing else
- `String` is an **object**, built from the `String` class that ships with the JDK
- Objects come with **methods**: capabilities you reach with a dot

```java
int lotSize = 250;
lotSize.length();        // no such thing -- primitives have no methods

String partNumber = "AR-4471-B";
partNumber.length();     // 9
```

## Two Ways to Create a String

```java
String partNumberA = new String("AR-4471-B");   // like any other object
String partNumberB = "AR-4471-B";               // shorthand, Strings only
```

- Most objects require `new` -- remember `new Scanner(System.in)`
- `String` is one of the few that doesn't
- The second form is what nearly every developer writes
- No `import` needed -- unlike `Scanner`, `String` is always available

## Every Character Has an Index

| Index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|---|---|---|---|---|---|---|---|---|---|
| Character | `A` | `R` | `-` | `4` | `4` | `7` | `1` | `-` | `B` |

- Counting starts at **0**, not 1
- `length()` is 9, but the last index is **8**
- Almost every String bug you write this week traces back to this one fact

## length()

- Argument: none
- Returns: `int` -- the number of characters

```java
String partNumber = "AR-4471-B";
System.out.println(partNumber.length());   // 9
```

Dashes count. Spaces count. Everything between the quotes counts.

## charAt(int)

- Argument: `int` -- the index of the character you want
- Returns: `char`

```java
partNumber.charAt(0);                        // A
partNumber.charAt(partNumber.length() - 1);  // B  -- the revision letter
```

The last character is always at `length() - 1`.

## Quick Guess

```java
String operatorId = "OP-1042";
```

Predict each of these before we run them:

1. `operatorId.length()`
2. `operatorId.charAt(3)`
3. `operatorId.charAt(operatorId.length() - 1)`

## indexOf(String)

- Argument: `String` -- the text to look for
- Returns: `int` -- index of the first match, or `-1` if it never appears

```java
partNumber.indexOf("-");      // 2
partNumber.indexOf("4471");   // 3
partNumber.indexOf("Z");      // -1
```

`-1` is the "not found" answer. It is not an error.

## contains() and isEmpty()

```java
partNumber.contains("4471");   // true
partNumber.contains("Z");      // false

String operatorNote = "";
operatorNote.isEmpty();        // true  -- length() is 0
partNumber.isEmpty();          // false
```

Both return a `boolean`, so they read like the questions they answer.

## substring(int)

- Argument: `int` -- beginIndex
- Returns: `String`

```java
partNumber.substring(3);   // 4471-B
```

You get the character at `beginIndex` **and everything after it**. Everything before it is dropped.

## substring(int, int)

- Arguments: `int` beginIndex, `int` endIndex
- Returns: `String`

```java
partNumber.substring(0, 2);   // AR    -- the plant code
partNumber.substring(3, 7);   // 4471  -- the lot number
```

**It stops before `endIndex`.** The last character included sits at `endIndex - 1`.

## Guess the Output

```java
String partNumber = "AR-4471-B";

System.out.println(partNumber.substring(0, 2));
System.out.println(partNumber.substring(2, 3));
System.out.println(partNumber.substring(8));
```

**Predict all three lines, then we run `SlicingStrings.java`.**

## When an Index Doesn't Exist

```java
partNumber.charAt(9);         // length is 9, so index 9 is one past the end
partNumber.substring(3, 20);
```

```
StringIndexOutOfBoundsException: Index 9 out of bounds for length 9
StringIndexOutOfBoundsException: Range [3, 20) out of bounds for length 9
```

A **runtime error** -- the same family as divide-by-zero and the `Scanner` type mismatch. The code compiles perfectly.

## Strings Are Immutable

A `String` can never be changed after it is created.

Every method today **returns a new String** and leaves the original untouched.

```java
String entry = "  pass  ";
entry.trim();                 // returns "pass"
System.out.println(entry);    // still "  pass  "
```

The returned value is the whole point. Throw it away and nothing happened.

## Predict the Output

```java
String plant = "AR";

plant.concat("4471");
System.out.println(plant);

String lotTag = plant.concat("4471");
System.out.println(lotTag);
```

**What prints? Why do the two halves behave differently?**

## Changing Case

```java
"pass".toUpperCase();    // PASS
"PASS".toLowerCase();    // pass
```

Neither takes an argument. Both return a new `String`.

Useful whenever you can't control how the operator typed something.

## Trimming Whitespace

```java
String entry = "  pass  ";
System.out.println("[" + entry.trim() + "]");   // [pass]
```

`trim()` removes spaces, tabs, and newlines from **both ends** -- never from the middle.

Printing brackets around a value makes invisible spaces visible. Keep that trick for debugging.

## replace()

```java
String partNumber = "AR-4471-B";

System.out.println(partNumber.replace("-", ""));   // AR4471B
System.out.println(partNumber);                    // AR-4471-B
```

Replaces **every** match, not just the first -- and, as always, returns a new `String`.

## Chaining Methods

Each of these methods returns a `String`, so the next method can be called directly on that result:

```java
String cleaned = entry.trim().toUpperCase();   // PASS
```

Read it left to right: trim first, then uppercase whatever `trim()` handed back.

## Comparing Strings: The Trap

The operator typed `pass` at the keyboard. Is this `true` or `false`?

```java
response == "pass"
```

**Predict, then we run `EqualsTrap.java`.**

## The Answer

```
false
```

`==` asks whether two variables point at the **same object in memory** -- not whether they hold the same characters.

The answer typed at the keyboard is a different object from the `"pass"` written in your code, even though every character matches.

## It Gets Worse

```java
String a = "pass";
String b = "pass";
System.out.println(a == b);   // true
```

Same operator. Same characters. **Different answer.**

`==` on Strings is unpredictable. IntelliJ underlines it for you -- it knows this is almost always a bug.

## equals(String)

- Argument: `String`
- Returns: `boolean` -- `true` when both hold the same characters

```java
response.equals("pass");   // true, every time
```

**Compare Strings with `equals()`. Never with `==`.**

## equalsIgnoreCase(String)

```java
"PASS".equals("pass");             // false
"PASS".equalsIgnoreCase("pass");   // true
```

Case matters to `equals()`. When it shouldn't -- an operator typing `pass`, `PASS`, or `Pass` -- reach for `equalsIgnoreCase()`.

## Guess the Output

```java
String response = "  PASS  ";

System.out.println(response.equals("pass"));
System.out.println(response.trim().equals("pass"));
System.out.println(response.trim().equalsIgnoreCase("pass"));
```

**Predict all three. Two of them are `false` for different reasons.**

## Recap

- A `String` is a sequence of characters, and an **object** rather than a primitive
- Indexes start at `0`, so the last character is at `length() - 1`
- `substring(a, b)` stops **before** `b`
- A bad index is a runtime error: `StringIndexOutOfBoundsException`
- Strings are **immutable** -- methods return a new String and never change the original
- Compare with `equals()` or `equalsIgnoreCase()`, **never** with `==`

## Practice

Open `CreatingStrings.java`, `InspectingStrings.java`, and `SlicingStrings.java` to watch today's methods run.

Then `TransformingStrings.java` -- predict each line before you run it.

Finish with `EqualsTrap.java`: run it, type `pass`, and explain the first line of output to the person sitting next to you.
