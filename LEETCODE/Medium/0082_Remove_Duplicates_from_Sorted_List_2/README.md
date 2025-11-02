# 82. Remove Duplicates from Sorted List II

## 🧩 Problem Description

Given the head of a **sorted linked list**, delete all nodes that have **duplicate numbers**, leaving only distinct numbers from the original list.  
Return the modified list in **sorted order**.

---

## 🔍 Example 1

**Input:**

```

head = [1,2,3,3,4,4,5]

```

**Output:**

```

[1,2,5]

```

---

## 🔍 Example 2

**Input:**

```

head = [1,1,1,2,3]

```

**Output:**

```

[2,3]

```

---

## ⚙️ Constraints

- The number of nodes in the list is in the range `[0, 300]`.
- `-100 <= Node.val <= 100`
- The list is guaranteed to be **sorted in ascending order**.

---

## 💡 Approach

We use a **two-pointer technique** (`slow` and `fast`) along with a **dummy node** to efficiently handle duplicates at the head and middle positions.

### Steps:

1. Create a dummy node pointing to the head to simplify edge case handling (like duplicates at the start).
2. Use:
   - `slow` to track the current node.
   - `fast` to move ahead and detect duplicates.
   - `preSlow` to maintain the link to the last unique node.
3. When duplicates are found (`slow.val == fast.val`):
   - Move `fast` until all duplicates of that value are skipped.
   - Connect `preSlow.next` directly to `fast` (skipping the duplicate group).
4. When values differ:
   - Move all pointers one step forward.
5. Continue until the end of the list.

Finally, return `dummy.next` as the head of the filtered list.

---

## 🧠 Intuition

Since the list is **sorted**, all duplicates will appear consecutively.  
By moving the `fast` pointer past duplicates and linking around them, we can effectively remove all duplicate nodes in one traversal.

---

## ⏱️ Complexity Analysis

| Complexity | Explanation                            |
| ---------- | -------------------------------------- |
| **Time**   | `O(n)` — each node is visited once     |
| **Space**  | `O(1)` — in-place pointer manipulation |

---

## 🧮 Example Walkthrough

**Input:**

```

head = [1,2,3,3,4,4,5]

```

**Step-by-Step:**

- `slow = 1`, `fast = 2` → different → move both ahead
- `slow = 2`, `fast = 3` → different → move both ahead
- `slow = 3`, `fast = 3` → duplicate found → skip both 3s
- `slow = 4`, `fast = 4` → duplicate found → skip both 4s
- Remaining unique nodes: `1 → 2 → 5`

**Output:**

```

[1, 2, 5]

```
