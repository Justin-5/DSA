# 🔁 141. Linked List Cycle

### 📌 Problem

Given the head of a linked list, determine if it contains a cycle.  
A cycle exists if following the `next` pointers leads back to a previously visited node.

🔗 [Problem Link](https://leetcode.com/problems/linked-list-cycle/)

---

### 💡 Examples

**Example 1**

```

Input: head = \[3,2,0,-4], pos = 1
Output: true
Explanation: The tail connects back to the 1st node.

```

**Example 2**

```

Input: head = \[1,2], pos = 0
Output: true
Explanation: The tail connects back to the 0th node.

```

**Example 3**

```

Input: head = \[1], pos = -1
Output: false
Explanation: No cycle exists.

```

---

### ⚙️ Approach (Floyd’s Cycle Detection)

1. Use **two pointers**:
   - `slow`: moves **1 step** at a time
   - `fast`: moves **2 steps** at a time
2. If a cycle exists, `slow` and `fast` will eventually meet.
3. If `fast` reaches the end (`null`), then no cycle exists.

---

### 🛠️ Complexity

- **Time:** `O(n)` → each node visited at most twice
- **Space:** `O(1)` → constant memory used

---

### 🧑‍💻 Code

See [LinkedListCycle.java](./LinkedListCycle.java) for full implementation.

```

```
