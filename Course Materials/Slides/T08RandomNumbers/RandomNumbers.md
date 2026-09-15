---
title: Random Numbers
subtitle: INEG 22104 -- Computing Methods for Industrial Engineers I
date: "Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code. Claude Code was used to draft, revise, and design these lecture slides."
---

## Why Random Numbers?

- Random numbers are used throughout industrial engineering
    - simulating queues and processing times
    - randomly sampling parts for a quality audit
    - generating synthetic test data
- Java offers two common ways to generate them
    - `Math.random()`
    - the `java.util.Random` class

## `Math.random()`

- `static` method on the `Math` class -- no import, no object needed
- Always returns a `double` in the interval [0.0, 1.0)
- Scale and cast to get a useful range

```java
double n = Math.random(); // 0.0 <= n < 1.0
int i = (int) (Math.random() * 10); // 0-9

System.out.println(n);
System.out.println(i);
```

- Poll: can `Math.random()` ever return exactly 1.0?

## Basic Random Number Exercise

- In the `Simple` class, add a line that prints a random `int` between 1 and 100, inclusive
- In the `Simple` class, add a line that prints a random `double` between 0.0 and 5.0

## The `java.util.Random` Class

```java
import java.util.Random;

public class Classic {
    public static void main(String[] args) {
        Random rand = new Random();

        int n = rand.nextInt(10);      // 0-9
        int n2 = rand.nextInt(6) + 1;  // 1-6
        double d = rand.nextDouble();  // 0.0 <= d < 1.0
        boolean b = rand.nextBoolean();

        System.out.println("int between 0 and 9: " + n);
        System.out.println("int between 1 and 6: " + n2);
        System.out.println("double between 0 and 1: " + d);
        System.out.println("boolean: " + b);
    }
}
```

- `nextInt(bound)`: `int` in [0, bound)
- `nextDouble()`: `double` in [0.0, 1.0)
- `nextBoolean()`: `true` or `false`
- Poll: what set of values can `rand.nextInt(6)` return on its own, before the `+ 1`?

## Seeding a `Random` Object

- `new Random()` -- seeded from the current system time, differs every run
- `new Random(42)` -- seeded with a fixed value, produces the *same* sequence every run
- Discuss: why would a repeatable sequence be useful when testing a simulation?

## Generating a Random Integer in an Arbitrary Range

```java
int value = min + rand.nextInt(max - min + 1);
```

```java
import java.util.Random;

public class RandomRange {
    public static void main(String[] args) {
        Random rand = new Random();

        int min = 30;
        int max = 60;
        int processingTime = min + rand.nextInt(max - min + 1); // 30-60, inclusive

        System.out.println("Processing time (s): " + processingTime);
    }
}
```

- Poll: for `min = 30` and `max = 60`, how many distinct values of `processingTime` are possible?

## Random Number Exercise

- A quality engineer wants to randomly route each incoming part to one of three inspection stations, `WS1`, `WS2` or `WS3`, with no station favored over another
- In the class `RandomExercise`, use `rand.nextInt(...)` to pick a station number from 1 to 3, then use a `switch` -- from last topic -- to set `selectedStation`

```java
import java.util.Random;

public class RandomExercise {
    public static void main(String[] args) {
        Random rand = new Random();

        //TODO: use rand.nextInt(...) to pick a station number from 1 to 3,
        //then use a switch statement to set selectedStation to "WS1", "WS2" or "WS3"
        int stationNumber = 0;
        String selectedStation = "";

        System.out.println("Station number: " + stationNumber);
        System.out.println("Part routed to: " + selectedStation);
    }
}
```

## Recap

- `Math.random()` returns a `double` in [0.0, 1.0) -- no import, no object, never exactly 1.0
- Scale and cast to reach a useful range: `(int) (Math.random() * 10)` gives 0-9
- `java.util.Random` adds `nextInt(bound)`, `nextDouble()`, and `nextBoolean()`
- `nextInt(bound)` always starts at 0, so shift it: `nextInt(6) + 1` gives 1-6
- For any range, `min + rand.nextInt(max - min + 1)` gives `min` through `max`, inclusive
- `new Random(42)` repeats the same sequence every run, which makes a simulation testable

## Practice

Open `Simple.java` and `Classic.java` and run each several times to confirm the values change.

Then `RandomRange.java` -- run it repeatedly and check that no value ever falls outside 30 to 60.

Change `RandomRange.java` to use `new Random(42)` and run it twice. Explain why the output no longer changes.

Finish `RandomExercise.java` routing parts across the three inspection stations.
