// 74. Search a 2D Matrix
// Problem: https://leetcode.com/problems/search-a-2d-matrix/
// Medium difficulty
//
// Approach:
// - The matrix has two properties:
//   1. Each row is sorted in non-decreasing order.
//   2. The first integer of each row > last integer of previous row.
//   => This means the entire matrix can be thought of as one flattened sorted array.
//
// - To achieve O(log(m * n)) time complexity, we can use binary search in two steps:
//
// Step 1: Binary Search on Rows
//   - Use rowL and rowR as pointers.
//   - Find the row where the target could possibly exist (based on row start and row end values).
//
// Step 2: Binary Search inside that Row
//   - Once row is identified, do a standard binary search in that row.
//
// Time Complexity: O(log(m) + log(n)) ≈ O(log(m * n))
// Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowL = 0;
        int rowR = matrix.length - 1;

        // Step 1: Binary search to find the correct row
        while (rowL <= rowR) {
            int rowMid = (rowL + rowR) / 2;

            // Check if target lies within this row
            if (target >= matrix[rowMid][0] && target <= matrix[rowMid][matrix[rowMid].length - 1]) {
                // Step 2: Binary search inside this row
                int colL = 0;
                int colR = matrix[rowMid].length - 1;

                while (colL <= colR) {
                    int colMid = (colL + colR) / 2;

                    if (matrix[rowMid][colMid] == target) {
                        return true; // Found target
                    } else if (matrix[rowMid][colMid] > target) {
                        colR = colMid - 1; // Search left half
                    } else {
                        colL = colMid + 1; // Search right half
                    }
                }

                return false; // Target not found in this row
            } else if (matrix[rowMid][0] > target) {
                rowR = rowMid - 1; // Search in upper rows
            } else {
                rowL = rowMid + 1; // Search in lower rows
            }
        }

        // If row not found, return false
        return false;
    }
}
