# 86. Partition List

## 🧩 Problem Description

Given the `head` of a linked list and an integer `x`, **partition** it so that:

- All nodes with values **less than `x`** come before nodes with values **greater than or equal to `x`**.
- The **relative order** of nodes in each partition is **preserved**.

Return the head of the new linked list.

---

## 🔍 Example 1

**Input**

```

head = [1,4,3,2,5,2], x = 3

```

**Output**

```

[1,2,2,4,3,5]

```

**Explanation**
Nodes less than `3`: `[1,2,2]`  
Nodes greater than or equal to `3`: `[4,3,5]`  
Concatenate them → `[1,2,2,4,3,5]`.

---

## 🔍 Example 2

**Input**

```

head = [2,1], x = 2

```

**Output**

```

[1,2]

```

**Explanation**
Nodes less than `2`: `[1]`  
Nodes greater than or equal to `2`: `[2]`.

---

## ⚙️ Constraints

- The number of nodes in the list is in the range `[0, 200]`.
- `-100 <= Node.val <= 100`
- `-200 <= x <= 200`

---

## 💡 Approach — Two Linked Lists (Stable Partition)

### Intuition

We can divide the list into **two sublists**:

1. Nodes with values **less than `x`**
2. Nodes with values **greater than or equal to `x`**

Then, link the tail of the first list to the head of the second list.

This guarantees:

- All `< x` values come first.
- The order within each partition remains unchanged.

---

### Algorithm

1. Create two dummy nodes:
   - `lesserHead` → head of nodes `< x`
   - `greaterHead` → head of nodes `>= x`
2. Iterate through the original list:
   - If `node.val < x`, append it to the **lesser list**.
   - Otherwise, append it to the **greater list**.
3. Connect the two lists:

```

lesserTail.next = greaterHead.next

```

4. Set the end of the greater list to `null` to prevent cycles.
5. Return the start of the new list:

```

return lesserHead.next;

```

---

### 🧮 Example Walkthrough

**Input**

```

head = [1,4,3,2,5,2], x = 3

```

| Step | Current Node | Condition | Lesser List | Greater List |
| ---- | ------------ | --------- | ----------- | ------------ |
| 1    | 1            | < 3       | [1]         | []           |
| 2    | 4            | ≥ 3       | [1]         | [4]          |
| 3    | 3            | ≥ 3       | [1]         | [4,3]        |
| 4    | 2            | < 3       | [1,2]       | [4,3]        |
| 5    | 5            | ≥ 3       | [1,2]       | [4,3,5]      |
| 6    | 2            | < 3       | [1,2,2]     | [4,3,5]      |

Final connection:

```

lesser → [1,2,2] + [4,3,5] ← greater

```

✅ **Result:** `[1,2,2,4,3,5]`

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                        |
| --------- | ---------- | ---------------------------------- |
| **Time**  | `O(n)`     | Traverse the list once             |
| **Space** | `O(1)`     | Only dummy nodes and pointers used |
