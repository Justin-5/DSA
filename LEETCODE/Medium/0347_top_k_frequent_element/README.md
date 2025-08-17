# 347. Top K Frequent Elements

## Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.  
The answer can be returned in any order.

---

### Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

### Example 2:

Input: nums = [1], k = 1
Output: [1]

---

## Constraints:

- 1 <= nums.length <= 10⁵
- -10⁴ <= nums[i] <= 10⁴
- k is in the range `[1, the number of unique elements in the array]`.
- It is guaranteed that the answer is unique.

**Follow up:**  
Your algorithm's time complexity must be better than `O(n log n)`.

---

## Code Implementation

```java
import java.util.*;

class Solution {
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
Explanation
We count frequencies using a HashMap.

Instead of sorting (which is O(n log n)), we use a bucket sort approach:

Each index in freqBucket represents how many times numbers occurred.

Example: freqBucket[3] holds all numbers that appeared 3 times.

Then we traverse from highest frequency down and collect the top k elements.

Time Complexity: O(n)

Counting frequency: O(n)

Filling buckets: O(n)

Collecting top k: O(n)

Space Complexity: O(n)

HashMap + Buckets to store elements.
```
