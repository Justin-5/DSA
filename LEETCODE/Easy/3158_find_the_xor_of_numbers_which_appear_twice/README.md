# 3158. Find the XOR of Numbers Which Appear Twice ⚙️

**Difficulty:** Easy  
**Topics:** Array, Bit Manipulation, Hash Map  
**LeetCode Link:** [3158. Find the XOR of Numbers Which Appear Twice](https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/)

---

## 🧩 Problem Statement

You are given an array `nums`, where each number in the array appears **either once or twice**.  
Return the **bitwise XOR** of all the numbers that appear twice in the array, or `0` if no number appears twice.

---

### 🔹 Example 1

**Input:**

```

nums = [1,2,1,3]

```

**Output:**

```

1

```

**Explanation:**  
The only number that appears twice is `1`.  
So, result = 1.

---

### 🔹 Example 2

**Input:**

```

nums = [1,2,3]

```

**Output:**

```

0

```

**Explanation:**  
No number appears twice, so return `0`.

---

### 🔹 Example 3

**Input:**

```

nums = [1,2,2,1]

```

**Output:**

```

3

```

**Explanation:**  
Numbers `1` and `2` appear twice.  
Result = `1 XOR 2 = 3`.

---

## ⚙️ Constraints

- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 50`
- Each number in `nums` appears **either once or twice**.

---

## 💡 Approach

### 🔸 Intuition

We need to find all numbers that appear **exactly twice** and XOR them together.

XOR properties make this simple:

- `a ^ a = 0`
- `a ^ 0 = a`
- XOR is **commutative** and **associative**

Thus, XORing all the duplicate numbers directly gives the required answer.

---

### 🔹 Steps

1. Create a frequency map using a `HashMap`.
2. For each number:
   - Increment its count.
   - When a number reaches frequency 2, XOR it into the result.
3. Return the final XOR result.

---

### 🧮 Complexity Analysis

| Complexity   | Explanation                          |
| ------------ | ------------------------------------ |
| ⏱️ **Time**  | O(n) — One pass to count frequencies |
| 💾 **Space** | O(n) — HashMap to store counts       |

---

## 🧠 Example Walkthrough

**Input:** `nums = [1, 2, 2, 1]`

| Step | num | freq | XOR result |
| ---- | --- | ---- | ---------- |
| 1    | 1   | 1    | 0          |
| 2    | 2   | 1    | 0          |
| 3    | 2   | 2    | 2          |
| 4    | 1   | 2    | 2 ^ 1 = 3  |

✅ **Output:** `3`
