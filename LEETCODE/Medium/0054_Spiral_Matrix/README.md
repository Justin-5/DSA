# 54. Spiral Matrix

## 🧩 Problem Description

Given an `m x n` matrix, return all elements of the matrix in **spiral order**.

---

## 🔍 Example 1

**Input**

```

matrix = [
[1,2,3],
[4,5,6],
[7,8,9]
]

```

**Output**

```

[1,2,3,6,9,8,7,4,5]

```

**Explanation**
The spiral traversal order is:

- Top row → `[1,2,3]`
- Right column → `[6,9]`
- Bottom row (reversed) → `[8,7]`
- Left column (reversed) → `[4]`
- Center element → `[5]`

---

## 🔍 Example 2

**Input**

```

matrix = [
[1,2,3,4],
[5,6,7,8],
[9,10,11,12]
]

```

**Output**

```

[1,2,3,4,8,12,11,10,9,5,6,7]

```

**Explanation**
The spiral traversal order is:

- Top row → `[1,2,3,4]`
- Right column → `[8,12]`
- Bottom row (reversed) → `[11,10,9]`
- Left column (reversed) → `[5]`
- Remaining middle → `[6,7]`

---

## ⚙️ Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 10`
- `-100 <= matrix[i][j] <= 100`

---

## 💡 Approach — Boundary Simulation

We simulate the spiral order by defining **four boundaries**:

- `top` → starting row index
- `bottom` → ending row index
- `left` → starting column index
- `right` → ending column index

### Steps

1. Traverse **left → right** across the top row, then increment `top`.
2. Traverse **top → bottom** down the right column, then decrement `right`.
3. Traverse **right → left** across the bottom row (if `top <= bottom`), then decrement `bottom`.
4. Traverse **bottom → top** up the left column (if `left <= right`), then increment `left`.
5. Repeat until all boundaries overlap or are crossed.

This ensures we cover all elements exactly once in spiral order.

---

## 🧮 Example Walkthrough

**Matrix**

```

[
[1,  2,  3],
[4,  5,  6],
[7,  8,  9]
]

```

| Step | Traversal Direction | Elements Added | Spiral So Far                  |
| ---- | ------------------- | -------------- | ------------------------------ |
| 1    | Left → Right        | [1, 2, 3]      | [1, 2, 3]                      |
| 2    | Top → Bottom        | [6, 9]         | [1, 2, 3, 6, 9]                |
| 3    | Right → Left        | [8, 7]         | [1, 2, 3, 6, 9, 8, 7]          |
| 4    | Bottom → Top        | [4]            | [1, 2, 3, 6, 9, 8, 7, 4]       |
| 5    | Final               | [5]            | ✅ [1, 2, 3, 6, 9, 8, 7, 4, 5] |

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                                           |
| --------- | ---------- | ----------------------------------------------------- |
| **Time**  | `O(m × n)` | Each element is visited exactly once                  |
| **Space** | `O(1)`     | Only a few variables are used for tracking boundaries |
