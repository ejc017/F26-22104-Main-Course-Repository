# Java Variables

[Slides for this topic](../../Slides/T03Variables/IntroToVariables.html)

## Introduction to Variables

Imagine a machine on a shop floor. It has a cycle time (`12.4` seconds), a batch size (`250` units), a pass/fail inspection result, and an operator ID (`OP-1042`). To write a program about that machine, you need a way to store each of those pieces of information -- that's what a **variable** is: a mechanism to store data (information) so a program can use it later.

In Java, every variable has a **type**, specified by the developer based on what kind of information is being stored, and a **name**, used to refer to it in code. The table below lists the most common types used in this course.

| Type | Declaration | Sample values | Notes |
|---|---|---|---|
| Integer | `int` | `-5`, `0`, `78`, `365` | Cannot contain decimals or characters |
| Float | `float` | `0.36f`, `1.2f`, `-578.333f` | Cannot contain characters; needs an `f` suffix |
| Double | `double` | `74.0`, `69.3`, `-0.7` | Cannot contain characters; default type for decimals |
| Character | `char` | `'a'`, `'4'`, `'='`, `'@'` | Exactly one character, single quotes `' '` |
| String | `String` | `"down"`, `"145a7w8"`, `"@Esa38"` | A sequence of characters, double quotes `" "` |
| Boolean | `boolean` | `true`, `false` | Only the literals `true`/`false` |

For the shop-floor example above: cycle time is a `double`, batch size is an `int`, the pass/fail result is a `boolean`, and the operator ID is a `String`.

### A Careful Note on Boolean

Java boolean literals are **only** `true` and `false` -- written in lowercase, with no quotes. Unlike some other languages, Java does **not** accept `1`/`0` as booleans, and unlike Python, it does **not** accept the capitalized `True`/`False`.

```java
boolean flag = true;   // correct
boolean flag = 1;      // compile error
boolean flag = True;   // compile error -- that's Python, not Java
```

### Other Numeric Types

Beyond `int`, `float`, and `double`, Java has a few other numeric primitive types you will encounter in other people's code:

| Type | Size | Typical use |
|---|---|---|
| `byte` | 8-bit | Very small numbers, memory-constrained arrays |
| `short` | 16-bit | Rarely used directly |
| `long` | 64-bit | Whole numbers larger than `int` can hold |

This course will primarily use `int`, `double`, `char`, `String`, and `boolean`.

### Why So Many Numeric Types?

Each numeric type trades off **range** and **precision** against **memory**. An `int` is a 32-bit signed integer, capable of representing whole numbers from about &minus;2.1 billion to 2.1 billion, but it cannot store a fractional value. A `float` is a 32-bit, single-precision floating-point value; a `double` is a 64-bit, double-precision floating-point value, generally the default choice for decimal numbers because it is more precise than a `float`.

As a rule of thumb for this course: use `int` for counts (batch size, number of defects) and `double` for measurements (cycle time, weight, cost).

## Declaring and Initializing Variables

There are two steps to creating a variable: (i) declare the variable and (ii) initialize the variable.

### Declaring Variables

For a variable to be declared, it needs a specified name and type. The general syntax is:

```java
variable_type variable_name;
```

For example, the following block of code declares two variables, `x` and `y`. Variable `x` is a primitive `int` type; variable `y` is a `char` type.

```java
int x;    // declaration of an integer type variable
char y;   // declaration of a char type variable
```

### Naming Rules

A variable name must start with a letter, an underscore (`_`), or a dollar sign (`$`) -- never a digit -- and may contain only letters, digits, underscores, and dollar signs after that. A variable name cannot be a reserved word (`int`, `class`, `public`, and so on), and Java is case-sensitive, so `total` and `Total` are two different variables.

By convention, Java variable names use `camelCase`: the first word lowercase, each subsequent word capitalized, with no spaces or underscores -- for example `batchSize` or `cycleTime`.

*Check yourself:* which of the following are legal Java variable names, and which follow Java naming convention: `1stPlace`, `first place`, `int`, `firstPlace`, `_temp`?

### Initializing Variables

Once declared, a variable should be initialized -- given a value to store. The general syntax to initialize a variable that has already been declared is:

```java
variable_name = value;
```

