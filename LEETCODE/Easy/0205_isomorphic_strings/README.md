# 205. Isomorphic Strings

**Difficulty:** Easy  
**Topics:** Hash Map, String  
**LeetCode Link:** [205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)

---

## 🧩 Problem Statement

Given two strings `s` and `t`, determine if they are **isomorphic**.

Two strings `s` and `t` are **isomorphic** if the characters in `s` can be replaced to get `t`.

- Each character must map to another unique character.
- The mapping must preserve the order of characters.
- No two different characters in `s` can map to the same character in `t`.

---

## 🔹 Example 1

**Input:**

```

s = "egg", t = "add"

```

**Output:**

```

true

```

**Explanation:**

```

Mapping:
e -> a
g -> d

```

Both words become identical after replacement.

---

## 🔹 Example 2

**Input:**

```

s = "foo", t = "bar"

```

**Output:**

```

false

```

**Explanation:**
The letter 'o' in `s` would need to map to both 'a' and 'r' in `t`, which is not allowed.

---

## 🔹 Example 3

**Input:**

```

s = "paper", t = "title"

```

**Output:**

```

true

```

**Explanation:**

```

p -> t
a -> i
e -> l
r -> e

```

The mapping is consistent.

---

## ⚙️ Constraints

- `1 <= s.length <= 5 * 10^4`
- `t.length == s.length`
- `s` and `t` consist of any valid ASCII characters.

---

## 💡 Approach

We need a **one-to-one mapping** between characters of `s` and `t`.

### 🔸 Steps:

1. Use a `HashMap<Character, Character>` to store mapping from `s → t`.
2. For each index `i`:
   - If the character `s[i]` is **not yet mapped**:
     - Check if `t[i]` is **already used** by another character.  
       If yes → return `false`.
     - Otherwise, add the mapping `s[i] → t[i]`.
   - If `s[i]` is already mapped, verify that the existing mapping matches `t[i]`.  
     If not → return `false`.
3. If all pairs match, return `true`.

---

## 🧠 Example Walkthrough

### Input:

```

s = "egg", t = "add"

```

### Iteration:

| i   | s[i] | t[i] | Mapping            | Result |
| --- | ---- | ---- | ------------------ | ------ |
| 0   | e    | a    | e → a              | valid  |
| 1   | g    | d    | g → d              | valid  |
| 2   | g    | d    | already consistent | ✅     |

✅ Return `true`.

---

## 🧾 Code

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Map from characters in s → characters in t
        Map<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // If s[i] not mapped but t[i] already used by another s char → invalid
            if (!charMap.containsKey(chS) && charMap.containsValue(chT)) {
                return false;
            }

            // If no mapping exists, create one
            if (!charMap.containsKey(chS)) {
                charMap.put(chS, chT);
            }
            // If mapping exists but does not match → invalid
            else if (charMap.get(chS) != chT) {
                return false;
            }
        }
        return true;
    }
}
```

---

## ⏱️ Complexity Analysis

| Type      | Complexity                                               |
| --------- | -------------------------------------------------------- |
| **Time**  | O(n²) — due to `containsValue()` check in each iteration |
| **Space** | O(n) — for storing mappings                              |

---

## 🚀 Optimization

We can achieve **O(n)** time complexity by using **two arrays** (`s→t` and `t→s`) to record bidirectional mappings:

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[256]; // ASCII mapping from s to t
        int[] mapTS = new int[256]; // ASCII mapping from t to s

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mapST[chS] == 0 && mapTS[chT] == 0) {
                mapST[chS] = chT;
                mapTS[chT] = chS;
            } else if (mapST[chS] != chT || mapTS[chT] != chS) {
                return false;
            }
        }
        return true;
    }
}
```

✅ **Optimized:** O(n) time, O(1) space.
