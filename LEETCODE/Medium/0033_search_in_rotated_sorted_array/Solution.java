// 33. Search in Rotated Sorted Array
// Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Medium difficulty
//
// Approach:
// - The array is sorted but rotated at some pivot.
// - We need to perform binary search in O(log n) while handling rotation.
//
// Key Idea:
// - At each step, one half of the array (left or right) must be sorted.
// - Check which half is sorted:
//   - If the left half is sorted, check if target lies within it.
//   - Otherwise, search the other half.
// - Repeat until found or search space is empty.
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2; // Prevents overflow

            // Case 1: Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Case 2: Left half is sorted
            if (nums[l] <= nums[mid]) {
                // Target lies in left half
                if (target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1; // Otherwise, search right half
                }
            }
            // Case 3: Right half is sorted
            else {
                // Target lies in right half
                if (target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1; // Otherwise, search left half
                }
            }
        }

        // Target not found
        return -1;
    }
}
