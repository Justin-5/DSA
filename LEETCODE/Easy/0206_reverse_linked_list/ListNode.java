// 206. Reverse Linked List
// Problem: https://leetcode.com/problems/reverse-linked-list/
//
// Approaches:
// 1. Iterative (using three pointers: prev, cur, next)
// 2. Recursive (reverse sublist and re-link)
//
// Time Complexity: O(n)   (we visit each node once)
// Space Complexity: O(1) for iterative, O(n) recursion stack for recursive

/**
 * Definition for singly-linked list.
 **/
  public class ListNode {
      ListNode next;
      @SuppressWarnings("unused")
      ListNode(int val, ListNode next) {this.next = next; }
  }
 

@SuppressWarnings("unused")
class Solution {

    // ✅ Iterative approach
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;      // Tracks the previous node
        ListNode cur = head;       // Tracks the current node

        // Traverse until we reach the end
        while (cur != null) {
            ListNode temp = cur.next; // Store next node
            cur.next = prev;          // Reverse the link
            prev = cur;               // Move prev forward
            cur = temp;               // Move cur forward
        }
        return prev; // prev is the new head
    }

    // ✅ Recursive approach
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse rest of the list
        ListNode newHead = reverseListRecursive(head.next);

        // Reverse current node
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
