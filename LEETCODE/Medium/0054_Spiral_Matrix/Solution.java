import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[left].length - 1;

        // Continue looping until all boundaries are crossed
        while (left <= right && top <= bottom) {

            // Traverse from left to right across the top boundary
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom boundary (if still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left boundary (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiral;
    }
}
