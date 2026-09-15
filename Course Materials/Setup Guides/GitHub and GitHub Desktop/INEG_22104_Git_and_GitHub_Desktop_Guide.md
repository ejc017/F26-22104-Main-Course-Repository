## INEG 22104: Computing Methods for Industrial Engineers I
  
**University of Arkansas**  
**Fall 2026**  
**Git and GitHub Desktop Guide**  
**Updated August 17, 2026**  
This guide explains how we will use Git and GitHub Desktop in INEG 22104. The course organization is `INEG-22104-Fall-2026`, and the main course repository is `F26-22104-Main-Course-Repository`. The goal is simple: the course repository is where I release material, and your fork is where you keep and submit your own work. You will not submit pull requests back to the course repository.  
The screens you see on GitHub or in GitHub Desktop may look a little different from the screenshots shown in class or in vendor documentation. Vendors redesign pages often, so look for the same labels rather than the same colors or exact layout.

### Before we begin: what are Git, GitHub, and GitHub Desktop?

Throughout this course, you will use three related tools:

<table>
<tr><th>Tool</th><th>What it does</th></tr>
<tr><td>Git</td><td>Keeps track of changes to files over time. Think of it as an unlimited undo system that records snapshots of your work.</td></tr>
<tr><td>GitHub</td><td>Stores Git repositories online so they can be backed up, shared, and reviewed.</td></tr>
<tr><td>GitHub Desktop</td><td>A graphical application that allows you to use Git without typing commands into a terminal.</td></tr>
</table>

For this course, you do not need to become a Git expert. We will use Git and GitHub for three practical reasons:

1. To keep your work backed up.
2. To make it easy for me to distribute course materials.
3. To allow the teaching team to review and grade your work directly.

#### A real-world analogy

Think of GitHub as a cloud folder that keeps a complete history of your work.

Imagine that I handed every student a three-ring binder at the beginning of the semester.

- The instructor section contains notes, examples, assignments, and course materials.
- The student section contains your own work.
- Whenever I add new course materials, everyone receives the update.
- Your work remains separate from everyone else's work.

Git and GitHub provide a similar experience, except everything is stored electronically and every change can be recorded.

#### Four important concepts

Before working with the repository, make sure you understand these ideas.

**Repository**

A repository, often called a repo, is a folder whose contents are tracked by Git.

In this course, the main repository is:

```text
F26-22104-Main-Course-Repository
```

This repository contains course materials and serves as the starting point for every student.

**Fork**

A fork is your own copy of a repository.

You will create a fork of the course repository. After creating a fork, there will be an instructor repository and your own fork:

```text
Instructor repository:
F26-22104-Main-Course-Repository

Your fork:
F26-22104-Main-Course-Repository-YourGitHubUsername
```

Your fork belongs to you. The teaching team can review it, but your fork is the place where your work lives.

**Clone**

A clone is a copy of a repository that lives on your computer.

After creating your fork on GitHub, you will use GitHub Desktop to clone the fork to your laptop:

```text
GitHub: your fork
Your computer: local clone
```

You will do most of your work in the local clone on your own computer.

**Commit**

A commit is a saved checkpoint.

Every time you reach a meaningful stopping point, Git allows you to create a commit. Think of a commit as saying:

> Save a snapshot of my work so I can return to it later if needed.

When you create a commit, the snapshot is stored locally on your computer. When you push, the snapshot is uploaded to GitHub.

#### The workflow you will use every week

For most assignments, your workflow will look like this:

```text
1. Sync your fork
2. Pull updates to your computer
3. Work in your personal folder
4. Commit your changes
5. Push to GitHub
6. Verify your work appears in your fork
```

That is the entire workflow we will use for most of the semester.

#### What you need to remember

If you remember only three things from this guide, remember these:

1. The instructor repository is where course materials originate.
2. Your fork is where your work is stored and graded.
3. Keep all of your work inside your personal folder under `student/`.

If you follow those three rules, Git and GitHub will be much easier to use.

### What you will do

