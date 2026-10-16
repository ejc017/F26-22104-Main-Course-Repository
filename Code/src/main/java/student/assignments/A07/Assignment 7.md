# Assignment 7

## INEG 22104 Computing Methods for INEG I | Fall 2026 | Due at 5:00 PM on Friday, October 16, 2026

To submit Assignment 7, commit and push your work to the **main branch of your fork** of the course repository.

All three starter files live in the `instructor.assignments.A07` package. Copy the **entire `A07` package** across in one step: right-click `instructor.assignments.A07`, choose **Refactor → Copy...** (not Move, and not a plain cut/paste), and set the destination to `student.assignments.A07`. That package does not exist under `student.assignments` yet. The copy creates it for you, along with all three files. Do all of your work in your copy, and leave the `instructor` version alone.

**Question 2 also has a fourth file that you create yourself:** a plain-text pseudocode file, `Assignment7_Q2_pseudocode.txt`, in your copy of the package. Create it only **after** the Refactor → Copy step above, and read "Planning With Pseudocode" below before you start Question 2. It must be your own work, with no AI of any kind.

**The written-answer questions** appear only in the comment block at the top of each starter file (the "YOUR WRITTEN ANSWERS" block), not in this document. Read that block before you start each question, and type your answers into it.

Three data files for this assignment are already in the project's `data` folder: `a07_cycleTimes.txt`, `a07_fillVolumes.txt`, and `a07_downtime.txt`. Your programs write their results into the project's `output` folder, which already exists; you do not need to create it.

Where a question below allows AI use, disclose it using the citation format described in the syllabus: place an APA 7 reference in a comment at the top of the affected file, along with a brief note of what you used it for.

### AI Usage Ground Rules (applies to every question below)

- **Never paste this assignment's question text into an AI tool** and ask it to answer or write the solution. This applies even on questions where AI is otherwise allowed. "AI allowed for syntax help" means a general Java question independent of this assignment, not this assignment's specifics.
- When a question allows AI, your disclosure comment must include **what you actually asked** (paraphrased), not just a general note like "used AI for help."
- Quizzes and paper exams test these same skills with no AI allowed. If a question here gets outsourced to AI, that gap just shows up there instead. There's no advantage to skipping the practice now.

### Planning With Pseudocode (required for Question 2)

**What it is.** Pseudocode is a plan for a program written in plain language instead of Java. Nothing runs it. Its job is to make you decide the structure of your solution: what comes in, what must come out, which arrays you need, how big they are, what each loop does, what decisions happen inside it, before you are also fighting semicolons and compiler errors. It is a **design**, so it comes first; a plan written after the code is just a description of the code.

**The style.** Someone who has never seen your code, and who may use a different language, should be able to build a correct program from it. So: plain language, no Java syntax (no semicolons, braces, `i++`, `new int[10]`, type words like `int`, or `printf` format strings), but exact about bounds, order, and special cases. Use this small set of capitalized keywords the same way everywhere, one action per line, and indent everything inside a block:

| Keyword | Use |
|---|---|
| `SET x TO ...` | give a variable or array element a value |
| `OPEN` / `READ x FROM ...` / `CLOSE` | file input |
| `WRITE ...` | output (to the console or a file; say which). To write a bar of stars, say how many ("`counts[b] / BAR_SCALE` stars, whole-number division"); you do not need an inner loop |
| `FOR i FROM a TO b` ... `END FOR` | counted loop; **both a and b are included**, and indexes start at 0 |
| `WHILE condition` ... `END WHILE` | loop that ends when the condition is false, such as `WHILE the file has another number` |
| `IF ... THEN` / `ELSE IF ... THEN` / `ELSE` ... `END IF` | decisions, tested top to bottom; **the first true test wins**; `THEN` is required on every `IF` and `ELSE IF` |
| `#` | a comment line; use it for the trace |

Array elements (`counts[b]`) and simple formulas (`LOW + b * WIDTH`) are fine. Use the same names in your pseudocode that you will use in your Java.

**Order of work.** (1) *Input / Process / Output:* write what comes in and what must come out. (2) *Data:* list each array and variable with a meaningful name, its type in plain words, its size, what each index means, and its starting value. (3) *Outline, then refine:* write the main steps first, then expand each one until every line is something you could do without having to make up a rule. Keep all lines at about the same level of detail. (4) *Trace it:* see below.

