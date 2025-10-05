## 973. K Closest Points to Origin

### Problem

We are given an array of 2D points `points[i] = [xi, yi]`.
We need to return the **k points closest to the origin (0,0)** using the **Euclidean distance formula**:

[
d = \sqrt{(x^2 + y^2)}
]

Since √ is monotonic, we can compare squared distances `x² + y²` instead of computing the square root.

---

### Example 1

```
Input: points = [[1,3], [-2,2]], k = 1
Output: [[-2,2]]

Explanation:
Distance(1,3) = √10
Distance(-2,2) = √8
Since √8 < √10 → closest point = [-2,2]
```

---

### Example 2

```
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]

Explanation:
Distances:
(3,3)   → 18
(5,-1)  → 26
(-2,4)  → 20
The 2 closest = (3,3), (-2,4)
```

---

### Constraints

- `1 <= k <= points.length <= 10^4`
- `-10^4 <= xi, yi <= 10^4`

---

### Approach 🚀

We want the **k smallest distances**.
A good way:

- Use a **max-heap** of size `k`.
- Each element stores a point and its distance.
- For each point:

  - Add it to the heap.
  - If heap size > k → remove the farthest point.

- At the end, heap contains the **k closest points**.

---

### Dry Run 📝

Input:

```
points = [[3,3],[5,-1],[-2,4]], k = 2
```

Steps:

- Insert (3,3) → heap = [(3,3)]
- Insert (5,-1) → heap = [(5,-1), (3,3)] (both kept since ≤ k)
- Insert (-2,4) → heap = [(5,-1), (3,3), (-2,4)] → pop farthest (5,-1)
  Result = [(3,3), (-2,4)]

---

### Complexity

- **Time:** `O(n log k)` (each insert/remove in heap costs `log k`)
- **Space:** `O(k)` (heap stores only k elements).
