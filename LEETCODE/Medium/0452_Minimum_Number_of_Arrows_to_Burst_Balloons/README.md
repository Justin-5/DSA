# 452. Minimum Number of Arrows to Burst Balloons

## 🧩 Problem Description

You are given a 2D integer array `points`, where each element `points[i] = [x_start, x_end]`
represents the **horizontal diameter** of a balloon on the XY-plane.

An arrow can be shot **vertically upward** from any `x` position, and it will burst all balloons
whose horizontal range `[x_start, x_end]` includes `x`.

Return the **minimum number of arrows** required to burst all balloons.

---

## 🔍 Example 1

**Input**

```

points = [[10,16],[2,8],[1,6],[7,12]]

```

**Output**

```

2

```

**Explanation**

- Shoot an arrow at `x = 6` → bursts `[1,6]` and `[2,8]`.
- Shoot another at `x = 11` → bursts `[7,12]` and `[10,16]`.

---

## 🔍 Example 2

**Input**

```

points = [[1,2],[3,4],[5,6],[7,8]]

```

**Output**

```

4

```

**Explanation**
Each balloon is isolated, so 4 arrows are needed — one per balloon.

---

## 🔍 Example 3

**Input**

```

points = [[1,2],[2,3],[3,4],[4,5]]

```

**Output**

```

2

```

**Explanation**

- Arrow at `x = 2` bursts `[1,2]` and `[2,3]`
- Arrow at `x = 4` bursts `[3,4]` and `[4,5]`

---

## ⚙️ Constraints

- `1 <= points.length <= 10^5`
- `points[i].length == 2`
- `-2^31 <= x_start < x_end <= 2^31 - 1`

---

## 💡 Approach — Greedy Interval Overlap

This is a **classic greedy interval problem**.

### Intuition

- If two balloons **overlap**, one arrow can burst them both.
- If a balloon starts **after** the previous overlap ends,  
  a new arrow is required.

### Steps

1. Sort all intervals by their **start coordinate**.
2. Initialize:
   - `arrowCount = 1` (at least one balloon exists)
   - `curOverlap = end of first balloon`
3. For each next balloon:
   - If the balloon starts **after** the current overlap → need a new arrow.
   - Else → update the current overlap to the **minimum** of current and new end.

This ensures we always shoot arrows at the tightest overlap range possible.

---

## 🧮 Example Walkthrough

**Input**

```

points = [[1,2],[2,3],[3,4],[4,5]]

```

| Step | Current Balloon | Current Overlap End | Action                  | Arrows   |
| ---- | --------------- | ------------------- | ----------------------- | -------- |
| 1    | [1,2]           | 2                   | Initialize              | 1        |
| 2    | [2,3]           | min(2,3) = 2        | Overlaps → no new arrow | 1        |
| 3    | [3,4]           | 2 < 3 → new arrow   | 2                       |
| 4    | [4,5]           | min(4,5)=4          | Overlaps → no new arrow | **2** ✅ |

✅ **Final Answer = 2**

---

## ⏱️ Complexity Analysis

| Type      | Complexity   | Explanation                     |
| --------- | ------------ | ------------------------------- |
| **Time**  | `O(n log n)` | Sorting dominates the runtime   |
| **Space** | `O(1)`       | Only uses a few extra variables |
