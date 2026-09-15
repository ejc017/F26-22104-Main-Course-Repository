# Random Numbers

[Slides for this topic](../../Slides/T08RandomNumbers/RandomNumbers.html)

## Introduction

In this section we will be focusing on generating random numbers in Java. Random numbers are used throughout industrial engineering, from simulating queues and processing times, to randomly sampling parts for a quality audit, to generating synthetic test data for an algorithm. Java provides two common ways to generate random values: the `Math.random()` method and the `java.util.Random` class. In the discussion that follows, both approaches are demonstrated.

## Generating Random Values with `Math.random()`

`Math.random()` is a `static` method available on the `Math` class. It requires no import and no object creation. Every call returns a `double` that is greater than or equal to 0.0 and strictly less than 1.0, i.e. the interval [0.0, 1.0). Because `Math.random()` always returns a value in this fixed range, we scale and cast the result to obtain values useful for a particular problem. In the example below, `n` stores the raw `double` result, and `i` scales that result by 10 and casts it to an `int` to produce a whole number between 0 and 9.

```java
double n = Math.random(); // 0.0 <= n < 1.0
int i = (int) (Math.random() * 10); // 0-9

System.out.println(n);
System.out.println(i);
```

### Basic Random Number Exercise

- In the `Simple` class, add a line that prints a random `int` between 1 and 100, inclusive.
- In the `Simple` class, add a line that prints a random `double` between 0.0 and 5.0.

## The `java.util.Random` Class

The `java.util.Random` class provides more options than `Math.random()`. After importing `java.util.Random` and creating a `Random` object, several methods are available: `nextInt(bound)` returns an `int` between 0 (inclusive) and `bound` (exclusive), `nextDouble()` returns a `double` in [0.0, 1.0) just like `Math.random()`, and `nextBoolean()` returns either `true` or `false`. The example below illustrates each of these methods, including how `nextInt` can be shifted with `+ 1` to simulate a six-sided die, which produces values 1 through 6 instead of 0 through 5.

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

A useful feature of `Random` that `Math.random()` does not offer is seeding. Creating a `Random` object with an integer argument, such as `new Random(42)`, produces the exact same sequence of "random" values every time the program runs. This is helpful when debugging a simulation or when a repeatable sequence of test values is needed; a `Random` object created without an argument, as in the example above, is seeded using the current system time and will differ from run to run.

## Generating a Random Integer Within an Arbitrary Range

`nextInt(bound)` always starts at 0. To generate a random integer within any range from `min` to `max`, inclusive, use the general formula below.

```java
int value = min + rand.nextInt(max - min + 1);
```

The example below simulates the processing time, in seconds, of a randomly selected part arriving at a workstation, where the processing time can be anywhere from 30 to 60 seconds.

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

## Random Number Exercise

A quality engineer wants to randomly route each incoming part to one of three inspection stations, `WS1`, `WS2` or `WS3`, so that no single station is biased toward getting more parts than the others. In the class `RandomExercise`, use `rand.nextInt(...)` to pick a station number from 1 to 3, then use a `switch` statement -- the construct from the previous chapter -- to set `selectedStation` to the matching station name.

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

Run your finished program several times. Because the station is chosen at random, the output should not be the same every run -- and over many runs, no station should appear noticeably more often than the other two.

## Check Your Understanding

1. Can `Math.random()` ever return exactly 1.0? Can it return exactly 0.0?
2. Why does `(int) (Math.random() * 10)` produce values 0 through 9 rather than 0 through 10?
3. What set of values can `rand.nextInt(6)` return on its own, before the `+ 1` is applied?
4. Using the formula `min + rand.nextInt(max - min + 1)`, how many distinct values are possible when `min` is 30 and `max` is 60?
5. Two students run the same program. One created their `Random` with `new Random()` and the other with `new Random(42)`. Which one can reproduce the exact same output tomorrow, and why would that matter when testing a simulation?

## Practice

Open `Simple.java` to see `Math.random()`, then `Classic.java` and `RandomRange.java` to see the `java.util.Random` class and the arbitrary-range formula.

Then complete `RandomExercise.java` to route parts randomly across three inspection stations.

## AI Use Disclosure

Anthropic. (2026). Claude Code (Opus 5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this primer, including content review and formatting.
