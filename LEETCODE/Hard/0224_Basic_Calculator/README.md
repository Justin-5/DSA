# 224. Basic Calculator

## 🧩 Problem Description

You are given a string `s` representing a **valid mathematical expression**.  
Implement a **basic calculator** to evaluate it **without using** any built-in evaluation functions like `eval()`.

The expression may contain:

- Integers
- `'+'` and `'-'` operators
- Parentheses `'('` and `')'`
- Whitespace characters

Return the integer result of the expression.

---

## 🔍 Example 1

**Input**

```

s = "1 + 1"

```

**Output**

```

2

```

---

## 🔍 Example 2

**Input**

```

s = " 2-1 + 2 "

```

**Output**

```

3

```

---

## 🔍 Example 3

**Input**

```

s = "(1+(4+5+2)-3)+(6+8)"

```

**Output**

```

23

```

---

## ⚙️ Constraints

- `1 <= s.length <= 3 * 10⁵`
- `s` contains digits, `+`, `-`, `(`, `)`, and spaces `' '`.
- Expression is valid and well-formed.
- `'+'` is **never unary**, but `'-'` **can be unary** (e.g., `"-1"` or `"-(2+3)"`).
- Every intermediate result fits in a **32-bit signed integer**.

---

## 💡 Approach — Stack-Based Expression Evaluation

### Intuition

The expression can contain nested parentheses.  
When we encounter `'('`, we need to **pause** the current computation and **resume** it after `')'`.

We can use a **stack** to save:

- The current `curResult` (result so far before entering parentheses)
- The `curSign` (sign before parentheses)

When a closing `')'` is found:

- Pop the `sign` and the previous `result`.
- Combine them with the value of the expression inside the parentheses.

---

### 🧠 Algorithm

1. Initialize:
   - `curResult = 0` → running total
   - `curSign = 1` → current sign (+1 or -1)
   - `stack` → to store previous results and signs
2. Iterate through each character `ch` in the string:
   - **Digit:** Build the number (handle multi-digit values).
   - **‘+’ / ‘-’**: Update the current sign.
   - **‘(’**: Push the current result and sign to stack, then reset both.
   - **‘)’**: Pop sign and previous result from stack, and update current result.
3. Return `curResult`.

---

### 🧮 Example Walkthrough

**Input**

```

(1+(4+5+2)-3)+(6+8)

```

| Step | Character | Action                           | Stack        | curResult | curSign |
| ---- | --------- | -------------------------------- | ------------ | --------- | ------- |
| 1    | `(`       | Push (0, 1)                      | [0, 1]       | 0         | 1       |
| 2    | `1`       | Add 1×1                          | [0, 1]       | 1         | 1       |
| 3    | `+`       | Set sign = +1                    | [0, 1]       | 1         | 1       |
| 4    | `(`       | Push (1, 1)                      | [0, 1, 1, 1] | 0         | 1       |
| 5    | `4`       | Add 4×1                          | [0, 1, 1, 1] | 4         | 1       |
| 6    | `+`       | Set sign = +1                    | [0, 1, 1, 1] | 4         | 1       |
| 7    | `5`       | Add 5×1                          | [0, 1, 1, 1] | 9         | 1       |
| 8    | `+`       | Set sign = +1                    | [0, 1, 1, 1] | 9         | 1       |
| 9    | `2`       | Add 2×1                          | [0, 1, 1, 1] | 11        | 1       |
| 10   | `)`       | Pop sign=1, prev=1 → 1+(1×11)=12 | [0, 1]       | 12        | 1       |
| 11   | `-`       | Set sign = -1                    | [0, 1]       | 12        | -1      |
| 12   | `3`       | Add 3×(-1)                       | [0, 1]       | 9         | -1      |
| 13   | `)`       | Pop sign=1, prev=0 → 0+(1×9)=9   | []           | 9         | 1       |
| 14   | `+`       | Set sign = +1                    | []           | 9         | 1       |
| 15   | `(`       | Push (9, 1)                      | [9, 1]       | 0         | 1       |
| 16   | `6`       | Add 6×1                          | [9, 1]       | 6         | 1       |
| 17   | `+`       | Set sign = +1                    | [9, 1]       | 6         | 1       |
| 18   | `8`       | Add 8×1                          | [9, 1]       | 14        | 1       |
| 19   | `)`       | Pop sign=1, prev=9 → 9+(1×14)=23 | []           | 23        | 1       |

✅ **Result = 23**

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                             |
| --------- | ---------- | --------------------------------------- |
| **Time**  | `O(n)`     | Single pass through string              |
| **Space** | `O(n)`     | Stack stores previous results and signs |
