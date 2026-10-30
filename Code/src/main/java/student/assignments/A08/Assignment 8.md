# Assignment 8

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, October 30, 2026

To submit Assignment 8, commit and push your work to the **main branch of your fork** of the course repository.

All three starter files live in the `instructor.assignments.A08` package. Copy the **entire `A08` package** across in one step: right-click `instructor.assignments.A08`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.assignments.A08`. That package does not exist under `student.assignments` yet. The copy creates it for you, along with all three files. Do all of your work in your copy, and leave the `instructor` version alone.

**Question 3 also has a fourth file that you create yourself:** a plain-text pseudocode file, `Assignment8_Q3_pseudocode.txt`, in your copy of the package. Create it only **after** the Refactor → Copy step above, and read "Planning With Pseudocode" below before you start Question 3. It must be your own work, with no AI of any kind.

**The written-answer questions** appear only in the comment block at the top of each starter file (the "YOUR WRITTEN ANSWERS" block), not in this document. Read that block before you start each question, and type your answers into it.

Four data files for this assignment are already in the project's `data` folder: `a08_crewA.txt`, `a08_crewB.txt`, `a08_suppliers.txt`, and `a08_demand.txt`. Question 2 writes its result into the project's `output` folder, which already exists.

Where a question below allows AI use, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution. This applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead. There's no advantage to skipping the practice now.

### Working With Methods on This Assignment

- **Read the header of a method before you write its body.** The header (access level, `static`, return type, name, parameters) is a contract with the code that calls it. In Questions 1 and 2 the headers are given. In Question 3 you work them out from the calls.
- **Test as you go.** A method can be tested on its own before the rest of the program depends on it. Call it from `main` with a few values whose answers you know, and look at the result.
- **Trace a call by hand** if the result is wrong: write down the arguments, which parameter each one goes into, and what `return` sends back.
- **Every method here is `static`.** Objects come later.
- **Arrays are not copied when you pass them.** A method that changes the elements of an array it was given changes the caller's array too. See the T15 primer, section "Arrays and Methods". You will see this in Questions 1 and 2.

### Planning With Pseudocode (required for Question 3)

Write the pseudocode for Question 3 the way you did for Assignment 7: the same style, the same keywords, the same `#` trace at the bottom, and the same steps for creating the file in IntelliJ and pushing it with GitHub Desktop. Reread "Planning With Pseudocode" in `instructor.assignments.A07` (`Assignment 7.md`) if you need a reminder. Only the file name changes: `Assignment8_Q3_pseudocode.txt`, in `student.assignments.A08`.

**What is new is writing a method.** Assignment 7 planned one `main`. Here you plan several methods, so add these two keywords to the ones you already know:

| Keyword | Use |
|---|---|
| `DEFINE name(type x, type y) GIVES type` ... `END DEFINE` | one method: its name, each parameter with its type in plain words, and the type it gives back (`GIVES NOTHING` for a method that only prints) |
| `RETURN value` | hand a value back to the caller; the method ends there |

A call to one of your other methods is written as part of a step (`SET s TO spread(values)`). Types are written in plain words ("list of decimal numbers", "whole number", "text"), never as Java types. A few notation notes for things that come up with methods and arrays:

- **Making a list:** `SET forecast TO a list of decimal numbers, one for each week, all 0`. Do not write `new double[n]`.
- **Sizes and ends:** `.length` is Java. Write "the number of values in `values`" or "the last index of `values`" instead. A `FOR` includes both ends, so "from `start` up to but **not** including `end`" is written `FOR i FROM start TO end - 1`.

**Worked example on a different problem.** *A method `spread` takes a list of decimal numbers (at least one) and gives back the largest minus the smallest. A second method prints the spread with a label.*

