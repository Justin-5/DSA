# 230. Kth Smallest Element in a BST

## Problem Statement

Given the root of a **binary search tree (BST)** and an integer `k`, return the **kth smallest value** (1-indexed) of all the nodes in the tree.

---

## Examples

### Example 1

```

Input:  root = \[3,1,4,null,2], k = 1
Output: 1

```

Tree:

```

```

3

```

/&#x20;
1   4

2

```

The smallest element is `1`.

---

### Example 2

```

Input:  root = \[5,3,6,2,4,null,null,1], k = 3
Output: 3

```

Tree:

```

```

5
/ \
 3 6
/ \

```

2   4
/
1

```

The elements in sorted order are `[1,2,3,4,5,6]`.  
The 3rd smallest is `3`.

---

## Constraints

- Number of nodes `n` in the tree: `1 <= n <= 10^4`
- `1 <= k <= n`
- `0 <= Node.val <= 10^4`

---

## Approach

### Idea

- **In-order traversal of a BST** yields the values in **sorted order**.
- During traversal, decrement `k` until it reaches 0.  
  At that point, the current node is the **kth smallest**.

### Steps

1. Perform an **inorder traversal** (Left → Root → Right).
2. Maintain a counter `count = k`.
3. Each time we visit a node, decrement `count`.
4. When `count == 0`, record the node’s value as the result.

---

## Complexity

- **Time Complexity:** `O(h + k)`
  - `h` = height of tree (`O(log n)` for balanced, `O(n)` for skewed).
  - We stop as soon as we reach the kth element.
- **Space Complexity:** `O(h)` (recursion stack).

---

## Follow-up

If the BST is modified frequently (insert/delete operations) and we need to query kth smallest often:

- Use an **augmented BST** that stores the **size of left subtree** in each node.  
  This allows `O(log n)` query/update for kth smallest.
- Alternatively, use a **balanced BST (AVL, Red-Black tree, or Order Statistic Tree)** for efficient queries.
