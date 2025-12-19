# 46. Permutations

## 🧠 Problem Description

Given an array `nums` of **distinct integers**, return **all possible permutations** of the array.

- You may return the answer in **any order**.
- A permutation is a rearrangement of all elements in the array.

---

## 📌 Examples

### Example 1

```

Input: nums = [1, 2, 3]
Output:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]

```

### Example 2

```

Input: nums = [0,1]
Output: [[0,1], [1,0]]

```

### Example 3

```

Input: nums = [1]
Output: [[1]]

```

---

## 📋 Constraints

- `1 <= nums.length <= 6`
- `-10 <= nums[i] <= 10`
- All integers in `nums` are **unique**

---

## 💡 Solution Approach (Backtracking)

This problem is solved using **backtracking**, which is ideal for generating all possible combinations or permutations.

### Key Idea

- Build permutations **one element at a time**
- At each step:
  - Try every number that has **not already been used**
  - Add it to the current permutation
  - Recurse
  - Remove it (backtrack) to try other possibilities

---

### 🧩 Algorithm Steps

1. Start with an empty list `p` representing the current permutation.
2. If `p.size() == nums.length`, a complete permutation is formed:
   - Add a copy of `p` to the result list.
3. Otherwise:
   - Loop through all elements in `nums`
   - If the current number is **not already in `p`**, add it
   - Recursively continue building the permutation
   - Remove the last element to explore other paths

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n × n!)**
  - There are `n!` permutations
  - Each permutation takes `O(n)` time to build

### Space Complexity

- **O(n!)**
  - Used to store all permutations
- **O(n)** recursion depth (call stack)

---

## 🧪 Edge Cases Covered

- Single-element array
- Small arrays (`n = 1 or 2`)
- Negative numbers
- Any order of valid permutations
