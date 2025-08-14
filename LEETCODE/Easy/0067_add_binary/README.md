# 67. Add Binary

## Problem Statement

Given two binary strings `a` and `b`, return their sum as a binary string.

### Example 1:

Input: a = "11", b = "1"
Output: "100"

### Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

## Constraints:

- 1 <= a.length, b.length <= 10⁴
- `a` and `b` consist only of `'0'` or `'1'` characters.
- Each string does not contain leading zeros except for the zero itself.

---

## Code Implementation

```java
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Loop until both strings are processed
        while (i >= 0 || j >= 0) {
            int sum = carry;

            // Add bit from a if available
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Add bit from b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Insert the binary digit at the beginning
            result.insert(0, sum % 2);

            // Update carry
            carry = sum / 2;
        }

        // If there is a remaining carry, insert it at the beginning
        if (carry == 1) {
            result.insert(0, '1');
        }

        String finalresult = result.toString();
        return finalresult;
    }
}
Explanation:
Start from the end of both strings, simulating binary addition.

Keep a carry variable to track overflow from each bit addition.

Insert each computed binary digit at the front of the result.

After processing both strings, if carry remains, add it at the start.

Time Complexity: O(max(m, n))
Space Complexity: O(max(m, n))
```
