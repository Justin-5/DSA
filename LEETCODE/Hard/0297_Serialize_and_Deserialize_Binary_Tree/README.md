# 297. Serialize and Deserialize Binary Tree

## Problem Statement

Serialization is the process of converting a data structure or object into a string/sequence of bits, so it can be:

- Stored in a file or memory
- Transmitted across a network
- Reconstructed later in the same or another environment

You need to design an algorithm to **serialize** a binary tree into a string, and then **deserialize** the string back into the original binary tree.

⚠️ There’s no restriction on the serialization format — you just need to ensure correctness and reversibility.

---

## Examples

### Example 1

```

Input:  root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

```

### Example 2

```

Input:  root = []
Output: []

```

---

## Constraints

- Number of nodes: `0 <= n <= 10^4`
- Node values: `-1000 <= val <= 1000`

---

## Approach

### Intuition

We can use **preorder traversal (root → left → right)** for serialization:

- If the node is `null`, append `"null"`.
- Otherwise, append the node’s value and recursively process left and right subtrees.

During deserialization:

- Read values in the same order.
- `"null"` indicates no node.
- Otherwise, create a `TreeNode` and recursively construct left and right children.

This ensures a **unique mapping** between string and tree.

---

### Algorithm

#### Serialization

1. Perform preorder traversal.
2. Append:
   - `"null,"` if node is `null`.
   - `node.val + ","` otherwise.
3. Return the final string.

#### Deserialization

1. Split the serialized string by `","`.
2. Use a queue to read values in order.
3. Rebuild recursively:
   - If `"null"`, return `null`.
   - Otherwise, construct a new node, then build its left and right subtrees.

---

## Complexity

- **Time Complexity:**
  - Serialization: `O(n)` (visit each node once).
  - Deserialization: `O(n)` (rebuild each node once).
- **Space Complexity:** `O(n)` (recursion stack + output string).

---

## Dry Run Example

Tree:

```

```

1

```

/
2   3
/
4   5

```

Serialization steps:

```

1 → 2 → null → null → 3 → 4 → null → null → 5 → null → null

```

Final string:

```

"1,2,null,null,3,4,null,null,5,null,null,"

```

Deserialization:

- Read `1` → create root.
- Read `2` → left child, then two `null`s → left is complete.
- Read `3` → right child, recurse → 4, nulls → 5, nulls.

Tree reconstructed.
