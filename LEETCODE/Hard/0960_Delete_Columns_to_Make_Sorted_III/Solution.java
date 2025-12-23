class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length;               // Number of rows
        int len = strs[0].length();        // Number of columns

        // dp[i] = length of longest valid column sequence ending at i
        int[] dp = new int[len];

        int maxKeep = 1;                   // Maximum columns we can keep

        // Iterate through each column
        for (int i = 0; i < len; i++) {

            // Every column can at least form a sequence of length 1
            dp[i] = 1;

            // Try to extend sequences ending at earlier columns
            for (int j = 0; j < i; j++) {

                boolean isValid = true;

                // Check if column j can come before column i for all rows
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        isValid = false;
                        break;
                    }
                }

                // If valid, update dp[i]
                if (isValid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Track maximum columns that can be kept
            maxKeep = Math.max(maxKeep, dp[i]);
        }

        // Minimum deletions = total columns - maximum columns kept
        return len - maxKeep;
    }
}
