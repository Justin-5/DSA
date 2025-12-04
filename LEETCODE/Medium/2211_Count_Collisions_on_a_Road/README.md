# 2211. Count Collisions on a Road

## 🔍 Problem Summary

You are given a string `directions` representing how each car on a road is moving:

| Character | Meaning          |
| --------- | ---------------- |
| `'L'`     | Car moving left  |
| `'R'`     | Car moving right |
| `'S'`     | Car stationary   |

Cars share the same speed. Collisions occur when:

- Two cars moving **toward each other** collide → **+2 collisions**
- A **moving** car collides with a **stationary** car → **+1 collision**

After a collision, the involved cars become **stationary** permanently.

### 🎯 Goal

Return the **total number of collisions** that will occur.

---

## 🧠 Intuition

Observations allow simplification:

- Leading `'L'` cars will never collide (they move outward off the road).
- Trailing `'R'` cars will never collide for the same reason.
- Any car within the remaining center segment (`left` to `right`) that is **not stationary (`'S'`)** will collide eventually.

Thus:

```

Total collisions = count of (L or R) cars between first non-L and last non-R

```

---

## 💡 Example

| Input      | Output | Explanation                                                    |
| ---------- | ------ | -------------------------------------------------------------- |
| `"RLRSLL"` | `5`    | Multiple interactions eventually make every moving car collide |
| `"LLRR"`   | `0`    | All cars move away from each other                             |

---

## ⏱️ Time & Space Complexity

| Complexity | Value  |
| ---------- | ------ |
| Time       | `O(n)` |
| Space      | `O(1)` |

---

## ✔️ Result

The algorithm efficiently counts the number of collisions without simulating movements step-by-step.

```

```
