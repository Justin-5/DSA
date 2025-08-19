import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        /*
         * =========================
         * APPROACH 1: Sorting-based
         * =========================
         * - Time Complexity: O(n log n) due to sorting
         * - Idea:
         *   1. Sort the array
         *   2. Walk through the array, counting consecutive sequences
         *   3. Handle duplicates (skip them)
         *   4. Track the maximum sequence length
         *
         * This approach works but is not optimal since sorting dominates.
         */

        // Arrays.sort(nums);
        // int curcount = 1;
        // int maxcount = 1;
        // if (nums.length == 0) {
        //     return 0;
        // }
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] == nums[i - 1]) {
        //         // Skip duplicates
        //         continue;
        //     }
        //     if (nums[i] == nums[i - 1] + 1) {
        //         // Current number continues the sequence
        //         curcount++;
        //     } else {
        //         // Sequence broke, reset count
        //         curcount = 1;
        //     }
        //     maxcount = Math.max(maxcount, curcount);
        // }
        // return maxcount;

        /*
         * ========================
         * APPROACH 2: HashSet-based
         * ========================
         * - Time Complexity: O(n)
         * - Idea:
         *   1. Insert all numbers into a HashSet for O(1) lookups.
         *   2. For each number, check if it’s the "start" of a sequence
         *      → i.e., (num - 1) is not in the set.
         *   3. Expand the sequence by checking consecutive numbers (num+1, num+2...).
         *   4. Track the maximum length.
         *
         * This avoids sorting and ensures linear time performance.
         */

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxcount = 0;

        for (int num : numSet) {
            // Only start counting if this number is the "start" of a sequence
            if (!(numSet.contains(num - 1))) {
                int curnum = num;
                int curcount = 1;

                // Expand sequence forward
                while (numSet.contains(curnum + 1)) {
                    curcount++;
                    curnum += 1;
                }

                // Update global max
                maxcount = Math.max(maxcount, curcount);
            }
        }

        return maxcount;
    }
}
