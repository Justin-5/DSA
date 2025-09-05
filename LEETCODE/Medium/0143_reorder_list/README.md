# 🔀 143. Reorder List

### 📌 Problem

You are given the head of a singly linked list. Reorder it into the following form:

```

L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

```

⚠️ You may not modify node values — only rearrange the nodes.

🔗 [Problem Link](https://leetcode.com/problems/reorder-list/)

---

### 💡 Examples

**Example 1**

```

Input: head = \[1,2,3,4]
Output: \[1,4,2,3]

```

**Example 2**

```

Input: head = \[1,2,3,4,5]
Output: \[1,5,2,4,3]

```

---

### ⚙️ Approach

1. **Find the middle** of the list using the slow/fast pointer technique.
2. **Reverse the second half** of the linked list.
3. **Merge two halves** by alternating nodes from first and second halves.

---

### 🛠️ Complexity

- **Time:** `O(n)` → single pass to find mid + reverse + merge
- **Space:** `O(1)` → in-place operations, no extra data structure

---

### 🧑‍💻 Code

See [ReorderList.java](./ReorderList.java) for full implementation.

```

```
