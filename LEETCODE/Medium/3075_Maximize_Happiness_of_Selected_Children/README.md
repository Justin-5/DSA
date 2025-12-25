# 3075. Maximize Happiness of Selected Children

## 🧠 Problem Description

You are given:

- An integer array `happiness` of length `n`
- A positive integer `k`

There are `n` children standing in a queue, where the `i`-th child has happiness value `happiness[i]`.

You must select **exactly `k` children**, one per turn.

### Rules per Turn

- When a child is selected, the happiness value of **all unselected children** decreases by `1`
- Happiness values **cannot become negative**
- Decrement only applies if the value is positive

Your goal is to **maximize the sum of happiness values** of the selected children.

---

## 📌 Examples

### Example 1

```

Input: happiness = [1,2,3], k = 2
Output: 4

```

Explanation:

- Pick child with happiness `3`
- Remaining happiness becomes `[0,1]`
- Pick child with happiness `1`
- Total = `3 + 1 = 4`

---

### Example 2

```

Input: happiness = [1,1,1,1], k = 2
Output: 1

```

Explanation:

- First pick gives `1`
- Remaining values drop to `0`
- Second pick gives `0`
- Total = `1`

---

### Example 3

```

Input: happiness = [2,3,4,5], k = 1
Output: 5

```

Explanation:

- Pick the child with happiness `5`
- Total = `5`

---

## 📋 Constraints

- `1 <= n <= 2 * 10^5`
- `1 <= happiness[i] <= 10^8`
- `1 <= k <= n`

---

## 💡 Solution Approach (Greedy)

### Key Insight

To maximize total happiness:

- Always pick the **currently happiest child**
- Each pick reduces the happiness of remaining children by `1`
- This reduction is cumulative over turns

So:

- Sort the array
- Pick from the **largest values**
- Account for decreasing happiness using a growing subtraction value

---

## 🧩 Algorithm Steps

1. Sort the `happiness` array in ascending order
2. Start picking from the **largest values**
3. Maintain a decrement counter (`sub`) representing how much happiness has reduced
4. After each pick:
   - Add current happiness to the answer
   - Reduce remaining values (bounded by zero)
5. Repeat for `k` picks

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n log n)** due to sorting

### Space Complexity

- **O(1)** extra space (in-place operations)

---

## 🧪 Edge Cases Covered

- Picking only one child
- All happiness values becoming zero early
- Large input sizes
- Large happiness values
