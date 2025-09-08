# 23. Merge k Sorted Lists

## Problem Statement

You are given an array of `k` linked lists, each sorted in ascending order.  
Merge all the linked lists into one sorted linked list and return it.

---

## Examples

**Example 1**

```

Input: lists = \[\[1,4,5],\[1,3,4],\[2,6]]
Output: \[1,1,2,3,4,4,5,6]

Explanation:
The linked lists are:
1 -> 4 -> 5
1 -> 3 -> 4
2 -> 6

Merging them results in:
1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

```

**Example 2**

```

Input: lists = \[]
Output: \[]

```

**Example 3**

```

Input: lists = \[\[]]
Output: \[]

```

---

## Constraints

- `k == lists.length`
- `0 <= k <= 10^4`
- `0 <= lists[i].length <= 500`
- `-10^4 <= lists[i][j] <= 10^4`
- Each `lists[i]` is sorted in ascending order
- The total number of nodes across all lists ≤ `10^4`

---

## Approach

### 🔑 Idea

- Since all lists are individually sorted, we can efficiently merge them using a **min-heap (priority queue)**.
- At any time, the heap stores the smallest head nodes among the `k` lists.
- Repeatedly extract the minimum node, append it to the result list, and insert its next node (if any) back into the heap.

### Steps

1. Initialize a **priority queue** (min-heap) ordered by node value.
2. Insert the head of each non-empty linked list into the heap.
3. While the heap is not empty:
   - Extract the smallest node.
   - Append it to the result list.
   - If that node has a `next`, push it into the heap.
4. Return the merged linked list.

---

## Complexity

- **Time Complexity:** `O(N log k)`
  - `N` = total number of nodes across all lists.
  - Each insertion/removal from heap takes `O(log k)` where `k` is the number of lists.
- **Space Complexity:** `O(k)`
  - The heap stores at most one node from each list at a time.

---

## Example Walkthrough

Input: `lists = [[1,4,5],[1,3,4],[2,6]]`

- Push heads → Heap = `[1,1,2]`
- Extract 1 → Result = `1`, push its next (4) → Heap = `[1,2,4]`
- Extract 1 → Result = `1->1`, push its next (3) → Heap = `[2,3,4]`
- Extract 2 → Result = `1->1->2`, push 6 → Heap = `[3,4,6]`
- Extract 3 → Result = `1->1->2->3`, push 4 → Heap = `[4,4,6]`
- Continue until heap is empty.

Final result: `1->1->2->3->4->4->5->6`

```

```
