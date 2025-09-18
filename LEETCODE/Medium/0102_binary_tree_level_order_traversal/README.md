# 102. Binary Tree Level Order Traversal

## Problem Statement

Given the root of a binary tree, return its **level order traversal**.  
Level order traversal means visiting nodes **level by level**, from left to right.

---

## Examples

### Example 1:

```

Input:  root = \[3,9,20,null,null,15,7]
Output: \[\[3],\[9,20],\[15,7]]

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

Level order traversal: `[[3],[9,20],[15,7]]`

---

### Example 2:

```

Input: root = \[1]
Output: \[\[1]]

```

---

### Example 3:

```

Input: root = \[]
Output: \[]

```

---

## Constraints

- `0 <= number of nodes <= 2000`
- `-1000 <= Node.val <= 1000`

---

## Approach

We can solve this using **Breadth-First Search (BFS)**:

1. Use a **queue** to store nodes level by level.
2. For each level:
   - Determine the number of nodes in that level (`queue.size()`).
   - Pop nodes one by one and store their values in a temporary list.
   - Push their children (if any) into the queue.
3. Add the temporary list (representing one level) into the final result.

---

## Complexity

- **Time Complexity:** `O(n)` → each node is visited once.
- **Space Complexity:** `O(n)` → for storing results and BFS queue.
