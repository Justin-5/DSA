import java.util.Arrays;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] check = new int[10]; // Used to track digits (1–9). Index = digit, value = seen(1)/not seen(0).

        // 1. Check each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') { // Ignore empty cells
                    int digit = board[i][j] - '0';
                    if (check[digit] == 0) {
                        check[digit] = 1; // Mark digit as seen
                    } else {
                        return false; // Duplicate found
                    }
                }
            }
            Arrays.fill(check, 0); // Reset check array for next row
        }

        // 2. Check each column
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (check[digit] == 0) {
                        check[digit] = 1;
                    } else {
                        return false; // Duplicate found
                    }
                }
            }
            Arrays.fill(check, 0); // Reset check array for next column
        }

        // 3. Check each 3x3 subgrid
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (board[row][col] != '.') {
                            int digit = board[row][col] - '0';
                            if (check[digit] == 0) {
                                check[digit] = 1;
                            } else {
                                return false; // Duplicate in 3x3 box
                            }
                        }
                    }
                }
                Arrays.fill(check, 0); // Reset for next 3x3 box
            }
        }
        return true; // If no duplicates found
    }
}