**Worked example on a different problem.** *A file holds the lengths in mm of 40 machined parts, each at least 100.0 and below 105.0. Report which part is the longest and how long it is, and count the parts in each 1 mm length class.*

```
INPUT   parts file: 40 lengths in mm, one per line
OUTPUT  console: number and length of the longest part, the class counts,
        then the long and short counts

DATA
  partLen     array of 40 decimal numbers; index i = part number i + 1
  classCount  array of 5 whole numbers, all start at 0;
              index c = parts from 100 + c up to, not including, 101 + c mm
  n           whole number, parts loaded so far, starts at 0
  best        whole number, index of the longest part so far, starts at 0
  c           whole number, class index of one part
  longCount, shortCount   whole numbers, parts 104.0 or longer / under 101.0, start at 0

STEPS
  1. Load the lengths
       OPEN the parts file
       WHILE the file has another number
           READ partLen[n] FROM the file
           SET n TO n + 1
       END WHILE
       CLOSE the file
  2. Find the longest (start at 1; index 0 is already best)
       SET best TO 0
       FOR i FROM 1 TO 39
           IF partLen[i] > partLen[best] THEN
               SET best TO i
           END IF
       END FOR
       WRITE best + 1 and partLen[best] to the console
  3. Count the classes
       FOR i FROM 0 TO 39
           SET c TO partLen[i] - 100, decimal part cut off
           SET classCount[c] TO classCount[c] + 1
           IF partLen[i] >= 104.0 THEN
               SET longCount TO longCount + 1
           ELSE IF partLen[i] < 101.0 THEN
               SET shortCount TO shortCount + 1
           END IF
       END FOR
       WRITE classCount, longCount, and shortCount to the console

# (40 and 39 are given by the problem. In Q2 your sizes come from NUM_BINS, not typed numbers.)

# TRACE with 4 parts (loops end at 3): 101.2, 103.7, 100.4, 103.9
# step 2: best 0 -> 1 (103.7 beats 101.2) -> stays 1 (100.4) -> 3 (103.9). Prints part 4, 103.9.
# step 3: c = 1, 3, 0, 3, so classCount = 1, 1, 0, 2, 0. Matches the 4 parts.
#         longCount 0 (no part reaches 104.0); shortCount 1 (100.4).
```

**Trace it before you start the Java.** Pick 4 or 5 actual values (from the data file, or a tiny made-up set that includes the awkward cases), follow your pseudocode on them by hand, line by line, through every step that handles a reading and through the final report or search, and write the result at the bottom of the file in `#` comment lines like the example: what each value does, then the final totals. If the trace shows a bug, fix the pseudocode first. Comments explain *why*.

**Good, vague, and code-like.** Compare three ways to write step 2:

- **Good:** the step as written above: bounds stated, what is compared, what is remembered.
- **Too vague:** "Find the longest part." No loop, no comparison, nothing remembered, so nothing has been planned. Also vague: "put each part in the right class" with no rule for which class.
- **Too code-like:** `for (int i = 1; i < partLen.length; i++) { if (partLen[i] > partLen[best]) best = i; }` That is Java. If you could paste it into a program unchanged, it is not pseudocode.

**Creating and submitting the file in IntelliJ and GitHub Desktop.** The file must be a plain `.txt` file, because it opens on any computer (Windows or Mac) with no special software.

1. Check that you have already done **Refactor → Copy...** so that the package `student.assignments.A07` exists in your project. If it does not, stop and do that first.
2. In the Project panel, expand `src` → `main` → `java` → `student` → `assignments` and right-click **`A07`** (the one under `student.assignments`).
3. Choose **New → File**. In the box that appears, type exactly `Assignment7_Q2_pseudocode.txt` and press Enter. If IntelliJ asks whether to add the file to Git, click **Add**.
4. The file opens in the editor. Write your pseudocode and save.
5. **Do NOT create the file in the `instructor` package**, and do not put it in the project's `data` or `output` folders. Check the Project panel: the file must appear directly under `student.assignments.A07`, next to your Java files.
6. Open **GitHub Desktop**. The new file appears in the list of changed files. Leave it checked so it is committed and pushed along with your Java files.

### What You May Use

