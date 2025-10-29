# 202. Happy Number

## 🧩 Problem Description

A **happy number** is defined by the following process:

1. Start with any positive integer.
2. Replace the number by the **sum of the squares of its digits**.
3. Repeat the process until:
   - The number equals `1` (where it will stay), or
   - It loops endlessly in a cycle that does **not** include `1`.

Numbers that end at `1` are **happy numbers**.

---

### 🔍 Example 1

**Input:**

```

n = 19

```

**Output:**

```

true

```

**Explanation:**

```

1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1

```

Since we reached 1, 19 is a happy number.

---

### 🔍 Example 2

**Input:**

```

n = 2

```

**Output:**

```

false

```

**Explanation:**
The process enters a loop and never reaches 1.

---

### ⚙️ Constraints

- `1 <= n <= 2^31 - 1`

---

## 💡 Approach (Based on Your Code)

1. **Use a HashSet** to keep track of all previously seen numbers.
   - If a number repeats, we are in a loop → return `false`.
2. **Iteratively replace** the number by the sum of the squares of its digits.
3. If we ever reach `1`, return `true`.

Additionally, small optimization:

- If the number becomes `1` or `7` early, we can directly return `true` (since 7 leads to a happy sequence).

---

### 🧠 Example Walkthrough

For `n = 19`:

| Step | Number | Sum of Squares | Seen Set          |
| ---- | ------ | -------------- | ----------------- |
| 1    | 19     | 82             | {19}              |
| 2    | 82     | 68             | {19, 82}          |
| 3    | 68     | 100            | {19, 82, 68}      |
| 4    | 100    | 1              | {19, 82, 68, 100} |

✅ We reached 1 → Happy number!

---

### ⏱️ Time Complexity

- **O(log n)** per iteration (digit extraction and squaring)
- **O(k)** total iterations (until repeat or reach 1)

### 💾 Space Complexity

- **O(k)** — to store seen numbers in the HashSet
