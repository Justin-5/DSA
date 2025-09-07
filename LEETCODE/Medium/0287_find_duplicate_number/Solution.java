class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];           // Move one step
            fast = nums[nums[fast]];     // Move two steps
        } while (slow != fast);          // Keep going until they meet

        // Phase 2: Find the entry point of the cycle (the duplicate number)
        slow = nums[0];                  // Reset slow to start
        while (slow != fast) {
            slow = nums[slow];           // Move one step
            fast = nums[fast];           // Move one step
        }

        // Both meet at the duplicate number
        return slow;
    }
}
