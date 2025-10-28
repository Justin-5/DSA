# 3354. Make Array Elements Equal to Zero

## 🧩 Problem Description

You are given an integer array `nums`.

Start by selecting a **starting position** `curr` such that `nums[curr] == 0`, and choose a **movement direction** of either left or right.

After that, you repeat the following process:

1. If `curr` is out of range `[0, n - 1]`, the process ends.
2. If `nums[curr] == 0`, move in the current direction (`curr++` if right, `curr--` if left).
3. Else if `nums[curr] > 0`:
   - Decrement `nums[curr]` by 1.
   - Reverse the movement direction.
   - Take a step in the new direction.

A selection of the initial position and movement direction is **valid** if every element in `nums` becomes 0 by the end of the process.

Return the **number of valid selections**.

---

### 🔍 Examples

#### Example 1:

**Input:**

```

nums = [1,0,2,0,3]

```

**Output:**

```

2

```

**Explanation:**
The only possible valid selections are:

- Start at `curr = 3` and move left.
- Start at `curr = 3` and move right.

---

#### Example 2:

**Input:**

```

nums = [2,3,4,0,4,1,0]

```

**Output:**

```

0

```

**Explanation:**
No valid starting position and direction result in all zeros.

---

### ⚙️ Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 100`
- There is **at least one element i where nums[i] == 0**.

---

## 💡 Approach (based on your code)

1. **Simulation for both directions**:
   - For each index `i` where `nums[i] == 0`, simulate both left and right movement directions.
2. **Clone the array for each simulation** to preserve the original state.
3. **Follow the rules**:
   - If you hit a positive number, decrement it and reverse direction.
   - If you hit zero, continue in the same direction.
4. **Check if all elements become zero**:
   - If yes, count this start-direction pair as valid.

---

### ⏱️ Time Complexity

- **O(n²)** — because for each possible zero position, we simulate the full traversal.

### 💾 Space Complexity

- **O(n)** — cloning the array for simulation.
