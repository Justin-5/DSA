# 29. Divide Two Integers ➗

**Difficulty:** Medium  
**Topics:** Bit Manipulation, Math  
**LeetCode Link:** [29. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

---

## 🧩 Problem Statement

Given two integers `dividend` and `divisor`, divide them **without using multiplication, division, or mod operator**.

The integer division should **truncate toward zero**, meaning fractional parts are dropped.

Return the **quotient** after dividing `dividend` by `divisor`.

### ⚠️ Note:

You must handle **overflow** according to the 32-bit signed integer range:

```

[-2³¹, 2³¹ - 1]

```

If the result exceeds this range:

- Return `2³¹ - 1` if overflow (i.e., > 2³¹ - 1)
- Return `-2³¹` if underflow (i.e., < -2³¹)

---

## 🔹 Example 1

**Input:**

```

dividend = 10, divisor = 3

```

**Output:**

```

3

```

**Explanation:**

```

10 / 3 = 3.3333... truncated to 3

```

---

## 🔹 Example 2

**Input:**

```

dividend = 7, divisor = -3

```

**Output:**

```

-2

```

**Explanation:**

```

7 / -3 = -2.3333... truncated to -2

```

---

## ⚙️ Constraints

- `-2³¹ <= dividend, divisor <= 2³¹ - 1`
- `divisor != 0`

---

## 💡 Approach

### 🔸 Intuition

We can simulate the division operation by **repeated subtraction**.  
However, naive subtraction would take too long when `dividend` is large.

To optimize:

- We use **bit shifts** to double (`<< 1`) the divisor each time (similar to multiplying by 2).
- This allows us to subtract large chunks quickly.
- We accumulate how many times the divisor fits into the dividend using a power-of-two count.

---

### 🔹 Steps

1. **Handle overflow case:**

   - If `dividend == Integer.MIN_VALUE` and `divisor == -1`, return `Integer.MAX_VALUE`.

2. **Determine sign:**

   - Result is negative if one of them (but not both) is negative.

3. **Work with absolute values** (cast to `long` to avoid overflow).

4. **Subtract divisor in powers of two:**

   - While the remaining dividend is larger than the divisor:
     - Keep doubling the divisor until it’s just smaller than the remaining dividend.
     - Subtract this large chunk and add its corresponding multiple to the quotient.

5. **Apply sign and return result.**

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                                   |
| ------------ | --------------------------------------------- |
| ⏱️ **Time**  | O(log n) — Each iteration doubles the divisor |
| 💾 **Space** | O(1) — Constant extra space                   |

---

## 🧠 Example Walkthrough

**Input:** `dividend = 43`, `divisor = 5`

| Step | Dividend Left | Temp Divisor | Power of 2 | Action              |
| ---- | ------------- | ------------ | ---------- | ------------------- |
| 1    | 43            | 5            | 1          | Subtract → 43−5=38  |
| 2    | 38            | 10           | 2          | Subtract → 38−10=28 |
| 3    | 28            | 20           | 4          | Subtract → 28−20=8  |
| 4    | 8             | 5            | 1          | Subtract → 8−5=3    |

✅ **Total Quotient = 4 + 2 + 1 = 7**

**Output:** `7`
