import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        // Sort the citations in ascending order
        Arrays.sort(citations);
        int n = citations.length;

        // Iterate to find the highest valid h-index
        for (int i = 0; i < n; i++) {
            int h = n - i; // number of papers with at least citations[i] citations
            if (citations[i] >= h) {
                return h; // Found the h-index
            }
        }

        // If no valid h-index found, return 0
        return 0;
    }
}
