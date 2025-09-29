# 387. First Unique Character in a String

## Problem Statement

Given a string `s`, return the index of the **first non-repeating character** in it.  
If no such character exists, return `-1`.

---

## Examples

### Example 1

```

Input: s = "leetcode"
Output: 0
Explanation: The character 'l' at index 0 is the first unique character.

```

### Example 2

```

Input: s = "loveleetcode"
Output: 2
Explanation: The character 'v' at index 2 is the first unique character.

```

### Example 3

```

Input: s = "aabb"
Output: -1
Explanation: Every character repeats, so return -1.

```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only lowercase English letters.

---

## Approach

### Key Idea

1. We need to find the **first character that appears exactly once**.
2. Since `s` only has lowercase letters (`a-z`), we can use a fixed-size **array of length 26** to count frequencies.

---

### Steps

1. Traverse the string and update the count of each character.
2. Traverse the string again:
   - The first index where the character count is `1` is our answer.
3. If no unique character is found, return `-1`.

---

## Complexity

- **Time Complexity:** `O(n)`
  - One pass to count characters, another to find the first unique.
- **Space Complexity:** `O(1)`
  - Array of size `26` (constant).

---

## Alternative

We could also use a `HashMap<Character, Integer>` for counting.  
However, since input only contains lowercase letters, an array is more space-efficient and faster.

```


```
