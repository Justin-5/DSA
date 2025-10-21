// 80. Remove Duplicates from Sorted Array II
// Approach: Two-pointer technique allowing at most two occurrences
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0; // Write pointer

        for (int i = 0; i < nums.length; i++) {
            // Always write the first two elements
            // or write nums[i] if it's greater than nums[j - 2]
            if (j < 2 || nums[i] > nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }

        // 'j' represents the new length (k)
        return j;
    }
}
