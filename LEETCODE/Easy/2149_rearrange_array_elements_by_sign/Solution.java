
// 2149. Rearrange Array Elements by Sign
// Approach: Two-pointer simulation (positive index, negative index)

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // positive pointer (even indices), negative pointer (odd indices)
        int positive = 0;
        int negative = 1;

        // Traverse through nums and place elements accordingly
        for (int num : nums) {
            if (num > 0) {
                // Place positive numbers at even indices
                res[positive] = num;
                positive += 2;
            } else {
                // Place negative numbers at odd indices
                res[negative] = num;
                negative += 2;
            }
        }

        // Return the rearranged array
        return res;
    }
}
