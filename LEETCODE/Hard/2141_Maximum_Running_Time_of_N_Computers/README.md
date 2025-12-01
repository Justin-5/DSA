# 2141. Maximum Running Time of N Computers

## 🔍 Problem Summary

You are given:

- `n` computers
- An array `batteries`, where each value represents how many minutes a battery can power a computer.

A computer can use **one battery at a time**, but **we may hot-swap batteries instantly at integer moments**.  
Batteries **cannot be recharged**.

### 🎯 Goal

Find the **maximum number of minutes** that all `n` computers can run **simultaneously**.

---

## 🧠 Key Insight

Instead of deciding explicitly which battery goes to which computer step-by-step, we observe:

> If all computers must run for `t` minutes, then the **total usable battery power** must be at least `n × t`.  
> A battery contributes at most `min(battery, t)` to the runtime.

This allows us to use **binary search** on `t`:

- `low = 1`
- `high = (sum of all batteries) / n`
- Check if we can run for `t` minutes using the rule above.

---

## 🧾 Example

| Input                        | Output | Explanation                                                 |
| ---------------------------- | ------ | ----------------------------------------------------------- |
| n = 2, batteries = [3,3,3]   | 4      | Optimal swapping allows both PCs to run for 4 minutes total |
| n = 2, batteries = [1,1,1,1] | 2      | Each minute swap to new batteries until all 4 are depleted  |

---

## 💡 Why Binary Search Works

If it is possible to run `n` computers for `t` minutes, then it is also possible for any time `< t`.  
This makes the feasibility check **monotonic**, enabling binary search.

---

## ⏱️ Time & Space Complexity

| Complexity | Value                                           |
| ---------- | ----------------------------------------------- |
| Time       | `O(m log(sum/n))`, where `m = batteries.length` |
| Space      | `O(1)`                                          |

---

## ✔️ Final Result

The algorithm returns the **maximum possible minutes** that all `n` computers can operate simultaneously.

```

```
