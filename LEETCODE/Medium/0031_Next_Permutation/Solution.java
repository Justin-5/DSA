import java.util.Arrays;

class Solution {
    // Swap helper function
    public void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    // Reverse helper function
    public void reverse(int[] n, int i, int j) {
        while (i < j) {
            swap(n, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean flag = false;

        // Step 1: Check if there is at least one increasing pair
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                flag = true;
                break;
            }
        }

        // If array is descending, sort ascending
        if (!flag) {
            Arrays.sort(nums);
        } else {
            int firstDecreasingIndex = 0;
            int firstGreatest = Integer.MAX_VALUE;
            int firstGreatestIndex = 0;

            // Step 2: Find the first decreasing index from the right
            for (int i = n - 1; i >= 1; i--) {
                if (nums[i - 1] < nums[i]) {
                    firstDecreasingIndex = i - 1;
                    break;
                }
            }

            // Step 3: Find the next greater element to swap
            for (int i = n - 1; i > firstDecreasingIndex; i--) {
                if (nums[i] > nums[firstDecreasingIndex] && nums[i] < firstGreatest) {
                    firstGreatest = nums[i];
                    firstGreatestIndex = i;
                }
            }

            // Step 4: Swap and reverse the suffix
            swap(nums, firstDecreasingIndex, firstGreatestIndex);
            reverse(nums, firstDecreasingIndex + 1, n - 1);
        }
    }
}
