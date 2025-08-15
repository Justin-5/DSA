# 242. Valid Anagram

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

---

### Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

### Example 2:

Input: s = "rat", t = "car"
Output: false

---

## Constraints:

- 1 <= s.length, t.length <= 5 × 10⁴
- `s` and `t` consist of lowercase English letters.

**Follow-up:**  
What if the inputs contain Unicode characters? You would need to use a `HashMap<Character, Integer>` instead of an array to count frequencies.

---

## Code Implementation

```java
class Solution {
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
Explanation:
If s and t differ in length, they can’t be anagrams.

Count the frequency of each character from s and t in a single pass:

Increment count for s characters.

Decrement count for t characters.

If all counts are zero after processing, s and t are anagrams.

Time Complexity: O(n)
Space Complexity: O(1) (constant size array of length 26)
```
