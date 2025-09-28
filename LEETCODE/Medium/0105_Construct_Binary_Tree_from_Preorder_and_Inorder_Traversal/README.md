# 105. Construct Binary Tree from Preorder and Inorder Traversal

## Problem Statement

You are given two integer arrays:

- `preorder`: preorder traversal of a binary tree
- `inorder`: inorder traversal of the same tree

Return the **binary tree** reconstructed from these traversals.

---

## Examples

### Example 1

```

Input:
preorder = \[3,9,20,15,7]
inorder  = \[9,3,15,20,7]

Output: \[3,9,20,null,null,15,7]

```

### Example 2

```

Input:
preorder = \[-1]
inorder  = \[-1]

Output: \[-1]

```

---

## Constraints

- `1 <= preorder.length <= 3000`
- `inorder.length == preorder.length`
- `-3000 <= preorder[i], inorder[i] <= 3000`
- `preorder` and `inorder` consist of **unique values**
- Each value in `inorder` also appears in `preorder`
- Traversals are guaranteed to be valid

---

## Approach

### Key Observations

1. **Preorder traversal** visits nodes as:

```

Root → Left → Right

```

So, the first element of `preorder` is always the root of the tree.

2. **Inorder traversal** visits nodes as:

```

Left → Root → Right

```

Using the position of the root in `inorder`, we can split the array:

- Left part → Left subtree
- Right part → Right subtree

---

### Steps

1. Use a global index `preIndex` to track the current root in `preorder`.
2. Build a hash map `inorderMap` for quick lookup of each value’s index in `inorder`.
3. Recursively construct subtrees:

- Take root from `preorder[preIndex]`
- Find its position in `inorder`
- Recurse left with `inorderLeft..inIndex-1`
- Recurse right with `inIndex+1..inorderRight`

---

## Complexity

- **Time Complexity:** `O(n)`
- Each node is processed once.
- Hash map gives `O(1)` lookups.
- **Space Complexity:** `O(n)`
- For recursion stack and hash map storage.

Efficient enough for `n = 3000`.
