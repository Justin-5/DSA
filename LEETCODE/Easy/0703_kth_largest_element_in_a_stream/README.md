---

## 📄 Approach Explanation

### Idea

* We want to **continuously track the kth largest element** in a dynamic stream of numbers.
* To do this efficiently:

  * Use a **min-heap of size `k`**.
  * The heap stores the **k largest elements so far**.
  * The **smallest element in the heap (`minHeap.peek()`)** is always the kth largest element.

---

### Why Min-Heap of Size `k`?

- If we used a **max-heap**, we’d have to pop `(k-1)` elements every time to find the kth largest → inefficient.
- Instead, a **min-heap of size k** keeps things lean:

  - If the new element is **bigger than the smallest** in the heap → replace it.
  - Otherwise, ignore it.

- That way, the heap always has the top `k` largest elements.

---

### Algorithm

1. Initialize:

   - Store `k`.
   - Create a min-heap.
   - Add all elements from the initial stream using the `add()` method.

2. For `add(val)`:

   - If heap size < k → push val.
   - Else, if val > heap’s min → pop min, then push val.
   - Return `heap.peek()` (the kth largest).

---

### Dry Run

Input:

```
k = 3, nums = [4, 5, 8, 2]
```

Step by step:

- Build heap:

  - Add 4 → heap = [4]
  - Add 5 → heap = [4, 5]
  - Add 8 → heap = [4, 5, 8]
  - Add 2 → heap = [4, 5, 8] (ignore 2 since smaller than root)
  - Now heap = [4, 5, 8], kth largest = 4

Operations:

```
add(3) → heap = [4, 5, 8], return 4
add(5) → heap = [5, 5, 8], return 5
add(10) → heap = [5, 10, 8], return 5
add(9) → heap = [8, 10, 9], return 8
add(4) → heap = [8, 10, 9], return 8
```
