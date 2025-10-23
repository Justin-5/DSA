

// 55. Jump Game
// Approach 1: Dynamic Programming (Bottom-Up)
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true; // Base case: last index can always reach itself

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Check if this index can reach any index that is true
            for (int j = i + 1; j <= Math.min(i + nums[i], n - 1); j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
