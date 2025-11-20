# 717. 1-bit and 2-bit Characters

## 🧠 Problem Summary

You are given a binary array `bits` where:

- `0` represents a **1-bit character**
- `10` or `11` represents a **2-bit character**

The array **always ends with 0**.

You must determine whether the **last character is a 1-bit character**.

---

## ✅ Approach

We simulate the decoding process:

- If the current bit is `1`, it's a **2-bit** character → skip next bit (`i += 2`)
- If it's `0`, it's a **1-bit** character → move one step (`i += 1`)

We track whether the **last decoded character** is a 1-bit character.

The array ends with `0`, so simply track whether the last processed character was a single bit.

---

## 🧮 Complexity

- **Time:** O(n)
- **Space:** O(1)

---

## ✔ Example

Input:

```

bits = [1,0,0]

```

Decoding:

```

10 → 2-bit
0 → 1-bit (last)

```

Output:

```

true

```

The last character is a 1-bit character.
