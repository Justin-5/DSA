## 215. Kth Largest Element in an Array

### Problem

Given an integer array `nums` and an integer `k`, return the **kth largest element** in the array.
This is the kth element in the sorted order, **not necessarily distinct**.

---

### Example 1

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

### Example 2

```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

---

### Constraints

- `1 <= k <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

---

### Approach 🚀

#### Idea

We want the **kth largest element**.
Instead of sorting the entire array (`O(n log n)`), we can use a **min-heap of size k**.

1. Iterate through `nums`.
2. Add elements into the min-heap.
3. If the heap size exceeds `k`, remove the smallest element.
4. At the end, the root of the min-heap is the **kth largest element**.

---

### Dry Run 📝

Input:

```
nums = [3,2,1,5,6,4], k = 2
```

Steps:

- Push 3 → heap = [3]
- Push 2 → heap = [2,3]
- Push 1 → heap = [1,3,2] → remove 1 → heap = [2,3]
- Push 5 → heap = [2,3,5] → remove 2 → heap = [3,5]
- Push 6 → heap = [3,5,6] → remove 3 → heap = [5,6]
- Push 4 → heap = [4,6,5] → remove 4 → heap = [5,6]

Final heap = [5,6] → kth largest = **5**

---

### Complexity

- Time: `O(n log k)` (heap operations for n elements, size limited to k).
- Space: `O(k)` (for the heap).

---
