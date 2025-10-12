// -----------------------------------------------------
// LeetCode 34: Find First and Last Position of Element
// -----------------------------------------------------
// Approach: Binary Search Twice (for leftmost & rightmost indices)
// Time Complexity: O(log n)
// Space Complexity: O(1)
// -----------------------------------------------------

class Solution {

    // Helper function to find first or last occurrence
    public int binarySearch(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                // Keep searching in the direction of first/last occurrence
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    // Main function to return first and last positions
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);
        return new int[]{first, last};
    }
}

/**
 * Example:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
