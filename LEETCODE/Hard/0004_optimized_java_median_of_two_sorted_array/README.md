# 🔢 LeetCode 4. Median of Two Sorted Arrays

### 📌 Problem

You are given two sorted arrays `nums1` and `nums2` of size `m` and `n`.  
Return the **median** of the two sorted arrays.  
The algorithm must run in **O(log(m+n))** time.

🔗 [Problem Link](https://leetcode.com/problems/median-of-two-sorted-arrays/)

---

### 💡 Examples

**Example 1**  
Input:

```text
nums1 = [1,3], nums2 = [2]
```

Output:

```text
2.0
```

Explanation: merged = `[1,2,3]` → median = `2`.

---

**Example 2**
Input:

```text
nums1 = [1,2], nums2 = [3,4]
```

Output:

```text
2.5
```

Explanation: merged = `[1,2,3,4]` → median = `(2+3)/2`.

---

### ⚙️ Approach (Binary Search Partition)

1. Always binary search on the smaller array.
2. Partition both arrays into left and right halves:

   - `partition1 + partition2 = (m+n+1)/2`

3. Check validity:

   - `maxLeft1 <= minRight2` and `maxLeft2 <= minRight1`.

4. If valid:

   - Odd length → median = `max(maxLeft1,maxLeft2)`
   - Even length → median = `(max(maxLeft1,maxLeft2) + min(minRight1,minRight2)) / 2`.

---

### 🛠️ Complexity

- **Time:** `O(log(min(m, n)))` (binary search)
- **Space:** `O(1)`

---

### 🧑‍💻 Code

See [MedianOfTwoSortedArrays.java](./MedianOfTwoSortedArrays.java) for the implementation.

---

### 📊 Dry Run Example

For `nums1 = [1,3], nums2 = [2]`

| Partition | nums1 left | nums1 right | nums2 left | nums2 right             | Median |
| --------- | ---------- | ----------- | ---------- | ----------------------- | ------ |
| \[1]      | \[3]       | \[2]        | \[]        | Left=\[1,2], Right=\[3] | 2      |

✅ Median = 2.0
