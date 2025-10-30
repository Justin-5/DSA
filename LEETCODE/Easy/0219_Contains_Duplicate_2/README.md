# 219. Contains Duplicate II

## 🧩 Problem Description

Given an integer array `nums` and an integer `k`, return **true** if there exist two distinct indices `i` and `j` in the array such that:

- `nums[i] == nums[j]`, and
- `abs(i - j) <= k`.

Otherwise, return **false**.

---

### 🔍 Example 1

**Input:**

```

nums = [1,2,3,1], k = 3

```

**Output:**

```

true

```

**Explanation:**  
The element `1` appears at indices `0` and `3`, and `|3 - 0| = 3 ≤ k`.

---

### 🔍 Example 2

**Input:**

```

nums = [1,0,1,1], k = 1

```

**Output:**

```

true

```

**Explanation:**  
The element `1` appears at indices `2` and `3`, and `|3 - 2| = 1 ≤ k`.

---

### 🔍 Example 3

**Input:**

```

nums = [1,2,3,1,2,3], k = 2

```

**Output:**

```

false

```

**Explanation:**  
The duplicates are too far apart — no pair satisfies `|i - j| ≤ k`.

---

### ⚙️ Constraints

- `1 <= nums.length <= 10⁵`
- `-10⁹ <= nums[i] <= 10⁹`
- `0 <= k <= 10⁵`

---

## 💡 Approach (Using HashMap)

We can efficiently track the **most recent index** of each number using a `HashMap`.

1. Iterate through the array.
2. For each number:
   - If it has been seen before, check the **distance** between the current and previous indices.
   - If `abs(i - prevIndex) <= k`, return `true`.
   - Otherwise, update the stored index for that number.
3. If no such pair is found, return `false`.

---

### 🧠 Example Walkthrough

For `nums = [1, 2, 3, 1]`, `k = 3`:

| i   | nums[i] | Last Seen | Distance | Valid? | Action        |
| --- | ------- | --------- | -------- | ------ | ------------- |
| 0   | 1       | -         | -        | -      | store index 0 |
| 1   | 2       | -         | -        | -      | store index 1 |
| 2   | 3       | -         | -        | -      | store index 2 |
| 3   | 1       | 0         | 3        | ✅     | return true   |

✅ Result: `true`

---

### ⏱️ Time Complexity

- **O(n)** → Single pass through the array.

### 💾 Space Complexity

- **O(n)** → HashMap storing up to `n` unique elements.
