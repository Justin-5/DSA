// 3158. Find the XOR of Numbers Which Appear Twice
// Approach: HashMap to track frequencies and XOR duplicates
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            // When a number appears twice, XOR it into the result
            if (freqMap.get(num) == 2) {
                res ^= num;
            }
        }
        return res;
    }
}
