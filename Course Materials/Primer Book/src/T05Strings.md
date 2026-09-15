# Strings

[Slides for this topic](../../Slides/T05Strings/Strings.html)

## Introduction

In the previous chapter, a quality inspector typed three things at the keyboard: an operator ID (`OP-1042`), a part number (`AR-4471-B`), and an answer to whether the batch passed (`pass`). Reading that text into a program is only the first step. The plant actually wants answers to questions buried inside it: which facility produced the part, which lot it belongs to, and whether the operator's answer should count as a pass when they happened to type `PASS` instead of `pass`.

Answering those questions requires working with text rather than merely storing it. This chapter introduces the `String` -- the Java type that holds text -- along with the methods used to measure it, pull pieces out of it, clean it up, and compare it to something else.

## Creating String Objects

A `String` in Java is defined as a sequence of characters. `"AR-4471-B"`, `"pass"`, `"z"`, and even the empty `""` are all Strings. Note that double quotes create a `String`, while single quotes create a `char`:

```java
String revision = "B";        // a String that happens to be one character long
char revisionChar = 'B';      // a char
```

Unlike the primitive variables of earlier chapters, a `String` is an **object**, created from the `String` class included with the JDK. The distinction matters for a practical reason: primitives hold a value and nothing more, while objects carry **methods** -- built-in capabilities reached with a dot, exactly like the `Scanner` methods of the previous chapter.

```java
int lotSize = 250;
lotSize.length();             // no such thing -- primitives have no methods

String partNumber = "AR-4471-B";
partNumber.length();          // 9
```

### Declaring and Initializing

A `String` object can be declared and initialized like any other object, using the `new` keyword:

```java
String partNumberA = new String("AR-4471-B");
```

However, `String` is one of the few object types in Java that can also be created without `new`:

```java
String partNumberB = "AR-4471-B";
```

The second form is the standard used by an overwhelming majority of developers, and it is the form used throughout this course. Note also that `String` requires no `import` statement. Unlike `Scanner`, which had to be imported from `java.util`, `String` is always available.

A `String` can be initialized in code as shown above, or read from the user with a `Scanner`, using either `next()` or `nextLine()`.

### Strings Are Indexed From Zero

Each character in a `String` has a numbered position, called its **index**. Indexing begins at 0:

| Index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|---|---|---|---|---|---|---|---|---|---|
| Character | `A` | `R` | `-` | `4` | `4` | `7` | `1` | `-` | `B` |

The part number `"AR-4471-B"` contains nine characters, so its length is 9 -- but its last valid index is 8. Nearly every error made with Strings traces back to this single off-by-one distinction, so it is worth committing to memory now: **the last character of a String is always at index `length() - 1`.**

## Inspecting a String

### length()

The `length()` method takes no argument and returns an `int`: the number of individual characters in the `String` that invoked it. Dashes, spaces, and punctuation all count.

```java
String partNumber = "AR-4471-B";
System.out.println(partNumber.length());
```

```
9
```

### charAt(int)

The `charAt(int)` method accepts an index and returns the single `char` at that position. Because the first character is at index 0, the last character is retrieved with `length() - 1`:

```java
System.out.println(partNumber.charAt(0));                        // the plant initial
System.out.println(partNumber.charAt(partNumber.length() - 1));  // the revision letter
```

```
A
B
```

### indexOf(String)

The `indexOf(String)` method searches for the text passed to it and returns an `int`: the index where the first match begins. If the text does not appear anywhere in the `String`, the method returns `-1`.

```java
System.out.println(partNumber.indexOf("-"));      // first dash
System.out.println(partNumber.indexOf("4471"));   // start of the lot number
System.out.println(partNumber.indexOf("Z"));      // not present
```

```
2
3
-1
```

The `-1` is a legitimate return value meaning "not found," not an error. The program keeps running.

### contains(String) and isEmpty()

Sometimes the position does not matter and only the yes-or-no answer does. `contains(String)` returns a `boolean` indicating whether the text appears at all, and `isEmpty()` returns `true` only when the `String` has a length of 0:

