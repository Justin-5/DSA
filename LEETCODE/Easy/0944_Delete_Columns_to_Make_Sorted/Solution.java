class Solution {
    public int minDeletionSize(String[] strs) {

        // Counter for number of columns to delete
        int delCount = 0;

        // Length of each string (number of columns)
        int len = strs[0].length();

        // Iterate through each column
        for (int i = 0; i < len; i++) {

            // Check if the current column is sorted
            for (int j = 1; j < strs.length; j++) {

                // If current character is smaller than the one above it
                // the column is not lexicographically sorted
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    delCount++; // Mark this column for deletion
                    break;      // Move to the next column
                }
            }
        }

        // Return total columns that need to be deleted
        return delCount;
    }
}
