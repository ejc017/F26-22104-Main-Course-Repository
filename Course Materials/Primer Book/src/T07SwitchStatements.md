# Switch Statements

[Slides for this topic](../../Slides/T07SwitchStatements/SwitchStatements.html)

## Introduction

In this section we will be focusing on `switch` statements. A `switch` statement is used to evaluate a value according to multiple conditions. Think about how hardware switches are used to route electrical connections. A `switch` statement is an alternative to the if-else statement construct discussed previously. In the discussion that follows, implementation of `switch` statements is demonstrated.

## Basic Concepts

A `switch` can replace if-else statements. `switch` statements receive an input value and compare it to different conditions called cases. Each case contains code that is to be executed if the case matches the input. If the input value does not match any of the cases, then the `switch`'s `default` case will be executed. The other component of `switch` statements are interruptions called `break` statements. A `break` terminates the `switch` statement execution.

In the example below, the `switch` statement evaluates an `int` variable named `input`. If the value is 0, then `input` is assigned 1. If the value is 1, then `input` is assigned the product of 4 and 36. Additional operations are specified for the cases where `input` is 25, 4 and 5. If the value provided to the `switch` statement is not 0, 1, 25, 4 or 5, then the `default` case is executed and the `String` "This is the default statement" is printed to the console. Since a `break` statement is included with each `case`, the `switch` statement terminates immediately after the operations associated with a matching `case` are executed.

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

### Basic `switch` Exercise

- In the `SwitchIntro` class, add a `case` that executes `input--` only if `input` equals 112.
- In the `SwitchIntro` class, add a `case` that executes `input*=4` only if `input` equals 58.

## Omitting the break Statement

It is possible to execute multiple cases when a single `switch` statement is evaluated. To accomplish this, omit the `break` statement from specific `case` code blocks. The example below illustrates this concept. When `input` is 1, `case` 1 is executed along with 2 and 3. This occurs because the `break` statement is not included until after `case` 3. Similarly, if the input does not match cases 1-3 but does match case 4, 5 or 6, then the operations associated with 4, 5 and 6 are executed. The exclusion of `break` statements makes the ordering of the cases consequential.

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

In both examples above, note that this use of `switch` is similar to an if-else statement with a range in the condition. If the problem allows multiple values to arrive at the same outcome, it might be worth considering an if-else statement instead. The same program above could be condensed to the following code:

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

We can see that with only a few outcomes to consider, the effort to implement a `switch` versus an if-else is similar. However, whenever we are dealing with large ranges of outcomes, if-else can be time saving to implement.

## `switch` Statements with `char` Input

Characters can also be used as input for a `switch` statement. This is particularly common when creating a menu of options for a user to choose from. Recall that lowercase and uppercase variants of `char` values are not equivalent. However, we can overcome this issue by including both lowercase and uppercase cases before a `switch` `break`. An example is shown below:

```java
char input = 'a';

switch (input)
{
  case 'a':
  case 'A':
    System.out.print("Either A or a will make this case execute");
  break;
       //Do not forget the break whenever you need to separate cases

  case 'b':
  case 'B':
    System.out.print("This statement can also be executed by upper or lowercase b");
  break;

  default:
    System.out.print("As usual, default executes if the input does not match any of the cases");
}
```

## `switch` with `String` Exercise

Assembly-line workstations are often identified by a short station code (a `String`), while downstream scheduling software needs the station's standard cycle time in seconds (an `int`) to balance the line. In the class `SwitchStrings`, add a `switch` statement that sets the `int` variable `cycleTime` to the value specified in the following table according to the `String` provided as the `station` input.

| station (String) | cycleTime, seconds (int) |
|---|---|
| WS1 | 42 |
| WS2 | 58 |
| WS3 | 35 |

If a station code other than the three in this table is provided as input to your `switch` statement, then the following message should be printed to the console and the program should terminate.

```java
    "Station not found"
```

## Check Your Understanding

1. What happens if you leave the `break` out of a `case` that is followed by other cases?
2. In the `SwitchIntro` starter code, `input` starts at 0. What value does the program print after the `switch` runs, and why isn't it `144`?
3. Why can't you write `case input > 5:` in a `switch` statement?
4. Why does the `char` example list `case 'a':` and `case 'A':` back to back instead of using a single case?
5. If a problem has 50 possible input values that each map to a different outcome, would you reach for a `switch` or an if-else chain? What if all 50 values map to only three outcomes?

## Practice

Open `SwitchIntro.java` to see the basic structure, then `OmittingBreaks.java` to see fall-through behavior and `SwitchCharacters.java` to see a `char` menu.

Then complete `SwitchStrings.java` using the cycle-time table above.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
