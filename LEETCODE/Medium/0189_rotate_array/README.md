# 189. Rotate Array

**Difficulty:** Medium  
**Topics:** Array, Two Pointers  
**LeetCode Link:** [189. Rotate Array](https://leetcode.com/problems/rotate-array/)

---

## 🧩 Problem Statement

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

---

## 🔹 Example 1

**Input:**

```

nums = [1,2,3,4,5,6,7], k = 3

```

**Output:**

```

[5,6,7,1,2,3,4]

```

**Explanation:**

- Rotate 1 step right → [7,1,2,3,4,5,6]
- Rotate 2 steps right → [6,7,1,2,3,4,5]
- Rotate 3 steps right → [5,6,7,1,2,3,4]

---

## 🔹 Example 2

**Input:**

```

nums = [-1,-100,3,99], k = 2

```

**Output:**

```

[3,99,-1,-100]

```

**Explanation:**

- Rotate 1 step right → [99,-1,-100,3]
- Rotate 2 steps right → [3,99,-1,-100]

---

## ⚙️ Constraints

- `1 <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `0 <= k <= 10^5`

---

## 💡 Approach

### 🔸 Intuition

Rotating an array by `k` steps means that:

- The **last k elements** move to the **front**.
- The remaining elements shift to the **right**.

Instead of using extra arrays, we can **reverse the array in parts** to achieve this in-place.

---

### 🔹 Reversal Algorithm Steps

1. **Reverse the entire array**
   - Now the order is fully reversed.
2. **Reverse the first k elements**
   - This moves the originally last k elements to their correct order.
3. **Reverse the remaining (n - k) elements**
   - This restores the rest of the array in the correct order.

---

### 🔹 Example Walkthrough

**Input:**

```

nums = [1,2,3,4,5,6,7], k = 3

```

**Step 1:** Reverse the entire array

```

[7,6,5,4,3,2,1]

```

**Step 2:** Reverse the first k elements (`k=3`)

```

[5,6,7,4,3,2,1]

```

**Step 3:** Reverse the remaining n-k elements

```

[5,6,7,1,2,3,4]

```

✅ Final Output: `[5,6,7,1,2,3,4]`

---

## 🧰 Complexity Analysis

| Complexity   | Explanation                                                |
| ------------ | ---------------------------------------------------------- |
| ⏱️ **Time**  | O(n) — Each element is reversed a constant number of times |
| 💾 **Space** | O(1) — In-place array reversal                             |

---

## 🔄 Alternative Approaches

1. **Using Extra Array** — Copy elements to a new array using modular arithmetic (`O(n)` space).
2. **Cyclic Replacement** — Rotate elements in cycles using index mapping.
3. **Reversal Method (Optimal)** — The approach implemented here; clean and in-place.