The concepts you can use on this assignment are:

- **Arrays**: one-dimensional and two-dimensional arrays of `int`, `double`, and `String`; creating them with `new type[size]` and `new type[rows][cols]`; creating them with a braces list; `arrayName[i]`; `arrayName.length`; `arrayName[i].length` for a 2D array; `Arrays.toString()` (requires `import java.util.Arrays;`)
- **File input**: `FileInputStream`, `Scanner` (wrapped around a `FileInputStream`), `throws FileNotFoundException`
- **File output**: `PrintWriter`, `print()`, `println()`, `printf()`, `close()`
- **Scanner**: `nextInt()`, `nextDouble()`, `hasNextInt()`, `hasNextDouble()`, `close()`
- **Output**: `printf()` with `%s`, `%d`, `%f`, `%n`, `%%`, and widths and precisions such as `%5d`, `%-8s`, and `%.2f`
- **Strings**: `+` for concatenation and `repeat()`
- **Casting**: `(int)` and `(double)`
- **Operators**: `+ - * / %`, `=`, `==`, `!=`, `>`, `<`, `>=`, `<=`, `&&`, `||`, `!`, `++`, `--`, `+=`
- **Branching**: `if`, `else if`, `else`, and nested `if`
- **Loops**: `while`, and `for` (including nested loops)
- **Constants**: `final` variables

We have **not** covered the following, and solutions that rely on them will not receive credit: any `java.util` class other than `Scanner` and `Arrays`, `Arrays.sort`, `Arrays.fill`, `Arrays.copyOf` and the other `Arrays` methods besides `toString`, `System.arraycopy`, the enhanced (for-each) `for` loop, `split()`, `try`/`catch`, the conditional (ternary) `?:` operator, `do`-`while` loops, `continue`, the `File` class, `Math` methods (you do not need any), and methods you write yourself other than `main`.

Everything in this assignment is done with loops and `if` statements over arrays. If an array is out of range, the fix is a correct `if` check, not a `try`/`catch`.

------

## Question 1 - Which Cycles Are Slow?

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I print the elements of a `double` array on one line?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the loops or the array code.

A pick-and-pack station is timed on 25 consecutive cycles, and the times (in seconds) are logged. The supervisor wants to know which cycles were unusually slow **compared with the station's own average**. That takes two passes over the data: you cannot say how far a cycle is from the average until you know the average. So the times have to be kept in an array.

`a07_cycleTimes.txt` begins with the number of cycles, and then the times themselves:

```
25
42.4
42.0
43.4
...
```

Work in `Assignment7_Q1`. The constant `SLOW_MARGIN` is already declared.

**a.** Create a `Scanner` on the file. Read the first value with `nextInt()` (that is `n`, the number of cycles) and create a `double` array `cycle` with exactly `n` elements. Fill it from the file with a `while` loop driven by `hasNextDouble()` and a separate index counter (declare `int i = 0` before the loop, store into `cycle[i]`, and do `i++` inside the loop; the file has exactly `n` times, so you do not need to guard against more). Close the `Scanner`. Then print to the console, using `printf` for the first line (print the number of cycles read from your counter `i`) and `Arrays.toString` for the second:

```
Cycles read: 25
[42.4, 42.0, 43.4, 40.8, 42.1, 49.6, ...]
```

