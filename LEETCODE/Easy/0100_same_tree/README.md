# 100. Same Tree

## Problem Statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the **same** or not.

Two binary trees are considered the same if:

1. They are structurally identical (same shape).
2. The nodes have the same value at each corresponding position.

---

## Examples

### Example 1:

```

Input: p = \[1,2,3], q = \[1,2,3]
Output: true

```

Both trees:

```

1
/&#x20;
2   3

```

They are identical.

---

### Example 2:

```

Input: p = \[1,2], q = \[1,null,2]
Output: false

```

Tree `p`:

```

1
/
2

```

Tree `q`:

```

1

2

```

Structures differ → Not the same.

---

### Example 3:

```

Input: p = \[1,2,1], q = \[1,1,2]
Output: false

```

Values differ at nodes even though shapes match → Not the same.

---

## Constraints

- Number of nodes in both trees: `[0, 100]`
- Node values: `[-10^4, 10^4]`

---

## Approach

We use **recursion** to compare trees:

1. If both `p` and `q` are `null`, they are the same.
2. If one is `null` and the other isn’t → not the same.
3. If values differ → not the same.
4. Otherwise, check recursively:
   - Left subtrees: `isSameTree(p.left, q.left)`
   - Right subtrees: `isSameTree(p.right, q.right)`
5. Only if both match, return `true`.

---

## Complexity

- **Time Complexity:** `O(n)` where `n` is the number of nodes (must check all nodes).
- **Space Complexity:**
  - `O(h)` for recursive call stack, where `h` is tree height.
  - Worst case `O(n)` (skewed tree), best case `O(log n)` (balanced tree).

```


```
