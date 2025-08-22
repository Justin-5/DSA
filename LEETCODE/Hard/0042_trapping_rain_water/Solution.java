class Solution {
    public int trap(int[] height) {
        /*
         * ---------------- BRUTE FORCE APPROACH ----------------
         * Time Complexity: O(n^2)   |   Space Complexity: O(1)
         *
         * Idea:
         * For each bar, calculate the maximum height to its left
         * and maximum height to its right. The water trapped at that bar
         * will be min(maxLeft, maxRight) - height[i].
         * 
         * Problem: For every index, scanning left and right takes O(n),
         * so the overall time complexity is O(n^2).
         */
        
        // int len = height.length;
        // int totalWater = 0;
        // for (int i = 1; i < len - 1; i++) {
        //     int left = 0;
        //     int right = len - 1;
        //     int maxLeft = 0;
        //     int maxRight = 0;
        //
        //     // Find max height on the left of current index
        //     while (left < i) {
        //         maxLeft = Math.max(maxLeft, height[left]);
        //         left++;
        //     }
        //
        //     // Find max height on the right of current index
        //     while (right > i) {
        //         maxRight = Math.max(maxRight, height[right]);
        //         right--;
        //     }
        //
        //     // Water trapped = min(leftMax, rightMax) - height[i]
        //     int trappedWater = Math.min(maxLeft, maxRight) - height[i];
        //     if (trappedWater > 0)
        //         totalWater += trappedWater;
        // }
        // return totalWater;



        /*
         * ---------------- OPTIMIZED TWO-POINTER APPROACH ----------------
         * Time Complexity: O(n)   |   Space Complexity: O(1)
         *
         * Idea:
         * Use two pointers (left, right) and track the max height from
         * the left side and the right side as we move inward.
         * 
         * At each step:
         * - Compare height[left] and height[right].
         * - If height[left] < height[right]:
         *      Update maxLeft and calculate trapped water at 'left'.
         *      Move left pointer forward.
         * - Otherwise:
         *      Update maxRight and calculate trapped water at 'right'.
         *      Move right pointer backward.
         *
         * This works because water trapping depends on the smaller boundary.
         * By processing the side with the smaller height first, we ensure
         * correctness while scanning only once.
         */
        
        int len = height.length;
        int totalWater = 0;
        int left = 0;
        int right = len - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while(left < right){
            if(height[left] < height[right]){
                // Update maxLeft and calculate water trapped at left
                maxLeft = Math.max(maxLeft, height[left]);
                totalWater += (maxLeft - height[left]);
                left++;
            } else {
                // Update maxRight and calculate water trapped at right
                maxRight = Math.max(maxRight, height[right]);
                totalWater += (maxRight - height[right]);
                right--;
            }
        }
        return totalWater;
    }
}
