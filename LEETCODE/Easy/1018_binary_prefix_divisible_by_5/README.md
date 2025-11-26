# 1018. Binary Prefix Divisible By 5

## 🔹 Problem Summary

You are given a binary array `nums` (each value is `0` or `1`).  
For each index `i`, define `xi` as the decimal value of the binary number formed by `nums[0..i]`.

Example:
If `nums = [1,0,1]`, then:

- `x0 = 1` (binary `1`)
- `x1 = 2` (binary `10`)
- `x2 = 5` (binary `101`)

Return an array of booleans `answer` such that:

```

answer[i] = true  if xi % 5 == 0
answer[i] = false otherwise

```

---

## 💡 Key Insight

Instead of constructing the full number (which becomes too large), keep only the **remainder modulo 5**, because:

```

remainder_new = (remainder_old * 2 + current_bit) % 5

```

If `remainder == 0`, the prefix is divisible by 5.

---

## 🧮 Complexity

| Type  | Complexity     |
| ----- | -------------- |
| Time  | O(n)           |
| Space | O(1) auxiliary |

---

## ✔ Example

| nums    | Decimal prefixes | Output                |
| ------- | ---------------- | --------------------- |
| [0,1,1] | 0, 1, 3          | [true, false, false]  |
| [1,1,1] | 1, 3, 7          | [false, false, false] |

---

## 🚀 Approach Summary

1. Maintain only the remainder mod 5.
2. After reading each bit, compute new remainder.
3. If `remainder == 0`, result is `true`, else `false`.