```java
System.out.println(partNumber.contains("4471"));   // true
System.out.println(partNumber.contains("Z"));      // false

String operatorNote = "";
System.out.println(operatorNote.isEmpty());        // true
System.out.println(partNumber.isEmpty());          // false
```

## Extracting Part of a String

### substring(int)

The `substring` method creates a new `String` by extracting a set of consecutive characters. The single-argument variant accepts one `int`, the `beginIndex`, and returns the character at that index along with everything after it. All prior characters are left out.

```java
String partNumber = "AR-4471-B";
System.out.println(partNumber.substring(3));
```

```
4471-B
```

### substring(int, int)

The two-argument variant accepts a `beginIndex` and an `endIndex`. The extraction **stops before** `endIndex`, meaning the last character included sits at `endIndex - 1`. This is the detail that catches most people:

```java
String plantCode = partNumber.substring(0, 2);   // indexes 0 and 1
String lotNumber = partNumber.substring(3, 7);   // indexes 3 through 6

System.out.println(plantCode);
System.out.println(lotNumber);
```

```
AR
4471
```

In the first call, `A` (index 0) and `R` (index 1) are included, and the dash at index 2 is not. In the second, the four digits at indexes 3, 4, 5, and 6 are included, and the dash at index 7 is not.

### When an Index Is Out of Bounds

Both `charAt` and `substring` fail if handed an index that does not exist in the `String`. Because `"AR-4471-B"` has a length of 9, index 9 is one position past the end:

```java
partNumber.charAt(9);
partNumber.substring(3, 20);
```

```
StringIndexOutOfBoundsException: Index 9 out of bounds for length 9
StringIndexOutOfBoundsException: Range [3, 20) out of bounds for length 9
```

Both are **runtime errors** -- the same general category as the divide-by-zero example and the `Scanner` type mismatch from previous chapters. The code compiles without complaint; the failure only appears once the program runs and reaches that line.

## Strings Are Immutable

Every method described in this chapter shares a property that is easy to miss and important to understand: **a `String` cannot be changed after it is created.** Methods like `substring`, `trim`, and `toUpperCase` do not modify the `String` that invoked them. They build and return a brand-new `String`, leaving the original exactly as it was.

```java
String entry = "  pass  ";

entry.trim();                 // returns "pass" -- and that value is discarded
System.out.println(entry);    // still "  pass  "
```

The returned value is the entire point of calling the method. If it is not stored in a variable or used immediately, the work is thrown away and the program appears to do nothing at all. To keep a result, assign it:

```java
String cleaned = entry.trim();
System.out.println(cleaned);
```

```
pass
```

### concat(String) and the + Operator

The `concat(String)` method joins two Strings, accepting a single `String` and adding it to the end of the `String` that invoked the method. It does the same job as the `+` operator introduced earlier:

```java
String plant = "AR";
String lot = "4471";

System.out.println(plant.concat(lot));   // same result as plant + lot
```

```
AR4471
```

In practice, `+` is what developers reach for, and `concat` is worth knowing mostly because it demonstrates immutability so plainly. The call above produces `AR4471`, but the variable `plant` is untouched:

```java
System.out.println(plant);
```

```
AR
```

## Transforming a String

### toUpperCase() and toLowerCase()

Neither method takes an argument, and both return a new `String` with the case of every letter converted:

```java
System.out.println("pass".toUpperCase());
System.out.println("PASS".toLowerCase());
```

```
PASS
pass
```

These are most useful when a program cannot control how a user typed something. Converting both sides of a comparison to the same case is one way to make an entry like `Pass` match an expected value of `pass`.

### trim()

The `trim()` method returns a new `String` with whitespace -- spaces, tabs, and newline characters -- removed from **both ends**. Whitespace in the middle is left alone:

```java
String entry = "  pass  ";
System.out.println("[" + entry.trim() + "]");
```

```
[pass]
```

The brackets are a debugging habit worth adopting. Leading and trailing spaces are invisible in console output, so printing a bracket on either side of a value makes it obvious whether whitespace is present. Trimming keyboard input before working with it prevents a whole category of confusing bugs.

### replace(String, String)

The `replace` method returns a new `String` in which **every** occurrence of the first argument has been swapped for the second:

