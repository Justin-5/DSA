# 12. Integer to Roman 🏛️

**Difficulty:** Medium  
**Topics:** String, Math, Hash Map  
**LeetCode Link:** [12. Integer to Roman](https://leetcode.com/problems/integer-to-roman/)

---

## 🧩 Problem Statement

Seven different symbols represent Roman numerals with the following values:

| Symbol | Value |
| :----: | :---: |
|   I    |   1   |
|   V    |   5   |
|   X    |  10   |
|   L    |  50   |
|   C    |  100  |
|   D    |  500  |
|   M    | 1000  |

---

### Roman numeral construction rules:

1. **Normal addition rule** — Symbols are added from highest to lowest:  
   `III = 3`, `VIII = 8`, `XXVII = 27`

2. **Subtractive notation** — Used for 4s and 9s:

   - `4 = IV`
   - `9 = IX`
   - `40 = XL`
   - `90 = XC`
   - `400 = CD`
   - `900 = CM`

3. Only powers of 10 (`I`, `X`, `C`, `M`) can repeat up to 3 times.

---

### 🔹 Example 1

**Input:**

```

num = 3749

```

**Output:**

```

"MMMDCCXLIX"

```

**Explanation:**

```

3000 = MMM
700 = DCC
40 = XL
9 = IX

```

---

### 🔹 Example 2

**Input:**

```

num = 58

```

**Output:**

```

"LVIII"

```

**Explanation:**

```

50 = L
8 = VIII

```

---

### 🔹 Example 3

**Input:**

```

num = 1994

```

**Output:**

```

"MCMXCIV"

```

**Explanation:**

```

1000 = M
900 = CM
90 = XC
4 = IV

```

---

## ⚙️ Constraints

- `1 <= num <= 3999`

---

## 💡 Approach

### 🔸 Intuition

We can represent all Roman numeral symbols and their values, including the **subtractive forms** (like `IV`, `IX`, `XL`, `XC`, `CD`, `CM`).  
Starting from the largest value, we append the corresponding Roman symbol and reduce the number until it becomes zero.

---

### 🔹 Steps

1. Create a map of **Roman values** for both normal and subtractive forms.
2. Create an array of Roman numeral values in **descending order**.
3. Iterate through these values:
   - If `num` is greater than or equal to the current value, append its Roman symbol and subtract that value.
4. Continue until `num == 0`.

---

### 🧮 Complexity Analysis

| Complexity   | Explanation                                                      |
| ------------ | ---------------------------------------------------------------- |
| ⏱️ **Time**  | O(1) — Constant time since Roman numerals are limited up to 3999 |
| 💾 **Space** | O(1) — Uses a fixed map and array                                |

---

## 🧠 Example Walkthrough

**Input:** `num = 1994`

| Step | Value Used | Symbol | Remaining | Result    |
| ---- | ---------- | ------ | --------- | --------- |
| 1    | 1000       | M      | 994       | "M"       |
| 2    | 900        | CM     | 94        | "MCM"     |
| 3    | 90         | XC     | 4         | "MCMXC"   |
| 4    | 4          | IV     | 0         | "MCMXCIV" |

✅ **Output:** `"MCMXCIV"`
