# 49. Group Anagrams

## Problem Statement

Given an array of strings `strs`, group the anagrams together.  
You can return the answer in any order.

---

### Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

"bat" has no anagrams in the list.

"tan" and "nat" are anagrams.

"ate", "eat", and "tea" are anagrams.

### Example 2:

Input: strs = [""]
Output: [[""]]

### Example 3:

Input: strs = ["a"]
Output: [["a"]]

---

## Constraints:

- 1 <= strs.length <= 10⁴
- 0 <= strs[i].length <= 100
- strs[i] consists of lowercase English letters

---

## Code Implementation

```java
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
Explanation
Each string is sorted alphabetically to form a key (e.g., "eat" → "aet").

All words that share the same sorted key are grouped together in the HashMap.

Finally, the grouped values from the map are returned.

Time Complexity:

Sorting each string: O(L log L), where L is the length of the string.

Doing this for N strings: O(N · L log L).

Space Complexity: O(N · L) for storing the grouped anagrams.
```
