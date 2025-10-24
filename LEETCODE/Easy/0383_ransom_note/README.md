# 383. Ransom Note

**Difficulty:** Easy  
**Topics:** Hash Table, String, Counting  
**LeetCode Link:** [383. Ransom Note](https://leetcode.com/problems/ransom-note/)

---

## 🧩 Problem Statement

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine`, and `false` otherwise.

Each letter in `magazine` can only be used **once** in `ransomNote`.

---

## 🔹 Example 1

**Input:**

```

ransomNote = "a"
magazine = "b"

```

**Output:**

```

false

```

---

## 🔹 Example 2

**Input:**

```

ransomNote = "aa"
magazine = "ab"

```

**Output:**

```

false

```

---

## 🔹 Example 3

**Input:**

```

ransomNote = "aa"
magazine = "aab"

```

**Output:**

```

true

```

---

## ⚙️ Constraints

- `1 <= ransomNote.length, magazine.length <= 10^5`
- `ransomNote` and `magazine` consist of lowercase English letters only (`'a'`–`'z'`).

---

## 💡 Approach

### 🧠 Frequency Counting

1. We count the frequency of each character (a–z) in `magazine` using a fixed-size array of length 26.
2. Then, for each character in `ransomNote`:
   - Check if that character is available in the `magazine` frequency array.
   - If not (frequency is 0), return `false`.
   - Otherwise, decrement its count.
3. If all characters in `ransomNote` are found, return `true`.

This ensures every letter in `ransomNote` is accounted for without reuse beyond availability.

---

## 🧾 Code

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Frequency array for all lowercase letters
        int[] charFreq = new int[26];

        // Step 1: Count characters in magazine
        for (char ch : magazine.toCharArray()) {
            int index = ch - 'a'; // Convert 'a'..'z' → 0..25
            charFreq[index]++;
        }

        // Step 2: Check if ransomNote can be constructed
        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            if (charFreq[index] == 0) {
                // This letter not available anymore
                return false;
            }
            charFreq[index]--; // Use one instance of this character
        }

        // Step 3: Successfully used available letters
        return true;
    }
}
```

---

## ⏱️ Complexity Analysis

| Type      | Complexity                                                     |
| --------- | -------------------------------------------------------------- |
| **Time**  | O(n + m), where `n` = ransomNote length, `m` = magazine length |
| **Space** | O(1), since we use only a fixed 26-length array                |

---

## ✅ Example Walkthrough

### Input

```
ransomNote = "aa"
magazine = "aab"
```

### Step-by-Step

| Character | Magazine Count (before) | Result |
| --------- | ----------------------- | ------ |
| 'a'       | 2 → 1                   | OK     |
| 'a'       | 1 → 0                   | OK     |

All characters are available → return `true`.
