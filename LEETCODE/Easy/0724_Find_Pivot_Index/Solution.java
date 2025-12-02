class Solution {

    public int pivotIndex(int[] nums) {
        // total will store the sum of all elements in the array.
        // We use this to compute the right sum later without extra loops.
        int total = 0;

        // First pass: calculate the total sum of the array.
        for (int n : nums) {
            total += n;
        }

        // left will store the running sum of elements to the LEFT of the current index.
        int left = 0;
        // Second pass: iterate through each index and check if it's a pivot index.
        for (int i = 0; i < nums.length; i++) {
            // For index i:
            // total = left + nums[i] + right
            // => right = total - left - nums[i]
            int right = total - left - nums[i];

            // If left sum equals right sum, we've found the pivot index.
            if (right == left) {
                return i; // Return the leftmost pivot index as soon as we find it.
            }

            // Update left sum by including the current element before moving to the next index.
            left += nums[i];
        }

        // If we finished the loop without finding a pivot index, return -1 as per the problem statement.
        return -1;
    }
}
