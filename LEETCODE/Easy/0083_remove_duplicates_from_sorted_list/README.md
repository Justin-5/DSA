# 0083. Remove Duplicates from Sorted List

## Problem

Given the head of a **sorted** linked list, delete all duplicates such that each element appears only once. Return the sorted linked list.

---

## Examples

### Example 1:

Input: head = [1,1,2]
Output: [1,2]

### Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

---

## Constraints

- The number of nodes in the list is in the range `[0, 300]`
- `-100 <= Node.val <= 100`
- The list is sorted in ascending order

---

## Approach

- Since the list is sorted, any duplicate values will be **adjacent**.
- Traverse the list and compare each node with its next.
- If values are equal, skip the duplicate node using `current->next = current->next->next`.

---

## Time & Space Complexity

- **Time Complexity**: O(n) — Single traversal of the list.
- **Space Complexity**: O(1) — In-place removal of duplicates.

---

Solution by Justin Aroza
