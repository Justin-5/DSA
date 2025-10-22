// 392. Is Subsequence
// Approach: Two Pointer technique
// Time Complexity: O(n + m)
// Space Complexity: O(1)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // Pointer for string s
        int j = 0; // Pointer for string t

        // Traverse both strings
        while (i < s.length() && j < t.length()) {
            // When characters match, move both pointers
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move t's pointer
            j++;
        }

        // If i has reached the end of s, all characters matched in order
        return i == s.length();
    }
}