<table>
<tr><th>Part</th><th>What you are doing</th><th>What you turn in</th></tr>
<tr><td>Part 1. Confirm access</td><td>Accept the course organization invitation and confirm that you can see the course repository</td><td>Nothing, but do this before class work begins</td></tr>
<tr><td>Part 2. Fork the course repository</td><td>Create your own copy of the course repository in your GitHub account</td><td>Your fork becomes the place where your work lives</td></tr>
<tr><td>Part 3. Clone your fork</td><td>Use GitHub Desktop to download your fork to your computer</td><td>Nothing, but the local folder is where you will edit files</td></tr>
<tr><td>Part 4. Work in your own folder</td><td>Create a personal folder under student/ and do all course work there</td><td>Your committed and pushed files in your personal folder under student/</td></tr>
<tr><td>Part 5. Sync when new course content is posted</td><td>Update your fork from the course repository, then pull the update in GitHub Desktop</td><td>Nothing, but do this whenever I announce new material</td></tr>
<tr><td>Part 6. Keep main current</td><td>Commit and push your assignment work to the main branch of your fork</td><td>The teaching team grades the main branch of your fork</td></tr>
</table>

### The course repository model

The course repository belongs to the `INEG-22104-Fall-2026` course organization. The repository is named `F26-22104-Main-Course-Repository`, and it is the main source of course material. Inside the repository, there are two important areas:

- `instructor/` is for course notes, examples, starter files, assignment descriptions, and other material that I provide. Do not edit files in this folder unless I explicitly tell you to do so.
- `student/` is the area where student work belongs. Inside your fork, create your own personal folder under `student/` and put all of your course work there. A good folder name is your GitHub username, because that makes the folder easy for the teaching team to identify.

You will create a fork of the course repository. A fork is your own copy of a repository. GitHub describes a fork as a new repository that shares code and visibility settings with the original upstream repository, and forking lets you work without affecting the upstream repository.[^forkdocs] In this course, the upstream repository is the course repository. Your fork is the copy under your GitHub account.

The important rule is this: **do not send pull requests back to the course repository unless I explicitly ask you to.** The teaching team will look at the main branch of your fork when grading. The course repository stays clean, and each student has a separate workspace. Within your workspace, keep your own work inside your own folder, such as `student/your-github-username/`.

### Best practice: keep your work isolated from the base structure

The first practice for the course is to do all of your work in a folder that does not interact with the base structure of the course repository in any manner. This greatly reduces the chance of conflicts when you sync new course material.

For example, after cloning your fork, create a personal folder inside `student/`:

```text
student/
  your-github-username/
    Assignment01/
    Assignment02/
    Practice/
    Notes/
```

If the instructor does not put anything in a folder with the same name, Git will rarely have a reason to report a conflict involving your work. For that reason, I recommend using your GitHub username as the folder name. For example:

```text
student/
  homer-simpson/
```

Think of the repository as a textbook and notebook combined into one folder structure. The `instructor/` folder is the textbook. Your personal folder inside `student/` is your notebook. Treat everything outside your personal folder as instructor-managed content. Treat everything inside your personal folder as your workspace.

### Part 1. Confirm your GitHub Desktop installation

1. Download and install GitHub Desktop from the official GitHub Desktop download page if you have not already installed it.[^desktop]
2. Open GitHub Desktop.
3. Sign in with the same GitHub account that you gave me for INEG 22104.
4. If GitHub Desktop asks to configure Git, accept the defaults unless you already know you need something different.
5. Keep GitHub Desktop installed on the computer that you bring to class.

### Part 2. Confirm your course organization access

6. Go to GitHub in a browser and sign in.
7. If you received an invitation to the INEG 22104 organization, accept it. GitHub organization invitations must be accepted before the invitation expires.
8. Click your profile picture in the upper-right corner of GitHub.
9. Choose **Your organizations**.
10. Confirm that you can see the `INEG-22104-Fall-2026` course organization.
11. Open the `INEG-22104-Fall-2026` organization and view its repositories.
12. Find the course repository named `F26-22104-Main-Course-Repository`.
13. If you cannot see the organization or the course repository, post in the course help channel or ask a TA before continuing.

### Part 3. Fork the course repository

