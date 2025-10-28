import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");
        if (word.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            // If pattern char not yet mapped but the word already used
            if (!map.containsKey(ch) && map.containsValue(word[i])) {
                return false;
            }

            // Map new pattern char to word
            if (!map.containsKey(ch)) {
                map.put(ch, word[i]);
            } 
            // If already mapped, check consistency
            else if (!map.get(ch).equals(word[i])) {
                return false;
            }
        }

        return true;
    }
}
