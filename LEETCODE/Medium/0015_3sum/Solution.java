import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         * ======================
         * PROBLEM: 3Sum
         * ======================
         * - Find all unique triplets (i, j, k) such that:
         *      nums[i] + nums[j] + nums[k] == 0
         * - Return list of triplets with no duplicates.
         *
         * Example:
         * Input: nums = [-1,0,1,2,-1,-4]
         * Output: [[-1,-1,2],[-1,0,1]]
         *
         * ----------------------
         * APPROACH: Sorting + Two Pointers
         * ----------------------
         * 1. Sort the array → ensures duplicates are adjacent.
         * 2. Fix one element (nums[i]) at a time.
         * 3. Use two-pointer approach (j, k) to find pairs such that:
         *        nums[i] + nums[j] + nums[k] == 0
         * 4. Skip duplicates:
         *    - For i: skip if nums[i] == nums[i-1]
         *    - For j, k: skip duplicates after finding a triplet
         *
         * Time Complexity: O(n^2)
         *   - Sorting: O(n log n)
         *   - Two-pointer scan for each element: O(n^2)
         * Space Complexity: O(1) extra (ignoring output list)
         */

        Arrays.sort(nums);                 // Step 1: sort the array
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // Step 2: iterate fixing one number at a time
        for (int i = 0; i < len; i++) {
            // Skip duplicates for nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];         // target for two-sum
            int j = i + 1;
            int k = len - 1;

            // Step 3: two-pointer search for nums[j] + nums[k] = target
            while (j < k) {
                if (nums[j] + nums[k] < target) {
                    j++; // need a larger sum
                } else if (nums[j] + nums[k] > target) {
                    k--; // need a smaller sum
                } else {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Step 4: skip duplicates for nums[j] and nums[k]
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
