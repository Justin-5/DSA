// 92. Reverse Linked List II
// Problem: https://leetcode.com/problems/reverse-linked-list-ii/
//
// Approach: One-pass reversal of a sublist using pointers
//
// Time Complexity: O(n)  (traverse the list once)
// Space Complexity: O(1) (in-place reversal)

/**
 Definition for singly-linked list.
 */
  public class ListNode {
     @SuppressWarnings("unused")
     int val;
     ListNode next;
     @SuppressWarnings("unused")
     ListNode() {}
     @SuppressWarnings("unused")
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
@SuppressWarnings("unused")
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Dummy node to simplify edge cases (like reversing from head)
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        // 1. Move `pre` pointer to node before "left"
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 2. Reverse sublist between [left, right]
        ListNode cur = pre.next; // starting node of sublist
        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        // 3. Reconnect reversed sublist
        ListNode leftNode = pre.next;   // old "left" (now tail of reversed sublist)
        pre.next = prev;                // connect pre to new head of reversed part
        leftNode.next = cur;            // connect tail of reversed part to remaining list

        return dummy.next; // return new head
    }
}
