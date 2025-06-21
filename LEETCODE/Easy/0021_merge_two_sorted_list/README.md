# 0021. Merge Two Sorted Lists

## Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.  
Merge the two lists into one sorted linked list.  
Return the head of the merged linked list.

---

### Examples

#### Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

#### Example 2:

Input: list1 = [], list2 = []
Output: []

#### Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

---

### Constraints

- The number of nodes in both lists is in the range [0, 50].
- -100 <= Node.val <= 100
- Both list1 and list2 are sorted in non-decreasing order.

---

## Approach

- Use a **dummy node** to simplify edge cases and avoid null checks while building the merged list.
- Use a pointer to iterate and compare nodes from both lists.
- Attach the smaller node to the result list and move forward in that list.
- Once one list is exhausted, attach the rest of the other list.

---

## Time and Space Complexity

- **Time Complexity**: O(n + m), where `n` and `m` are the number of nodes in `list1` and `list2`
- **Space Complexity**: O(1) (in-place merging, no extra data structures used)

---

Solution by Justin Aroza
