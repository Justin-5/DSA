# 66. Plus One

**Difficulty:** Easy  
**Topics:** Array, Math, Simulation  
**LeetCode Link:** [66. Plus One](https://leetcode.com/problems/plus-one/)

---

## 🧩 Problem Statement

You are given a large integer represented as an **integer array `digits`**, where each `digits[i]` is the _i-th digit_ of the integer.  
The digits are ordered from **most significant to least significant** (left to right).  
The large integer **does not contain any leading 0's**.

Increment the large integer by **one** and return the resulting array of digits.

---

## 🔹 Example 1

**Input:**

```

digits = [1,2,3]

```

**Output:**

```

[1,2,4]

```

**Explanation:**
The array represents the integer `123`.  
Incrementing by one gives `123 + 1 = 124`.

---

## 🔹 Example 2

**Input:**

```

digits = [4,3,2,1]

```

**Output:**

```

[4,3,2,2]

```

**Explanation:**
The array represents `4321`.  
After incrementing by 1 → `4322`.

---

## 🔹 Example 3

**Input:**

```

digits = [9]

```

**Output:**

```

[1,0]

```

**Explanation:**
The array represents `9`.  
After incrementing by 1 → `10`.

---

## ⚙️ Constraints

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` **does not contain leading zeros**

---

## 💡 Approach

### 🔸 Intuition

We need to simulate how addition works manually — starting from the **least significant digit (rightmost)**:

1. Start from the end of the array.
2. Increment the current digit by 1.
3. If it becomes 10, set it to 0 and carry over 1 to the next digit.
4. If a digit becomes less than 10 after addition, we can **stop early** since no further carry is needed.
5. If all digits become 0 (like `[9,9,9] → [1,0,0,0]`), we need to create a new array with an extra leading `1`.

---

### 🔹 Steps

1. Iterate from the last index to the first.
2. Add one to the current digit.
3. If it’s not 10, return the array immediately.
4. If it is 10, set it to 0 and continue.
5. After the loop, if no return occurred, that means all digits were `9`. Create a new array of size `n + 1` with `1` at the front.

---

## 🧮 Example Walkthrough

**Input:**

```

digits = [9, 9, 9]

```

| Step             | Operation | Result       | Carry |
| ---------------- | --------- | ------------ | ----- |
| +1 to last digit | 9 → 0     | [9, 9, 0]    | 1     |
| Carry +1 to next | 9 → 0     | [9, 0, 0]    | 1     |
| Carry +1 to next | 9 → 0     | [0, 0, 0]    | 1     |
| Overflow handled | —         | [1, 0, 0, 0] | —     |

✅ **Output:** `[1, 0, 0, 0]`

---

## 🧰 Complexity Analysis

| Complexity   | Explanation                                                 |
| ------------ | ----------------------------------------------------------- |
| ⏱️ **Time**  | O(n) — Traverse digits once                                 |
| 💾 **Space** | O(1) — In-place modification (except when new array needed) |

---

## 🧠 Key Takeaway

A classic **simulation** problem testing understanding of carry propagation —  
simple yet great for mastering array manipulation and control flow logic.
