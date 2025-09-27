# 812. Largest Triangle Area

## Problem Statement

You are given an array of points on the 2D plane, where `points[i] = [xi, yi]`.  
Return the **area of the largest triangle** that can be formed by any three different points.

Answers within `10^-5` of the actual answer are accepted.

---

## Examples

### Example 1

```

Input: points = \[\[0,0],\[0,1],\[1,0],\[0,2],\[2,0]]
Output: 2.00000

```

- The triangle formed by points `(0,2), (2,0), (0,0)` has the maximum area = **2.0**.

---

### Example 2

```

Input: points = \[\[1,0],\[0,0],\[0,1]]
Output: 0.50000

```

- The triangle `(0,0), (1,0), (0,1)` has area = **0.5**.

---

## Constraints

- `3 <= points.length <= 50`
- `-50 <= xi, yi <= 50`
- All given points are unique.

---

## Approach

### Idea

To calculate the area of a triangle given 3 vertices `(x1,y1), (x2,y2), (x3,y3)`, we can use the **shoelace formula**:

\[
\text{Area} = \frac{1}{2} \cdot |x1 \cdot (y2 - y3) + x2 \cdot (y3 - y1) + x3 \cdot (y1 - y2)|
\]

### Steps

1. Iterate through all possible triplets `(i, j, k)` of points.
2. Compute the triangle area using the shoelace formula.
3. Keep track of the **maximum area** seen.
4. Return the maximum.

---

## Complexity

- **Time Complexity:** `O(n^3)`  
  Since we check every combination of 3 points (with `n ≤ 50`, this is feasible).
- **Space Complexity:** `O(1)`  
  Only constant extra memory is used.
