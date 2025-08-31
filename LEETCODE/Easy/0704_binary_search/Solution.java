// 704. Binary Search
// Problem: https://leetcode.com/problems/binary-search/
// Easy difficulty
//
// Approach:
// - Since the array is sorted in ascending order, we can apply Binary Search.
// - Use two pointers: left (l) and right (r).
// - Repeatedly check the middle element:
//    1. If nums[mid] == target → return mid (target found).
//    2. If nums[mid] < target → move search range to the right half (l = mid + 1).
//    3. If nums[mid] > target → move search range to the left half (r = mid - 1).
// - If not found after the loop, return -1.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            // Compute middle index safely
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid; // Found target
            } else if (nums[mid] < target) {
                l = mid + 1; // Search right half
            } else {
                r = mid - 1; // Search left half
            }
        }

        // If we exit loop, target not found
        return -1;
    }
}
