// ----------------------------------------------
// LeetCode 119: Pascal's Triangle II
// ----------------------------------------------
// Approach: In-place dynamic programming (reverse update)
// Time Complexity: O(n²)
// Space Complexity: O(n)
// ----------------------------------------------

import java.util.*;

class Solution {

    // Returns the kth (0-indexed) row of Pascal's Triangle
    public List<Integer> getRow(int rowIndex) {
        // Initialize list with the first row
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1); // First row is always [1]

        // Build each subsequent row in place
        for (int i = 1; i <= rowIndex; i++) {
            // Update current row from end to start to avoid overwriting
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            // Last element of each row is always 1
            row.add(1);
        }

        // Return the completed row
        return row;
    }
}

/**
 * Example:
 * Input: rowIndex = 3
 * Output: [1, 3, 3, 1]
 *
 * Explanation:
 * - Row 0: [1]
 * - Row 1: [1, 1]
 * - Row 2: [1, 2, 1]
 * - Row 3: [1, 3, 3, 1]
 *
 * This solution uses only O(rowIndex) space.
 */
