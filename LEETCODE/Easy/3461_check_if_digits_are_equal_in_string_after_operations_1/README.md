# 3461. Check If Digits Are Equal in String After Operations I

**Difficulty:** Easy  
**Topics:** Simulation, String, Math  
**LeetCode Link:** [3461. Check If Digits Are Equal in String After Operations I](https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/)

---

## 🧩 Problem Statement

You are given a string `s` consisting of digits. Perform the following operation repeatedly **until the string has exactly two digits**:

1. For each pair of consecutive digits in `s`, calculate a new digit as `(digit[i] + digit[i + 1]) % 10`.
2. Replace `s` with the sequence of these newly calculated digits.

Return `true` if the **final two digits** in `s` are the same, otherwise `false`.

---

## 🔹 Example 1

**Input:**

```

s = "3902"

```

**Output:**

```

true

```

**Explanation:**

```

Step 1: (3+9)%10=2, (9+0)%10=9, (0+2)%10=2 → s = "292"
Step 2: (2+9)%10=1, (9+2)%10=1 → s = "11"
✅ Both digits are same → true

```

---

## 🔹 Example 2

**Input:**

```

s = "34789"

```

**Output:**

```

false

```

**Explanation:**

```

Step 1: (3+4)%10=7, (4+7)%10=1, (7+8)%10=5, (8+9)%10=7 → s = "7157"
Step 2: (7+1)%10=8, (1+5)%10=6, (5+7)%10=2 → s = "862"
Step 3: (8+6)%10=4, (6+2)%10=8 → s = "48"
❌ '4' != '8' → false

```

---

## ⚙️ Constraints

- `3 <= s.length <= 100`
- `s` consists of digits `'0'` to `'9'` only.

---

## 💡 Approach

### 🔸 Intuition

We simulate the process step by step:

- Convert the input string into an integer array.
- Repeatedly perform the operation `(arr[i] + arr[i+1]) % 10` for each consecutive pair.
- After each iteration, the length decreases by 1.
- When only two digits remain, check if they are equal.

### 🔹 Example Walkthrough

For `s = "3902"`:

```

[3,9,0,2]
→ [2,9,2]
→ [1,1]
✅ Equal → return true

```

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                                                           |
| ------------ | --------------------------------------------------------------------- |
| ⏱️ **Time**  | O(n²) — Each pass reduces length by 1, so ~n + (n-1) + ... + 2 ≈ n²/2 |
| 💾 **Space** | O(n) — Using an integer array to simulate digits                      |
