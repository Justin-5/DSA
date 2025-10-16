// 485. Max Consecutive Ones
// Approach: Single-pass counting with O(n) time and O(1) space

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;    // stores the maximum number of consecutive 1s found so far
        int curMaxOnes = 0; // counts the current streak of 1s

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // Continue the streak
                curMaxOnes++;
            } else {
                // End of a streak; update max if needed and reset
                maxOnes = Math.max(maxOnes, curMaxOnes);
                curMaxOnes = 0;
            }
        }

        // Handle the case where the array ends with 1s
        maxOnes = Math.max(maxOnes, curMaxOnes);

        return maxOnes;
    }
}
