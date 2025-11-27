class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // If k <= 1, no positive number can produce product < k
        if (k <= 1) return 0;

        int i = 0;        // Left pointer of sliding window
        int prod = 1;     // Product of current window
        int count = 0;    // Result counter

        // Expand window by moving right pointer
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];

            // Shrink window if product is too large
            while (prod >= k && i <= j) {
                prod /= nums[i];
                i++;
            }

            // All subarrays nums[i..j], nums[i+1..j], ..., nums[j..j] are valid
            count += j - i + 1;
        }

        return count;
    }
}
