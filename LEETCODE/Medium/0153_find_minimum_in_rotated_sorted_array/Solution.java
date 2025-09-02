// 153. Find Minimum in Rotated Sorted Array
// Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Medium difficulty
//
// Approach:
// - We need to find the smallest element in a rotated sorted array.
// - Since array is rotated, the smallest element is the "rotation point".
// - Use binary search with O(log n) time.
//
// Key Observations:
// 1. If the array is already sorted (nums[left] < nums[right]), then nums[left] is the minimum.
// 2. Otherwise, check the middle element:
//    - If nums[mid] > nums[right], the minimum must be in the right half.
//    - Else, the minimum lies in the left half (including mid).
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // Case 1: Already sorted (no rotation)
        if (nums[r] >= nums[l]) {
            return nums[l];
        }

        // Case 2: Binary search for rotation point
        while (l < r) {
            int mid = l + (r - l) / 2;

            // If mid > right, min is to the right of mid
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } 
            // Otherwise, min is at mid or to the left of mid
            else {
                r = mid;
            }
        }

        // l == r is the minimum
        return nums[l];
    }
}
