# 228. Summary Ranges

## 🧩 Problem Description

You are given a **sorted unique integer array** `nums`.

A range `[a, b]` represents all integers from `a` to `b` (inclusive).

Return the **smallest sorted list of ranges** that exactly cover all the numbers in the array.  
Each element in `nums` must belong to exactly one range.

Each range `[a, b]` should be formatted as:

- `"a->b"` if `a != b`
- `"a"` if `a == b`

---

### 🔍 Example 1

**Input:**

```

nums = [0,1,2,4,5,7]

```

**Output:**

```

["0->2","4->5","7"]

```

**Explanation:**  
The ranges are:

- `[0,2]` → `"0->2"`
- `[4,5]` → `"4->5"`
- `[7,7]` → `"7"`

---

### 🔍 Example 2

**Input:**

```

nums = [0,2,3,4,6,8,9]

```

**Output:**

```

["0","2->4","6","8->9"]

```

**Explanation:**  
The ranges are:

- `[0,0]` → `"0"`
- `[2,4]` → `"2->4"`
- `[6,6]` → `"6"`
- `[8,9]` → `"8->9"`

---

### ⚙️ Constraints

- `0 <= nums.length <= 20`
- `-2^31 <= nums[i] <= 2^31 - 1`
- All elements in `nums` are **unique**
- `nums` is sorted in **ascending order**

---

## 💡 Approach

### 1️⃣ Two-Pointer Range Detection

Use two pointers (`a` and `b`) to track the start and end of each range.

#### Steps:

1. Initialize `a = 0`, `b = 0`
2. Traverse the array:
   - Increment `b` while consecutive numbers continue (`nums[b + 1] == nums[b] + 1`)
3. Once the range ends:
   - If `a == b`, it’s a single number → `"a"`
   - Otherwise → `"a->b"`
4. Move `a` and `b` to the next unprocessed element.

---

### 🧠 Example Walkthrough

For `nums = [0,2,3,4,6,8,9]`:

| Step | a   | b   | Range formed |
| ---- | --- | --- | ------------ |
| 1    | 0   | 0   | `"0"`        |
| 2    | 1   | 3   | `"2->4"`     |
| 3    | 4   | 4   | `"6"`        |
| 4    | 5   | 6   | `"8->9"`     |

✅ Output → `["0", "2->4", "6", "8->9"]`

---

### ⏱️ Time Complexity

- **O(n)** → Each number is processed once.

### 💾 Space Complexity

- **O(1)** → Only uses a few extra variables.
