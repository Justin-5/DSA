import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // Step 1: Create a frequency map for all characters in t
        Map<Character, Integer> seen = new HashMap<>();
        for (char ch : t.toCharArray()) {
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
        }

        // Number of unique characters from t that we still need to match in s
        int req = seen.size();

        // Two pointers for sliding window
        int left = 0;

        // Variables to track the best (minimum) window
        int minWindow = Integer.MAX_VALUE;
        int startIndex = 0;

        // Step 2: Expand window with right pointer
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            // If current char is part of t, decrease its count in map
            if (seen.containsKey(currChar)) {
                int charCount = seen.get(currChar);
                seen.put(currChar, charCount - 1);

                // When a character count reaches zero, it means all of that char are satisfied
                if (charCount - 1 == 0) {
                    req -= 1;
                }
            }

            // Step 3: Try shrinking window from the left while all requirements are met
            while (req == 0) {
                int currWindow = right - left + 1;

                // Update the minimum window if smaller than the previously found one
                if (currWindow < minWindow) {
                    minWindow = currWindow;
                    startIndex = left;
                }

                // Try removing the leftmost character from the window
                char removeChar = s.charAt(left);
                left++;

                // If it's part of t, update its count in map
                if (seen.containsKey(removeChar)) {
                    seen.put(removeChar, seen.get(removeChar) + 1);

                    // If count becomes positive, it means this character is now "missing" from the window
                    if (seen.get(removeChar) > 0) {
                        req += 1;
                    }
                }
            }
        }

        // Step 4: Return result if valid window found, else empty string
        if (minWindow != Integer.MAX_VALUE) {
            return s.substring(startIndex, startIndex + minWindow);
        } else {
            return "";
        }
    }
}
