# 0043. Multiply Strings

## Problem

Given two non-negative integers represented as strings, multiply them and return the result as a string.

---

## Examples

### Example 1

Input: num1 = "2", num2 = "3"
Output: "6"

shell
Copy
Edit

### Example 2

Input: num1 = "123", num2 = "456"
Output: "56088"

yaml
Copy
Edit

---

## Constraints

- 1 <= num1.length, num2.length <= 200
- num1 and num2 contain digits only
- No leading zeros except for zero itself

---

## Approach

- This implementation uses basic digit-by-digit multiplication like you would by hand.
- The intermediate results are stored in a result array of size `m + n`.
- Leading zeros are skipped in the final result string.
- No use of BigInteger libraries or direct integer conversions.

---

## Output

Product of 123 and 456 is 56088

yaml
Copy
Edit

---

## Note

This is a **non-optimized** C implementation focusing on clarity and following the problem’s constraints.

Simple implementation by Justin Aroza
