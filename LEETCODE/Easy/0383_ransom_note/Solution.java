

class Solution {
    /**
     * Determines whether the ransomNote can be constructed
     * from the letters available in the magazine.
     *
     * Each letter in the magazine can only be used once.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // Array to store the count of each character from 'a' to 'z'
        int[] charFreq = new int[26];

        // Count frequency of each letter in the magazine
        for (char ch : magazine.toCharArray()) {
            int index = ch - 'a'; // Map 'a'..'z' → 0..25
            charFreq[index]++;
        }

        // Try constructing ransomNote using available characters
        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            if (charFreq[index] == 0) {
                // This letter is not available or already used up
                return false;
            }
            // Use one instance of this letter
            charFreq[index]--;
        }

        // Successfully built the ransom note
        return true;
    }
}