14. Open `F26-22104-Main-Course-Repository` in GitHub.
15. Click **Fork** in the upper-right area of the repository page. GitHub's fork documentation shows this as the standard way to create a fork from the web interface.[^forkdocs]
16. When GitHub asks for the owner of the fork, choose **your personal GitHub account**, not the course organization.
17. Use a fork name that is easy to identify, such as `F26-22104-Main-Course-Repository-YourGitHubUsername`. Use the name or username the instructor and TAs will recognize from class, such as `F26-22104-Main-Course-Repository-homer-simpson`.
18. If GitHub offers an option to copy only the default branch, leave that option selected unless I tell you otherwise. GitHub notes that many forking scenarios only require the default branch.[^forkdocs]
19. Click **Create fork**.
20. After GitHub creates the fork, confirm that the repository page is under your GitHub username. The browser address should look like `github.com/your-username/F26-22104-Main-Course-Repository-YourGitHubUsername`.
21. Do not delete the fork or change its settings unless I ask you to.

### Part 4. Clone your fork with GitHub Desktop

22. While viewing your fork on GitHub, click the green **Code** button.
23. Choose **Open with GitHub Desktop**. GitHub's documentation also describes cloning a fork after it has been created.[^forkdocs]
24. When GitHub Desktop opens, choose a local path that you can find again. A folder such as `Documents/GitHub` is a good choice.
25. Click **Clone**.
26. If GitHub Desktop asks how you plan to use the fork, choose the option indicating that you are keeping the work for your own purposes rather than contributing to the parent repository. In this course, you will not submit pull requests to the course repository.
27. After the clone finishes, click **Repository**, then **Show in Explorer** on Windows or **Show in Finder** on macOS to confirm that the local folder exists on your computer.

### Part 5. Do your work only in your own folder

28. Open the cloned repository folder on your computer.
29. Open the `student/` folder.
30. Inside `student/`, create one folder for your own work. I recommend naming this folder with your GitHub username.
31. Put all assignments, labs, practice exercises, and personal notes inside your own folder.
32. Do not place work directly in the top level of `student/` unless I specifically tell you to do so.
33. Do not create files or folders that interact with the base structure of the course repository. Your personal folder should be separate from the instructor-managed structure.
34. Do not edit, move, rename, or delete files inside the `instructor/` folder. That folder exists so I can deliver notes, examples, starter code, and assignment materials to you.
35. If an assignment gives you a starter file in `instructor/`, copy the required file into the correct place inside your personal folder under `student/` before editing it, unless the assignment directions say something else.
36. If the instructor does not place files in a folder with the same name as your personal folder, then your work should not conflict with future updates to the course repository.

### Part 6. Commit and push your work

37. In GitHub Desktop, select your cloned fork from the current repository menu.
38. Make sure the current branch is `main`.
39. After you add or edit files in your folder under `student/`, return to GitHub Desktop.
40. Review the list of changed files. Confirm that the changes are inside your personal folder under `student/`, not directly in `student/` and not in `instructor/`.
41. Type a short summary in the summary box. Examples: `Complete assignment 01 setup`, `Add loop practice files`, or `Update reflection code`.
42. Click **Commit to main**.
43. Click **Push origin**. This sends the commit from your computer to your fork on GitHub.
44. Open your fork in a browser and confirm that the latest files appear in your personal folder under `student/`.

### Part 7. Sync your fork when I post new material

When I announce that new course material is available, update your fork before you start working from those files.

45. Open your fork on GitHub in a browser.
46. Make sure you are on the `main` branch.
47. Click the **Sync fork** dropdown. GitHub's syncing documentation says that people with write access to a fork can use **Sync fork** to sync a fork to the upstream repository.[^syncdocs]
48. Review the update information.
49. Click **Update branch** if GitHub says your branch can be updated.
50. If GitHub reports a conflict, stop and ask for help before clicking anything else. Conflicts usually mean the same file changed in both your fork and the course repository.
51. After the web update finishes, open GitHub Desktop.
52. Select your fork.
53. Click **Fetch origin**.
54. If GitHub Desktop says there are changes to pull, click **Pull origin**.
55. Confirm that new course material appears in the local `instructor/` folder or elsewhere in the instructor-managed structure.

### Part 8. What the teaching team will grade

The teaching team will grade the main branch of your fork. Your fork should remain under your GitHub account. I will add myself and the TAs to the grading workflow. If GitHub sends you a collaborator or access-related notification from the teaching team, accept it promptly.

