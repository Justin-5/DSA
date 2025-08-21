# 15. 3Sum

## Problem Description

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that:

- `i != j`, `i != k`, and `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution set must not contain **duplicate triplets**.

---

### Examples

**Example 1:**
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

**Example 2:**
Input: nums = [0,1,1]
Output: []

**Example 3:**
Input: nums = [0,0,0]
Output: [[0,0,0]]

---

## Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

---

## Approach: Sorting + Two Pointers

1. **Sort the array** → makes duplicate handling easier.
2. Iterate through the array, fixing one element `nums[i]`.
3. Use **two pointers** (`j` at `i+1`, `k` at end) to find pairs such that:  
   nums[i] + nums[j] + nums[k] == 0

4. Skip duplicates for both `i`, `j`, and `k` to avoid repeated triplets.

### Complexity

- **Time Complexity:** `O(n^2)`
- **Space Complexity:** `O(1)` (ignoring output list)

---

## Code (Java)

```java
class Solution {
 public List<List<Integer>> threeSum(int[] nums) {
     Arrays.sort(nums);
     int len = nums.length;
     List<List<Integer>> result = new ArrayList<>();
     for (int i = 0; i < len; i++) {
         if (i > 0 && nums[i] == nums[i - 1]) continue;
         int target = -nums[i];
         int j = i + 1, k = len - 1;
         while (j < k) {
             if (nums[j] + nums[k] < target) {
                 j++;
             } else if (nums[j] + nums[k] > target) {
                 k--;
             } else {
                 result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                 j++;
                 k--;
                 while (j < k && nums[j] == nums[j - 1]) j++;
                 while (j < k && nums[k] == nums[k + 1]) k--;
             }
         }
     }
     return result;
 }
}
```
