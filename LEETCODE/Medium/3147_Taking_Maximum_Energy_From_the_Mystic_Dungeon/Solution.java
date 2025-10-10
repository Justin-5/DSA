// ----------------------------------------------
// LeetCode 3147: Taking Maximum Energy From the Mystic Dungeon
// ----------------------------------------------

class Solution {

    // Function to calculate maximum possible energy gain
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;  // Tracks maximum energy found
        int n = energy.length;

        // Traverse from the end of the array backwards
        for (int i = n - 1; i >= 0; i--) {
            // If the jump (i + k) stays within bounds, accumulate energy
            if (i + k <= n - 1) {
                energy[i] += energy[i + k];
            }

            // Update the global maximum energy
            max = Math.max(energy[i], max);
        }

        // Return the highest possible energy
        return max;
    }
}

/**
 * Example:
 * Input: energy = [5, 2, -10, -5, 1], k = 3
 * Output: 3
 *
 * Explanation:
 * Start at index 1 → energies collected: 2 + 1 = 3 (maximum total)
 *
 * Input: energy = [-2, -3, -1], k = 2
 * Output: -1
 *
 * Explanation:
 * Starting at index 2 gives the best result (-1)
 */
