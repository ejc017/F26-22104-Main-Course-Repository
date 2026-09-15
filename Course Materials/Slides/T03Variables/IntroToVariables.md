---
title: Introduction to Variables
subtitle: INEG 22104 -- Computing Methods for Industrial Engineers I
date: "Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. https://claude.com/claude-code. Claude Code was used to draft, revise, and design these lecture slides."
---

## Before We Start

Consider a machine on a shop floor:

- Cycle time: `12.4` seconds
- Batch size: `250` units
- Passed inspection?: `yes` / `no`
- Operator ID: `OP-1042`

**What kind of information is each of these? How would you store each one in a program?**

## What Is a Variable?

A mechanism to store data (information) so a program can use it later.

Every variable in Java has two things:

- A **type** -- what kind of data it holds
- A **name** -- how you refer to it in code

## Quick Guess

Before we look at the formal list, guess the Java type for each value:

- `5`
- `0.36`
- `'a'`
- `"down"`
- `true`

(Hold your guesses -- we'll check them against the table on the next slide.)

## Common Variable Types

| Type | Declaration | Sample values | Notes |
|---|---|---|---|
| Integer | `int` | `-5`, `0`, `78`, `365` | Cannot contain decimals or characters |
| Float | `float` | `0.36f`, `1.2f`, `-578.333f` | Cannot contain characters; needs an `f` suffix |
| Double | `double` | `74.0`, `69.3`, `-0.7` | Cannot contain characters; default type for decimals |
| Character | `char` | `'a'`, `'4'`, `'='`, `'@'` | Exactly one character, single quotes `' '` |
| String | `String` | `"down"`, `"145a7w8"`, `"@Esa38"` | A sequence of characters, double quotes `" "` |
| Boolean | `boolean` | `true`, `false` | **Only** the literals `true`/`false` -- lowercase, no quotes |

Note for the shop-floor example: cycle time -> `double`, batch size -> `int`, passed inspection -> `boolean`, operator ID -> `String`.

## Careful: Boolean Is Not What You Think

- Java boolean literals are **only** `true` and `false` -- lowercase, no quotes.
- `1` and `0` do **not** work as booleans in Java (unlike some other languages).
- `True` and `False` (capitalized) do **not** work either -- that's Python, not Java.

```java
boolean flag = true;   // correct
boolean flag = 1;      // compile error
boolean flag = True;   // compile error
```

## Beyond `int` and `double`

Java has a few other numeric types you'll see in other people's code:

| Type | Size | Use case |
|---|---|---|
| `byte` | 8-bit | Very small numbers, memory-constrained arrays |
| `short` | 16-bit | Rarely used directly |
| `long` | 64-bit | Whole numbers larger than `int` can hold |

We'll stick mainly to `int`, `double`, `char`, `String`, and `boolean` in this course.

## Why So Many Numeric Types?

Each numeric type trades off **range** and **precision** against **memory**:

- `int` -- 32-bit signed integer: about &minus;2.1 billion to 2.1 billion, no decimals
- `float` -- 32-bit, single-precision decimal (less precise, smaller)
- `double` -- 64-bit, double-precision decimal (more precise, the default)

For an IE application: counts (batch size, defect count) are `int`; measurements (cycle time, weight, cost) are almost always `double`.

## Declaring Variables

The general syntax to declare a variable is:

```java
variable_type variable_name;
```

Example:

```java
int x;    // declaration of an integer type variable
char y;   // declaration of a char type variable
```

## Naming Rules

A variable name must:

- Start with a letter, `_`, or `$` (not a digit)
- Contain only letters, digits, `_`, `$` after that
- Not be a reserved word (`int`, `class`, `public`, ...)
- Be case-sensitive (`total` and `Total` are different variables)

**Convention:** Java uses `camelCase` for variable names -- e.g. `batchSize`, `cycleTime`.

## Spot the Illegal Name

Which of these are **legal** Java variable names? Which are good style?

- `1stPlace`
- `first place`
- `int`
- `firstPlace`
- `_temp`

## Initializing Variables

The general syntax to initialize a variable that has already been declared is:

```java
variable_name = value;
```

Example:

```java
x = 0;      // initialize the int x to 0
y = 'A';    // initialize char y to 'A'
```

Declaration of `x` and `y` is omitted above, but must happen before initialization.

## Declare and Initialize Together

Most of the time, declaration and initialization happen in a single line:

```java
String s = "Example Text";  // declare and initialize in one line
int batchSize = 250;
double cycleTime = 12.4;
```

## Why `float pi = 3.14f;` Needs the `f`

In Java, a plain decimal literal like `3.14` is treated as a `double` by default.

```java
float pi = 3.14;    // compile error: double cannot convert to float
float pi = 3.14f;   // correct: f marks this literal as a float
```

`double` doesn't need a suffix -- it's already the default for decimals.

## Constants

A **constant** variable cannot be changed after it is initialized. Declare one with the keyword `final`:

```java
final type variableName = value;
```

Convention: constant names are `ALL_CAPS_WITH_UNDERSCORES`.

## Constants: Why Bother?

```java
double area1 = 3.14159 * radius1 * radius1;
double area2 = 3.14159 * radius2 * radius2;
double area3 = 3.14159 * radius3 * radius3;
```

**What's fragile about this code? Where should a constant go?**

```java
final double PI_VALUE = 3.14159;

double area1 = PI_VALUE * radius1 * radius1;
```

## Assignment Operator

The `=` operator assigns a value to a declared variable -- hence "assignment operator."

```java
double length = 2.2;   // assignment operator used to initialize length
double width = 3.1;
double p;
p = 2 * width + 2 * length;  // assign result of an expression to p
```

**Important:** `=` is assignment, not mathematical equality -- a common early mistake.

## Showing What's Inside a Variable

Declaring a variable doesn't show you anything -- printing it does:

```java
double cycleTime = 12.4;
System.out.println("Cycle time: " + cycleTime);
```

```
Cycle time: 12.4
```

The `+` here joins ("concatenates") text and a variable's value into one `String`.

## Predict the Error

```java
public class Variables_Demo {
    public static void main(String[] args) {
        int b = 8;
        int a = b + 7;   // works -- b was initialized
        int c;
        int result = 19 + c;   // ???
    }
}
```

**What happens when this compiles? Predict before we run it.**

## The Actual Error

```
error: variable c might not have been initialized
        int result = 19 + c;
                          ^
```

Java requires every local variable to be initialized before it's used in an expression -- there is no automatic default value for local variables.

## Recap

- Every variable has a **type** and a **name**
- **Declare** first, then **initialize** (or do both in one line)
- Match the type to the data: counts -> `int`, measurements -> `double`, yes/no -> `boolean`, text -> `String`
- `final` marks a constant
- Uninitialized local variables are a compile error, not a silent default

## Practice

Open `IntroToVariables.java` to see each type demonstrated.

Then try `VariablesPractice.java` -- declare the six variables described in the TODO comments.
