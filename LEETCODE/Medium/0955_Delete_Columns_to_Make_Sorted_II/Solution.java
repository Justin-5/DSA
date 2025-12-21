class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length;               // Number of strings (rows)
        int len = strs[0].length();        // Length of each string (columns)
        int delCount = 0;                  // Count of deleted columns

        // Tracks whether row j and j+1 are already confirmed sorted
        boolean[] sortedRow = new boolean[n];

        // Number of adjacent row pairs already sorted
        int sortedCount = 0;

        // Flag to indicate whether current column must be deleted
        boolean deleted = false;

        // Iterate through each column
        for (int i = 0; i < len; i++) {

            // If all row pairs are sorted, no need to continue
            if (sortedCount == n - 1) {
                break;
            }

            // Step 1: Check if this column causes a violation
            for (int j = 0; j < n - 1; j++) {

                // Skip already sorted row pairs
                if (sortedRow[j]) {
                    continue;
                }

                // Violation found → column must be deleted
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    delCount++;
                    deleted = true;
                    break;
                }
            }

            // Step 2: If column is valid, update sorted row states
            if (!deleted) {
                for (int j = 0; j < n - 1; j++) {

                    // Skip already sorted row pairs
                    if (sortedRow[j]) {
                        continue;
                    }

                    // Strictly increasing → mark as sorted
                    if (strs[j].charAt(i) < strs[j + 1].charAt(i)) {
                        sortedRow[j] = true;
                        sortedCount++;
                    }
                }
            }

            // Reset deletion flag for next column
            deleted = false;
        }

        return delCount;
    }
}
