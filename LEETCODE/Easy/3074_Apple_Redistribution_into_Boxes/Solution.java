import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        int totalApples = 0;     // Total number of apples
        int curCapacity = 0;     // Accumulated box capacity
        int boxCount = 0;        // Number of boxes used
        int m = capacity.length;

        // Calculate total apples
        for (int apples : apple) {
            totalApples += apples;
        }

        // Sort capacities to pick largest boxes first
        Arrays.sort(capacity);

        // Select boxes starting from the largest capacity
        for (int i = m - 1; i >= 0; i--) {
            curCapacity += capacity[i];
            boxCount++;

            // Stop once total capacity can hold all apples
            if (curCapacity >= totalApples) {
                break;
            }
        }

        return boxCount;
    }
}
