import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap to always fetch the heaviest stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones into the heap
        for (int weight : stones) {
            maxHeap.offer(weight);
        }

        // Keep smashing until one or zero stones left
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest

            // If weights are different, push the difference back
            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        // If a stone remains, return its weight, else return 0
        Integer result = maxHeap.peek();
        return result == null ? 0 : result;
    }
}
