# 3370. Smallest Number With All Set Bits

## 🧩 Problem Description

You are given a positive number `n`.

Return the smallest number `x` **greater than or equal to `n`**, such that the **binary representation of `x` contains only set bits** (i.e., all bits are `1`).

---

### 🔍 Examples

#### Example 1:

**Input:**

```

n = 5

```

**Output:**

```

7

```

**Explanation:**
Binary representation of `7` is `"111"` which has all bits set.

---

#### Example 2:

**Input:**

```

n = 10

```

**Output:**

```

15

```

**Explanation:**
Binary representation of `15` is `"1111"`.  
`15 >= 10` and all bits are set.

---

#### Example 3:

**Input:**

```

n = 3

```

**Output:**

```

3

```

**Explanation:**
Binary representation of `3` is `"11"`, which already satisfies the condition.

---

### ⚙️ Constraints

- `1 <= n <= 1000`

---

## 💡 Approach (based on your code)

1. Start from `1` and keep calculating powers of 2 (`2^i`) until the value becomes **greater than `n`**.
2. Subtract `1` from that power to get a number with **all bits set**.
   - For example:
     - `2^3 = 8 → 8 - 1 = 7 (111)`
     - `2^4 = 16 → 16 - 1 = 15 (1111)`
3. Return that number.

---

### 🧠 Example Walkthrough

For `n = 10`:

```

2^3 = 8 (less than 10)
2^4 = 16 (greater than 10)
16 - 1 = 15
Result = 15

```

---

### ⏱️ Time Complexity

- **O(log n)** — loop iterates until power of 2 exceeds `n`.

### 💾 Space Complexity

- **O(1)** — constant space usage.
