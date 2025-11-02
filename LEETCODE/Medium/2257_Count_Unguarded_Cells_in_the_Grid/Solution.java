class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 0 → unguarded cell
        // 1 → guarded cell
        // 2 → guard
        // 3 → wall
        int[][] grid = new int[m][n];

        // Mark guards
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Mark walls
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        // For each guard, mark all visible cells in 4 directions
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            // ↓ Down
            for (int r = row + 1; r < m && grid[r][col] != 2 && grid[r][col] != 3; r++) {
                grid[r][col] = 1;
            }

            // ↑ Up
            for (int r = row - 1; r >= 0 && grid[r][col] != 2 && grid[r][col] != 3; r--) {
                grid[r][col] = 1;
            }

            // → Right
            for (int c = col + 1; c < n && grid[row][c] != 2 && grid[row][c] != 3; c++) {
                grid[row][c] = 1;
            }

            // ← Left
            for (int c = col - 1; c >= 0 && grid[row][c] != 2 && grid[row][c] != 3; c--) {
                grid[row][c] = 1;
            }
        }

        // Count unguarded cells
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguarded++;
                }
            }
        }

        return unguarded;
    }
}
