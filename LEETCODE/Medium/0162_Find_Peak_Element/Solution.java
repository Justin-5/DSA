class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If slope is rising → move right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            // If slope is falling → move left (peak could be mid)
            else {
                right = mid;
            }
        }

        // Both pointers meet at a peak
        return left;
    }
}
