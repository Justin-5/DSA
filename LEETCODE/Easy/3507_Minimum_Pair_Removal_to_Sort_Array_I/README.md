# 3507. Minimum Pair Removal to Sort Array I

## 🧠 Problem Description

You are given an integer array `nums`.

You can perform the following operation **any number of times**:

1. Select the **adjacent pair with the minimum sum** in the array
   - If multiple such pairs exist, choose the **leftmost** one
2. Replace that pair with **their sum**

Your task is to return the **minimum number of operations** needed to make the array **non-decreasing**.

---

### 📌 Definition

An array is **non-decreasing** if:

```

nums[i] >= nums[i - 1]   for all valid i

```

---

## 📌 Examples

### Example 1

```

Input: nums = [5,2,3,1]
Output: 2

```

Explanation:

```

[5,2,3,1]
→ minimum sum pair is (3,1) → replace with 4 → [5,2,4]
→ minimum sum pair is (2,4) → replace with 6 → [5,6]

```

The array is now non-decreasing after **2 operations**.

---

### Example 2

```

Input: nums = [1,2,2]
Output: 0

```

Explanation:

- The array is already non-decreasing
- No operations are required

---

## 📋 Constraints

- `1 <= nums.length <= 50`
- `-1000 <= nums[i] <= 1000`

---

## 💡 Solution Approach (Simulation / Greedy)

### Key Idea

- At every step, you are **forced** to choose the adjacent pair with the **minimum sum**
- Since the array size is small (`≤ 50`), we can safely **simulate** the process

---

## 🧩 Algorithm Steps

1. Convert the array into a dynamic list (`ArrayList`) for easy removal/insertion
2. While the array is **not non-decreasing**:
   - Find the index of the **adjacent pair with minimum sum**
   - Replace the pair with their sum
   - Increment operation count
3. Stop when the array becomes non-decreasing
4. Return the operation count

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n³)** (worst case)
  - Checking sorted order → `O(n)`
  - Finding minimum adjacent sum → `O(n)`
  - Can happen up to `O(n)` times

Given `n ≤ 50`, this is acceptable.

### Space Complexity

- **O(n)** for the dynamic list

---

## 🧪 Edge Cases Covered

- Already sorted array
- Single-element array
- Negative numbers
- Multiple minimum-sum pairs (leftmost chosen)
