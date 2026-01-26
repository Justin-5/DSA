# 1200. Minimum Absolute Difference

## 🧠 Problem Description

You are given an array `arr` of **distinct integers**.

Your task is to find **all pairs of elements** with the **minimum absolute difference** among all possible pairs.

Each returned pair `[a, b]` must satisfy:

- `a` and `b` are elements from `arr`
- `a < b`
- `b - a` equals the **minimum absolute difference** found in the array

Return the list of such pairs in **ascending order**.

---

## 📌 Examples

### Example 1

```

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]

```

Explanation:

- Sorted array: `[1,2,3,4]`
- Minimum difference = `1`
- All adjacent pairs with difference `1` are returned

---

### Example 2

```

Input: arr = [1,3,6,10,15]
Output: [[1,3]]

```

---

### Example 3

```

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]

```

---

## 📋 Constraints

- `2 <= arr.length <= 10^5`
- `-10^6 <= arr[i] <= 10^6`
- All elements in `arr` are **distinct**

---

## 💡 Solution Approach (Sorting)

### Key Insight

The minimum absolute difference between any two elements in an array will always occur between **adjacent elements in the sorted array**.

So:

1. Sort the array
2. Find the smallest difference between consecutive elements
3. Collect all consecutive pairs that have this minimum difference

---

## 🧩 Algorithm Steps

1. Sort the array `arr`
2. Traverse once to find the minimum difference between adjacent elements
3. Traverse again to collect all pairs with that minimum difference
4. Return the list of pairs

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n log n)** due to sorting

### Space Complexity

- **O(1)** extra space (excluding the output list)

---

## 🧪 Edge Cases Covered

- Negative numbers
- Large input size
- Multiple valid pairs
- Minimum difference appearing multiple times

---
