
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Determines if two strings s and t are isomorphic.
     * A one-to-one mapping between characters in s and t must exist.
     */
    public boolean isIsomorphic(String s, String t) {
        // Map for character mapping s -> t
        Map<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // Check if t[i] is already used by another character in s
            if (!charMap.containsKey(chS) && charMap.containsValue(chT)) {
                return false;
            }

            // Create mapping if it doesn’t exist
            if (!charMap.containsKey(chS)) {
                charMap.put(chS, chT);
            } 
            // If mapping exists, validate it
            else if (charMap.get(chS) != chT) {
                return false;
            }
        }

        // If all mappings are consistent
        return true;
    }
}
