# Roman to Integer (LeetCode #13)

## Problem Description

Roman numerals are represented by seven different symbols:  
Symbol Value
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Roman numerals are usually written from largest to smallest left to right.  
However, certain numbers require subtraction notation:

- `I` before `V` (5) or `X` (10) makes 4 and 9.
- `X` before `L` (50) or `C` (100) makes 40 and 90.
- `C` before `D` (500) or `M` (1000) makes 400 and 900.

### Examples:

- `"III"` → `3`
- `"LVIII"` → `58` (L=50, V=5, III=3)
- `"MCMXCIV"` → `1994` (M=1000, CM=900, XC=90, IV=4)

**Constraints:**

- `1 <= s.length <= 15`
- `s` contains only valid Roman numeral characters.
- Guaranteed to be a valid Roman numeral between 1 and 3999.

---

## Approach

We use a **HashMap** to store the value of each Roman numeral symbol.  
We traverse the string **from right to left**, adding or subtracting values:

1. Start with the value of the last character as the initial result.
2. For each character moving leftwards:
   - If its value is **less** than the value to its right, subtract it.
   - Otherwise, add it.
3. Return the final result.

---

## Time & Space Complexity

- **Time Complexity:** `O(n)` where `n` is the length of the Roman numeral string.
- **Space Complexity:** `O(1)` since the HashMap has a fixed size.

---
