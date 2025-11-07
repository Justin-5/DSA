# 61. Rotate List

## 🧩 Problem Description

Given the head of a singly linked list, rotate the list to the right by `k` positions.

Rotation means taking the last `k` nodes and moving them to the front of the list, preserving the order.

---

## 🔍 Example 1

**Input**

```

head = [1,2,3,4,5]
k = 2

```

**Output**

```

[4,5,1,2,3]

```

**Explanation**
After two rotations:

- 1st rotation → [5,1,2,3,4]
- 2nd rotation → [4,5,1,2,3]

---

## 🔍 Example 2

**Input**

```

head = [0,1,2]
k = 4

```

**Output**

```

[2,0,1]

```

**Explanation**
The list length is 3, and `k % 3 = 1`.  
So effectively, we only rotate once → `[2,0,1]`.

---

## ⚙️ Constraints

- `0 <= k <= 2 * 10^9`
- `The number of nodes in the list is in the range [0, 500]`
- `-100 <= Node.val <= 100`

---

## 💡 Approach — Circular Rotation Trick

### Key Idea

1. Compute the **length** of the list and connect the tail to the head to form a **circular linked list**.
2. Compute `k % length` — since rotating by the list’s length brings it back to its original form.
3. Find the **new tail** — the `(length - k % length - 1)`th node.
4. The node after the new tail becomes the **new head**.
5. Break the circular connection at the new tail.

---

## 🧮 Step-by-Step Example

**Input**

```

head = [1,2,3,4,5], k = 2

```

**Step 1: Compute length**

```

length = 5

```

**Step 2: Connect tail → head (circular list)**

```

1 → 2 → 3 → 4 → 5
↑----------------|

```

**Step 3: Compute effective rotation**

```

k % length = 2

```

**Step 4: Find new tail**

```

Move (5 - 2 - 1) = 2 steps → newTail = node with value 3

```

**Step 5: Break circle and update head**

```

New head = newTail.next = 4
New list = [4,5,1,2,3]

```

✅ **Final Answer:** `[4,5,1,2,3]`

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                                                       |
| --------- | ---------- | ----------------------------------------------------------------- |
| **Time**  | `O(n)`     | Single pass to find length + one more pass to find rotation point |
| **Space** | `O(1)`     | No extra data structures used                                     |
