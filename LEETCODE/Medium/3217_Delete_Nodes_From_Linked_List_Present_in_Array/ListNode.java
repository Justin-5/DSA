/**
  Definition for singly-linked list. */
  import java.util.*;
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (seen.contains(cur.val)) {
                prev.next = cur.next; // skip current node
            } else {
                prev = cur; // keep current node
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