```
DEFINE spread(list of decimal numbers values) GIVES decimal number
    # largest minus smallest; the list has at least one number
    SET smallest TO values[0]
    SET largest TO values[0]
    FOR i FROM 1 TO the last index of values
        IF values[i] < smallest THEN
            SET smallest TO values[i]
        ELSE IF values[i] > largest THEN
            SET largest TO values[i]
        END IF
    END FOR
    RETURN largest - smallest
END DEFINE

DEFINE printSpread(text label, list of decimal numbers values) GIVES NOTHING
    # prints the label and the spread to the console
    SET s TO spread(values)
    WRITE label and s to the console
END DEFINE

# TRACE spread with 4.0, 2.5, 6.0
# start: smallest 4.0, largest 4.0.  i=1: 2.5 < 4.0, so smallest 2.5.
# i=2: 6.0 is not < 2.5; 6.0 > 4.0, so largest 6.0.  RETURN 6.0 - 2.5 = 3.5.
```

### What You May Use

The concepts you can use on this assignment are:

- **Methods**: defining your own `public static` and `private static` methods; parameters and arguments (including arrays and `String`); `return`; `void` methods; methods that call other methods; a method that returns an array; `throws FileNotFoundException` on a method that opens a file
- **Array operations**: `Arrays.copyOf` (to copy, and to make an array one element larger), `Arrays.equals`, `Arrays.sort`, `Arrays.toString` (requires `import java.util.Arrays;`), and swapping two elements with a temporary variable
- **Arrays**: one-dimensional arrays of `int`, `double`, and `String`; `arrayName[i]`; `arrayName.length`
- **File input**: `FileInputStream`, `Scanner` (wrapped around a `FileInputStream`), `nextInt()`, `nextDouble()`, `next()`, `close()`
- **File output**: `PrintWriter`, `printf()`, `close()`
- **Output**: `printf()` with `%s`, `%d`, `%f`, `%n`, and widths and precisions such as `%5d`, `%-12s`, and `%.2f`
- **Everything from earlier assignments**: `if`/`else if`/`else`, `for` and `while` loops, `final` constants, casting, `boolean` values, and the arithmetic (including `%`), comparison, and logical operators

We have **not** covered the following, and solutions that rely on them will not receive credit: `Math` methods (none are needed; in particular, write your own absolute value instead of `Math.abs`), `Arrays.fill`, `Arrays.copyOfRange`, `System.arraycopy`, `Collections`, `ArrayList`, the enhanced (for-each) `for` loop, `split()`, `try`/`catch`, the conditional (ternary) `?:` operator, `do`-`while` loops, `continue`, recursion, two methods with the same name, non-`static` methods, and objects.

------

## Question 1 - Overtime Pay

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I declare a method that returns a `boolean`?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the methods.

Two work crews log the hours each worker put in during one week. The company pays **overtime** for every hour above 40 in a week, at **time and a half** (1.5 times the regular rate). A supervisor wants a report for each crew, and wants to know which crew costs more in overtime. Computing one worker's overtime pay takes several small steps (are the hours over the limit? how many hours over? what is the overtime rate?), and the same steps are needed for every worker in both crews. That is exactly the kind of job methods are for: write each step once and let the bigger methods call the smaller ones.

Each data file begins with the number of workers, followed by the hours each worked, one per line:

```
8
38.5
40.0
...
```

Work in `Assignment8_Q1`. The `main` method already contains the calls for parts a through d (`readHours` and `printReport`); you add the code for part e and the two experiments in part g. Your job is otherwise to fill in the bodies of the methods below `main`. The headers are given and must not change. Until you replace the placeholder `return` statements, the program compiles but prints nothing useful.

**a.** `readHours` takes the name of a file, reads the count `n` from the file's first line, creates a `double` array with `n` elements, fills it with a `for` loop, closes the `Scanner`, and returns the array. Notice the `throws FileNotFoundException`: any method that creates a `FileInputStream` must declare it, and so must every method that calls such a method (here, `main`).

