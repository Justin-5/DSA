/**
 * Definition for singly-linked list. */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      @SuppressWarnings("unused")
      ListNode(int val) { this.val = val; }
      @SuppressWarnings("unused")
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

@SuppressWarnings("unused")
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Base cases: empty list or single node — nothing to remove
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node to handle edge cases (like duplicates at head)
        ListNode dummy = new ListNode();
        dummy.next = head;

        // Pointers:
        // slow = current node being checked
        // fast = next node (for comparison)
        // preSlow = node before slow (to help reconnect after removals)
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode preSlow = dummy;

        // Traverse until fast reaches the end
        while (fast != null) {
            if (slow.val != fast.val) {
                // No duplicate — move all pointers forward
                preSlow = preSlow.next;
                slow = fast;
                fast = fast.next;
            } else {
                // Duplicate detected — skip all nodes with same value
                while (fast != null && slow.val == fast.val) {
                    fast = fast.next;
                }
                // Connect preSlow to the next distinct node
                preSlow.next = fast;
                // Update slow and fast pointers
                if (fast != null) {
                    slow = fast;
                    fast = fast.next;
                }
            }
        }

        // Return the new head (dummy.next skips any removed initial duplicates)
        return dummy.next;
    }
}
