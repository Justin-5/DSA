// 268. Missing Number
// Approach: Math formula (Sum of first n natural numbers)
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Expected sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Calculate actual sum of elements in nums
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // Missing number is the difference between expected and actual sums
        return expectedSum - actualSum;
    }
}
