# 2048. Next Greater Numerically Balanced Number

**Difficulty:** Medium  
**Topics:** Math, Counting, Brute Force  
**LeetCode Link:** [2048. Next Greater Numerically Balanced Number](https://leetcode.com/problems/next-greater-numerically-balanced-number/)

---

## 🧩 Problem Statement

An integer `x` is **numerically balanced** if for every digit `d` in the number `x`, there are exactly `d` occurrences of that digit in `x`.

Given an integer `n`, return the **smallest numerically balanced number strictly greater than `n`**.

---

## 🔹 Example 1

**Input:**

```

n = 1

```

**Output:**

```

22

```

**Explanation:**

```

22 is numerically balanced since:

* The digit 2 occurs 2 times.
  It is also the smallest numerically balanced number strictly greater than 1.

```

---

## 🔹 Example 2

**Input:**

```

n = 1000

```

**Output:**

```

1333

```

**Explanation:**

```

1333 is numerically balanced since:

* The digit 1 occurs 1 time.
* The digit 3 occurs 3 times.
  It is also the smallest numerically balanced number strictly greater than 1000.

```

---

## 🔹 Example 3

**Input:**

```

n = 3000

```

**Output:**

```

3133

```

**Explanation:**

```

3133 is numerically balanced since:

* The digit 1 occurs 1 time.
* The digit 3 occurs 3 times.

```

---

## ⚙️ Constraints

- `0 <= n <= 10^6`

---

## 💡 Approach

### 🧠 Brute Force Search + Frequency Count

1. Start from `n + 1`.
2. For each number, check if it is **numerically balanced**:
   - Count the frequency of each digit (0–9).
   - For each digit `d`, if it appears > 0 times, its frequency must equal `d`.
3. If a number satisfies this property, return it.

Since the maximum `n` is only `10^6`, this brute-force approach is efficient enough.

## ⏱️ Complexity Analysis

| Type      | Complexity                                                                     |
| --------- | ------------------------------------------------------------------------------ |
| **Time**  | O(k × log₁₀(n)) — at most a few thousand checks, each requiring digit counting |
| **Space** | O(1) — only a small fixed-size frequency array                                 |

---

## ⚡ Optimization Idea (Precomputation)

You can **precompute all numerically balanced numbers up to 10⁷**, store them in a sorted list, and use binary search to find the next one greater than `n`.

For example:

```java
List<Integer> balanced = Arrays.asList(1, 22, 122, 333, 1333, 4444, 14444, 22333, 33322, 55555, ...);
```

Then use binary search to find the next element greater than `n`.

This approach reduces the search to **O(log N)** after precomputation.

---

## ✅ Example Walkthrough

### Input

```
n = 1000
```

### Iterations

```
1001 ❌ (1 appears twice)
1002 ❌ (1 appears once, 2 appears once)
...
1333 ✅ (1 occurs once, 3 occurs three times)
```

**Output:** `1333`
