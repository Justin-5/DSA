# 226. Invert Binary Tree

## Problem Statement

Given the `root` of a binary tree, invert the tree, and return its root.  
Inverting means swapping every left and right subtree recursively.

---

## Examples

**Example 1:**

```

Input:  root = \[4,2,7,1,3,6,9]
Output: \[4,7,2,9,6,3,1]

Explanation:
4                4
/ \              /&#x20;
2   7   --->     7   2
/ \ / \          / \ /&#x20;
1  3 6  9        9  6 3  1

```

**Example 2:**

```

Input: root = \[2,1,3]
Output: \[2,3,1]

Explanation:
2              2
/ \     =>     /&#x20;
1   3          3   1

```

**Example 3:**

```

Input: root = \[]
Output: \[]

```

---

## Constraints

- Number of nodes: `0 <= n <= 100`
- Node values: `-100 <= Node.val <= 100`

---

## Approach

We can solve this using **recursion**:

1. **Base Case:**  
   If the root is `null`, return `null`.

2. **Recursive Step:**

   - Invert the left subtree.
   - Invert the right subtree.
   - Swap the left and right children of the current node.

3. Return the root (now inverted).

---

## Complexity

- **Time Complexity:** `O(n)` — we visit each node exactly once.
- **Space Complexity:**
  - `O(h)` for recursion stack, where `h` = height of the tree.
  - Worst case: `O(n)` for a skewed tree, Best case: `O(log n)` for a balanced tree.

---

## Follow-up

We could also implement this iteratively using **BFS with a queue**, swapping children level by level.

```

```
