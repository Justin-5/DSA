import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0; // Two pointers for the sliding window (left and right boundaries)
        int len = s.length(); 
        int maxLength = 0; // Stores the maximum substring length without repeating characters
        Set<Character> checkDuplicate = new HashSet<>(); // Keeps track of characters inside the current window

        // Expand the right pointer until it reaches the end of the string
        while (r < len) {
            char currChar = s.charAt(r);

            // Case 1: Current character is NOT in the set (no duplicate found)
            if (!checkDuplicate.contains(currChar)) {
                checkDuplicate.add(currChar); // Add the character to the set
                maxLength = Math.max(maxLength, r - l + 1); // Update max length if needed
                r++; // Expand the window by moving right pointer forward
            } 
            // Case 2: Current character IS already in the set (duplicate found)
            else {
                // Shrink the window from the left until the duplicate is removed
                while (checkDuplicate.contains(currChar)) {
                    checkDuplicate.remove(s.charAt(l)); // Remove character at left pointer
                    l++; // Move left pointer forward
                }
            }
        }
        // After processing all characters, return the maximum length found
        return maxLength;
    }
}
