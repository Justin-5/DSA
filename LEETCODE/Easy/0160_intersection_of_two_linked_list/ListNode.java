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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case: if one list is empty, no intersection
        if (headA == null || headB == null) return null;

        // Step 1: Find tail and length of listA
        ListNode tailA = headA;
        int countA = 1;
        while (tailA.next != null) {
            tailA = tailA.next;
            countA++;
        }

        // Step 2: Find tail and length of listB
        ListNode tailB = headB;
        int countB = 1;
        while (tailB.next != null) {
            tailB = tailB.next;
            countB++;
        }

        // Step 3: If tails are different, no intersection
        if (tailA != tailB) {
            return null;
        }

        // Step 4: Align both lists by skipping extra nodes in the longer list
        ListNode dummyA = headA;
        ListNode dummyB = headB;

        if (countA > countB) {
            int diff = countA - countB;
            while (diff-- > 0) {
                dummyA = dummyA.next;
            }
        } else {
            int diff = countB - countA;
            while (diff-- > 0) {
                dummyB = dummyB.next;
            }
        }

        // Step 5: Traverse both together until intersection
        while (dummyA != dummyB) {
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }

        // Both point to the intersection node (or null if no intersection)
        return dummyA;
    }
}
