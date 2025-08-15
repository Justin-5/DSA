
public class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int i = 0;
        // Array to store frequency differences for each letter
        int[] freq = new int[26];

        // Process both strings simultaneously
        while (i < s.length()) {
            int index = s.charAt(i) - 'a';
            freq[index]++; // increment for s

            index = t.charAt(i) - 'a';
            freq[index]--; // decrement for t

            i++;
        }

        // If all frequencies are zero, they are anagrams
        for (int j = 0; j < 26; j++) {
            if (freq[j] != 0) {
                return false;
            }
        }
        return true;
    }
}
 
