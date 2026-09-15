# Introduction to Java, Comments, and Whitespace

[Slides: Introduction to Java](../../Slides/T02IntroToJava/IntroductionToJava.html) &middot; [Slides: Comments, Whitespace, and Errors](../../Slides/T02IntroToJava/Comments_Errors_Whitespace.html)

## What a Computer Program Does

Every computer program, no matter how complex, is built from the same three pieces: it takes **input** (from a keyboard, a text file, a database, or a user interface), it does some **processing** on that input (expressions, loops, branching, algorithms), and it produces **output** (to a console, a text file, a database, or a user interface). As you learn Java, it can help to ask of any piece of code: what is its input, what processing is it doing, and what output does it produce?

## Why Java

Java is an **object-oriented** language, and a large amount of engineering and scientific software -- including many third-party libraries you may use later in this course and in your career -- is written in it. Learning an object-oriented language like Java first also tends to make it easier to pick up other, more scripting-oriented languages later (Python, MATLAB, R), since many of the underlying concepts (variables, types, control flow) carry over directly.

## Anatomy of a Java Class

A Java source file has a `.java` extension, and it is commonly referred to as a **class file**, because its contents define a **class**. When you are starting out, the name of the file must match the name of the public class defined inside it -- a file named `FirstClass.java` must define `public class FirstClass`.

```java
public class FirstClass {

}
```

### Braces

The open and closed braces (`{` and `}`) mark the beginning and end of a programming construct -- a class, a method, a loop, and so on. A very common error, especially early on, is forgetting to close a brace that was opened. A useful habit: whenever you type an opening brace, immediately type its matching closing brace, then go back and fill in what belongs between them. If your code won't compile and the error is confusing, counting open braces against closed braces is often the fastest way to find the problem.

### The `main` Method

When a Java program runs, it starts by executing a method named `main`. For now, every class file you write will need a `main` method, and -- until we introduce custom methods and classes later in the course -- essentially all of your code will live inside it.

```java
public class FirstClass {

    public static void main(String[] args) {
        System.out.println("First Program Success");
    }
}
```

### Semicolons

In Java, a line of code ends with a semicolon (`;`). Leaving one off is one of the most common early compile errors, and the compiler's error message will point you to roughly where it expected one.

## Whitespace Doesn't Change What Your Code Does

Java almost entirely ignores whitespace -- blank lines, extra spaces, and indentation have no effect on how your program runs. That does not mean whitespace doesn't matter; it matters enormously for *you*, the person reading the code.

### Blank Lines

Blank lines inside a method have no effect on execution. Given the code below, there are exactly four statements that do anything (the four lines ending in a semicolon); the blank lines around them are invisible to the compiler.

```java
public static void main(String[] args) {

    int a = 1;

    int b = 2;

    int c = a + b;
    System.out.println(c);

}
```

Use blank lines the way you'd use paragraph breaks in writing: to visually separate one idea or section of code from the next. Overusing them, on the other hand, just makes code longer to scroll through without adding any clarity.

### Spacing Within a Line

The number of spaces between tokens on a single line also has no effect on execution. Both lines below compile and run identically:

```java
int x = 5;
int y  =   5;
```

By convention (and because most IDEs auto-format this way), use a single space around operators like `=`.

### Indentation

Indentation -- how far a line is shifted to the right -- has no impact on execution, but a large impact on readability. Code that is nested inside another block (inside a class, inside a method, inside a loop) should be indented to show that hierarchy. You've already seen a simple example of this: the `main` method's body is indented one level inside the class body. This convention becomes much more important once you start writing loops and conditionals, where several levels of nesting are common.

## Comments

A **comment** is text in your source file that the compiler ignores entirely -- it exists only for people reading the code. Comments are useful for explaining *why* code does something (not just *what* it does, which the code itself already shows), organizing a file into labeled sections, and leaving yourself `TODO` notes.

Java has two comment styles:

```java
// A single-line comment runs from // to the end of the line.

/*
A multi-line comment starts with /* and ends with the matching */
/* and can span as many lines as you need.
*/
```

## Understanding Errors

You will encounter errors constantly while learning to program -- that's normal, not a sign you're doing something wrong. What matters is recognizing which of three broad categories an error falls into, because each is diagnosed differently.

**Syntax errors** prevent your code from compiling at all. IntelliJ flags these as you type, typically with a red squiggly underline, and the compiler will refuse to run the program until they're fixed. Missing semicolons and mismatched braces are common syntax errors.

**Logic errors** let the code compile and run to completion, but the result is wrong because of a flaw in how you implemented it -- for example, using the wrong formula, or a loop that runs one too many or too few times. Java can't detect these for you, since as far as the compiler is concerned nothing is wrong; you have to catch them by checking your output against what you expected.

**Runtime errors** occur when code that compiles fine is asked, during execution, to do something Java does not allow -- and the program terminates prematurely as a result. A classic example is dividing an integer by zero:

```java
int a = 8;
int b = 0;
int c = a / b;   // compiles fine, but throws an exception when run
```

Running this produces an error along these lines:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

Learning to read messages like this one -- which exception was thrown, and on which line -- is a skill you'll rely on throughout the course.

## Check Your Understanding

1. What are the three things every computer program does, in terms of input, processing, and output?
2. Why must the file name and the public class name match in a Java file (for now)?
3. If your code won't compile because of a mismatched brace, what's a good strategy for finding the problem?
4. Does adding extra blank lines or spaces change what a Java program does? What *is* it useful for?
5. What's the difference between a single-line comment and a multi-line comment in Java?
6. Classify each of the following as a syntax, logic, or runtime error: (a) forgetting a semicolon, (b) a loop that runs one time too few, (c) dividing by zero.

## Practice

See `Whitespace_Empty_Lines.java` and `Whitespace_Empty_Spaces.java` for examples of formatting that has no effect on execution, `SyntaxErrors.java` for examples of syntax errors (commented out so the file compiles -- uncomment one at a time to see each error), and `RuntimeErrors.java` for a runtime error you can trigger by running the file as-is.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
