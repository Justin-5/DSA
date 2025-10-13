
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2273. Find Resultant Array After Removing Anagrams
// Approach: Check anagram between adjacent words using sorting

class Solution {
    // Helper to check if the current word is an anagram of the last one in result list
    private boolean isAnagram(String current, List<String> result) {
        char[] prev = result.get(result.size() - 1).toCharArray();
        char[] curr = current.toCharArray();
        Arrays.sort(prev);
        Arrays.sort(curr);
        return Arrays.equals(prev, curr);
    }

    // Main function
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]); // add first word

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], result)) {
                result.add(words[i]);
            }
        }
        return result;
    }
}
