# INEG 22104 Course Repository

This is the course repository for INEG 22104 (Fall 2026). It contains two things: the non-code course materials, and a single shared Java project used for all in-class demos, assignments, and exams.

## What's in this repo

### `Course Materials/`

Non-code content, organized by type:

- **`Slides/`** — Lecture slide decks, one folder per topic (e.g. `T02IntroToJava/`, `T03Variables/`).
- **`Primer Book/`** — Written primers for each topic, built into a single browsable book with [mdBook](https://rust-lang.github.io/mdbook/). Open `Primer Book/Open Primer Book.html` to read it.
- **`Syllabus/`** — The course syllabus.
- **`Semester Calendar/`** — The semester calendar (dates for zyBooks, assignments, reflections, quizzes, and exams).
- **`Setup Guides/`** — Step-by-step guides for setting up IntelliJ, Git, and GitHub Desktop.
- **`assets/`** — Shared CSS and embedded webfonts used when generating the Slides. The Primer Book is built by mdBook and uses its own styling. Not something you need to open directly.

### `Code/`

A single Gradle/IntelliJ project (`Code/`) shared by everyone in the course, rather than a separate project per topic. Inside it, source code is split into two top-level Java packages:

```
Code/src/main/java/
├── instructor/
│   ├── demo/                 T01CreateFirstClass, T02IntroToJava, T03Variables, ...
│   ├── practiceActivities/
│   ├── assignments/
│   └── exams/
└── student/
    ├── demo/
    ├── practiceActivities/
    ├── assignments/
    └── exams/
```

`instructor.*` holds the starter code the instructor pushes to the repo throughout the semester. `student.*` is where you do your own work.

## What you should and shouldn't modify

**Don't edit anything under `instructor.*` in `Code/`, or anything under `Course Materials/`.** Those are instructor-owned, updated regularly throughout the semester, and always pulled from the shared upstream repo. If you edit a file there and it's later updated by the instructor, you'll get a merge conflict the next time you sync your fork.

**Only do your own work under `student.*` in `Code/`.** As long as everything you write lives there, syncing and pulling new content from the instructor will never conflict with your work.

### Getting a topic's starter code into your own package

When the instructor adds new content (a new demo, assignment, or exam) under `instructor.*`:

1. Sync your fork on GitHub.com, then pull in GitHub Desktop.
2. In IntelliJ, right-click the new package under `instructor.*` and choose **Refactor → Copy...** (not Move, and not a plain cut/paste).
3. Set the destination to the matching package under `student.*` (e.g. `instructor.demo.T04SomeTopic` → `student.demo.T04SomeTopic`).

See `Course Materials/Setup Guides/` for help with the initial fork/clone/sync setup.
