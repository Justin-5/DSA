// 3461. Check If Digits Are Equal in String After Operations I
// Approach: Simulation
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();

        // Step 1: Convert string to integer array for easier arithmetic
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        // Step 2: Repeatedly apply the operation until only 2 digits remain
        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            n--; // reduce the array length after each round
        }

        // Step 3: Check if the final two digits are equal
        return arr[0] == arr[1];
    }
}
