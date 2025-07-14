# 0002. Add Two Numbers

## Problem

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each node contains a **single digit**. Add the two numbers and return the sum as a linked list.

---

## Examples

### Example 1

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807

shell
Copy
Edit

### Example 2

Input: l1 = [0], l2 = [0]
Output: [0]

shell
Copy
Edit

### Example 3

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

yaml
Copy
Edit

---

## Constraints

- Each linked list has at least one node.
- Node values: 0 ≤ val ≤ 9
- No leading zeroes in input lists (except when the list is [0])

---

## Approach

- Loop through both lists while either has nodes or there's a carry.
- At each step, add corresponding digits and carry.
- Create a new node with the digit and continue.

This code does not use any optimizations and keeps the logic simple and easy to understand.

---

## Utility Functions

- `createList()` – builds a linked list from an array.
- `printList()` – prints the linked list in readable format.

---

## Output

Sum: 7 -> 0 -> 8

yaml
Copy
Edit

---

## Author

Straightforward implementation by Justin Aroza
