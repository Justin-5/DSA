// 141. Linked List Cycle
// Problem: https://leetcode.com/problems/linked-list-cycle/
//
// Approach: Floyd's Tortoise and Hare Algorithm
// - Use two pointers: slow moves 1 step at a time, fast moves 2 steps.
// - If the linked list has a cycle, fast and slow will eventually meet.
// - If fast reaches null (end of list), then no cycle exists.
//
// Time Complexity: O(n)  (each pointer traverses at most n nodes)
// Space Complexity: O(1) (no extra memory)

/**
 * Definition for singly-linked list.
 * */
public class ListNode {
    @SuppressWarnings("unused")
    int val;
    ListNode next;
    @SuppressWarnings("unused")
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
@SuppressWarnings("unused")
class Solution {
    public boolean cycleList(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 and fast by 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected if they meet
            if (slow == fast) {
                return true;
            }
        }

        // No cycle if fast reaches null
        return false;
    }
}
