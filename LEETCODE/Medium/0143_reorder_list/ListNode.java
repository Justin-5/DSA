// 143. Reorder List
// Problem: https://leetcode.com/problems/reorder-list/
//
// Approach: 
// 1. Find the middle of the linked list using slow/fast pointers
// 2. Reverse the second half of the list
// 3. Merge the two halves alternately
//
// Time Complexity: O(n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 */
 public class ListNode {
      @SuppressWarnings("unused")
      int val;
      ListNode next;
      @SuppressWarnings("unused")
      ListNode(int val) { this.val = val; }
      @SuppressWarnings("unused")
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
@SuppressWarnings("unused")
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode prev = null, cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        slow.next = null; // cut the list into two halves

        // Step 3: Merge two halves
        ListNode l1 = head, l2 = prev;
        while (l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            l2.next = temp1;

            l1 = temp1;
            l2 = temp2;
        }
    }
}
