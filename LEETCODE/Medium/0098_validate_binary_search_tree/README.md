# 98. Validate Binary Search Tree

## Problem Statement

Given the root of a binary tree, determine if it is a **valid Binary Search Tree (BST)**.

A valid BST must satisfy:

1. The left subtree of a node contains only nodes with keys **strictly less** than the node's key.
2. The right subtree of a node contains only nodes with keys **strictly greater** than the node's key.
3. Both the left and right subtrees must also be valid BSTs.

---

## Examples

### Example 1

```

Input:  root = \[2,1,3]
Output: true

```

Tree:

```

```

2

```

/&#x20;
1   3

```

This is a valid BST.

---

### Example 2

```

Input:  root = \[5,1,4,null,null,3,6]
Output: false

```

Tree:

```

```

5
/ \
1 4
/ \
 3 6

```

```

This is **not valid**, because the node `4` is in the right subtree of `5` but is **not greater than 5**.

---

## Constraints

- `1 <= number of nodes <= 10^4`
- `-2^31 <= Node.val <= 2^31 - 1`

---

## Approach

We use a **recursive DFS approach with value bounds**:

1. Each node must satisfy:  
   `min < node.val < max`
2. Initially:
   - `min = -∞ (Long.MIN_VALUE)`
   - `max = +∞ (Long.MAX_VALUE)`
3. Recursively check:
   - Left subtree: values must be `< node.val`
   - Right subtree: values must be `> node.val`
4. If any node violates the condition, return `false`.

---

## Complexity

- **Time Complexity:** `O(n)` → every node is visited once.
- **Space Complexity:** `O(h)` → recursion stack, where `h` is the height of the tree (`O(log n)` for balanced, `O(n)` for skewed).
