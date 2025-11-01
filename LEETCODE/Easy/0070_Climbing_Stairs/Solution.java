class Solution {
    // Dynamic Programming Approach
    // Each step can be reached from one of the two previous steps.
    // Hence, this problem is equivalent to computing the Fibonacci sequence.

    public int climbStairs(int n) {
        // Base cases
        if (n == 1 || n == 2) {
            return n;
        }

        // dp[i] = number of ways to reach step i
        // We only need the last two computed values
        int first = 1;  // ways to reach step 1
        int second = 2; // ways to reach step 2
        int[] dp = new int[n];

        // Compute number of ways for each step
        for (int i = 2; i < n; i++) {
            dp[i] = first + second;
            first = second;
            second = dp[i];
        }

        // Return total ways to reach nth step
        return dp[n - 1];
    }
}
