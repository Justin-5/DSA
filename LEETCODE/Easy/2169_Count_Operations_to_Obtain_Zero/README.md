# 2169. Count Operations to Obtain Zero

## 🧩 Problem Description

You are given two **non-negative integers** `num1` and `num2`.

In one operation:

- If `num1 >= num2`, subtract `num2` from `num1`.
- Otherwise, subtract `num1` from `num2`.

Repeat the process until **either `num1 == 0` or `num2 == 0`**.

Return the **number of operations** performed.

---

## 🔍 Example 1

**Input**

```

num1 = 2, num2 = 3

```

**Output**

```

3

```

**Explanation**

```

(2, 3) → (2, 1) → (1, 1) → (0, 1)

```

Total operations = 3.

---

## 🔍 Example 2

**Input**

```

num1 = 10, num2 = 10

```

**Output**

```

1

```

**Explanation**

```

(10, 10) → (0, 10)

```

Only one operation needed.

---

## ⚙️ Constraints

- `0 <= num1, num2 <= 10⁵`

---

## 💡 Approach — Simulate the Process

### Intuition

At every step, we **subtract the smaller number from the larger** until one of them becomes `0`.

This is essentially mimicking the **Euclidean algorithm**, but counting each subtraction as an individual operation.

---

### Algorithm

1. Initialize a counter `count = 0`.
2. While both `num1` and `num2` are greater than zero:
   - If `num1 >= num2`, subtract `num2` from `num1`.
   - Else, subtract `num1` from `num2`.
   - Increment the count.
3. Return the total count.

---

### Example Walkthrough

**Input**

```

num1 = 5, num2 = 2

```

| Step | num1 | num2 | Action         | count |
| ---- | ---- | ---- | -------------- | ----- |
| 1    | 5    | 2    | 5 ≥ 2 → 5−2=3  | 1     |
| 2    | 3    | 2    | 3 ≥ 2 → 3−2=1  | 2     |
| 3    | 1    | 2    | 1 < 2 → 2−1=1  | 3     |
| 4    | 1    | 1    | 1 == 1 → 1−1=0 | 4     |

✅ **Result:** `count = 4`

---

## ⏱️ Complexity Analysis

| Type      | Complexity           | Explanation                                  |
| --------- | -------------------- | -------------------------------------------- |
| **Time**  | `O(max(num1, num2))` | Each subtraction reduces at least one number |
| **Space** | `O(1)`               | Constant space usage                         |

---

## 🧮 Optimization Note

This process can be optimized using division instead of repeated subtraction:

```java
while (num1 != 0 && num2 != 0) {
    if (num1 >= num2) {
        count += num1 / num2;
        num1 %= num2;
    } else {
        count += num2 / num1;
        num2 %= num1;
    }
}
```

This reduces the time complexity to **O(log(max(num1, num2)))**, like the Euclidean GCD algorithm.
