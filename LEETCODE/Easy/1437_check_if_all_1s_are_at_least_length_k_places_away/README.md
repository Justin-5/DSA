# 1437. Check If All 1's Are at Least Length K Places Away

## 🧠 Problem Summary

You are given:

- A binary array `nums`
- An integer `k`

Return **true** if every pair of `1`s in the array is at least **k** zeros apart.  
Otherwise, return **false**.

Distance is measured as:

```

distance = (index₂ - index₁ - 1)

```

---

## ✅ Approach

We traverse the array and track the **most recent index of '1'**.

Steps:

1. Initialize `prev = -1` (no 1 seen yet).
2. Iterate through `nums`:
   - When a `1` is found:
     - If `prev != -1`, check:
       ```
       if (i - prev - 1 < k) → return false
       ```
     - Update `prev = i`
3. If no violations found, return `true`.

---

## 🧮 Complexity

- **Time:** O(n)
- **Space:** O(1) — constant

---

## ✔ Example

Input:

````

nums = [1,0,0,0,1,0,0,1], k = 2

```
Output:
```

true

```

All 1s are separated by at least 2 zeros.

````
