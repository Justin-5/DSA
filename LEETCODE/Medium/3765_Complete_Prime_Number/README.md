# 3765. Complete Prime Number

## 🔍 Problem Summary

You are given an integer `num`.

A number is called a **Complete Prime Number** if:

- Every **prefix** of the number is prime
- Every **suffix** of the number is prime

### Notes

| Term         | Meaning                                              |
| ------------ | ---------------------------------------------------- |
| Prefix       | First k digits of the number                         |
| Suffix       | Last k digits of the number                          |
| Prime        | Natural number > 1 with only 2 factors: 1 and itself |
| Single-digit | Complete Prime only if itself is prime               |

---

## 🧠 Examples

| Input | Output  | Explanation                                      |
| ----- | ------- | ------------------------------------------------ |
| `23`  | `true`  | Prefixes: 2, 23 → prime; Suffixes: 3, 23 → prime |
| `39`  | `false` | `39` and `9` are not prime                       |
| `7`   | `true`  | Single-digit & prime                             |

---

## 💡 Approach

1. Check if the whole number is prime.
2. Convert it to string for digit-level slicing.
3. Check all prefixes (`substring(0, i)`)
4. Check all suffixes (`substring(i)`)

If **any** prefix or suffix is not prime → return `false`.

---

## ⏱️ Time Complexity

| Process                   | Complexity                               |
| ------------------------- | ---------------------------------------- |
| Prime check               | `O(√n)`                                  |
| Prefix & Suffix iteration | `O(d * √n)` where `d = number of digits` |

---

## ✔️ Result

Return `true` only if **all** prefixes and suffixes are prime.