Before an assignment deadline, check the following:

- Your fork is visible under your GitHub account.
- Your current work is committed to `main`.
- You clicked **Push origin** after the final commit.
- The files to be graded are inside your personal folder under `student/`.
- You did not edit the `instructor/` folder or the base structure of the course repository.
- You did not open a pull request back to the course repository.

### Common vocabulary

<table>
<tr><th>Term</th><th>What it means in this course</th></tr>
<tr><td>Course organization</td><td>The GitHub organization named INEG-22104-Fall-2026.</td></tr>
<tr><td>Course repository</td><td>The main repository where I release course material. The repository is F26-22104-Main-Course-Repository.</td></tr>
<tr><td>Fork</td><td>Your copy of F26-22104-Main-Course-Repository under your GitHub account.</td></tr>
<tr><td>Local clone</td><td>The copy of your fork stored on your computer and managed with GitHub Desktop.</td></tr>
<tr><td>Origin</td><td>The Git remote that points from your local clone to your fork on GitHub.</td></tr>
<tr><td>Upstream</td><td>The original course repository from which your fork was created.</td></tr>
<tr><td>Main branch</td><td>The branch the teaching team will grade unless I announce otherwise.</td></tr>
<tr><td>Commit</td><td>A saved checkpoint in Git.</td></tr>
<tr><td>Push</td><td>Sending your local commits to your fork on GitHub.</td></tr>
<tr><td>Pull</td><td>Downloading commits from your fork on GitHub to your local computer.</td></tr>
<tr><td>Sync fork</td><td>Updating your fork with new changes from the course repository.</td></tr>
</table>

### If something goes wrong

<table>
<tr><th>If you run into this</th><th>Do this</th></tr>
<tr><td>You cannot see the course organization</td><td>Confirm that you accepted the invitation using the same GitHub account you gave me. If it still does not appear, ask for help.</td></tr>
<tr><td>You cannot see the course repository</td><td>Make sure you are signed in with the correct account and that you accepted the organization invitation.</td></tr>
<tr><td>You accidentally forked into the wrong owner</td><td>Stop and ask for help. Do not create multiple extra copies unless directed.</td></tr>
<tr><td>GitHub Desktop cloned the course repository instead of your fork</td><td>In GitHub Desktop, remove the incorrect local repository from the app only. Do not delete the files from your computer unless a TA or I tells you to. Then clone your fork instead.</td></tr>
<tr><td>You edited a file in instructor/</td><td>Do not push until you ask for help. The goal is to keep instructor-provided materials unchanged.</td></tr>
<tr><td>You put work directly in student/ instead of your own folder</td><td>Move the work into your personal folder under student/, then commit and push the corrected structure.</td></tr>
<tr><td>You committed but forgot to push</td><td>Open GitHub Desktop and click Push origin. A commit on your computer is not visible to the teaching team until you push it.</td></tr>
<tr><td>Sync fork reports conflicts</td><td>Stop and ask for help. Do not resolve the conflict by deleting files unless a TA or I tells you exactly what to do.</td></tr>
<tr><td>Your files are missing on GitHub</td><td>Check that the files were saved inside your personal folder under student/, committed to main, and pushed to origin.</td></tr>
</table>

### The basic routine

1. Open GitHub Desktop before you start working.
2. Click **Fetch origin** and pull if GitHub Desktop says there are updates.
3. If I announced new course material, sync your fork on GitHub first, then return to GitHub Desktop and pull.
4. Work in your personal folder under `student/`.
5. Commit your work with a meaningful summary.
6. Push origin.
7. Check your fork on GitHub before the deadline.

### References and AI use disclosure

[^desktop]: GitHub. (n.d.). *Download GitHub Desktop*. https://desktop.github.com/download/  
[^forkdocs]: GitHub Docs. (n.d.). *Fork a repository*. https://docs.github.com/fork-a-repo?tool=desktop  
[^syncdocs]: GitHub Docs. (n.d.). *Syncing a fork*. https://docs.github.com/en/pull-requests/how-tos/work-with-forks/syncing-a-fork  
Microsoft. (2026). *Microsoft Copilot* [Large language model]. https://copilot.microsoft.com. Microsoft Copilot was used in support of the creation of this guide.
