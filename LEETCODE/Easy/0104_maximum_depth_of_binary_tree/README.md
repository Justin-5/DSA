# 104. Maximum Depth of Binary Tree

## Problem Statement

Given the root of a binary tree, return its **maximum depth**.

A binary tree's maximum depth is defined as the **number of nodes along the longest path** from the root node down to the farthest leaf node.

---

## Examples

### Example 1:

```

Input: root = \[3,9,20,null,null,15,7]
Output: 3

```

Tree structure:

```

```

3
/ \
 9 20
/ \
 15 7

```

```

Longest path is `3 → 20 → 15` (or `3 → 20 → 7`), so depth = 3.

---

### Example 2:

```

Input: root = \[1,null,2]
Output: 2

```

Tree structure:

```

1

2

```

Longest path is `1 → 2`, so depth = 2.

---

## Constraints

- Number of nodes in the tree: `[0, 10^4]`
- Node values: `[-100, 100]`

---

## Approach

We use **recursion**:

1. If the tree is empty (`root == null`), depth is `0`.
2. Otherwise, recursively compute the maximum depth of the left and right subtrees.
3. Add `1` for the current root node.
4. Final result is:

```

1 + max(leftDepth, rightDepth)

```

---

## Complexity

- **Time Complexity:** `O(n)` where `n` is the number of nodes (each node visited once).
- **Space Complexity:**
- Worst case `O(n)` (skewed tree → recursive stack depth = n).
- Best/average case `O(log n)` (balanced tree).

```

```
