
import java.util.*;

class Solution {
    /**
     * Helper function to compute x-sum for a subarray from index [start..end].
     */
    public int xSum(int[] arr, int start, int end, int xSize) {
        // Step 1: Count frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = start; i <= end; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: Sort elements by frequency (descending), then by value (descending)
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freq.entrySet());
        entryList.sort((entry1, entry2) -> {
            int freq1 = entry1.getValue();
            int freq2 = entry2.getValue();
            if (freq1 != freq2) {
                return freq2 - freq1; // Higher frequency first
            } else {
                return entry2.getKey() - entry1.getKey(); // For tie, larger value first
            }
        });

        // Step 3: Keep only the top x most frequent elements
        Set<Integer> topXSet = new HashSet<>();
        int size = Math.min(xSize, entryList.size());
        for (int i = 0; i < size; i++) {
            topXSet.add(entryList.get(i).getKey());
        }

        // Step 4: Calculate the sum of all elements in subarray that belong to top X set
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (topXSet.contains(arr[i])) {
                sum += arr[i];
            }
        }
        return sum;
    }

    /**
     * Main function to find x-sum for every k-length subarray.
     */
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        // For each subarray of length k, compute its x-sum
        for (int i = 0; i < n - k + 1; i++) {
            answer[i] = xSum(nums, i, i + k - 1, x);
        }

        return answer;
    }
}
