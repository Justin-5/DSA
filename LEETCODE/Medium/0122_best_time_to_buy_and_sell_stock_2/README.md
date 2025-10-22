# 122. Best Time to Buy and Sell Stock II

**Difficulty:** Medium  
**Topics:** Greedy, Array, Dynamic Programming  
**LeetCode Link:** [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

---

## 🧩 Problem Statement

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i`-th day.

On each day, you may **buy and/or sell** the stock.  
You can **only hold at most one share** of the stock at any time.  
However, you can sell and buy the stock on the same day, as long as you never hold more than one share.

Return the **maximum profit** you can achieve.

---

## 🔹 Example 1

**Input:**

```

prices = [7,1,5,3,6,4]

```

**Output:**

```

7

```

**Explanation:**

- Buy on day 2 (price = 1), sell on day 3 (price = 5) → profit = 4
- Buy on day 4 (price = 3), sell on day 5 (price = 6) → profit = 3  
  ✅ Total profit = 4 + 3 = **7**

---

## 🔹 Example 2

**Input:**

```

prices = [1,2,3,4,5]

```

**Output:**

```

4

```

**Explanation:**
Buy on day 1 and sell on day 5 → profit = 5 - 1 = **4**

---

## 🔹 Example 3

**Input:**

```

prices = [7,6,4,3,1]

```

**Output:**

```

0

```

**Explanation:**
No profitable transaction possible, so total profit = **0**

---

## ⚙️ Constraints

- `1 <= prices.length <= 3 * 10^4`
- `0 <= prices[i] <= 10^4`

---

## 💡 Approach

### 🔸 Intuition

We can make a profit **every time the price increases**.  
In other words:

- Buy whenever a price is **lower than the next day’s** price.
- Sell the next day to gain `(prices[i+1] - prices[i])`.

Since you can buy and sell multiple times, just **sum all positive differences** between consecutive days.

---

### 🔹 Example Walkthrough

**prices = [7,1,5,3,6,4]**

| Day | Price | Next Day | Gain (if any) | Total Profit |
| --- | ----- | -------- | ------------- | ------------ |
| 1   | 7     | 1        | 0             | 0            |
| 2   | 1     | 5        | 4             | 4            |
| 3   | 5     | 3        | 0             | 4            |
| 4   | 3     | 6        | 3             | 7            |
| 5   | 6     | 4        | 0             | 7            |

✅ Final profit = **7**

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                         |
| ------------ | ----------------------------------- |
| ⏱️ **Time**  | O(n) — one pass through prices      |
| 💾 **Space** | O(1) — only one variable for profit |

---

## 🔄 Alternative Approaches

- **Dynamic Programming:**  
  You can use a DP table to track “holding” and “not holding” states.  
  However, the greedy method is optimal and simpler for this problem.
