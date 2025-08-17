import java.util.*;

class Solutions {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        // Each bucket holds a list of numbers with that frequency
        List<Integer>[] freqBucket = new List[nums.length + 1];
        for (int i = 0; i < freqBucket.length; i++) {
            freqBucket[i] = new ArrayList<>();
        }

        // Step 3: Place numbers into their frequency bucket
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();
            freqBucket[count].add(number);
        }

        // Step 4: Collect top k frequent elements starting from highest frequency
        int[] result = new int[k];
        int j = 0;
        for (int i = freqBucket.length - 1; i > 0 && j < k; i--) {
            if (!freqBucket[i].isEmpty()) {
                for (int num : freqBucket[i]) {
                    result[j++] = num;
                    if (j == k) break; // Stop once we have k elements
                }
            }
        }

        return result;
    }
}
