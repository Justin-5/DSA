// 4. Median of Two Sorted Arrays
// Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Hard difficulty
//
// Approach: Binary Search Partition
// --------------------------------------------------
// 1. We want to partition both arrays into "left" and "right" halves
//    such that every element in left half <= every element in right half.
// 2. We binary search on the smaller array (nums1).
//    - Partition nums1 at index i
//    - Partition nums2 at index j = (m + n + 1)/2 - i
// 3. Conditions for correct partition:
//    - maxLeft1 <= minRight2
//    - maxLeft2 <= minRight1
// 4. If correct partition is found:
//    - If total length is odd → median = max(maxLeft1, maxLeft2)
//    - If even → median = (max(maxLeft1,maxLeft2)+min(minRight1,minRight2)) / 2
//
// Time Complexity: O(log(min(m, n)))
// Space Complexity: O(1)
//
// Example: nums1 = [1,3], nums2 = [2]
// - Partition nums1 = [1] | [3]
// - Partition nums2 = [2] | []
// - Left = [1,2], Right = [3]
// - Median = 2

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array (binary search on smaller size)
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int half = (m + n + 1) / 2;

        while (left <= right) {
            int partition1 = left + (right - left) / 2;
            int partition2 = half - partition1;

            // Elements around partitions
            int maxLeft1  = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2  = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Correct partition found
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 != 0) {
                    // Odd total length → take max of left side
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // Even → average of max left and min right
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            }
            // Too many elements from nums1 → move left
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            }
            // Too few elements from nums1 → move right
            else {
                left = partition1 + 1;
            }
        }

        // Should not reach here if input is valid
        return 0;
    }
}
