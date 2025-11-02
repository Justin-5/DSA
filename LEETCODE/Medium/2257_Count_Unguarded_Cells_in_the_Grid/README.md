# 2257. Count Unguarded Cells in the Grid

## 🧩 Problem Description

You are given two integers `m` and `n` representing a 0-indexed `m x n` grid.  
You are also given two 2D integer arrays `guards` and `walls`:

- `guards[i] = [rowi, coli]` — position of the ith guard.
- `walls[j] = [rowj, colj]` — position of the jth wall.

A guard can see every cell in the four **cardinal directions** (north, south, east, west) from its position **until a wall or another guard blocks the view**.

A cell is considered **guarded** if **at least one guard** can see it.

Return the **number of unoccupied cells** that are **not guarded**.

---

## 🔍 Example 1

**Input:**

```

m = 4, n = 6
guards = [[0,0],[1,1],[2,3]]
walls = [[0,1],[2,2],[1,4]]

```

**Output:**

```

7

```

**Explanation:**
The guarded and unguarded cells are illustrated below:  
Red = guarded, Green = unguarded.  
There are a total of **7 unguarded cells**.

---

## 🔍 Example 2

**Input:**

```

m = 3, n = 3
guards = [[1,1]]
walls = [[0,1],[1,0],[2,1],[1,2]]

```

**Output:**

```

4

```

**Explanation:**
The unguarded cells are `[0,0], [0,2], [2,0], [2,2]`.

---

## ⚙️ Constraints

- `1 <= m, n <= 10^5`
- `2 <= m * n <= 10^5`
- `1 <= guards.length, walls.length <= 5 * 10^4`
- `2 <= guards.length + walls.length <= m * n`
- `guards[i].length == walls[j].length == 2`
- `0 <= rowi, rowj < m`
- `0 <= coli, colj < n`
- All positions in `guards` and `walls` are **unique**.

---

## 💡 Approach

We simulate the grid with the following marking system:

- `0` → empty and unguarded
- `1` → guarded
- `2` → guard
- `3` → wall

### Steps:

1. Initialize an `m x n` grid with zeros.
2. Mark all **guards** and **walls** in the grid.
3. For each guard, explore all **4 directions** (up, down, left, right):
   - Mark cells as guarded (`1`) until you hit a wall (`3`) or another guard (`2`).
4. Finally, count the number of cells still marked as `0`.

---

## 🧠 Intuition

The problem is similar to extending visibility lines in a grid until a barrier appears — a classic simulation pattern.  
We avoid BFS/DFS since each direction is independent and constrained by walls or guards.

---

## ⏱️ Complexity Analysis

| Complexity | Explanation                                                 |
| ---------- | ----------------------------------------------------------- |
| **Time**   | `O(m * n)` worst case, since we may traverse each cell once |
| **Space**  | `O(m * n)` for the grid                                     |

---

## 🧮 Example Walkthrough

**Input:**

```

m = 4, n = 6
guards = [[0,0],[1,1],[2,3]]
walls = [[0,1],[2,2],[1,4]]

```

**Process:**

1. Place guards (2) and walls (3).
2. For each guard, mark all reachable cells (1) until a wall/guard is hit.
3. Count cells still `0` → **7 unguarded cells**.
