class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {

        // Total profit without any modification
        long originalProfit = 0;
        int len = prices.length;

        // Half of the window size
        int mid = k / 2;

        // Calculate original profit
        for (int i = 0; i < len; i++) {
            originalProfit += (long) prices[i] * strategy[i];
        }

        // Stores the profit change for the current k-length window
        long changeProfit = 0;

        // Calculate profit change for the first window [0, k-1]
        for (int i = 0; i < k; i++) {
            if (i < mid) {
                // First half becomes 0 (hold), so remove original contribution
                changeProfit += -(long) prices[i] * strategy[i];
            } else {
                // Second half becomes 1 (sell)
                changeProfit += prices[i] - (long) prices[i] * strategy[i];
            }
        }

        // Track maximum profit change among all windows
        long maxProfit = changeProfit;

        // Slide the window across the array
        for (int i = 1; i <= len - k; i++) {

            // Index leaving the window
            int prev = i - 1;

            // Index shifting from sell-half to hold-half
            int shift = i + mid - 1;

            // New index entering the sell-half
            int end = i + k - 1;

            // Remove effect of outgoing first-half element
            long leftEnd = -(long) prices[prev] * strategy[prev];
            changeProfit -= leftEnd;

            // Remove old sell contribution of shift element
            long rightShift = prices[shift] - (long) prices[shift] * strategy[shift];
            changeProfit -= rightShift;

            // Add new hold contribution of shift element
            long leftShift = -(long) prices[shift] * strategy[shift];
            changeProfit += leftShift;

            // Add sell contribution of new entering element
            long rightEnd = prices[end] - (long) prices[end] * strategy[end];
            changeProfit += rightEnd;

            // Update maximum profit change
            maxProfit = Math.max(maxProfit, changeProfit);
        }

        // Return original profit plus best positive modification
        return originalProfit + Math.max(0, maxProfit);
    }
}
