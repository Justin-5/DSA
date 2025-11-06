import java.util.*;

class Solution {
    @SuppressWarnings("CollectionsToArray")
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedInterval = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            mergedInterval.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge overlapping intervals with newInterval
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        mergedInterval.add(newInterval);

        // Phase 3: Add all remaining intervals
        while (i < n) {
            mergedInterval.add(intervals[i]);
            i++;
        }

        // Convert list to array and return
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}
