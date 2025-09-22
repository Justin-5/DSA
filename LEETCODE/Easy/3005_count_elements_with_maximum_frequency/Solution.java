import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Frequency map to count occurrences of each number
        Map<Integer, Integer> freq = new HashMap<>();
        
        int maxFreq = 0;   // Maximum frequency observed
        int maxCount = 0;  // Sum of frequencies of elements with maxFreq
        
        for (int num : nums) {
            // Update frequency
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            int count = freq.get(num);
            
            // If this number now has the highest frequency
            if (count > maxFreq) {
                maxFreq = count;      // Update max frequency
                maxCount = count;     // Reset maxCount to this frequency
            }
            // If this number matches the current maximum frequency
            else if (count == maxFreq) {
                maxCount += count;    // Add its contribution
            }
        }
        
        return maxCount;
    }
}
