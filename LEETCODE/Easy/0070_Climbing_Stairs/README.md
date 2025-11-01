# 70. Climbing Stairs

## 🧩 Problem Description

You are climbing a staircase that has `n` steps.  
Each time you can climb **either 1 or 2 steps**.  
Your task is to determine **how many distinct ways** there are to reach the top.

---

### 🔍 Example 1

**Input:**

```

n = 2

```

**Output:**

```

2

```

**Explanation:**
There are two possible ways:

1. 1 step + 1 step
2. 2 steps

---

### 🔍 Example 2

**Input:**

```

n = 3

```

**Output:**

```

3

```

**Explanation:**
There are three possible ways:

1. 1 + 1 + 1
2. 1 + 2
3. 2 + 1

---

### ⚙️ Constraints

- `1 <= n <= 45`

---

## 💡 Approach

This problem is a classic **Dynamic Programming (DP)** problem that mimics the **Fibonacci sequence**.

### 🧠 Intuition

- If you’re on step `n`, you could have reached it either from:
  - Step `n-1` (by taking 1 step), or
  - Step `n-2` (by taking 2 steps).
- Therefore,  
  `ways(n) = ways(n-1) + ways(n-2)`

### 🧱 Steps

1. Handle base cases:
   - `ways(1) = 1`
   - `ways(2) = 2`
2. For each step `i` from 3 to `n`, compute:
   - `ways(i) = ways(i-1) + ways(i-2)`
3. Use variables to store only the last two computed results for **O(1)** space optimization.

---

## ⏱️ Complexity Analysis

| Complexity | Explanation                                              |
| ---------- | -------------------------------------------------------- |
| **Time**   | `O(n)` — We iterate once through all steps               |
| **Space**  | `O(1)` — Only two variables are used (`first`, `second`) |

---

## 🧮 Example Walkthrough

**Input:** `n = 5`  
| Step | first | second | dp[i] | Explanation |
|------|--------|---------|-------|-------------|
| 1 | 1 | 2 | — | Base values |
| 2 | 2 | 3 | 3 | ways(3) = 1 + 2 |
| 3 | 3 | 5 | 5 | ways(4) = 2 + 3 |
| 4 | 5 | 8 | 8 | ways(5) = 3 + 5 |

✅ **Output:** `8`
