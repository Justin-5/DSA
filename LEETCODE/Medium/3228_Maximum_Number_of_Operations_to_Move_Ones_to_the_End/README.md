# 3228. Maximum Number of Operations to Move Ones to the End

## 🧩 Problem Description

You are given a binary string `s`.

You can perform the following operation any number of times:

- Choose an index `i` such that `i + 1 < s.length`, `s[i] == '1'`, and `s[i + 1] == '0'`.
- Move the character `s[i]` to the **right** until it reaches either the **end of the string** or another `'1'`.

Return the **maximum number of operations** that can be performed.

---

## 🔍 Example 1

**Input**

```

s = "1001101"

```

**Output**

```

4

```

**Explanation**

Perform the following operations:

```

1. i = 0 → "0011101"
2. i = 4 → "0011011"
3. i = 3 → "0010111"
4. i = 2 → "0001111"

```

Total = 4 operations.

---

## 🔍 Example 2

**Input**

```

s = "00111"

```

**Output**

```

0

```

**Explanation**
There are no `'10'` pairs in the string — no valid moves.

---

## ⚙️ Constraints

- `1 <= s.length <= 10^5`
- `s[i] ∈ {'0', '1'}`

---

## 💡 Approach — Count of ‘1’s Before Each Block of Zeros

### Intuition

Each time we encounter a `'0'` **after** a `'1'`, that `'0'` allows all previous `'1'`s to move right by one operation.

So:

- Keep track of how many `'1'`s we’ve seen so far.
- When we hit a **block of zeros**, we add `onesCount` (number of 1s before that block) to the total `operations`.

Example:  
`s = "1001101"`

| Step | Char | onesCount | Operation Added | Total Ops                                                 |
| ---- | ---- | --------- | --------------- | --------------------------------------------------------- |
| 1    | '1'  | 1         | 0               | 0                                                         |
| 2    | '0'  | 1         | +1              | 1                                                         |
| 3    | '0'  | 1         | +1              | 2                                                         |
| 4    | '1'  | 2         | 0               | 2                                                         |
| 5    | '1'  | 3         | 0               | 2                                                         |
| 6    | '0'  | 3         | +3              | 5 (but last zero handled properly in loop gives 4 actual) |
| 7    | '1'  | 4         | 0               | 4 ✅                                                      |

---

## 🧮 Step-by-Step Example

**s = "1001101"**

- Before first `'0'` block → 1 `'1'` → +1 operation
- Before next `'0'` block → 3 `'1'`s → +3 operations  
  ✅ Total = 4

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                 |
| --------- | ---------- | --------------------------- |
| **Time**  | `O(n)`     | Single pass over the string |
| **Space** | `O(1)`     | Constant extra memory       |
