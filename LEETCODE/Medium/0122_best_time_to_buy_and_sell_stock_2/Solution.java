// 122. Best Time to Buy and Sell Stock II
// Approach: Greedy
// Intuition: Capture every increasing pair of prices as profit
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Traverse through all consecutive days
        for (int i = 0; i < prices.length - 1; i++) {
            // If price goes up, add the profit
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }

        return maxProfit;
    }
}
