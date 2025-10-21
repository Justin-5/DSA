// 189. Rotate Array
// Approach: Reverse the entire array, then reverse parts
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    // Helper method to reverse a subarray
    public void reverseArray(int[] ar, int start, int end) {
        while (start < end) {
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start++;
            end--;
        }
    }

    // Main rotation method
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        // Step 1: Reverse the entire array
        reverseArray(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverseArray(nums, 0, k - 1);

        // Step 3: Reverse the rest
        reverseArray(nums, k, n - 1);
    }
}

