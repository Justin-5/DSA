# 3. Longest Substring Without Repeating Characters

**Difficulty:** Medium  
**Topics:** HashSet, Sliding Window, Two Pointers

---

## 📌 Problem Statement

Given a string `s`, find the length of the longest substring without duplicate characters.

---

## 📖 Examples

### Example 1:

**Input:**  
`s = "abcabcbb"`

**Output:**  
`3`

**Explanation:**  
The answer is `"abc"`, with the length of 3.

---

### Example 2:

**Input:**  
`s = "bbbbb"`

**Output:**  
`1`

**Explanation:**  
The answer is `"b"`, with the length of 1.

---

### Example 3:

**Input:**  
`s = "pwwkew"`

**Output:**  
`3`

**Explanation:**  
The answer is `"wke"`, with the length of 3.  
Note: `"pwke"` is a subsequence and not a substring.

---

## ✅ Constraints

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols and spaces.

---

## 💡 Approach

We use a **sliding window technique** with two pointers (`l` and `r`) and a `HashSet` to track characters currently in the window.

- Expand the window by moving `r` and adding characters.
- If a duplicate is found, shrink the window from the left (`l`) until the duplicate is removed.
- At each step, update the maximum window size.

This ensures we always have the longest valid substring in the current window.

---

## ⏱️ Complexity

- **Time Complexity:** `O(n)` → Each character is added and removed at most once.
- **Space Complexity:** `O(min(n, charset))` → At most stores all unique characters.

---

## 📝 Code

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0; // Two pointers for sliding window
        int len = s.length();
        int maxLength = 0; // Stores maximum substring length
        Set<Character> checkDuplicate = new HashSet<>();

        while (r < len) {
            char currChar = s.charAt(r);

            // Case 1: No duplicate found → expand window
            if (!checkDuplicate.contains(currChar)) {
                checkDuplicate.add(currChar);
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            }
            // Case 2: Duplicate found → shrink window
            else {
                while (checkDuplicate.contains(currChar)) {
                    checkDuplicate.remove(s.charAt(l));
                    l++;
                }
            }
        }
        return maxLength;
    }
}
```
