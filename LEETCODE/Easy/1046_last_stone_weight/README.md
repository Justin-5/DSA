## 1046. Last Stone Weight

### Problem

You are given an array of integers `stones`, where `stones[i]` is the weight of the i-th stone.

We repeatedly **smash the two heaviest stones** together:

- If `x == y`, both are destroyed.
- If `x != y`, the lighter one is destroyed and the heavier becomes `y - x`.

At the end, return the weight of the last remaining stone. If none remain, return `0`.

---

### Example 1

```
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
- Smash 8 & 7 → result 1 → stones = [2,4,1,1,1]
- Smash 4 & 2 → result 2 → stones = [2,1,1,1]
- Smash 2 & 1 → result 1 → stones = [1,1,1]
- Smash 1 & 1 → result 0 → stones = [1]
Final stone = 1
```

### Example 2

```
Input: stones = [1]
Output: 1
```

---

### Constraints

- `1 <= stones.length <= 30`
- `1 <= stones[i] <= 1000`

---

### Approach 🚀

We need to always pick the **two heaviest stones** quickly.
This is a classic use case for a **max-heap**.

1. Put all stone weights into a **max-heap** (PriorityQueue with reverse order).
2. While more than one stone remains:

   - Pop the two heaviest (`y` and `x`).
   - If `x != y`, insert `y - x` back into the heap.

3. When only one (or zero) stone remains, return its weight.

---

### Dry Run 📝

Input:

```
stones = [2,7,4,1,8,1]
```

Steps:

- Heap = [8,7,4,2,1,1]
- Pop 8,7 → insert 1 → Heap = [4,2,1,1,1]
- Pop 4,2 → insert 2 → Heap = [2,1,1,1]
- Pop 2,1 → insert 1 → Heap = [1,1,1]
- Pop 1,1 → insert 0 → Heap = [1]
  Result = **1**

---

### Complexity

- **Time:** `O(n log n)`
  (Each poll/insert is `O(log n)` and we do it up to `n` times.)
- **Space:** `O(n)` for the heap.
