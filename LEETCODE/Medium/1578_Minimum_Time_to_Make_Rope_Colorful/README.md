# 1578. Minimum Time to Make Rope Colorful

## 🧩 Problem Description

Alice has `n` balloons arranged on a rope. You are given a 0-indexed string `colors`, where `colors[i]` is the color of the `i`-th balloon.

Alice wants the rope to be **colorful** — meaning no two consecutive balloons have the same color.  
Bob can remove balloons to achieve this, where removing the `i`-th balloon costs `neededTime[i]` seconds.

Return the **minimum total time** required for Bob to make the rope colorful.

---

## 🔍 Example 1

**Input**

```

colors = "abaac"
neededTime = [1,2,3,4,5]

```

**Output**

```

3

```

**Explanation**
Remove the second `'a'` (index 2, cost 3).  
Final sequence: `"abac"` — all colors are unique consecutively.  
Total time = **3 seconds**.

---

## 🔍 Example 2

**Input**

```

colors = "abc"
neededTime = [1,2,3]

```

**Output**

```

0

```

**Explanation**
No removals needed — already colorful.

---

## 🔍 Example 3

**Input**

```

colors = "aabaa"
neededTime = [1,2,3,4,1]

```

**Output**

```

2

```

**Explanation**
Remove the first and last `'a'` (each cost 1).  
Final sequence: `"abaa"` → `"aba"` → all unique consecutively.  
Total time = **1 + 1 = 2 seconds**.

---

## ⚙️ Constraints

- `n == colors.length == neededTime.length`
- `1 <= n <= 10⁵`
- `1 <= neededTime[i] <= 10⁴`
- `colors` consists only of lowercase English letters

---

## 💡 Approach

We process the string using a **two-pointer sliding window** approach to find contiguous segments of the same color.

For each contiguous block of identical colors (e.g., `"aaa"`):

- We must **keep one balloon** and **remove all others**.
- To minimize time, **remove all except the one with the largest neededTime**.

### Steps:

1. Use two pointers `start` and `end` to identify groups of same-colored balloons.
2. When a color group ends:
   - Calculate the sum of removal times in that segment.
   - Subtract the **maximum removal time** (the one we keep).
3. Add this cost to the total.
4. Move to the next color segment.

---

## 🧮 Example Walkthrough

**Input**

```

colors = "abaac"
neededTime = [1,2,3,4,5]

```

| Segment | Balloons | Times              | Action | Cost |
| ------- | -------- | ------------------ | ------ | ---- |
| "a"     | single   | -                  | keep   | 0    |
| "b"     | single   | -                  | keep   | 0    |
| "aa"    | [3, 4]   | remove smaller (3) | +3     |
| "c"     | single   | -                  | keep   | 0    |

**Total Cost = 3**

---

## ⏱️ Complexity Analysis

| Complexity | Explanation                           |
| ---------- | ------------------------------------- |
| **Time**   | `O(n)` — single traversal of the rope |
| **Space**  | `O(1)` — constant extra space         |
