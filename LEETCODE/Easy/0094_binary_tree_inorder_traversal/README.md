# 0094. Binary Tree Inorder Traversal

## Problem

Given the `root` of a binary tree, return the **inorder traversal** of its nodes' values.

---

## Examples

### Example 1

Input: root = [1,null,2,3]
Output: [1,3,2]

shell
Copy
Edit

### Example 2

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

shell
Copy
Edit

### Example 3

Input: root = []
Output: []

yaml
Copy
Edit

---

## Constraints

- Number of nodes: 0 to 100
- Node values: -100 to 100

---

## Approach: Recursive (Simple)

- Traverse left subtree
- Process current node
- Traverse right subtree

This approach uses a helper function and counts the number of nodes first to allocate memory.

### Time Complexity: O(n)

### Space Complexity: O(n) for recursion stack and result

---

Follow-up
The recursive solution is straightforward. For an advanced challenge, consider an iterative approach using a stack or Morris Traversal with O(1) space.

Author
Recursive implementation by Justin Aroza
