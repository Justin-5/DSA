class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // Step 1: Initialize a difference matrix with one extra row and column
        int[][] diff = new int[n + 1][n + 1];

        // Step 2: Apply difference array updates for each query
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            diff[r1][c1]++;              // top-left corner
            diff[r1][c2 + 1]--;          // right of top-right
            diff[r2 + 1][c1]--;          // below bottom-left
            diff[r2 + 1][c2 + 1]++;      // bottom-right + 1
        }

        // Step 3: Compute prefix sums row-wise
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j > 0 ? res[i][j - 1] : 0;
                res[i][j] = diff[i][j] + left;
            }
        }

        // Step 4: Compute prefix sums column-wise
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] += res[i - 1][j];
            }
        }

        // Step 5: Return the resulting matrix
        return res;
    }
}
