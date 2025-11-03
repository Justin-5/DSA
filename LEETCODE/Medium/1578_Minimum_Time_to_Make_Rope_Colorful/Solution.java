class Solution {

    // Helper method: compute the cost of removing all balloons in [s, e]
    // except the one with the highest removal time.
    public int minSum(int s, int e, int[] a) {
        int max = 0;
        int total = 0;
        for (int i = s; i <= e; i++) {
            max = Math.max(max, a[i]);
            total += a[i];
        }
        return total - max;  // remove all but the most costly one
    }

    public int minCost(String colors, int[] neededTime) {
        int start = 0, end = 1;
        int minTime = 0;

        while (end < colors.length()) {
            if (colors.charAt(start) == colors.charAt(end)) {
                // same color — extend segment
                end++;
            } else if (end - start > 1) {
                // segment of identical colors ends here
                minTime += minSum(start, end - 1, neededTime);
                start = end;
                end++;
            } else {
                // no duplicates in this step
                start++;
                end++;
            }
        }

        // Handle the last color segment if it ends with duplicates
        if (end - start > 1) {
            minTime += minSum(start, end - 1, neededTime);
        }

        return minTime;
    }
}
