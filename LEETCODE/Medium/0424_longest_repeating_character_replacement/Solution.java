class Solution {
    public int characterReplacement(String s, int k) {
        // Left pointer of sliding window
        int left = 0;

        // Right pointer will move through the string
        int right;

        // Track the maximum frequency of a single character in the current window
        int maxFreq = 0;

        // Array to store frequency of each character (since only uppercase English letters, size = 26)
        int[] freqMap = new int[26];

        // Expand the window with the right pointer
        for (right = 0; right < s.length(); right++) {
            // Convert character to index (A=0, B=1, ..., Z=25) and increase its frequency
            freqMap[s.charAt(right) - 'A'] += 1;

            // Update the max frequency of any character in the current window
            maxFreq = Math.max(maxFreq, freqMap[s.charAt(right) - 'A']);

            // Current window length
            int windowLength = right - left + 1;

            // Check if window is invalid (more than k replacements needed)
            // Condition: characters to replace = windowLength - maxFreq
            if (windowLength - maxFreq > k) {
                // Shrink window from the left by reducing count of left character
                freqMap[s.charAt(left) - 'A'] -= 1;
                left++; // Move left pointer
            }
        }

        // The size of the longest valid window = right - left
        // (since right already moved out of loop, this difference gives max length)
        return right - left;
    }
}
