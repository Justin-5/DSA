# 424. Longest Repeating Character Replacement

**Difficulty:** Medium  
**Topics:** Sliding Window, HashMap, Two Pointers

---

## 📌 Problem Statement

You are given a string `s` and an integer `k`.  
You can choose any character of the string and change it to any other uppercase English character.  
You can perform this operation at most `k` times.

Return the **length of the longest substring** containing the same letter you can get after performing the above operations.

---

## 📖 Examples

### Example 1:

**Input:**  
`s = "ABAB", k = 2`

**Output:**  
`4`

**Explanation:**  
Replace the two `'A'`s with `'B'`s (or vice versa) → `"BBBB"` or `"AAAA"`.  
The longest valid substring length is `4`.

---

### Example 2:

**Input:**  
`s = "AABABBA", k = 1`

**Output:**  
`4`

**Explanation:**  
Replace the one `'A'` in the middle with `'B'` → `"AABBBBA"`.  
The substring `"BBBB"` has length `4`.

---

## ✅ Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only uppercase English letters.
- `0 <= k <= s.length`

---

## 💡 Approach

We use a **sliding window** with two pointers (`left` and `right`) and keep track of:

- A frequency map (`freqMap`) of characters in the current window.
- `maxFreq`: The count of the most frequent character in the current window.

### Key Insight:

For a window of length `windowLength` to be valid, the number of replacements required is:

windowLength - maxFreq <= k

- If valid, expand the window (`right++`).
- If invalid, shrink the window from the left (`left++`).

At the end, `right - left` gives the longest valid window length.

---

## ⏱️ Complexity

- **Time Complexity:** `O(n)` → Each character is visited at most twice.
- **Space Complexity:** `O(1)` → Frequency array of size `26` (fixed).

---

## 📝 Code

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right;
        int maxFreq = 0;
        int[] freqMap = new int[26]; // Frequency of each character

        for (right = 0; right < s.length(); right++) {
            // Update frequency of current char
            freqMap[s.charAt(right) - 'A'] += 1;

            // Track max frequency in current window
            maxFreq = Math.max(maxFreq, freqMap[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;

            // If more than k replacements needed, shrink window
            if (windowLength - maxFreq > k) {
                freqMap[s.charAt(left) - 'A'] -= 1;
                left++;
            }
        }

        // The size of the longest valid window
        return right - left;
    }
}
```
