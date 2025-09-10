# 160. Intersection of Two Linked Lists

## Problem Statement

You are given the heads of two singly linked-lists `headA` and `headB`.  
Return the node at which the two lists intersect.  
If they do not intersect, return `null`.

⚠️ Note: Intersection is determined by reference, not value.  
Even if two nodes have the same value, they are only considered intersected if they are the exact same node in memory.

---

## Examples

### Example 1:

```

Input: intersectVal = 8, listA = \[4,1,8,4,5], listB = \[5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'

Explanation:
listA: 4 -> 1 -> 8 -> 4 -> 5
listB: 5 -> 6 -> 1 ↘
8 -> 4 -> 5

```

### Example 2:

```

Input: intersectVal = 2, listA = \[1,9,1,2,4], listB = \[3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'

Explanation:
listA: 1 -> 9 -> 1 -> 2 -> 4
listB: 3 ---------↘
2 -> 4

```

### Example 3:

```

Input: intersectVal = 0, listA = \[2,6,4], listB = \[1,5]
Output: No intersection

```

---

## Constraints

- `1 <= m, n <= 3 * 10^4` where `m` and `n` are lengths of listA and listB.
- Node values: `1 <= Node.val <= 10^5`
- `intersectVal` is `0` if no intersection.
- No cycles exist in the input.

---

## Approach

We solve this in **O(m + n)** time and **O(1)** extra space:

1. **Find lengths of both lists** (`countA`, `countB`) and tails.
2. If tails are different → return `null` (they never intersect).
3. Move the head of the longer list forward by the length difference.
4. Traverse both lists together until the intersection node is found.
5. Return the intersected node.

---

## Complexity

- **Time Complexity:** `O(m + n)` — each list traversed at most twice.
- **Space Complexity:** `O(1)` — only pointers used.

---

## Follow-up

An alternate trick: use two pointers (`a`, `b`) traversing `headA` and `headB`.  
When a pointer reaches the end, redirect it to the other list’s head.  
They will either meet at the intersection or both reach `null`.

```

```
