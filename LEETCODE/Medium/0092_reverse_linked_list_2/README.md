# 🔄 92. Reverse Linked List II

### 📌 Problem

Given the head of a singly linked list and two integers `left` and `right` (1-indexed), reverse the nodes between positions `left` and `right`.

🔗 [Problem Link](https://leetcode.com/problems/reverse-linked-list-ii/)

---

### 💡 Examples

**Example 1**

```

Input: head = \[1,2,3,4,5], left = 2, right = 4
Output: \[1,4,3,2,5]

```

**Example 2**

```

Input: head = \[5], left = 1, right = 1
Output: \[5]

```

---

### ⚙️ Approach

1. Use a **dummy node** to handle edge cases cleanly.
2. Move pointer `pre` to the node just before `left`.
3. Reverse the sublist between `left` and `right` using the **classic linked list reversal**.
4. Reconnect the reversed sublist:
   - `pre.next` points to new head of sublist.
   - old `left` node (now tail) connects to `cur` (first node after `right`).

---

### 🛠️ Complexity

- **Time:** `O(n)` → traverses each node once
- **Space:** `O(1)` → in-place reversal

---

### 🧑‍💻 Code

See [ReverseLinkedListII.java](./ReverseLinkedListII.java) for full implementation.

```

```