```java
String partNumber = "AR-4471-B";

System.out.println(partNumber.replace("-", ""));
System.out.println(partNumber);
```

```
AR4471B
AR-4471-B
```

Every dash is removed from the returned value, and -- consistent with immutability -- the original `partNumber` still contains all of them.

### Chaining Method Calls

Because these methods return a `String`, another `String` method can be called directly on the result. This is called **chaining**, and it reads left to right:

```java
String cleaned = entry.trim().toUpperCase();
```

`trim()` runs first and produces `"pass"`. `toUpperCase()` is then invoked on that result, producing `"PASS"`, which is what gets stored in `cleaned`. Chaining is convenient, but each link still follows the same rule: nothing is modified in place, and the final result must be stored to be useful.

## Comparing Strings

### Why == Is Not What You Want

Checking whether two Strings hold the same text seems like a job for `==`, the way it would be for two `int` values. It is not.

```java
Scanner scnr = new Scanner(System.in);
String response = scnr.nextLine();   // the operator types: pass

System.out.println(response == "pass");
```

```
false
```

The characters match perfectly, and the answer is still `false`. This happens because `==` does not compare the *contents* of two Strings. It compares whether the two variables refer to the **same object in memory**. The text typed at the keyboard was built into a new object at runtime; the `"pass"` written in the source code is a different object. Two different objects, so `==` reports `false`.

What makes this trap genuinely dangerous is that `==` does not always answer `false`. Compare two Strings written directly in the code, and Java may reuse a single shared object behind the scenes:

```java
String a = "pass";
String b = "pass";
System.out.println(a == b);
```

```
true
```

Identical comparison, identical characters, opposite answer. `==` on Strings is unpredictable, which is reason enough never to use it for this purpose. IntelliJ recognizes the mistake and will underline the comparison as a warning.

### equals(String)

The `equals(String)` method is the correct tool. It accepts a `String` and returns a `boolean`: `true` when both Strings contain exactly the same characters in the same order, and `false` otherwise. It compares contents, so it gives the same answer regardless of how the Strings were created.

```java
System.out.println(response.equals("pass"));
```

```
true
```

**Compare Strings with `equals()`, never with `==`.**

### equalsIgnoreCase(String)

`equals()` treats uppercase and lowercase letters as different characters, which is usually correct but not always what a program needs. An inspector answering a prompt may reasonably type `pass`, `PASS`, or `Pass`, and all three should count the same. The `equalsIgnoreCase(String)` method performs the same comparison while treating case as irrelevant:

```java
System.out.println("PASS".equals("pass"));
System.out.println("PASS".equalsIgnoreCase("pass"));
```

```
false
true
```

Combined with `trim()`, this handles most of the messiness of real keyboard input:

```java
String response = "  PASS  ";
System.out.println(response.trim().equalsIgnoreCase("pass"));
```

```
true
```

Note that `equals()` and `equalsIgnoreCase()` answer the question *are these the same?* A related question -- *which of these comes first alphabetically?* -- becomes relevant when sorting data later in the semester, and Java provides a separate method for it at that point.

## Check Your Understanding

1. Why does a `String` variable have methods available to it when an `int` variable does not?
2. The part number `"AR-4471-B"` has a length of 9. What is the index of its last character, and what happens if you ask for `charAt(9)`?
3. What does `"AR-4471-B".substring(3, 7)` return, and why is the character at index 7 not included?
4. A program calls `entry.trim();` on its own line and then prints `entry`, which still shows the original spaces. Explain why, in terms of immutability.
5. Two Strings contain exactly the same characters, but `==` reports `false`. What is `==` actually comparing?
6. An operator might type `pass`, `PASS`, or `  Pass  `. Write the single line of code that returns `true` for all three.

## Practice

Open `CreatingStrings.java`, `InspectingStrings.java`, and `SlicingStrings.java` to watch this chapter's methods run. In `SlicingStrings.java`, uncomment the final two lines to trigger a `StringIndexOutOfBoundsException` on purpose.

Then work through `TransformingStrings.java`, predicting the output of each line before running it -- especially the third one.

Finish with `EqualsTrap.java`. Run it, type `pass`, and make sure you can explain why the first line of output disagrees with the last one.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
