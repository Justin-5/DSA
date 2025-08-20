---
### 📑 README Entry (Markdown Friendly)

| #   | Problem Name                          | Difficulty | Key Idea                                                                                                            | Solution Link                     |
  | --- | ------------------------------------- | ---------- | ------------------------------------------------------------------------------------------------------------------- | --------------------------------- |
  | 167 | Two Sum II – Input Array Is Sorted 🔗 | Medium     | Use **two pointers**: one at start, one at end. Move pointers inward based on sum vs target. O(n) time, O(1) space. | [Java](./solutions/TwoSumII.java) |
---

### 📝 Explanation for README

#### **Approach: Two Pointers (O(n), O(1))**

1. Initialize two pointers:

   - `i` → start of the array
   - `j` → end of the array

2. Compute `sum = numbers[i] + numbers[j]`

   - If `sum < target`: move `i` right (increase sum).
   - If `sum > target`: move `j` left (decrease sum).
   - If `sum == target`: return `[i+1, j+1]` (1-indexed).

3. Guaranteed to find exactly one solution due to problem constraints.

➡️ Efficient because each number is visited at most once.

---
