# 51. N-Queens

## 🧠 Problem Description

The **N-Queens puzzle** is the problem of placing `n` queens on an `n × n` chessboard such that **no two queens attack each other**.

A queen can attack:

- Any other queen in the **same row**
- The **same column**
- The **same diagonal**

Given an integer `n`, return **all distinct solutions** to the N-Queens puzzle.

Each solution is represented as a board configuration where:

- `'Q'` represents a queen
- `'.'` represents an empty cell

You may return the solutions in **any order**.

---

## 📌 Examples

### Example 1

```

Input: n = 4

Output:
[
[".Q..","...Q","Q...","..Q."],
["..Q.","Q...","...Q",".Q.."]
]

```

Explanation:
There are **two distinct solutions** to the 4-Queens puzzle.

---

### Example 2

```

Input: n = 1
Output: [["Q"]]

```

---

## 📋 Constraints

- `1 <= n <= 9`

---

## 💡 Solution Approach (Backtracking)

### Key Insight

- Each row can contain **only one queen**
- We place queens **row by row**
- For each placement, we must ensure:
  - No other queen is in the same column
  - No other queen is in the same **positive diagonal**
  - No other queen is in the same **negative diagonal**

---

## 🧩 State Tracking

To efficiently check conflicts, we use:

- `cols[col]` → whether a column is occupied
- `posDiagonals[row + col]` → positive diagonal (`/`)
- `negDiagonals[row - col + n]` → negative diagonal (`\`)

All checks are **O(1)**.

---

## 🧩 Algorithm Steps

1. Start placing queens from `row = 0`
2. For each column in the current row:
   - Check column and diagonals
3. If safe:
   - Place queen
   - Mark column and diagonals
   - Recurse to next row
4. If `row == n`, a valid solution is found
5. Backtrack to explore other possibilities

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n!)**
  - Each row has up to `n` choices, reduced by constraints

### Space Complexity

- **O(n²)** for the board
- **O(n)** for recursion stack and helper arrays

---

## 🧪 Edge Cases Covered

- `n = 1`
- Small boards
- Maximum constraint `n = 9`
- Multiple valid configurations
