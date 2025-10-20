# 2011. Final Value of Variable After Performing Operations

**Difficulty:** Easy  
**Topics:** Simulation, String  
**LeetCode Link:** [2011. Final Value of Variable After Performing Operations](https://leetcode.com/problems/final-value-of-variable-after-performing-operations/)

---

## 🧩 Problem Statement

There is a programming language with only **four operations** and **one variable `X`**:

- `"++X"` and `"X++"` → increment the value of `X` by **1**
- `"--X"` and `"X--"` → decrement the value of `X` by **1**

Initially, the value of `X` is **0**.

Given an array of strings `operations` representing a list of operations,  
return the **final value of `X`** after performing all the operations.

---

## 🔹 Example 1

**Input:**

```

operations = ["--X","X++","X++"]

```

**Output:**

```

1

```

**Explanation:**

```

X starts at 0.
--X → X = -1
X++ → X = 0
X++ → X = 1
Final value = 1

```

---

## 🔹 Example 2

**Input:**

```

operations = ["++X","++X","X++"]

```

**Output:**

```

3

```

**Explanation:**

```

X starts at 0.
++X → X = 1
++X → X = 2
X++ → X = 3
Final value = 3

```

---

## 🔹 Example 3

**Input:**

```

operations = ["X++","++X","--X","X--"]

```

**Output:**

```

0

```

**Explanation:**

```

X starts at 0.
X++ → X = 1
++X → X = 2
--X → X = 1
X-- → X = 0
Final value = 0

```

---

## ⚙️ Constraints

- `1 <= operations.length <= 100`
- Each operation is one of `"++X"`, `"X++"`, `"--X"`, or `"X--"`

---

## 💡 Approach

### 🔸 Intuition

Since each operation either **increments or decrements** the variable `X` by `1`,  
we can simply:

- Increase `X` for `"++X"` or `"X++"`
- Decrease `X` for `"--X"` or `"X--"`

No matter whether the `++` or `--` appears before or after `X`, the result on `X` is identical.

---

### 🔹 Steps

1. Initialize `x = 0`
2. Iterate through each operation in `operations`
3. If the operation contains `"++"`, increment `x`
4. Else, decrement `x`
5. Return `x` as the final value

---

## 🧮 Example Walkthrough

**Input:**

```

operations = ["++X", "X++", "--X"]

```

| Operation | Action | X Value |
| --------- | ------ | ------- |
| `++X`     | +1     | 1       |
| `X++`     | +1     | 2       |
| `--X`     | -1     | 1       |

✅ **Output:** `1`

---

## 🧰 Complexity Analysis

| Complexity   | Explanation                           |
| ------------ | ------------------------------------- |
| ⏱️ **Time**  | O(n) — iterate through all operations |
| 💾 **Space** | O(1) — only one variable used         |

---

## 🧠 Key Takeaway

This problem tests basic **string iteration and condition handling** — ideal for beginners learning control flow and simulation problems.
