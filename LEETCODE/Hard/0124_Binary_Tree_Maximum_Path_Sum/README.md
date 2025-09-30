# 124. Binary Tree Maximum Path Sum

## Problem Statement

A **path** in a binary tree is a sequence of nodes where each adjacent pair is connected by an edge.

- A node can appear in the path at most once.
- The path does **not** need to pass through the root.

The **path sum** is the sum of the node values along the path.

Given the root of a binary tree, return the **maximum path sum** of any non-empty path.

---

## Examples

### Example 1

```

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3, with sum = 2 + 1 + 3 = 6.

```

### Example 2

```

Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7, with sum = 15 + 20 + 7 = 42.

```

---

## Constraints

- `1 <= number of nodes <= 3 * 10^4`
- `-1000 <= Node.val <= 1000`

---

## Approach

### Key Idea

We need to consider two cases for each node:

1. **As a connecting node** (path passes through it):
   - Path sum = `node.val + leftContribution + rightContribution`
   - This can potentially update the **global max sum**.
2. **As a returning node** (path continues upward to its parent):
   - Path sum = `node.val + max(leftContribution, rightContribution)`
   - Only one side can be chosen since a path can’t branch upward.

We recursively compute these values using DFS.

---

### Steps

1. Use a helper function `findMaxSum(node)`:
   - If `node == null`, return `0`.
   - Compute contributions from left and right subtrees.
   - Ignore negative contributions by taking `Math.max(0, contribution)`.
   - Update global `maxSum` with `node.val + leftContribution + rightContribution`.
   - Return `node.val + max(leftContribution, rightContribution)` for parent usage.
2. Initialize `maxSum = -∞`.
3. Call `findMaxSum(root)` and return `maxSum`.

---

## Complexity

- **Time Complexity:** `O(n)` — Each node is visited once.
- **Space Complexity:** `O(h)` — Recursion depth (worst-case `O(n)` for skewed tree, `O(log n)` for balanced tree).

---

## Example Walkthrough

For `[-10,9,20,null,null,15,7]`:

```

```

     -10
     /  \
    9    20
        /  \
       15   7

```

```

- At node `15`: contributes `15`, max path sum = `15`.
- At node `7`: contributes `7`, max path sum = `7`.
- At node `20`: contributes `20 + max(15,7) = 35`,  
  but candidate path = `20 + 15 + 7 = 42` → updates global max.
- At root `-10`: candidate = `-10 + 9 + 35 = 34` (does not beat 42).
- Final result = `42`.
