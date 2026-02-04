# 380. Insert Delete GetRandom O(1)

## 🧠 Problem Description

Design a data structure that supports **insert**, **remove**, and **getRandom** operations in **average O(1) time**.

Implement the `RandomizedSet` class with the following methods:

- `RandomizedSet()`  
  Initializes the data structure.

- `boolean insert(int val)`  
  Inserts `val` into the set if it is not already present.  
  Returns `true` if the value was inserted, otherwise `false`.

- `boolean remove(int val)`  
  Removes `val` from the set if it exists.  
  Returns `true` if the value was removed, otherwise `false`.

- `int getRandom()`  
  Returns a random element from the current set.  
  Each element must have the **same probability** of being returned.

It is guaranteed that `getRandom()` will be called only when the set is **not empty**.

---

## 📌 Example

```

Input:
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]

Output:
[null, true, false, true, 2, true, false, 2]

```

---

## 📋 Constraints

- `-2^31 <= val <= 2^31 - 1`
- At most `2 * 10^5` operations
- `getRandom()` is always called when at least one element exists

---

## 💡 Solution Approach (Array + HashMap)

### Key Insight

To achieve **O(1)** time complexity for all operations:

- Use an **ArrayList** to store values
  - Enables `O(1)` random access for `getRandom`
- Use a **HashMap** to store:

```

value → index in array

```

- Enables `O(1)` lookup for insert and remove

---

## 🧩 How Removal Works in O(1)

Removing an element from the middle of an array is normally `O(n)`.  
To avoid this:

1. Get the index of the element to remove
2. Swap it with the **last element** in the array
3. Remove the last element
4. Update the index in the HashMap

This keeps removal in **constant time**.

---

## ⏱️ Time and Space Complexity

### Time Complexity (Average)

- `insert` → **O(1)**
- `remove` → **O(1)**
- `getRandom` → **O(1)**

### Space Complexity

- **O(n)** for storing elements and indices

---

## 🧪 Edge Cases Covered

- Inserting duplicates
- Removing non-existent values
- Random selection with one element
- Large number of operations

---
