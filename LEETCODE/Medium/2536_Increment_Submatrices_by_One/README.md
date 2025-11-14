# 2536. Increment Submatrices by One

## 🧩 Problem Description

You are given:

- An integer `n`, representing the size of an `n x n` matrix `mat`, initially filled with **zeroes**.
- A list of queries, where each query `q = [row1, col1, row2, col2]` means:
  > Add 1 to all elements in the submatrix bounded by the top-left corner `(row1, col1)` and the bottom-right corner `(row2, col2)`.

Return the resulting matrix after applying **all queries**.

---

## 🔍 Example 1

**Input**

```

n = 3
queries = [[1,1,2,2],[0,0,1,1]]

```

**Output**

```

[[1,1,0],
[1,2,1],
[0,1,1]]

```

**Explanation**

1. After query `[1,1,2,2]`:

```

0 0 0
0 1 1
0 1 1

```

2. After query `[0,0,1,1]`:

```

1 1 0
1 2 1
0 1 1

```

---

## 🔍 Example 2

**Input**

```

n = 2
queries = [[0,0,1,1]]

```

**Output**

```

[[1,1],
[1,1]]

```

---

## ⚙️ Constraints

- `1 <= n <= 500`
- `1 <= queries.length <= 10⁴`
- `0 <= row1 <= row2 < n`
- `0 <= col1 <= col2 < n`

---

## 💡 Approach — 2D Difference Array + Prefix Sum

### 🧠 Intuition

A naive approach would update all cells in the submatrix for each query — `O(n² * q)` (too slow).

To optimize, we use a **2D difference array**:

- Instead of incrementing every cell directly, we mark **corners** of each rectangle with **+1** and **-1**.
- Then, we reconstruct the final matrix using **prefix sums** both row-wise and column-wise.

---

### 🧩 Step-by-Step Algorithm

1. Create a `diff` matrix of size `(n+1) x (n+1)` to avoid boundary issues.
2. For each query `[r1, c1, r2, c2]`:

```

diff[r1][c1]       += 1
diff[r1][c2 + 1]   -= 1
diff[r2 + 1][c1]   -= 1
diff[r2 + 1][c2+1] += 1

```

3. Build the final matrix:

- First, compute **row-wise prefix sums**.
- Then, compute **column-wise prefix sums**.

4. Return the resulting matrix.

---

### 🧮 Example Dry Run

**Input**

```

n = 3
queries = [[1,1,2,2],[0,0,1,1]]

```

After processing both queries, the `diff` matrix looks like:

```

[ [ 1,  0, -1,  0 ],
[ 0,  1,  0, -1 ],
[ 0,  0,  1,  0 ],
[ 0,  0,  0,  0 ] ]

```

After prefix sums (first rows, then columns):

```

[ [1,1,0],
[1,2,1],
[0,1,1] ]

```

✅ Final Answer.

---

## ⏱️ Complexity Analysis

| Type      | Complexity  | Explanation                                              |
| --------- | ----------- | -------------------------------------------------------- |
| **Time**  | `O(n² + q)` | Each query adds 4 updates, then prefix sums take `O(n²)` |
| **Space** | `O(n²)`     | For the `diff` and result matrices                       |
