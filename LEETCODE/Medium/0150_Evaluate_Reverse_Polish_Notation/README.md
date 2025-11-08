# 150. Evaluate Reverse Polish Notation

## 🧩 Problem Description

You are given an array of strings `tokens` representing an arithmetic expression in **Reverse Polish Notation (RPN)**.

Your task is to **evaluate** the expression and return the final integer result.

### Rules:

- Valid operators: `"+"`, `"-"`, `"*"`, `"/"`.
- Each operand is either an integer or another expression.
- Division between two integers truncates **toward zero**.
- There is **no division by zero**.
- The input always represents a valid RPN expression.
- All calculations fit within a **32-bit signed integer**.

---

## 🔍 Example 1

**Input**

```

tokens = ["2","1","+","3","*"]

```

**Output**

```

9

```

**Explanation**

```

((2 + 1) * 3) = 9

```

---

## 🔍 Example 2

**Input**

```

tokens = ["4","13","5","/","+"]

```

**Output**

```

6

```

**Explanation**

```

(4 + (13 / 5)) = 6

```

---

## 🔍 Example 3

**Input**

```

tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]

```

**Output**

```

22

```

**Explanation**

```

((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * 0) + 17) + 5
= 22

```

---

## ⚙️ Constraints

- `1 <= tokens.length <= 10⁴`
- `tokens[i]` is one of: `"+"`, `"-"`, `"*"`, `"/"`, or an integer in range `[-200, 200]`.

---

## 💡 Approach — Stack-Based Evaluation

### Intuition

In **Reverse Polish Notation**, operators come _after_ their operands.
For example:

```

"2 1 + 3 *"  →  (2 + 1) * 3

```

We can use a **stack** to process the expression:

1. Traverse tokens one by one.
2. If a token is a **number**, push it to the stack.
3. If it’s an **operator**, pop the top two numbers:
   - The first popped = right operand
   - The second popped = left operand
4. Apply the operation and push the result back.
5. After processing all tokens, the stack will contain one element → the result.

---

### 🧮 Example Walkthrough

**Input**

```

tokens = ["2", "1", "+", "3", "*"]

```

| Step | Token | Action           | Stack  |
| ---- | ----- | ---------------- | ------ |
| 1    | 2     | Push             | [2]    |
| 2    | 1     | Push             | [2, 1] |
| 3    | +     | Pop 1, 2 → 2+1=3 | [3]    |
| 4    | 3     | Push             | [3, 3] |
| 5    | \*    | Pop 3, 3 → 3×3=9 | [9]    |

✅ **Result = 9**

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                             |
| --------- | ---------- | --------------------------------------- |
| **Time**  | `O(n)`     | Each token processed exactly once       |
| **Space** | `O(n)`     | Stack stores operands during evaluation |
