// 1004. Max Consecutive Ones III
// Approach: Sliding Window with Two Pointers
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;            // left pointer of the window
        int zeroes = 0;       // count of zeros in the current window
        int maxOnes = 0;      // maximum length of a valid window

        for (int j = 0; j < nums.length; j++) {
            // If current element is 0, increase zero count
            if (nums[j] == 0) {
                zeroes++;
            }

            // If zeros exceed k, shrink the window from the left
            while (zeroes > k) {
                if (nums[i] == 0) {
                    zeroes--;
                }
                i++;
            }

            // Update maxOnes with the current valid window size
            maxOnes = Math.max(maxOnes, j - i + 1);
        }

        return maxOnes;
    }
}
