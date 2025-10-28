import java.util.Arrays;

class Solution {

    // Simulates the process starting from position `cur` and direction
    // direction == true → right, false → left
    public int op(int cur, boolean direction, int[] arr) {
        int size = arr.length;
        int[] n = arr.clone(); // Clone to preserve the original array

        // Simulate movement
        while (cur < size && cur >= 0) {
            if (n[cur] > 0) {
                n[cur]--;
                // Reverse direction when a positive element is decremented
                direction = !direction;
            }
            // Move in the current direction
            cur = direction ? cur + 1 : cur - 1;
        }

        // Check if all elements became zero
        if (Arrays.stream(n).allMatch(num -> num == 0)) {
            return 1; // Valid selection
        }
        return 0; // Invalid selection
    }

    public int countValidSelections(int[] nums) {
        int valid = 0;

        // Try all positions that have zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // Test both directions
                valid += op(i, true, nums);  // Right
                valid += op(i, false, nums); // Left
            }
        }
        return valid;
    }
}
