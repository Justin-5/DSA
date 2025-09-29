class Solution {
    public int firstUniqChar(String s) {
        // Array to store frequency of each character (a-z)
        int[] charCount = new int[26];

        // First pass: count frequencies
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        // Second pass: find first index with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // If no unique character found
        return -1;
    }
}
