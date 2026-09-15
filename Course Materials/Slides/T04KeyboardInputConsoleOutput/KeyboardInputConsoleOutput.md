---
title: Keyboard Input and Console Output
subtitle: INEG 22104 -- Computing Methods for Industrial Engineers I
date: "Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. https://claude.com/claude-code. Claude Code was used to draft, revise, and design these lecture slides."
---

## Before We Start

A quality inspector needs your program to collect three things during a shift:

- Their operator ID (`String`)
- How many parts they inspected (`int`)
- Whether the batch passed (`boolean`)

We know how to store these -- but how does a program actually **get** this information from a person typing at the keyboard?

## Where Does Input Come From?

A program can read data from several places:

- keyboard
- input file (`.csv`, `.dat`, `.txt`)
- database
- user interface

This lecture covers keyboard input using a `Scanner`, and basic console output.

## The Scanner Class

- `Scanner` is a Java object available through the libraries bundled with the JDK
- Capable of reading input from either the keyboard or a file
- Unlike `int`, `double`, or `boolean`, `Scanner` is not a primitive type -- it's an **object**

## A New Kind of Statement: import

`Scanner` lives in a Java package called `java.util`, not in your file by default.

To use it, tell Java where to find it with an `import` statement at the very top of your file:

```java
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        ...
```

## Declaring and Initializing a Scanner

Creating an object requires the `new` keyword:

```java
Scanner name_of_Scanner_object = new Scanner(Scanner_source);
```

`Scanner_source` specifies where input comes from.

For keyboard input:

```java
Scanner scnr = new Scanner(System.in);
```

## Calling a Method

`Scanner` objects have built-in capabilities called **methods**. You call (invoke) a method like this:

```java
object_name.method_name();
```

- `object_name` is the name you chose for your `Scanner`
- `method_name` is one of the capabilities that come with the `Scanner` class

## Scanner Methods

| Method | Returns |
|---|---|
| `next()` | next token as a `String` |
| `nextInt()` | next token as an `int` |
| `nextDouble()` | next token as a `double` |
| `nextFloat()` | next token as a `float` |
| `nextBoolean()` | next token as a `boolean` |
| `nextLine()` | rest of the current line, as a `String` |

`next()` and the `nextX()` methods stop at whitespace. `nextLine()` reads all the way to the end of the line.

## Demo: Reading a Line of Text

```java
Scanner scnr = new Scanner(System.in);   // defining the scanner
String exampleText;                      // stores the line of text read from the user

exampleText = scnr.nextLine();           // reads up to the newline character

scnr.close();
```

**Always close your `Scanner`** when you're done reading input, by calling `.close()`.

## Reading Multiple Values

You can type several values on one line, separated by spaces -- `Scanner` reads them one token at a time, in order:

```java
// user types: 250 true
int batchSize = scnr.nextInt();     // reads 250
boolean passed = scnr.nextBoolean(); // reads true
```

Each call to a `Scanner` method picks up wherever the last one left off.

## The nextInt() + nextLine() Trap

`nextInt()` stops right after the number -- it leaves the newline character behind unread.

```java
int batchSize = scnr.nextInt();   // user types: 250 [enter]
String note = scnr.nextLine();    // reads the LEFTOVER newline -- an empty string!
```

**The program looks like it skipped your input.** Fix: add an extra `scnr.nextLine();` to consume the leftover newline before reading the next real line.

## When Types Don't Match

If you ask for a type the user doesn't type, the program stops with a **runtime error** -- the same category of error as the divide-by-zero example from earlier this semester.

```java
boolean passed = scnr.nextBoolean();
// user types: 3.5   -- not true/false -- program crashes with a runtime error
```

## Predict the Crash

Open `ScannerDemo.java`. It reads a word, an integer, another word, then a boolean.

**What happens if you type `3.5` when it asks for the boolean value? Predict, then we'll run it live.**

## Displaying Output: print vs println

```java
System.out.println(info_to_display);
```

`println` prints the information, then adds a newline.

```java
System.out.print(info_to_display);
```

`print` prints the information with **no** newline added.

## Guess the Output

```java
System.out.print("Computing");
System.out.print("Methods");
```

versus

```java
System.out.println("Computing");
System.out.println("Methods");
```

**Predict what each pair prints before we run `Output.java`.**

## Formatting Output with printf

`printf` works like `print`, but lets you control exactly how information is displayed:

```java
System.out.printf("%conversion_character", output);
```

Three conversion characters we'll use:

| Character | Formats |
|---|---|
| `%s` | `String` values |
| `%d` | `int` values |
| `%f` | floating-point values (`float`/`double`) |

## printf: Formatting Strings

```java
System.out.printf("%s!", "Happy");
```

```
Happy!
```

Use `%n` inside a `printf` format string for a newline (instead of `\n`):

```java
System.out.printf("%s%n%s*", "Abraham", "Lincoln");
```

```
Abraham
Lincoln*
```

## printf: Formatting Integers

```java
int batchSize = 250;
System.out.printf("Batch size: %d%n", batchSize);
```

```
Batch size: 250
```

## printf: Formatting Floating-Point Numbers

```java
System.out.printf("%.Xf", floating_point_value);
```

`X` is the number of decimal places -- values are **rounded**, not truncated.

```java
System.out.printf("%.3f", 8.79253);
```

```
8.793
```

## Guess the Output

```java
int defectCount = 7;
double defectRate = 0.028;
System.out.printf("Defects: %d (%.1f%%)%n", defectCount, defectRate * 100);
```

**Predict the exact output before we run it.**

## Recap

- `Scanner` reads input from the keyboard (or a file) -- import it with `java.util.Scanner`
- `next()`/`nextInt()`/etc. stop at whitespace; `nextLine()` reads the whole line
- Mixing `nextInt()` and `nextLine()` can silently skip input -- watch for the leftover newline
- A type mismatch during input is a runtime error, same family as divide-by-zero
- `print` vs `println`: only `println` adds a newline
- `printf` formats output with `%s`, `%d`, and `%f`

## Practice

Open `Output.java` and `Formatting.java` to see console output and `printf` in action.

Then try `ScannerDemo.java` -- run it, enter valid input, then run it again and break it on purpose.
