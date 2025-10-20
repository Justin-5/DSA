// 66. Plus One
// Approach: Simulate addition from the last digit, handle carry
// Time Complexity: O(n)
// Space Complexity: O(1) (in-place, except when carry adds a new digit)

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse digits from the last index backwards
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++; // Add 1 to the current digit

            // If digit becomes 10, set to 0 and carry continues
            if (digits[i] == 10) {
                digits[i] = 0;
            } 
            // If no carry needed, return result
            else {
                return digits;
            }
        }

        // If all digits were 9 (e.g., 999 -> 1000)
        int[] res = new int[n + 1];
        res[0] = 1; // Set leading 1
        return res;
    }
}
