import java.util.ArrayList;

class Solution {

    // Checks whether the array is non-decreasing
    private boolean checkSorted(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Finds the index of the adjacent pair with the minimum sum
    // If multiple exist, the leftmost index is returned
    private int minSumIndex(ArrayList<Integer> l) {
        int n = l.size();
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < n - 1; i++) {
            int sum = l.get(i) + l.get(i + 1);
            if (sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int minimumPairRemoval(int[] nums) {

        // Convert array to ArrayList for easier manipulation
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int count = 0;

        // Repeat operations until array becomes non-decreasing
        while (!checkSorted(list)) {

            // Find index of adjacent pair with minimum sum
            int index = minSumIndex(list);

            // Compute sum of the pair
            int sum = list.get(index) + list.get(index + 1);

            // Remove the pair
            list.remove(index);
            list.remove(index);

            // Insert their sum at the same position
            list.add(index, sum);

            count++;
        }

        return count;
    }
}
