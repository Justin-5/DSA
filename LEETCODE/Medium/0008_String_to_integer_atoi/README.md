# 8. String to Integer (atoi)

**Difficulty:** Medium  
**Language:** Java

## Problem Statement

Implement the `myAtoi(String s)` function, which converts a string to a 32-bit signed integer according to the following rules:

1. **Whitespace**: Ignore any leading whitespace `" "`.
2. **Signedness**: Determine the sign by checking if the next character is `'-'` or `'+'`. Assume positivity if neither is present.
3. **Conversion**: Read digits until a non-digit character is encountered or the end of the string is reached.
4. **Overflow Handling**:
   - If the integer exceeds `2^31 - 1` (2147483647), return `Integer.MAX_VALUE`.
   - If the integer is less than `-2^31` (-2147483648), return `Integer.MIN_VALUE`.

---

## Examples

### Example 1

**Input:**  
`s = "42"`  
**Output:**  
`42`

### Example 2

**Input:**  
`s = "   -042"`  
**Output:**  
`-42`

### Example 3

**Input:**  
`s = "1337c0d3"`  
**Output:**  
`1337`

### Example 4

**Input:**  
`s = "0-1"`  
**Output:**  
`0`

### Example 5

**Input:**  
`s = "words and 987"`  
**Output:**  
`0`

---

## Constraints

- `0 <= s.length <= 200`
- `s` consists of:
  - English letters (a–z, A–Z)
  - Digits (0–9)
  - Space `' '`
  - Signs `'+'` or `'-'`
  - Period `'.'`

---

## Approach

This implementation:

1. Skips leading spaces.
2. Detects optional sign.
3. Reads numeric digits one by one.
4. Uses a `long` variable to detect overflow before converting to `int`.
5. Clamps values to `Integer.MAX_VALUE` or `Integer.MIN_VALUE` when overflow/underflow occurs.

---

## Code

See [main.java](main.java) for the complete solution with comments.
