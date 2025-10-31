# 3289. The Two Sneaky Numbers of Digitville

## 🧩 Problem Description

In the town of **Digitville**, there was a list of numbers called `nums` containing integers from `0` to `n - 1`.  
Each number was supposed to appear exactly **once** in the list.

However, two mischievous numbers sneaked in an additional time — making the list longer than usual.

Your task as the town detective 🕵️‍♂️ is to find **these two sneaky numbers** and return them as an array of size 2 (in any order).

---

### 🔍 Example 1

**Input:**

```

nums = [0,1,1,0]

```

**Output:**

```

[0,1]

```

**Explanation:**  
The numbers 0 and 1 each appear twice.

---

### 🔍 Example 2

**Input:**

```

nums = [0,3,2,1,3,2]

```

**Output:**

```

[2,3]

```

**Explanation:**  
The numbers 2 and 3 each appear twice.

---

### 🔍 Example 3

**Input:**

```

nums = [7,1,5,4,3,4,6,0,9,5,8,2]

```

**Output:**

```

[4,5]

```

**Explanation:**  
The numbers 4 and 5 each appear twice in the array.

---

### ⚙️ Constraints

- `2 <= n <= 100`
- `nums.length == n + 2`
- `0 <= nums[i] < n`
- Input guarantees **exactly two repeated numbers**.

---

## 💡 Approach 1: Cyclic Sort Technique (In-Place)

The goal is to place each number at its correct index (`nums[i] == i`).  
If a number is already at its position or a duplicate is found, we skip ahead.

### Steps:

1. Iterate through each index `i`.
2. While `nums[i] != i` and the number at `nums[i]` is different, **swap** to place it in the right spot.
3. If a duplicate is detected (`nums[i] == nums[nums[i]]`), move to the next.
4. After sorting, any index `j` where `nums[j] != j` will correspond to the repeated numbers.

---

### 🧠 Example Walkthrough

For `nums = [0,1,1,0]`:

| Step      | nums      | Action                        |
| --------- | --------- | ----------------------------- |
| 1         | [0,1,1,0] | 0 & 1 are fine                |
| 2         | [0,1,1,0] | duplicate detected at index 2 |
| 3         | [0,1,1,0] | duplicate detected at index 3 |
| ✅ Result | [0,1]     |

---

### ⏱️ Time Complexity

- **O(n)** → Each element is swapped at most once.

### 💾 Space Complexity

- **O(1)** → Constant extra space (in-place).

---

## 💡 Alternative Approach: HashSet

Use a `HashSet` to record seen numbers.  
When a number is already in the set, it’s one of the sneaky numbers.

### Complexity:

- Time: **O(n)**
- Space: **O(n)**
