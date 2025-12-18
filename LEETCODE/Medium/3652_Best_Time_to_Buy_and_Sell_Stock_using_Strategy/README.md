# 3652. Best Time to Buy and Sell Stock using Strategy

## 🧠 Problem Description

You are given two integer arrays:

- `prices[i]`: the stock price on the `i`-th day
- `strategy[i]`: the trading action on the `i`-th day
  - `-1` → Buy one unit of stock
  - `0` → Hold
  - `1` → Sell one unit of stock

You are also given an **even integer `k`**, and you may perform **at most one modification** to the `strategy` array.

### 🔧 Modification Rules

- Select **exactly `k` consecutive elements**
- Set:
  - First `k/2` elements → `0` (hold)
  - Last `k/2` elements → `1` (sell)

### 💰 Profit Definition

```

profit = Σ(strategy[i] × prices[i])

```

There are **no constraints on budget or stock ownership**, so all operations are valid.

---

## ✅ Objective

Return the **maximum possible profit** after applying **at most one modification**.

---

## 📌 Example 1

```

Input:
prices   = [4, 2, 8]
strategy = [-1, 0, 1]
k = 2

Output: 10

```

Explanation:

- Modifying the subarray `[0, 1]` gives `[0, 1, 1]`
- Profit = `0×4 + 1×2 + 1×8 = 10`

---

## 💡 Solution Approach

### Step 1: Calculate Original Profit

Compute the profit without any modification:

```

originalProfit = Σ(strategy[i] × prices[i])

```

---

### Step 2: Calculate Profit Change for First Window

For a window of size `k`:

- First `k/2` → changed to `0` (remove old contribution)
- Last `k/2` → changed to `1` (add selling profit)

This gives the **net profit change** if this window is modified.

---

### Step 3: Sliding Window Optimization

Instead of recalculating for every window:

- Use a **sliding window**
- Remove the effect of elements leaving the window
- Add the effect of new elements entering the window

Track the **maximum additional profit** achievable from any window.

---

### Step 4: Final Answer

```

answer = originalProfit + max(0, bestModificationProfit)

```

If modification is harmful, we simply skip it.

---

## ⏱️ Time & Space Complexity

| Metric | Complexity |
| ------ | ---------- |
| Time   | **O(n)**   |
| Space  | **O(1)**   |

- Single pass to compute original profit
- Single sliding window pass for modification profit

---

## 🧪 Edge Cases Handled

- No modification gives better profit
- `k` equals array length
- Negative or zero profit strategies
- Large inputs up to `10⁵`
