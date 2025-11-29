class Solution {
    public int minOperations(int[] nums, int k) {

        // Compute total sum of array
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        // If sum is already divisible by k, return 0.
        // Otherwise, we need (sum % k) operations to make it divisible.
        return sum % k;
    }
}
