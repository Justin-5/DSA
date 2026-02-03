class Solution {
    public boolean isTrionic(int[] nums) {

        int n = nums.length;
        int i = 0;

        // Phase 1: strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        // Must have at least one increasing step
        if (i == 0 || i == n - 1) {
            return false;
        }

        int p = i;

        // Phase 2: strictly decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }

        // Must have at least one decreasing step
        if (i == p || i == n - 1) {
            return false;
        }

        int q = i;

        // Phase 3: strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        // Must end exactly at the last index with at least one step

        return !(i == q || i != n - 1);
    }
}
