import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to group strings by their sorted character form
        Map<String, List<String>> sortedAnagram = new HashMap<>();

        // For each string in input
        for (String str : strs) {
            // Convert string to char array and sort it
            char[] sortCharArray = str.toCharArray();
            Arrays.sort(sortCharArray);

            // The sorted string will act as the key
            String key = new String(sortCharArray);

            // Add the original string into the map under the sorted key
            sortedAnagram.computeIfAbsent(key, k -> new ArrayList<>()).add(str);

            // Alternative equivalent code:
            // if (!sortedAnagram.containsKey(key)) {
            //     sortedAnagram.put(key, new ArrayList<>());
            // }
            // sortedAnagram.get(key).add(str);
        }

        // Convert map values to a list of lists
        List<List<String>> result = new ArrayList<>(sortedAnagram.values());
        return result;
    }
}
