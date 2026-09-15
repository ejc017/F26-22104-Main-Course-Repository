---
title: Switch Statements
subtitle: INEG 22104 -- Computing Methods for Industrial Engineers I
date: "Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code. Claude Code was used to draft, revise, and design these lecture slides."
---

## `switch` Introduction

- `switch` statements allow for branching and can replace if-else statements
- `switch` statements receive an input value and compare it to different conditions called cases
    - a code block is executed if the case matches the input
    - if the input value does not match any of the cases, then the `default` case is executed
- `break` statements terminate `switch` execution

## `switch` Illustration

```java
switch (input)
{  //<--- Notice how the statement is enclosed by braces
  case 0:
    input = 1; //Any expression here will be executed if the input matches the case number
    //This is the first case of the `switch` statement
  break;
  case 1:
    input = 4*36;
    //This is the second case of the `switch` statement
  break;

  case 25:
    input = input + 1;
    //Notice that the case number can be any number you choose
  break;

  case 4:
    input++;
    //They do not need to be in any specific order, but it is good practice to start from the lowest number
  break;

  case 5:
    input = input/25;
    //Notice how after the case number we have a colon ":" instead of the usual semi-colon ";"
  break;
  default:
    System.out.print("This is the default statement");
    //This statement will execute if the value of the input does not match any of the other cases
  break;
}  //<--- Notice how the statement is enclosed by braces
```

## Basic `switch` Exercise

- In the `SwitchIntro` class, add a `case` that executes `input--` only if `input` equals 112
- In the `SwitchIntro` class, add a `case` that executes `input*=4` only if `input` equals 58
- Poll: in the *unmodified* `SwitchIntro` starter code, `input` starts at 0 -- what value does it print after the `switch` runs?

## Omitting `break` Statement

- Multiple cases can be executed with a single `switch` statement evaluation
    - omit `break` statement from specific `case` code blocks

```java

switch (input)
{
case 1:
case 2:
case 3:
  System.out.print("The input was between 1 and 3");
break;

case 4:
case 5:
case 6:
  System.out.print("The input was between 4 and 6");
break;

case 7:
case 8:
case 9:
  System.out.print("The input was between 7 and 9");
break;

default:
  System.out.print("The input did not match any of the cases");
}
```

- Poll: with this code, what prints when `input` is 5?

## if-else Alternative to `switch` Statement

```java

if(input>=1 && input <=3)
{
  System.out.print("The input was between 1 and 3");
}
else if(input > 3 && input <=6)
{
  System.out.print("The input was between 4 and 6");
}
else if(input > 6 && input <=9)
{
  System.out.print("The input was between 7 and 9");
}
else
{
  System.out.print("The input did not match any of the cases");
}
```

- Discuss: if there were 50 possible cases instead of 9, would you reach for `switch` or if-else, and why?

## `switch` Statements with `char` Input

- A `switch` can also take a `char` -- common when building a menu of options
- Uppercase and lowercase `char` values are **not** equivalent, so list both before the `break`

```java
char input = 'a';

switch (input)
{
  case 'a':
  case 'A':
    System.out.print("Either A or a will make this case execute");
  break;

  case 'b':
  case 'B':
    System.out.print("This statement can also be executed by upper or lowercase b");
  break;

  default:
    System.out.print("As usual, default executes if the input does not match any of the cases");
}
```

- Poll: what would print for `'b'` if that second `break` were deleted?

## `switch` with `String` Exercise

- In the class `SwitchStrings`, add a `switch` statement that sets the `int` variable `cycleTime` to the value specified in the following table according to the `String` provided as the `station` input

| station (String) | cycleTime, seconds (int) |
|---|---|
| WS1 | 42 |
| WS2 | 58 |
| WS3 | 35 |

- If a station code other than the three in this table is provided as input to your `switch` statement, then the following message should be printed to the console and the program should terminate
- Discuss: why use `switch` here instead of three `if` statements comparing `Strings`?

```java
    "Station not found"
```

## Recap

- A `switch` compares one input value against a list of `case` values
- `default` runs when the input matches none of the cases
- `break` ends the `switch` -- leaving it out makes execution **fall through** into the next case
- Deliberate fall-through lets several cases share one block, as with `'a'` and `'A'`
- A `switch` needs constant case values, so ranges and comparisons still belong in an if-else
- Switching on a `String` compares by value, the same thing `equals()` does in an if-else

## Practice

Open `SwitchIntro.java` and change `input` to 0, 1, 25, 4, 5, and 100 -- confirm which case runs each time.

Then `OmittingBreaks.java` -- run it with 1, 5, and 42, and explain why several cases share one message.

Run `SwitchCharacters.java` with `'a'`, `'A'`, `'b'`, and `'z'`. Delete the `break` after the `'B'` case and explain the new output.

Finish `SwitchStrings.java` using the cycle-time table, including the `Station not found` case.
