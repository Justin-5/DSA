# 0019. Remove Nth Node From End of List

## Problem

Given the head of a linked list, remove the n-th node from the end of the list and return its head.

---

## Examples

### Example 1

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

### Example 2

Input: head = [1], n = 1
Output: []

### Example 3

Input: head = [1,2], n = 1
Output: [1]

---

## Constraints

- The number of nodes in the list is sz.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

---

## Approach

The solution uses two pointers: `first` and `last`.

- Move `first` ahead by `n` nodes.
- If `first` becomes `NULL`, it means we need to remove the head node.
- Otherwise, move both `first` and `last` until `first` reaches the end.
- Adjust `last->next` to skip the nth node from the end.

This is a non-optimized approach directly based on the basic two-pointer technique.

---

## Output

Original list:
1 2 3 4 5
List after removing 2-th node from the end:
1 2 3 5

Simple implementation by Justin Aroza
