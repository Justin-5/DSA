import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap to store the most recent index of each number
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // If number already seen before
            if (seen.containsKey(nums[i])) {
                int j = seen.get(nums[i]);

                // Check if distance between indices <= k
                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            // Update index of the current number
            seen.put(nums[i], i);
        }

        // If no valid pair found
        return false;
    }
}