**b.** `isOvertime(hours, limit)` returns `true` if the hours are **more than** the limit and `false` otherwise (exactly 40.0 hours is not overtime). `overtimeHours(hours, limit)` returns how many hours are above the limit, or `0.0` if there are none. It must **call `isOvertime`** to decide, rather than repeat the comparison.

**c.** `premiumRate(baseRate)` returns the overtime pay rate, which is the base rate times 1.5. Notice that it is `private` and the other methods are `public`. `overtimePay(hours, limit, baseRate)` returns one worker's overtime pay: the overtime hours times the overtime rate. It must **call `overtimeHours` and `premiumRate`**. `totalOvertimePay(hours, limit, baseRate)` takes a whole crew's array and returns the sum of every worker's overtime pay. It must **call `overtimePay`** for each worker.

**d.** `indexOfMost(hours)` returns the **index** of the worker with the most hours (the first of them if two tie). `printReport` prints one summary line for the label and array passed to it, with `printf`, getting its numbers by calling `totalOvertimePay` and `indexOfMost` (the number of workers comes from the array's length, worker numbers start at 1, the pay has 2 decimal places and the hours have 1). The finished program prints these two lines:

```
Crew A: 8 workers, overtime pay $630.00, most hours: worker 6 (47.5 h)
Crew B: 8 workers, overtime pay $750.00, most hours: worker 5 (49.0 h)
```

**e.** In `main`, below the two `printReport` calls, call `totalOvertimePay` for each crew and store the results. Print which crew has the higher overtime pay, with `printf`, in the form shown in the starter (the crew with more first, and the larger amount first), and handle the case of a tie.

**f.** Run the program and record the full console output, including the lines printed for part g, in the comment block at the top of the file.

**g.** Answer the written questions in the comment block: what happens when two arguments of the same type are swapped (and whether the compiler notices); why a `double` passed to a method is not changed but an array's element is; why `premiumRate` is `private`; and what changing the overtime rule would touch. For the first two, **predict before you run**, then run and record what actually happened. The starter has a `TODO` in `main` for the two small experiments, with the exact lines to print.

------

## Question 2 - Supplier Lead Times

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I make a `double` array one element longer?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the sort, the swap methods, or the median.

A purchasing group has a list of 12 suppliers and the lead time (in days) each quotes for delivery. Order a part from the fastest supplier and you wait the shortest time, but a handful of suppliers are far slower than the rest, so the group wants the **median** lead time (the typical supplier) and a ranking from fastest to slowest.

`a08_suppliers.txt` begins with the number of suppliers, followed by one line per supplier holding a name and a lead time:

```
12
Acme 14
Brightway 7
...
```

The names and the lead times are held in two **parallel arrays**: `names[i]` and `leadTimes[i]` describe the same supplier. Work in `Assignment8_Q2`. The starter lists each part as a `TODO`, and the method headers are given. Do the parts in order, and do part f **last**: sorting rearranges your arrays in place. Part c has a written prediction to make **before** you run anything. This is the longest question; start it early.

**a.** Read the file into the two arrays. Print the number of suppliers (as `Suppliers read: 12`) and the lead times with `Arrays.toString`.

**b.** `Arrays.sort` sorts in place, so the original order is lost. To keep it, make a **copy** with `Arrays.copyOf`, and sort the copy. Print the original and the sorted copy. To make a copy of the same length, use `Arrays.copyOf(leadTimes, leadTimes.length)`. Then write the `median` method, which takes an array that is **already sorted** and returns the median as a `double` (the middle value for an odd count, the mean of the two middle values for an even count; `length % 2` tells you which), and print the median of the sorted copy.

**c.** Predict, then run, the three comparison printouts given in the starter (after the line that makes `copy`; `==` on two arrays with the same values, `Arrays.equals` on the same two, and `Arrays.equals` on the original and the sorted copy). Record your predictions before the run, and record any line that surprised you.

**d.** A new supplier, Zenith, quotes 21 days. An array cannot grow, so make **both** arrays one element larger with `Arrays.copyOf` (assign the result back to the array) and set the new last element. Print the new count, assign a **new** sorted copy of the grown `leadTimes` to your existing `sorted` variable, and print the median again. Notice that the median changed: because `median` is a method, it is the same code, called a second time.

**e.** Make a copy of the grown `names` array (it now includes Zenith), sort the copy with `Arrays.sort`, and print it. Look closely at where `eastbound` lands and answer the written question about it.

**f.** `Arrays.sort(leadTimes)` would put the lead times in order but leave the names where they were, so every name would now sit next to somebody else's lead time. To rank the suppliers, both arrays have to be reordered **together**. You will write that sort yourself, out of small methods:

- `indexOfSmallest(values, from)` returns the index of the smallest value at position `from` or later. If two values tie for smallest it returns the earlier index (use `<`).
- `swapInts(values, i, j)` and `swapStrings(values, i, j)` swap two elements of an array, using a temporary variable. They are `void`. Two methods are needed because one takes an `int[]` and the other a `String[]`.
- `sortTogether(names, leadTimes)` is a **selection sort**: for each position `p` from the first to the second-to-last, find the index `s` of the smallest lead time from `p` onward, and swap positions `p` and `s` in **both** arrays. It is `void`: it changes the arrays it was given.

Call `sortTogether` on the grown arrays. Then check your work against the library: print the result of `Arrays.equals` between your sorted `leadTimes` and the sorted copy from part d (it must be `true`). Finally, write the ranking to `output/a08_supplierRanking.txt` with a `PrintWriter`: a header printed with `"%-6s %-12s %5s%n"` (`Rank`, `Supplier`, `Days`), then one line per supplier printed with `"%-6d %-12s %5d%n"`, rank 1 being the fastest. The first lines of a correct file are:

```
Rank   Supplier      Days
1      Hartwell         5
2      Brightway        7
3      eastbound        7
```

Suppliers with the same lead time come out in the order your sort produces them. With `<` in `indexOfSmallest` the order is the one shown.

**g.** Run the program. Record the full console output, and the header and first three rows of the file, in the comment block at the top of the file. Then answer the five written questions there: what sorting the original would have lost; where `eastbound` went and why it ranks differently in the final file; what a swap with no temporary variable does; why a `void` method can still change an array; and why `sortTogether` could not simply return the sorted arrays.

------

## Question 3 - Choosing a Forecast Window

**AI Usage**: **Part a (the pseudocode) must be entirely your own work: no AI of any kind, not even for wording or syntax-style help.** For the Java in the remaining parts, AI is allowed for general Java syntax questions only (e.g., "How do I return an array from a method?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write any of the five methods. Do not give AI your pseudocode either. The pseudocode is graded on whether it is complete and consistent with how `main` uses each method; you may correct it after coding if you find a mistake.

A distribution center wants to forecast next week's demand for a product. The simplest forecast is the **moving average**: next week's forecast is the average of the last `window` weeks. A short window reacts fast but is jumpy; a long window is smooth but slow to react. Which window is best is an empirical question, so the planner will try every window from 1 to 6 on 26 weeks of history, score each one by its **mean absolute error (MAE)**, and use the best.

`a08_demand.txt` begins with the number of weeks, followed by the demand in units for each week, one per line:

```
26
199
197
...
```

Work in `Assignment8_Q3`. This time, **`main` is written for you and the methods are not.** Read `main` and work out what each method must look like (its name, its parameter types, and its return type) from the way `main` calls it and uses its result. Until the methods exist, the program will not compile. That is expected. To test as you go, first write all five with placeholder bodies so it compiles, then fill them in one at a time. `absoluteValue` is not called from `main`, so `main` will not tell you its types: it takes a `double` and returns a `double`. `readData` opens a file, so its header needs `throws FileNotFoundException`, as in Question 1 (the imports are already in the starter).

**A forecast array in this question.** `movingAverageForecast(demand, window)` returns an array the same length as `demand`. Element `t` is the forecast **for week `t`** made from the `window` weeks just before it. So with `window = 2` and demand `10, 12, 14, 16`:

```
forecast[0] = 0       (no weeks before it, so no forecast)
forecast[1] = 0       (only one week before it, not enough for window 2)
forecast[2] = 11.0    average of demand[0] and demand[1]
forecast[3] = 13.0    average of demand[1] and demand[2]
```

The error for each forecast week is the absolute difference between the forecast and the actual demand. For the example, scoring from index 2: `|14 - 11| = 3` and `|16 - 13| = 3`, so the MAE is `3.0`.

**a.** **Pseudocode first.** Before you write any Java, create `Assignment8_Q3_pseudocode.txt` in `student.assignments.A08` (see "Planning With Pseudocode" above for what is new, and Assignment 7 for the rest). Plan all five methods, working out what each receives and gives back from the way `main` calls it and from the descriptions in the starter. The file must show, for **each** method:

- **A `DEFINE` line:** the name, each parameter with its type in plain words and a name, and what it gives back (use the same method and parameter names you will use in Java).
- **The steps:** every loop with its exact starting and stopping index (state which end is included), every decision, which other methods it uses, and what is returned. For `readData`, the file steps (`OPEN`, `READ`, `CLOSE`); for `movingAverageForecast`, which elements stay 0 and why.
- **A trace:** one small made-up example of your own (for example 5 weeks of demand and a window of 2 or 3) followed by hand through `movingAverageForecast` and `meanAbsoluteError`, with the result recorded in `#` lines at the bottom (what each step does, then the arrays and the error that come out). Use your own demand numbers, not the 10, 12, 14, 16 from this handout. For `meanAbsoluteError` in your trace, use a `start` equal to your window (the real program uses 6, which is past the end of a 5-week example).

**b.** Write the five methods. `readData` reads the file into an array. `averageOf(values, start, end)` averages the elements from index `start` up to but **not** including `end`. `movingAverageForecast` builds the forecast array described above, and must **call `averageOf`**. `meanAbsoluteError(demand, forecast, start)` averages the absolute errors from index `start` to the last week, and must **call `absoluteValue`**. `absoluteValue` is a `private` helper (no `Math.abs`). Run the program. A correct run prints these lines first:

```
Weeks read: 26
Mean weekly demand: 232.2 units

Window 1: MAE 15.45 units
Window 2: MAE 13.58 units
...
```

**c.** (No code to write for this part.) Notice what `main` does with the scores: it keeps the **index** of the best window, the same "remember the index of the best" pattern as in Assignment 7. All windows are scored over the same weeks (from index `MAX_WINDOW`, which is 6, to the end). Written answer (1) asks you to see what happens if that is not done.

**d.** Add the final step to `main`, as described in the starter: recompute the forecast for the best window, make that array **one element larger with `Arrays.copyOf`**, and put next week's forecast in the new last element, then print it (the week number is `demand.length + 1`) and the last three weeks of actual demand against their forecasts.

**e.** Run the program. Record the full console output in the comment block, then answer the three written questions there: what happens to window 1's error when each window is scored from its own start; why the best window is neither the shortest nor the longest; and one benefit of building bigger methods from small ones.

------

## Submission Guidelines

1. **Code**: Push all three Java files and the pseudocode file `Assignment8_Q3_pseudocode.txt` (all under `student.assignments.A08`), and the output file `output/a08_supplierRanking.txt`, to your fork's main branch.
2. **Comments**: Every question asks for recorded results or written answers in comments. A program that runs correctly but is missing its recorded results will not receive full credit.
3. **Due Date**: Friday, October 30, 2026 at 5:00 PM.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5.5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review, formatting, and the generation of the data files.
