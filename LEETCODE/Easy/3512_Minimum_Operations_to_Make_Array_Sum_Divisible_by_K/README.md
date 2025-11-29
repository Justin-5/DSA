# 3512. Minimum Operations to Make Array Sum Divisible by K

## 🔍 Problem Summary

You are given an integer array `nums` and an integer `k`.  
In one operation, you may select an index `i` and replace `nums[i]` with `nums[i] - 1`.

Your goal is to determine **the minimum number of operations required** to make the **sum of the entire array divisible by `k`**.

---

## 🧠 Key Insight

Each operation reduces the total sum of the array by exactly `1`.  
So instead of performing operations on individual values, we only care about how many operations are needed to adjust the **total sum modulo `k`** to `0`.

If:

```

sum % k == 0   →  already divisible → 0 operations needed
sum % k == r   →  we need to reduce sum by r → r operations

```

---

## 🧾 Examples

| Input                 | Output | Explanation                                          |
| --------------------- | ------ | ---------------------------------------------------- |
| nums = [3,9,7], k = 5 | 4      | sum = 19 → 19 mod 5 = 4 → reduce 4 times             |
| nums = [4,1,3], k = 4 | 0      | sum = 8 → already divisible                          |
| nums = [3,2], k = 6   | 5      | sum = 5 → 5 mod 6 = 5 → need 5 reductions to reach 0 |

---

## 🧩 Complexity

| Complexity | Value  |
| ---------- | ------ |
| Time       | `O(n)` |
| Space      | `O(1)` |

---

## ✔️ Final Answer

Minimum operations = `sum(nums) % k`
