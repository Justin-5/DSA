# 0058. Length of Last Word

## Problem Statement

Given a string `s` consisting of words and spaces, return the **length of the last word** in the string.

A **word** is defined as a maximal substring consisting of **non-space characters** only.

---

## Examples

### Example 1

Input: s = "Hello World"
Output: 5
Explanation: Last word is "World"

### Example 2

Input: s = " fly me to the moon "
Output: 4
Explanation: Last word is "moon"

### Example 3

Input: s = "luffy is still joyboy"
Output: 6
Explanation: Last word is "joyboy"

---

## Constraints

- 1 <= s.length <= 10⁴
- `s` consists of only English letters and spaces `' '`.
- There is at least one word in `s`.

---

## Approach

1. Start from the end of the string.
2. Skip any trailing spaces.
3. Count the number of characters in the last word by checking for alphabetic characters.
4. Return the count.

---

## Time & Space Complexity

- **Time Complexity**: O(n) — where `n` is the length of the string.
- **Space Complexity**: O(1) — constant space.

---

Solution by Justin Aroza
