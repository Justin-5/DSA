# 1015. Smallest Integer Divisible by K

## 🧠 Problem Summary

Given an integer `k`, find the **length** of the smallest positive integer `n` such that:

- `n` consists only of the digit `'1'` (e.g., `1`, `11`, `111`, `1111`, …)
- `n % k == 0`

If no such number exists, return `-1`.

⚠️ Note: `n` itself might be too large to store directly — so we compute using modular arithmetic.

---

## 🔍 Key Observations

- If `k` is divisible by **2** or **5**, there will never be a number consisting only of `1`s that is divisible by `k`.  
  → Immediately return `-1`.

- Instead of constructing the number (which would overflow), maintain the **remainder**:

```

remainder = (previous_remainder * 10 + 1) % k

```

- If remainder becomes **0** when length = `i`, then the number with `i` ones is divisible by `k`.

---

## 🧮 Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(k)       |
| Space | O(1)       |

---

## ✔ Example

| k   | Smallest n | Length |
| --- | ---------- | ------ |
| 1   | 1          | 1      |
| 2   | —          | -1     |
| 3   | 111        | 3      |

---

## 🚀 Approach Summary

Loop from `1` to `k`, updating the remainder of a repunit (`"111..."`).  
The moment remainder reaches `0`, return the current count.
