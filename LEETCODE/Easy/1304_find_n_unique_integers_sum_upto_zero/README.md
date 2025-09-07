# ⚖️ 1304. Find N Unique Integers Sum up to Zero

### 📌 Problem

Given an integer `n`, return any array containing `n` **unique integers** such that they **add up to 0**.

🔗 [Problem Link](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/)

---

### 💡 Examples

**Example 1**

```

Input: n = 5
Output: \[-2, -1, 0, 1, 2]
Explanation: The sum is -2 + -1 + 0 + 1 + 2 = 0

```

**Example 2**

```

Input: n = 3
Output: \[-1, 0, 1]

```

**Example 3**

```

Input: n = 1
Output: \[0]

```

---

### ⚙️ Approach

1. Use **pairs of positive and negative numbers**: `(i, -i)`.
2. If `n` is odd, include `0` to balance the sum.
3. This guarantees:
   - All numbers are **unique**.
   - The total sum is **0**.

---

### 🛠️ Complexity

- **Time:** `O(n)` → loop runs up to n/2 pairs.
- **Space:** `O(1)` → aside from result array.

---

### 🧑‍💻 Code

See [SumZeroArray.java](./SumZeroArray.java) for the implementation.

```


```
