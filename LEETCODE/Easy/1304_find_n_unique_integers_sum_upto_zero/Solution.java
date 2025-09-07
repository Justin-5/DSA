// 1304. Find N Unique Integers Sum up to Zero
// Problem: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
//
// Approach:
// - We need n unique integers that sum up to zero.
// - Use pairs of numbers (i, -i).
// - If n is odd, include 0 in the array.
// 
// Example: 
// n = 5 → [1, -1, 2, -2, 0]
// n = 4 → [1, -1, 2, -2]
//
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding output array)

class Solution {

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int index = 0;

        // Add pairs of (i, -i)
        for (int i = 1; i <= n / 2; i++) {
            arr[index++] = i;
            arr[index++] = -i;
        }

        // If n is odd, add 0
        if (n % 2 == 1) {
            arr[index] = 0;
        }

        return arr;
    }
}
