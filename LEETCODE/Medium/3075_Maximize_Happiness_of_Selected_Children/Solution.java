import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        // Sort happiness values to access the largest values first
        Arrays.sort(happiness);

        int i = happiness.length - 1;  // Start from the largest element
        long maxSum = 0;               // Stores the maximum happiness sum
        int sub = 0;                   // Tracks total decrement applied so far

        // Select k children
        while (k > 0 && i >= 0) {

            // Effective happiness after decrement
            int current = Math.max(happiness[i] - sub, 0);

            // Add to result
            maxSum += current;

            // Each selection increases decrement for remaining children
            sub++;

            // Move to next largest value
            i--;
            k--;
        }

        return maxSum;
    }
}
