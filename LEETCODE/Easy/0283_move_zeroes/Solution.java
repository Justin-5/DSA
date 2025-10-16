// 283. Move Zeroes
// Approach: Two-pointer method (in-place, O(n) time, O(1) space)

class Solution {
    public void moveZeroes(int[] nums) {
        int insert = 0; // Pointer to track position for next non-zero element

        // First pass: move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insert++] = nums[i];
            }
        }

        // Second pass: fill remaining positions with zeroes
        while (insert < nums.length) {
            nums[insert++] = 0;
        }
    }
}

