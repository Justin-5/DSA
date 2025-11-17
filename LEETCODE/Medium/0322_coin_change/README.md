# 322. Coin Change

## 🧠 Problem Summary

You are given:

- An array `coins[]` of coin denominations.
- An integer `amount`.

Your task:  
Return the **fewest number of coins** needed to make `amount`.  
If it is **not possible**, return `-1`.

You may assume an **infinite supply** of each coin.

---

## ✅ Approach — Dynamic Programming (Bottom-Up)

We use a DP array where:

`dp[x] = minimum coins needed to make amount x`

Steps:

1. Initialize `dp[]` with `amount + 1` (acts like ∞).
2. Set `dp[0] = 0` (0 coins needed to form amount 0).
3. For each amount `i` from 1 → amount:
   - Try all coins.
   - If `coin <= i`, compute:
     ```
     dp[i] = min(dp[i], 1 + dp[i - coin])
     ```
4. Final answer is:
   - `dp[amount]` if reachable
   - Otherwise return `-1`

---

## 🧮 Complexity

- **Time:** O(amount × number_of_coins)
- **Space:** O(amount)

---

## ✔ Example

Input:

````

coins = [1, 2, 5], amount = 11

```

DP result:
```

dp[11] = 3  → 5 + 5 + 1

```

---

## 📝 Notes
This is the classical DP solution and is optimal for constraints up to `amount = 10⁴`.
```

````
