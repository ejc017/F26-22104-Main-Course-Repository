# Keyboard Input and Console Output

[Slides for this topic](../../Slides/T04KeyboardInputConsoleOutput/KeyboardInputConsoleOutput.html)

## Introduction

A quality inspector needs your program to collect three things during a shift: their operator ID (a `String`), how many parts they inspected (an `int`), and whether the batch passed (a `boolean`). We already know how to store these values in variables -- but a program is not useful if it can only work with values the developer hard-codes ahead of time. It needs a way to **get** information from the person using it.

A program can retrieve information from several sources: a keyboard, an input file (`.csv`, `.dat`, `.txt`), a database, or a user interface. In cases where only a small amount of information is needed, direct input from a keyboard is a simple approach for data entry. This chapter introduces the `Scanner` object for that purpose. Output works the same way in reverse -- a program can display information to a development environment console, an output file, a database, or a user interface. This chapter covers formatting and displaying information to the console; file input/output, user interfaces, and databases are covered in later chapters.

## Keyboard Input via the Scanner Object

### A New Kind of Statement: import

Later chapters introduce the idea of a Java class and Java object in detail. For now, it is enough to think of a Java object as a programming entity with attributes and capabilities. Sometimes you will create your own objects; other times, like today, you will use objects that other Java developers have already written and made available through libraries.

`Scanner` is one such object, and it lives in a Java package called `java.util` -- not in your file by default. To use it, you have to tell Java where to find it with an `import` statement at the very top of your file, before the `public class` line:

```java
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        ...
```

### Declaring and Initializing a Scanner Object

Unlike declaring a primitive variable (`int`, `char`, `double`), creating an object requires the `new` keyword. The general syntax for declaring and initializing a `Scanner` is:

```java
Scanner name_of_Scanner_object = new Scanner(Scanner_source);
```

As with primitive variables, the name of the `Scanner` is chosen by the developer. `Scanner_source` specifies where the input comes from. To read from the keyboard, the source is `System.in`:

```java
Scanner scnr = new Scanner(System.in);
```

### Reading Input

A `Scanner` object has several built-in capabilities, which in Java are called **methods**. A method is invoked (called to action) with the following syntax:

```java
object_name.method_name();
```

`object_name` is the name you gave your `Scanner`. `method_name` is one of the capabilities that comes with the `Scanner` class. The following is a list of common `Scanner` methods:

- `next()`: returns the next token as a `String`
- `nextInt()`: returns the next token as an `int`
- `nextDouble()`: returns the next token as a `double`
- `nextFloat()`: returns the next token as a `float`
- `nextBoolean()`: returns the next token as a `boolean`
- `nextLine()`: returns the rest of the current line, as a `String`

`next()` and the `nextX()` methods stop reading at the next whitespace (a space or a newline). `nextLine()` is different -- it reads everything up to the next newline character, including spaces.

A complete example of reading a line of text from the keyboard:

```java
Scanner scnr = new Scanner(System.in);   // defining the scanner
String exampleText;                      // stores the line of text read from the user

exampleText = scnr.nextLine();           // reads up to the newline character

scnr.close();
```

Always close a `Scanner` once you are done reading input, by calling `scnr.close()`.

### Reading Multiple Values on One Line

You are not limited to one value per `Scanner` call per line. If a user types several values separated by spaces on the same line, each `Scanner` method call reads the next token in order:

```java
// user types: 250 true
int batchSize = scnr.nextInt();      // reads 250
boolean passed = scnr.nextBoolean(); // reads true
```

Each call picks up exactly where the previous one left off.

### The nextInt() + nextLine() Trap

`nextInt()` (and the other `nextX()` methods) stop reading as soon as they find the value they need -- they do **not** consume the newline character left behind when the user presses Enter. If you call `nextLine()` immediately after `nextInt()`, that call reads the leftover, empty newline instead of waiting for the user to type a new line:

```java
int batchSize = scnr.nextInt();   // user types: 250 [enter]
String note = scnr.nextLine();    // reads the LEFTOVER newline -- an empty string!
```

The program will appear to skip your input entirely. This is one of the most common `Scanner` bugs. The fix is to consume the leftover newline with an extra `scnr.nextLine();` call before reading the next real line of input.

### When Types Don't Match

The most common error when gathering keyboard input is the user providing data that isn't the type being asked for. Consider reading a boolean:

```java
boolean passed = scnr.nextBoolean();
```

If the user types `true`, `false`, `1`, or `0`, this works without issue. But if the user types something else -- say, `3.5` -- the program stops immediately with a **runtime error**, the same general category of error as the divide-by-zero example from earlier this semester: something that only shows up once the program is actually running, rather than at compile time.

## Console Output

### print vs println

A quick and simple way to display output is the console. In IntelliJ, output appears in the Run window, typically in the lower-left portion of the IDE (use **View > Tool Windows > Run** if it isn't visible). Displaying information to the screen is done with one of the following:

```java
System.out.print(info_to_display);
System.out.println(info_to_display);
```

The only difference is that `println` adds a newline character after the output, and `print` does not. For example:

```java
System.out.print("Computing");
System.out.print("Methods");
```

prints `ComputingMethods` on a single line, with no space or break between the two calls, while the same two calls using `println` would print each word on its own line.

### Formatting Output with printf

The `printf` method works like `print`, but gives you control over exactly how information is displayed. The general syntax is:

```java
System.out.printf("%conversion_character", output);
```

The format is controlled by the conversion character associated with the type of information being displayed. The three conversion characters used in this course are:

- `s`: formats `String` values
- `d`: formats `int` values
- `f`: formats floating-point (`float` or `double`) values

Additional resource information on the use of `printf` can be found [here](https://www.baeldung.com/java-printstream-printf).

#### Formatting Strings

A basic string is formatted as follows, with additional characters and spaces added before or after the `%s` conversion character as needed:

```java
System.out.printf("%s!", "Happy");
```

```
Happy!
```

`printf` does not add a newline automatically the way `println` does. Use `%n` in the format string to add one:

```java
System.out.printf("%s%n%s*", "Abraham", "Lincoln");
```

```
Abraham
Lincoln*
```

Two `String` arguments are supplied here, matching the two `%s` conversion characters in the format string.

#### Formatting Integers

Integer values are formatted with `%d`:

```java
int batchSize = 250;
System.out.printf("Batch size: %d%n", batchSize);
```

```
Batch size: 250
```

#### Formatting Floating-Point Numbers

To format a floating-point value with a fixed number of decimal places, use `%.Xf`, where `X` is the number of decimal places:

```java
System.out.printf("%.Xf", floating_point_value);
```

Values are **rounded**, not truncated, to fit the requested number of decimal places. For example:

```java
System.out.printf("%.3f", 8.79253);
```

```
8.793
```

## Check Your Understanding

1. Why does a Java file need `import java.util.Scanner;` at the top, when it doesn't need an import to use `int` or `String`?
2. What's the difference between what `next()` and `nextLine()` each read?
3. A program calls `scnr.nextInt()` and then immediately `scnr.nextLine()`. What does the second call actually read, and why?
4. Is a `Scanner` type mismatch (e.g. typing `3.5` when a `boolean` is expected) a compile-time error or a runtime error? How is that different from a missing semicolon?
5. What does `System.out.printf("%.2f", 3.14159)` print?

## Practice

Open `Output.java` and `Formatting.java` to see console output and `printf` in action.

Then try `ScannerDemo.java` -- run it, enter valid input, then run it again and break it on purpose.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