For example, the following code initializes `x` to `0` and `y` to `'A'`. Note that the declaration of `x` and `y` is omitted here, but must have already happened before this initialization step.

```java
x = 0;      // initialize the int x to 0
y = 'A';    // initialize char y to 'A'
```

It is common for declaration and initialization to happen in a single line. For example, in the code below, `s`, `batchSize`, and `cycleTime` are each declared and initialized in one step.

```java
String s = "Example Text";
int batchSize = 250;
double cycleTime = 12.4;
```

### Why `float` Literals Need an `f`

In Java, a plain decimal literal such as `3.14` is treated as a `double` by default. Assigning it directly to a `float` variable is a type mismatch:

```java
float pi = 3.14;    // compile error: double cannot be converted to float
float pi = 3.14f;   // correct: the f suffix marks this literal as a float
```

`double` never needs a suffix, because it is already Java's default type for decimal literals.

## Constants

There are often scenarios in which a variable should retain the same value throughout a program -- in these cases, it is appropriate to declare the variable as a **constant**. A constant variable cannot be changed after it is initialized. The general format to declare a constant is to add the keyword `final` before the type:

```java
final type variableName = value;
```

By convention, constant names are written in `ALL_CAPS_WITH_UNDERSCORES`. Consider the following code, which repeats a "magic number":

```java
double area1 = 3.14159 * radius1 * radius1;
double area2 = 3.14159 * radius2 * radius2;
double area3 = 3.14159 * radius3 * radius3;
```

If that value ever needed to change, or simply to make the code more readable, it is better written as:

```java
final double PI_VALUE = 3.14159;

double area1 = PI_VALUE * radius1 * radius1;
double area2 = PI_VALUE * radius2 * radius2;
double area3 = PI_VALUE * radius3 * radius3;
```

## Assignment Operator

In the initialization step discussed above, the `=` operator was used to assign a value to a declared variable. For this reason, `=` is commonly referred to as the **assignment operator**. It is used to assign values to variables, whether those values come from user input, an input file, or the result of an expression, as shown below.

```java
double p;
double length = 2.2;   // assignment operator used to initialize length to 2.2
double width = 3.1;    // assignment operator used to initialize width to 3.1
p = 2 * width + 2 * length;  // assign expression calculating perimeter of rectangle to p
```

It is important to note that `=` does not represent mathematical equality. This is a common mistake for students new to Java.

When assigning a value to a variable, only a single variable may appear on the left-hand side of `=`. The following would produce an error:

```java
int z;
int v;
z + v = 3;   // this would produce an error
```

## Displaying What's Inside a Variable

Declaring and initializing a variable doesn't, by itself, show you anything -- you have to print it. The `+` operator, when used with a `String`, joins ("concatenates") text and a variable's value into a single `String` for output.

```java
double cycleTime = 12.4;
System.out.println("Cycle time: " + cycleTime);
```

```
Cycle time: 12.4
```

## Failing to Initialize a Variable

Failure to initialize a local variable before using it in an expression will cause a compile-time error -- Java does **not** give local variables an automatic default value. (This differs from fields of a class, which do get default values; that distinction will matter once we introduce classes later in the course.)

Consider the following example, and assume that `a`, `b`, and `c` have all been declared:

```java
b = 8;
a = b + 7;    // this works because b has been initialized
a = 19 + c;   // this produces an error because c has not been initialized
```

Attempting to compile the second assignment produces an error along these lines:

```
error: variable c might not have been initialized
        a = 19 + c;
                 ^
```

Reading and understanding compiler errors like this one is a skill you will use constantly throughout this course -- the error message tells you exactly which variable is the problem and why.

## Check Your Understanding

1. What Java type would you use to store: a part count, a machine's cycle time, whether a part passed inspection, and an operator's badge ID?
2. Why does `float pi = 3.14;` fail to compile, while `double pi = 3.14;` works fine?
3. Is `boolean done = 1;` legal in Java? Why or why not?
4. Which of these are legal variable names: `1stPlace`, `first place`, `int`, `firstPlace`, `_temp`?
5. Why might you prefer a `final` constant over repeating the same literal value throughout a program?

## Practice

See `IntroToVariables.java` for a worked example of each type discussed above, and `VariablesPractice.java` for a short hands-on exercise declaring each type yourself.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
