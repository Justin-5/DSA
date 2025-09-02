# 🔎 LeetCode 153. Find Minimum in Rotated Sorted Array

### 📌 Problem

An array `nums` is sorted in ascending order and then rotated between `1` and `n` times.  
Find the **minimum element** in the array in **O(log n)** time.

🔗 [Problem Link](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

---

### 💡 Examples

**Example 1**  
Input:

```text
nums = [3,4,5,1,2]
```

Output:

```text
1
```

**Example 2**
Input:

```text
nums = [4,5,6,7,0,1,2]
```

Output:

```text
0
```

**Example 3**
Input:

```text
nums = [11,13,15,17]
```

Output:

```text
11
```

---

### ⚙️ Approach

1. **Check if array is sorted (no rotation):**
   If `nums[0] <= nums[n-1]`, then the first element is the minimum.

2. **Binary Search for rotation point:**

   - Compute `mid`.
   - If `nums[mid] > nums[right]`, then the min is in the right half.
   - Else, the min is in the left half (including `mid`).

3. Loop until `l == r`. At this point, `nums[l]` is the minimum.

---

### 🛠️ Complexity

- **Time:** `O(log n)`
- **Space:** `O(1)`
