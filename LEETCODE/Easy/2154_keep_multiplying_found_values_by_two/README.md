# 2154. Keep Multiplying Found Values by Two

## 🧠 Problem Summary

You are given:

- An integer array `nums`
- An integer `original`

You repeatedly apply the following rule:

1. If `original` exists in `nums`, update

```

original = original * 2

```

2. Otherwise, stop.

Return the **final value** of `original`.

---

## ✅ Approach

- Convert `nums` into a **HashSet** for O(1) lookup.
- Loop while `original` exists in the set:
- Multiply it by 2.
- Return the final value.

This gives optimal performance.

---

## 🧮 Complexity

- **Time:** O(n)
- **Space:** O(n)

---

## ✔ Example

Input:

```

nums = [5,3,6,1,12], original = 3

```

Process:

```

3 → 6 → 12 → 24

```

Output:

```

24

```
