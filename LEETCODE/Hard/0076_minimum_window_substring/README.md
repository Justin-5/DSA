# 76. Minimum Window Substring

## Problem Statement

You are given two strings `s` and `t`. Find the **minimum window substring** of `s` such that every character in `t` (including duplicates) is included in the window.  
If no such substring exists, return `""`.

The answer is guaranteed to be unique.

### Example 1

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The substring "BANC" contains 'A', 'B', and 'C' from t.

### Example 2

Input: s = "a", t = "a"
Output: "a"

### Example 3

Input: s = "a", t = "aa"
Output: ""
Explanation: t requires two 'a's but s has only one.

---

## Constraints

- `1 <= m, n <= 10^5`
- `s` and `t` consist of uppercase and lowercase English letters

**Follow up:** Achieve `O(m + n)` time complexity.

---

## Approach

This problem is solved using the **Sliding Window Technique** with two pointers (`left` and `right`).

1. Count frequencies of all characters in `t`.
2. Expand the window by moving the `right` pointer.
3. Whenever all characters from `t` are satisfied within the window, try shrinking it from the left to minimize length.
4. Keep track of the minimum window found so far.
5. Return the substring, or empty string if no valid window exists.

---

## Complexity

- **Time Complexity:** `O(m + n)` → each character is visited at most twice (once by `right` and once by `left`).
- **Space Complexity:** `O(|t|)` for storing frequencies of characters.

---

## Code

```java
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> seen = new HashMap<>();
        for (char ch : t.toCharArray()) {
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
        }

        int req = seen.size();
        int left = 0, minWindow = Integer.MAX_VALUE, startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            if (seen.containsKey(currChar)) {
                int charCount = seen.get(currChar);
                seen.put(currChar, charCount - 1);
                if (charCount - 1 == 0) req--;
            }

            while (req == 0) {
                int currWindow = right - left + 1;
                if (currWindow < minWindow) {
                    minWindow = currWindow;
                    startIndex = left;
                }

                char removeChar = s.charAt(left++);
                if (seen.containsKey(removeChar)) {
                    seen.put(removeChar, seen.get(removeChar) + 1);
                    if (seen.get(removeChar) > 0) req++;
                }
            }
        }

        return (minWindow != Integer.MAX_VALUE) ? s.substring(startIndex, startIndex + minWindow) : "";
    }
}
```
