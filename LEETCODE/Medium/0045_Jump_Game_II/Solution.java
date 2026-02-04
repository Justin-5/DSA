class Solution {
    public int jump(int[] nums) {

        int n = nums.length;

        // If there's only one element, no jump is needed
        if (n == 1) {
            return 0;
        }

        int jumps = 0;        // Number of jumps taken
        int currentEnd = 0;   // End of the current jump range
        int farthest = 0;     // Farthest index reachable so far

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Update the farthest index we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we can already reach the last index, stop
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
