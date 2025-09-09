# 138. Copy List with Random Pointer

## Problem Statement

You are given a linked list where each node has:

- A `val` (integer value)
- A `next` pointer
- A `random` pointer (which may point to any node in the list, or null)

Your task is to create a **deep copy** of this list:

- The new list should contain all new nodes (no shared nodes with the original).
- The `next` and `random` pointers must replicate the structure of the original list.

---

## Examples

**Example 1**

```

Input: head = \[\[7,null],\[13,0],\[11,4],\[10,2],\[1,0]]
Output: \[\[7,null],\[13,0],\[11,4],\[10,2],\[1,0]]

```

**Example 2**

```

Input: head = \[\[1,1],\[2,1]]
Output: \[\[1,1],\[2,1]]

```

**Example 3**

```

Input: head = \[\[3,null],\[3,0],\[3,null]]
Output: \[\[3,null],\[3,0],\[3,null]]

```

---

## Constraints

- `0 <= n <= 1000`
- `-10^4 <= Node.val <= 10^4`
- `Node.random` is `null` or points to some node in the list.

---

## Approach

We use a **two-pass HashMap solution**:

1. **First Pass (Clone Nodes Only)**

   - Traverse the original list.
   - For each node, create a new node with the same value.
   - Store the mapping: `original_node → cloned_node` in a HashMap.

2. **Second Pass (Assign Pointers)**

   - Traverse the list again.
   - Use the HashMap to set the `next` and `random` pointers of the cloned nodes:
     - `newNode.next = map.get(original.next)`
     - `newNode.random = map.get(original.random)`

3. **Return** the cloned head: `map.get(head)`

---

## Complexity

- **Time Complexity:** `O(n)` (two traversals of the list)
- **Space Complexity:** `O(n)` (HashMap storing mapping of nodes)

---

## Example Walkthrough

Input: `head = [[7,null],[13,0],[11,4],[10,2],[1,0]]`

- **Pass 1:** Create clones `[7,13,11,10,1]` and map originals to copies.
- **Pass 2:** Assign `next` and `random` using map lookups.
- Return new head.

Output: `[[7,null],[13,0],[11,4],[10,2],[1,0]]`

```


```
