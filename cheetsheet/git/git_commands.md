# THE ULTIMATE DEVELOPER GIT CHEAT-SHEET
> **Reference:** [Official Git Documentation](https://git-scm.com/cheat-sheet)



---

### 1️⃣ CHECK CURRENT STATE
| Command                | Description                           |
|:-----------------------|:--------------------------------------|
| `git status`           | Shows modified files, staged/unstaged |
| `git diff`             | Shows exact line changes in files     |
| `git diff --name-only` | Shows file names with changes         |
| `git diff --cached`    | Shows changes staged for next commit  |

**Example `diff --name-only` Output:**
* `fileA.java`
* `fileB.java`

---

### 2️⃣ STAGING & COMMITTING
* **Stage a single file:** `git add fileA.java`
* **Stage all files:** `git add .`
* **Commit:** `git commit -m "Commit message"`
* **Amend last commit:** `git commit --amend --no-edit` (Fix typo/add forgotten file)
* **Push:** `git push`

---

### 3️⃣ VIEW COMMIT HISTORY
* **Brief History:** `git log --oneline`
    * *Example:* `a12bc34 Fix login bug`
* **Visual Graph:** `git log --oneline --graph --all`
* **Last Commit Details:** `git show HEAD`
* **Unpushed Commits:** `git log --oneline origin/main..HEAD`

---

### 4️⃣ UNDO LOCAL COMMITS (NOT PUSHED)
* `git reset --soft HEAD~1` — Undo last commit, **keep** changes staged.
* `git reset HEAD~1` — Undo last commit, **unstage** changes.
* `git reset --hard HEAD~1` — ⚠️ **Warning:** Deletes commit + code. Use only if sure.

---

### 5️⃣ UNDO PUSHED COMMITS (SAFE)
* `git revert HEAD` — Create new commit that reverses last commit.
* `git revert a12bc34` — Revert a specific commit.

---

### 6️⃣ BRANCHING & NAVIGATION


* **List Branches:** `git branch`
* **New Branch:** `git checkout -b feature/login` (or `git switch -c feature/login`)
* **Switch Branch:** `git checkout main` (or `git switch main`)
* **Delete Branch:** `git branch -d feature/name`

---

### 7️⃣ MERGE & REBASE
* **Merge:** `git merge feature/login` (Combines work)
* **Interactive Rebase:** `git rebase -i HEAD~3` (Clean last 3 commits)
    * `pick` -> keep
    * `drop` -> remove
    * `squash` -> combine
* **Force Push:** `git push --force` (⚠️ Use only on your own branch)

---

### 8️⃣ STASHING (TEMPORARY STORAGE)
* **Save:** `git stash`
* **List:** `git stash list`
* **Restore & Remove:** `git stash pop`
* **Apply without removing:** `git stash apply`

---

### 9️⃣ FILE RECOVERY
* **Discard changes in file:** `git restore fileA.java`
* **Unstage a file:** `git restore --staged fileA.java`
* **Recover lost commits:** `git reflog` (The ultimate undo history)

---

### 🔟 CHERRY-PICK & TAGS
* **Cherry-pick:** `git cherry-pick a12bc34` (Grab one specific commit from another branch)
* **Create Tag:** `git tag v1.0.0`
* **Push Tag:** `git push origin v1.0.0`

---

### 1️⃣1️⃣ CLEANUP & SYNC
* **Fetch:** `git fetch` (Download remote changes only)
* **Pull:** `git pull` (Fetch + Merge)
* **Clean Preview:** `git clean -n` (See what will be deleted)
* **Clean Delete:** `git clean -f` (Delete untracked files)

---

### 🏆 GOLDEN RULES
* ✅ **Status First:** Always check `git status` before any operation.
* ✅ **Safe Undos:** Use `revert` for pushed commits; use `reset` only for local.
* ✅ **Atomic Commits:** One commit = one task/fix.
* ✅ **No Force on Main:** Avoid force pushing on shared/production branches.
* ✅ **Git is a Time Machine:** Mistakes can usually be fixed via `reflog`.