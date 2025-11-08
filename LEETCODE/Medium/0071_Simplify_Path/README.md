# 71. Simplify Path

## 🧩 Problem Description

Given an **absolute path** for a Unix-style file system (always starting with `/`),  
convert it into its **simplified canonical path**.

### Canonical Path Rules:

1. The path must start with a single `/`.
2. Directories are separated by exactly one `/`.
3. The path must not end with a `/` (unless it’s the root `/`).
4. `.` means **current directory** — ignore it.
5. `..` means **parent directory** — move up one level (pop from stack).
6. Multiple slashes `//` or `///` count as a single `/`.
7. Names like `...` or `....` are **valid directories**, not special symbols.

---

## 🔍 Example 1

**Input**

```

path = "/home/"

```

**Output**

```

"/home"

```

**Explanation**
Trailing slashes are removed.

---

## 🔍 Example 2

**Input**

```

path = "/home//foo/"

```

**Output**

```

"/home/foo"

```

**Explanation**
Multiple consecutive slashes are simplified into one.

---

## 🔍 Example 3

**Input**

```

path = "/home/user/Documents/../Pictures"

```

**Output**

```

"/home/user/Pictures"

```

**Explanation**
`..` goes up one directory level.

---

## 🔍 Example 4

**Input**

```

path = "/../"

```

**Output**

```

"/"

```

**Explanation**
Trying to go up from root is invalid — stay at `/`.

---

## 🔍 Example 5

**Input**

```

path = "/.../a/../b/c/../d/./"

```

**Output**

```

"/.../b/d"

```

**Explanation**
Here `"..."` is treated as a normal folder name, not a relative directory.

---

## ⚙️ Constraints

- `1 <= path.length <= 3000`
- `path` consists of letters, digits, `.`, `/`, and `_`
- `path` is a valid absolute Unix path

---

## 💡 Approach — Stack-Based Directory Simplification

### Intuition

We use a **stack** to simulate directory navigation:

- Push normal folder names.
- Pop one entry for every `..` (if available).
- Ignore `.` and empty segments (from extra slashes).

After processing, join stack elements with `/`.

---

### Steps

1. Split the input by `/` → gives path components.
2. Traverse each component:
   - Skip if empty (`""`) or `"."`
   - If `".."` → pop from stack if not empty.
   - Otherwise → push directory name.
3. Join the stack using `/`.
4. Prepend `/` to make the result an absolute path.

---

### Example Walkthrough

**Input**

```

"/a//b/../c/./d/"

```

| Step | Component | Action | Stack     |
| ---- | --------- | ------ | --------- |
| 1    | a         | Push   | [a]       |
| 2    | (empty)   | Skip   | [a]       |
| 3    | b         | Push   | [a, b]    |
| 4    | ..        | Pop    | [a]       |
| 5    | c         | Push   | [a, c]    |
| 6    | .         | Skip   | [a, c]    |
| 7    | d         | Push   | [a, c, d] |

✅ Final Path: `/a/c/d`

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                   |
| --------- | ---------- | ----------------------------- |
| **Time**  | `O(n)`     | Each directory processed once |
| **Space** | `O(n)`     | Stack stores path components  |
