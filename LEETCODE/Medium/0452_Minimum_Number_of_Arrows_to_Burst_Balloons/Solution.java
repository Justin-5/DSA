import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort intervals by their starting x-coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int arrowCount = 1;  // At least one arrow is needed
        int curOverLap = points[0][1]; // End of the first balloon's range
        int n = points.length;

        // Iterate through all balloons
        for (int i = 1; i < n; i++) {
            // If the next balloon starts after the overlap → need a new arrow
            if (curOverLap < points[i][0]) {
                arrowCount++;
                curOverLap = points[i][1]; // Reset overlap range
            } else {
                // Overlapping interval → shrink overlap range
                curOverLap = Math.min(curOverLap, points[i][1]);
            }
        }

        return arrowCount;
    }
}
