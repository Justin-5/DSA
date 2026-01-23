import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Stores all valid board configurations
    List<List<String>> solutions = new ArrayList<>();

    // Converts the current board into a list of strings and adds to solutions
    private void addSolution(char[][] board) {
        List<String> sol = new ArrayList<>();
        for (char[] row : board) {
            sol.add(new String(row));
        }
        solutions.add(sol);
    }

    // Backtracking function to place queens row by row
    private void backTrack(
            int row,
            int n,
            char[][] board,
            boolean[] cols,
            boolean[] posDiag,
            boolean[] negDiag
    ) {

        // If all rows are filled, we found a valid solution
        if (row == n) {
            addSolution(board);
            return;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {

            int pDiag = row + col;      // Positive diagonal index
            int nDiag = row - col + n;  // Negative diagonal index

            // Skip if column or diagonals are already occupied
            if (cols[col] || posDiag[pDiag] || negDiag[nDiag]) {
                continue;
            }

            // Place the queen
            board[row][col] = 'Q';
            cols[col] = true;
            posDiag[pDiag] = true;
            negDiag[nDiag] = true;

            // Recurse to the next row
            backTrack(row + 1, n, board, cols, posDiag, negDiag);

            // Backtrack: remove the queen
            board[row][col] = '.';
            cols[col] = false;
            posDiag[pDiag] = false;
            negDiag[nDiag] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        // Initialize empty board
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Helper arrays to track occupied columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] posDiagonals = new boolean[2 * n];
        boolean[] negDiagonals = new boolean[2 * n];

        // Start backtracking from row 0
        backTrack(0, n, board, cols, posDiagonals, negDiagonals);

        return solutions;
    }
}
