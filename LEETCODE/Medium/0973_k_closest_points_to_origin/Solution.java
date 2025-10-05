import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap: store farthest point on top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> {
            int dist1 = p1[0] * p1[0] + p1[1] * p1[1]; // squared distance of p1
            int dist2 = p2[0] * p2[0] + p2[1] * p2[1]; // squared distance of p2
            return dist2 - dist1; // larger distance has higher priority
        });

        // Process each point
        for (int[] point : points) {
            maxHeap.offer(point);  // add point into heap
            if (maxHeap.size() > k) {
                maxHeap.poll();   // remove farthest point if heap too large
            }
        }

        // Build result array from heap
        int[][] closestPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            closestPoints[i] = maxHeap.poll();
        }

        return closestPoints;
    }
}
