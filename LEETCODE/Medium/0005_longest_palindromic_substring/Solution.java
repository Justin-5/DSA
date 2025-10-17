// 5. Longest Palindromic Substring
// Approach: Expand Around Center
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {

    // Helper method: expands around given center and returns palindrome length
    public int checkPalindrome(char[] ch, int mid1, int mid2) {
        // Expand outwards as long as characters match and indices are valid
        while (mid1 >= 0 && mid2 < ch.length && ch[mid1] == ch[mid2]) {
            mid1--;
            mid2++;
        }
        // Return length of palindrome found
        return mid2 - mid1 - 1;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0; // start index of longest palindrome
        int end = 0;   // end index of longest palindrome
        char[] st = s.toCharArray();

        // Loop through each character as potential center
        for (int i = 0; i < st.length; i++) {
            // Check both odd and even length palindromes
            int len1 = checkPalindrome(st, i, i);       // odd length
            int len2 = checkPalindrome(st, i, i + 1);   // even length
            int len = Math.max(len1, len2);

            // Update start and end indices if new max length found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }
}
