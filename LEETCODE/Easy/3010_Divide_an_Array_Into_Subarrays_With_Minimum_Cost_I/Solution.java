class Solution {
    public int minimumCost(int[] nums) {

        int n = nums.length;

        // Cost always includes the first element
        int minCost = nums[0];

        // Find the two smallest values after index 0
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        // Add the two smallest values to the cost
        minCost += (min1 + min2);

        return minCost;
    }
}
