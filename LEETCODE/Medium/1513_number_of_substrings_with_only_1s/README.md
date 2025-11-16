# 1513. Number of Substrings With Only 1s

## 🧠 Problem Summary

Given a binary string `s`, return the number of substrings that consist only of `'1'` characters.  
Since the answer may be very large, return it modulo **1e9 + 7**.

---

## ✅ Approach

### 🔍 Key Idea

Whenever we find a continuous sequence of `'1'`s of length **k**, the number of substrings formed is:

\[
\frac{k(k+1)}{2}
\]

Example:  
For `"111"` → substrings are `"1","1","1","11","11","111"` → 6 substrings.

We iterate through the string, count lengths of consecutive `'1'`s, and sum these values.

---

## 💡 Why This Works

- A substring of all 1s must be inside a _consecutive block_ of 1s.
- We never double-count.
- Time complexity is O(n).

---

## 🧮 Complexity

- **Time:** O(n)
- **Space:** O(1)

---

## ✔ Example

Input:

```

s = "0110111"

```

Runs of `"1"`:

- `"11"` → 3 substrings
- `"1"` → 1 substring
- `"111"` → 6 substrings  
  Total = **9**

---

## 📝 Final Notes

This is the optimal solution — single pass, no extra memory, modulo handled safely.

```

```
