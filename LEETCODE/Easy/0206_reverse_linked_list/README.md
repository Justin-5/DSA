Great one 🙌 This is a classic linked list problem.

# 🔄 206. Reverse Linked List

### 📌 Problem

Given the head of a singly linked list, reverse the list and return the reversed list.

🔗 [Problem Link](https://leetcode.com/problems/reverse-linked-list/)

---

### 💡 Examples

**Example 1**

```

Input: head = \[1,2,3,4,5]
Output: \[5,4,3,2,1]

```

**Example 2**

```

Input: head = \[1,2]
Output: \[2,1]

```

**Example 3**

```

Input: head = \[]
Output: \[]

```

---

### ⚙️ Approach

We can reverse a linked list in two main ways:

#### 1. **Iterative (O(1) space)**

- Use three pointers:
  - `prev` → initially `null`
  - `cur` → start at `head`
  - `next` → temporarily store `cur.next`
- At each step, reverse the link `cur.next = prev`, then move forward.
- Return `prev` as the new head.

#### 2. **Recursive (O(n) space)**

- Base case: if the list is empty or only one node, return it.
- Recursively reverse the rest of the list.
- Fix the current link: `head.next.next = head`, `head.next = null`.
- Return the new head.

---

### 🛠️ Complexity

- **Time:** `O(n)` – traverse each node once
- **Space:**
  - Iterative → `O(1)`
  - Recursive → `O(n)` (recursion stack)
