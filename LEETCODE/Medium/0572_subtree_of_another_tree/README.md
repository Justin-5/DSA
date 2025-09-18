# 572. Subtree of Another Tree

## Problem Statement

You are given two binary trees `root` and `subRoot`.  
Return `true` if there exists a subtree of `root` with the **same structure and node values** as `subRoot`. Otherwise, return `false`.

A **subtree** of a binary tree is defined as:

- A node in the tree and all of its descendants.
- The tree itself can also be considered a subtree.

---

## Examples

### Example 1:

```

Input:  root = \[3,4,5,1,2], subRoot = \[4,1,2]
Output: true

```

Tree root:

```

```

3
/ \

```

4   5
/&#x20;
1   2

```

Tree subRoot:

```

4
/&#x20;
1   2

```

✅ SubRoot exists inside root.

---

### Example 2:

```

Input: root = \[3,4,5,1,2,null,null,null,null,0], subRoot = \[4,1,2]
Output: false

```

Here, the node `4` has children `1` and `2`, but in `root` the left subtree has an **extra node `0`** under `2`.  
Hence, ❌ not identical.

---

## Constraints

- `1 <= root.size <= 2000`
- `1 <= subRoot.size <= 1000`
- `-10^4 <= node.val <= 10^4`

---

## Approach

We solve this in **two steps**:

1. **Check identical trees function** (`isIdentical`):

   - Recursively checks if two trees are exactly the same (both structure and values).

2. **Traverse root tree**:
   - At each node in `root`, call `isIdentical(node, subRoot)`.
   - If a match is found → return `true`.
   - If no match is found after traversing → return `false`.

We can traverse root using either **DFS** or **BFS**.  
Here, BFS (using a queue) is used.

---

## Complexity

- **Time Complexity:** `O(m * n)` in the worst case
  - `m = number of nodes in root`
  - `n = number of nodes in subRoot`
  - Each node of root could trigger a full comparison with subRoot.
- **Space Complexity:**
  - `O(h)` for recursion (height of tree) + `O(m)` for BFS queue.
  - Worst case: `O(m + h)`.
