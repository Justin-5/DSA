// 3350. Adjacent Increasing Subarrays Detection II
// Approach: Greedy + Single Pass with two counters (prev & suff)

import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prev = 0; // length of previous increasing segment
        int suff = 1; // length of current increasing segment
        int k = 0;    // maximum value of k found

        // Traverse through the list
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                // Continue the increasing segment
                suff++;
            } else {
                // Reset: store previous segment, start new one
                prev = suff;
                suff = 1;
            }

            // Update maximum k
            // min(prev, suff): ensures both segments are valid
            // suff / 2 handles continuous increase overlap
            k = Math.max(k, Math.max(suff / 2, Math.min(prev, suff)));
        }

        return k;
    }
}