(The rest of that second line is your array's remaining 19 values; a correct program prints all 25 on that one line.)

**b.** Use a `for` loop over `cycle.length` to find the mean cycle time, keep it in a `double` variable `mean` (you need it again in part c), and print it with `printf`. A correct program prints:

```
Mean cycle time: 43.22 seconds
```

**c.** Create two more arrays with `n` elements each: a `double` array `dev` and an `int` array `slowFlag`. In a `for` loop, set `dev[k]` to how far cycle `k` is from the mean (`cycle[k] - mean`, so a cycle faster than average is negative). If `dev[k]` is **greater than** `SLOW_MARGIN`, set `slowFlag[k]` to `1`. Do **not** put a `0` into `slowFlag` anywhere. An `int` array is already full of zeros when it is created, and that is the point. Print `Arrays.toString(slowFlag)` once, right after you create it, to see what it holds, then delete that line.

**d.** Create a `PrintWriter` for `output/a07_cycleReport.txt`. Write this header, then one row per cycle with `"%5d %9.1f %10.2f  %s%n"`, giving the cycle **number** (the first cycle is cycle 1, not cycle 0), its time, its deviation, and the text `SLOW` if `slowFlag` is `1`, otherwise `ok`. Close the `PrintWriter`. The first rows of a correct file are:

```
Cycle  Time (s)  Deviation  Flag
    1      42.4      -0.82  ok
    2      42.0      -1.22  ok
    3      43.4       0.18  ok
```

**e.** Find the slowest cycle: the one with the largest deviation, remembering its **index** as well as its value. Start your "best" index at `0` and loop from `k = 1`, asking `dev[k] > dev[best]` (if two cycles tie, the earlier one wins; this follows from using `>`). Count the slow cycles over **all** cycles, starting at `k = 0` (the 1s in `slowFlag`); use a separate loop for this, because the slowest-cycle search and the neighbour count start at `k = 1`. Also count how many cycles took longer than the cycle **immediately before** them (compare `cycle[k]` with `cycle[k - 1]`); cycle 1 has no cycle before it, so it cannot be one of them. Print to the console with `printf`:

```
Slow cycles: 4 of 25
Slowest cycle: 14 (51.8 s, 8.58 s above the mean)
Cycles longer than the one before: 13
```

**f.** Run the program. Open `output/a07_cycleReport.txt` and check it. Record the full console output (as `//` comment lines), plus the header and first three rows of the report, in the comment block at the top of the file. Then answer the three written questions in that block: what `Arrays.toString(slowFlag)` shows right after you create it and which rule from the T13 Arrays chapter explains that; why the deviations cannot be found in a single pass through the file the way a running total can; and what index `cycle[k - 1]` would ask for if the loop started at `k = 0`, what happens, and what you started `k` at instead.

------

## Question 2 - A Histogram of Bottle Fill Volumes

**AI Usage**: **Part a (the pseudocode) must be entirely your own work: no AI of any kind, not even for wording or syntax-style help.** For the Java in parts b through f, AI is allowed for general Java syntax questions only (e.g., "What does casting a `double` to `int` do to the decimal part?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the counting or bucket logic. Do not give AI your pseudocode either.

A bottling plant fills bottles to a nominal 500.0 mL. A quality engineer wants to see the **shape** of the fill volumes in one sample of 300 bottles: where the readings pile up, how spread out they are, and how many are far from nominal. The standard picture is a **histogram**: divide the range of volumes into equal-width bins, and count how many readings land in each bin.

`a07_fillVolumes.txt` holds the 300 readings in mL, one per line, with no count at the top and no other text:

```
501.8
500.7
497.7
...
```

Work in `Assignment7_Q2`. The constants `LOW`, `WIDTH`, `NUM_BINS`, and `BAR_SCALE` are already declared. The bins are `WIDTH` = 2.0 mL wide, there are `NUM_BINS` = 10 of them, and bin 0 starts at `LOW` = 490.0. So bin 0 holds volumes from 490.0 up to but not including 492.0, bin 1 holds 492.0 up to but not including 494.0, and so on up to bin 9, which stops just short of 510.0. A volume exactly on a boundary belongs to the bin that **starts** there (492.0 is in bin 1).

A reading can also land outside all ten bins. Those readings are not part of any bin: you count them separately as `below` (less than 490.0) and `above` (510.0 or more). Declare `int total = 0`, `int below = 0`, and `int above = 0` before you start reading.

**a. Pseudocode first.** Before you write any Java, create `Assignment7_Q2_pseudocode.txt` in `student.assignments.A07` (see "Planning With Pseudocode" above for the style, the keywords, the trace, and the click-by-click steps for creating and submitting the file). Plan the whole program for parts b through e. The file must show:

- **Input / Output and Data:** what comes in and what goes out, then a data list. It has two arrays, each with its name, type, size (in terms of `NUM_BINS`), what an index means, and what the elements hold at the start; also `total`, `below`, `above`, `HIGH`, the loop variable `b`, and the fullest-bin variable, with starting values (an array that is filled by a loop may say "filled in step 1"). Put the given constants `LOW`, `WIDTH`, `NUM_BINS`, `BAR_SCALE` on one line marked as given, and `SET` `HIGH` in a step before the reading loop.
- **Loops:** the loop that fills the bin edges and the loop that reads the file, each with its bounds or its stopping condition, and what one pass does. Also the loop that writes the report rows and the loop that searches for the fullest bin.
- **Decisions:** what is done with each reading, in the order the tests are made, including how a reading becomes a bin number and what happens to a reading that belongs to no bin.
- **What is written at the end:** the columns of each report row, and the lines printed to the console (one line is enough for "find the fullest bin").
- **A trace:** 4 or 5 readings followed by hand through your plan (include one that belongs to no bin and one exactly on a bin boundary), with the result recorded in `#` lines at the bottom (what each reading does, then the final `total`, `below`, `above`, and `counts`).

Size the arrays from the constants described above, not from the data file.

**b.** Create two arrays, each with `NUM_BINS` elements: an `int` array `counts` (readings per bin) and a `double` array `binLow` (the low edge of each bin). Fill `binLow` with a `for` loop: `binLow[b] = LOW + b * WIDTH`. Leave `counts` alone; it starts at zero. These two arrays are **parallel arrays**: element `b` of each describes bin `b`.

**c.** Create a `Scanner` on the file and read it with a `while` loop driven by `hasNextDouble()`. Do **not** store the readings. For each reading `v`:

- add one to `total`
- if `v` is less than `LOW`, add one to `below`
- else if `v` is `HIGH` or more, where `HIGH` = `LOW + NUM_BINS * WIDTH` (that is 510.0; compute it once, before the loop), add one to `above`
- otherwise the reading belongs in bin number `(int) ((v - LOW) / WIDTH)`; add one to `counts` at that index

Close the `Scanner` when the loop ends. The order of the tests matters. Think about what the bin index would be for 489.6 and for 510.0 if either test were missing.

**d.** Create a `PrintWriter` for `output/a07_fillHistogram.txt`. Write this header, then one row per bin with `"%5.1f-%5.1f %8d %8.2f  %s%n"`, giving the bin's low edge, its high edge (`binLow[b] + WIDTH`), its count, its percent of **all** readings, and a bar made of `"*".repeat(counts[b] / BAR_SCALE)` (one star for every 5 readings; `int` division rounds down). Percents come from `100.0 * counts[b] / total`, so the division keeps its decimals. Close the `PrintWriter`.

```
Volume (mL)    Count  Percent
490.0-492.0        1     0.33  
492.0-494.0        6     2.00  *
494.0-496.0       14     4.67  **
```

(The first row's bar is empty, so that line ends with two spaces.)

**e.** Find the fullest bin: the one with the largest count, remembering its **index** (ties go to the lower bin; start the "best" index at `0` and loop from `b = 1`, asking `counts[b] > counts[best]`). Print to the console, using `printf` for each line and `Arrays.toString(counts)` for the array line:

```
Readings: 300
Below 490.0: 3
At or above 510.0: 4
[1, 6, 14, 36, 91, 82, 44, 13, 5, 1]
Fullest bin: 498.0-500.0 (91 readings)
Histogram written to output/a07_fillHistogram.txt
```

Take the 490.0, the 510.0, and the bin edges in those lines from your variables and constants, not typed in, and print each with one decimal (`%.1f`). (Only the last line, the file name, is typed text.)

**f.** Run the program, open `a07_fillHistogram.txt` and check it against the numbers above. Then record the full console output and the header and first three rows of the file in the comment block at the top of the starter file, and answer the four written questions in that block: whether the histogram is centered on the nominal 500.0 mL and roughly symmetric (one sentence); what `(int) ((489.6 - 490.0) / 2.0)` evaluates to, which bin 489.6 would be wrongly counted in without the "below `LOW`" test, and why 487.3 behaves differently; what happens, and on which kind of reading, if you leave out the test for readings at or above the top of the last bin; and which lines would change for 40 bins, and why doing this without an array would be a poor choice.

------

## Question 3 - A Downtime Grid

**AI Usage**: AI allowed for general Java syntax questions only (e.g., "How do I get the number of columns of a 2D array?"), completely independent of this assignment. NOT allowed: describing this scenario to AI, or asking it to write the nested loops, the totals, or the table code.

A machine shop logs the minutes of unplanned downtime for 8 machines over 10 production days. The result is a table: one row per machine, one column per day. The maintenance supervisor wants the total for each machine, the total for each day, and the table printed with those totals. A grid like this is a **2D array**, and the totals need nested loops. The report cannot print a machine's total at the end of its row until the whole row has been added up, and it cannot print the column totals until every row has been read, so the grid has to be stored.

`a07_downtime.txt` begins with two numbers, the number of rows (machines) and the number of columns (days), followed by one line of downtime per machine:

```
8 10
 28  48  20  21  23  62  38  24  22  26
 48  30  16  24  36  76  14  31  24  26
...
```

Work in `Assignment7_Q3`. There are no constants to declare. The rows of the file are, in order: Lathe 1, Lathe 2, Mill 1, Mill 2, Drill 1, Drill 2, Press 1, Press 2.

**a.** Create a `String` array `machines` with a braces list holding the 8 names above, in that order. Create a `Scanner` on the file. Read the number of rows and the number of columns with `nextInt()`, create an `int[][]` named `down` with that many rows and columns, and fill it with nested `for` loops (rows on the outside, columns on the inside) that read one `nextInt()` per cell. Use `down.length` and `down[i].length` as the loop bounds. Close the `Scanner`.

**b.** Print to the console with `System.out.println` (build the first line with `+`) and `Arrays.toString`:

```
Machines: 8, days: 10
Lathe 1 row: [28, 48, 20, 21, 23, 62, 38, 24, 22, 26]
Press 2 row: [36, 37, 27, 30, 36, 57, 25, 28, 34, 2]
```

The two row lines are the **first** and the **last** row of the grid. A row of a 2D array is a 1D array, so `down[0]` is the whole first row. For the last row, build the index from the number of rows (`down.length - 1`); do not type in `7`.

**c.** Create two `int` arrays: `rowTotals` with one element per machine, and `colTotals` with one element per day. Do not fill them; they start at zero. With **one** set of nested loops over the grid, add every cell into its machine's total, into its day's total, and into a grand total (an `int` variable, `grand`).

**d.** Create a `PrintWriter` for `output/a07_downtimeReport.txt` and write a table with three kinds of lines:

- The header line: `"%-8s"` for the word `Machine`, then `"%5s"` for `D1`, `D2`, ... `D10` (build each label as `"D" + (j + 1)` inside a loop), then `"%7s"` for `Total` followed by a line break. Use `printf("%7s%n", "Total")` for that last piece.
- One line per machine: `"%-8s"` for its name, `"%5d"` for each day's downtime, then `"%7d"` and `%n` for its row total.
- A last line: `"%-8s"` for the word `Total`, `"%5d"` for each column total, then `"%7d"` and `%n` for the grand total.

Close the `PrintWriter`. The first two lines of a correct file are:

```
Machine    D1   D2   D3   D4   D5   D6   D7   D8   D9  D10  Total
Lathe 1    28   48   20   21   23   62   38   24   22   26    312
```

**e.** Find the worst machine (the largest row total) and the worst day (the largest column total), remembering the **index** of each. Ties go to the earlier one: start each "best" index at `0`, loop from `1`, and use `>`. Print to the console with `printf`:

```
Grand total downtime: 2840 minutes
Worst machine: Press 1 (581 minutes)
Worst day: D6 (567 minutes)
```

The day label is `D` followed by the day number, and the day number is the index plus 1.

**f.** Run the program. Open `output/a07_downtimeReport.txt` and check it against your console output (the last number on the Total line must equal the grand total). Record the full console output, plus the header line and the Total line of the report, in the comment block at the top of the file.

**g.** Answer the written questions in the comment block at the top of the starter (they are printed there): which machine and which day stand out, and what the two index-bound mistakes described there would do (crash, or quietly wrong totals).

------

## Submission Guidelines

1. **Code**: Push all three Java files (under `student.assignments.A07`) to your fork's main branch.
2. **Comments**: Every question asks for recorded results or written answers in comments. A program that runs correctly but is missing its recorded results will not receive full credit.
3. **Due Date**: Friday, October 16, 2026 at 5:00 PM.

------

## AI Use Disclosure

Anthropic. (2026). Claude Code (Sonnet 5.5) [Large language model]. https://claude.com/claude-code

Claude Code was used to draft, revise, and design this assignment, including content review, formatting, and the generation of the data files.
