class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        // Keep reducing the array until only one element remains
        while (n != 1) {
            int[] newNums = new int[n - 1];

            // Fill newNums with pairwise sums mod 10
            for (int i = 0; i < newNums.length; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }

            // Replace nums with the reduced array
            nums = newNums;
            n--; // size reduces by 1
        }

        // Final remaining element
        return nums[0];
    }
}
