
import java.util.PriorityQueue;
  public class ListNode {
      int val;
      ListNode next;
      @SuppressWarnings("unused")
      ListNode() {}
      ListNode(int val) { this.val = val; }
      @SuppressWarnings("unused")
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 



@SuppressWarnings("unused")
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to always get the smallest node
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add the head of each non-empty list into the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        // Dummy node to simplify result construction
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Keep extracting the smallest node and build the result
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll(); // Get the smallest node
            tail.next = minNode;              // Append it to result
            tail = tail.next;                 // Move tail

            // If this node has a next, push it into the heap
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        // Return the merged list (skip dummy node)
        return dummy.next;
    }
}