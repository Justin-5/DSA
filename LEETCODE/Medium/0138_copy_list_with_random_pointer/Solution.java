/*
// Definition for a Node.
*/

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



@SuppressWarnings("unused")
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Map to store mapping: original node -> cloned node
        Map<Node, Node> linkMap = new HashMap<>();

        // 1. First pass: Create new nodes (without setting next/random yet)
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            linkMap.put(cur, newNode);  // store mapping
            cur = cur.next;
        }

        // 2. Second pass: Assign next and random pointers
        cur = head;
        while (cur != null) {
            Node newNode = linkMap.get(cur);
            newNode.next = linkMap.get(cur.next);       // copy next
            newNode.random = linkMap.get(cur.random);   // copy random
            cur = cur.next;
        }

        // Return the deep-copied head
        return linkMap.get(head);
    }
}
