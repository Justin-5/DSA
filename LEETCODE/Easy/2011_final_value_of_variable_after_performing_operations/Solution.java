// 2011. Final Value of Variable After Performing Operations
// Approach: Simple simulation — increment or decrement based on the operation
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        // Iterate through all operations
        for (String op : operations) {
            // If operation is an increment type (++X or X++)
            if (op.equals("++X") || op.equals("X++")) {
                x++;
            } 
            // Otherwise, it's a decrement type (--X or X--)
            else {
                x--;
            }
        }

        // Return the final value of X
        return x;
    }
}
