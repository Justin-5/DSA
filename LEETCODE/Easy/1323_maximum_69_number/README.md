# 1323. Maximum 69 Number

## Problem Statement

You are given a positive integer `num` consisting only of digits `6` and `9`.  
Return the maximum number you can get by changing at most **one digit** (6 → 9 or 9 → 6).

---

### Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.

### Example 2:

Input: num = 9996
Output: 9999
Explanation:
Changing the last digit 6 to 9 results in the maximum number.

### Example 3:

Input: num = 9999
Output: 9999
Explanation:
It is better not to apply any change.

---

## Constraints:

- 1 <= num <= 10⁴
- `num` consists of only digits `6` and `9`.

---

## Code Implementation

```java
class Solution {
    public int maximum69Number (int num) {
        int temp = num;
        int len = String.valueOf(num).length();  // find number of digits
        int[] digitArray = new int[len];         // store digits in array

        // Convert number into array of digits
        for (int i = len - 1; i >= 0; i--) {
            digitArray[i] = temp % 10;
            temp /= 10;
        }

        // Change the first '6' to '9' (from left to right)
        for (int i = 0; i < len; i++) {
            if (digitArray[i] == 6) {
                digitArray[i] = 9;
                break; // only one change allowed
            }
        }

        // Reconstruct the number from the modified digit array
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 10 + digitArray[i];
        }

        return result;
    }
}
Explanation:
Convert the number into an array of digits.

Traverse from left to right, changing the first occurrence of 6 into 9 (this maximizes the number).

Reconstruct the number and return it.

If there are no 6’s, return the number as-is.

Time Complexity: O(d) where d = number of digits (at most 5, since num <= 10⁴).
Space Complexity: O(d) for the digit array.
```
