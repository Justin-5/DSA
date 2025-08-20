class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
         * ======================
         * APPROACH: Two Pointers
         * ======================
         * - Since the array is sorted in non-decreasing order,
         *   we can use a two-pointer strategy to find the pair.
         *
         * Steps:
         * 1. Initialize two pointers:
         *    - i = start of array
         *    - j = end of array
         * 2. Compute sum = numbers[i] + numbers[j]
         *    - If sum < target → move left pointer forward (i++)
         *      (because we need a bigger sum)
         *    - If sum > target → move right pointer backward (j--)
         *      (because we need a smaller sum)
         *    - If sum == target → return indices (1-indexed)
         *
         * Time Complexity: O(n) — each element is visited at most once
         * Space Complexity: O(1) — only constant space used
         *
         * Note: The problem guarantees exactly one solution,
         * so we can safely return once found.
         */

        int i = 0, j = numbers.length - 1;   // two pointers at start and end
        int[] result = new int[2];           // to store answer indices

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum < target) {
                // Current sum is too small → move left pointer forward
                i++;
            } else if (sum > target) {
                // Current sum is too large → move right pointer backward
                j--;
            } else {
                // Found the pair → convert to 1-indexed and return
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
}
