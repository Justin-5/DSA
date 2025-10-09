import java.util.Arrays;

class Solution {

    /**
     * Returns the number of successful potion pairs for each spell.
     * 
     * @param spells  array representing spell strengths
     * @param potions array representing potion strengths
     * @param success the minimum required product for success
     * @return array of counts of successful pairs for each spell
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        // Step 1: Sort potions for binary search
        Arrays.sort(potions);

        int n = spells.length;
        int[] successPair = new int[n];

        // Step 2: Process each spell individually
        for (int i = 0; i < n; i++) {

            int l = 0;
            int r = potions.length - 1;

            // Step 3: Binary search to find the first potion
            // that makes spell[i] * potions[mid] >= success
            while (l <= r) {
                int m = l + (r - l) / 2;

                // Convert to long to prevent overflow
                if ((long) spells[i] * potions[m] < success) {
                    l = m + 1; // move right
                } else {
                    r = m - 1; // move left
                }
            }

            // Step 4: Remaining potions from l onward are successful
            successPair[i] = potions.length - l;
        }

        return successPair;
    }
}
