/**
 * Definition for singly-linked list.
 * */
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
    public ListNode partition(ListNode head, int x) {
        ListNode lesserHead = new ListNode();  // Dummy node for < x
        ListNode lesserTail = lesserHead;
        ListNode greaterHead = new ListNode(); // Dummy node for >= x
        ListNode greaterTail = greaterHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lesserTail.next = cur;
                lesserTail = lesserTail.next;
            } else {
                greaterTail.next = cur;
                greaterTail = greaterTail.next;
            }
            cur = cur.next;
        }

        // Prevent cycle and merge the two lists
        greaterTail.next = null;
        lesserTail.next = greaterHead.next;

        return lesserHead.next;
    }
}
