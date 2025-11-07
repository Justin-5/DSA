/**
 * Definition for singly-linked list.
 * */
  public class ListNode {
      @SuppressWarnings("unused")
      int val;
      ListNode next;
      @SuppressWarnings("unused")
      ListNode() {}
      @SuppressWarnings("unused")
      ListNode(int val) { this.val = val; }
      @SuppressWarnings("unused")
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 @SuppressWarnings("unused")
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length and tail of the list
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Compute effective rotation
        int modK = k % length;
        if (modK == 0) {
            return head; // no change needed
        }

        // Step 3: Make the list circular
        tail.next = head;

        // Step 4: Find new tail (length - modK - 1 steps from head)
        ListNode newTail = head;
        for (int i = 1; i <= length - modK - 1; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle and set new head
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
