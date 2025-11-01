# 3217. Delete Nodes From Linked List Present in Array

## 🧩 Problem Description

You are given an array of integers `nums` and the head of a linked list.  
Your task is to **remove all nodes from the linked list** that have a value present in `nums`.

Return the head of the modified linked list.

---

### 🔍 Example 1

**Input:**

```

nums = [1,2,3]
head = [1,2,3,4,5]

```

**Output:**

```

[4,5]

```

**Explanation:**
Nodes with values `1`, `2`, and `3` are removed.

---

### 🔍 Example 2

**Input:**

```

nums = [1]
head = [1,2,1,2,1,2]

```

**Output:**

```

[2,2,2]

```

**Explanation:**
All nodes with value `1` are deleted.

---

### 🔍 Example 3

**Input:**

```

nums = [5]
head = [1,2,3,4]

```

**Output:**

```

[1,2,3,4]

```

**Explanation:**
No nodes have value `5`, so the list remains unchanged.

---

### ⚙️ Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
- All elements in `nums` are **unique**
- The number of nodes in the linked list is in the range `[1, 10^5]`
- `1 <= Node.val <= 10^5`
- There is **at least one node** in the list that does not appear in `nums`

---

## 💡 Approach

### 1️⃣ Use a HashSet for Quick Lookup

Store all numbers from `nums` in a `HashSet` for **O(1)** lookup.

### 2️⃣ Traverse the Linked List

- Use a **dummy node** to simplify edge case handling (especially when the head node needs removal).
- Use two pointers:
  - `prev` → last valid node in the result list
  - `cur` → current node being checked
- If `cur.val` is in `nums`, skip it by updating `prev.next = cur.next`.
- Otherwise, move `prev` forward.

### 3️⃣ Return the Modified List

Return `dummy.next` as the new head.

---

### 🧠 Example Walkthrough

#### Input

```

nums = [1, 2, 3]
head = [1, 2, 3, 4, 5]

```

| Step | cur.val | Action  | Resulting List |
| ---- | ------- | ------- | -------------- |
| 1    | 1       | removed | [2,3,4,5]      |
| 2    | 2       | removed | [3,4,5]        |
| 3    | 3       | removed | [4,5]          |
| 4    | 4       | kept    | [4,5]          |
| 5    | 5       | kept    | [4,5]          |

✅ Final list: `[4,5]`

---

### ⏱️ Time Complexity

- **O(n + m)**
  - `n` = number of nodes in the list
  - `m` = number of elements in `nums`

### 💾 Space Complexity

- **O(m)** → for storing elements in the `HashSet`.
