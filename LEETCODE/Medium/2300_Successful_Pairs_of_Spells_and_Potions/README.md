## 2300. Successful Pairs of Spells and Potions

### 🧩 Problem

You are given two arrays:

- `spells[i]`: strength of the ith spell
- `potions[j]`: strength of the jth potion
  and an integer `success`.

A **pair (spell, potion)** is _successful_ if:

```
spell[i] * potion[j] >= success
```

You must return an array `pairs[]`, where each `pairs[i]` represents
the number of potions that form a successful pair with spell `i`.

---

### 💡 Example 1

**Input**

```
spells = [5, 1, 3]
potions = [1, 2, 3, 4, 5]
success = 7
```

**Output**

```
[4, 0, 3]
```

**Explanation**

- Spell `5`: [5,10,15,20,25] → 4 ≥ success
- Spell `1`: [1,2,3,4,5] → 0 ≥ success
- Spell `3`: [3,6,9,12,15] → 3 ≥ success

---

### 🧠 Approach

1. **Sort potions** → allows binary search for each spell.
2. For each spell:

   - Use **binary search** to find the **first potion** where
     `spell[i] * potion[j] >= success`.
   - All potions from that index onward form successful pairs.

3. Calculate count as:

   ```
   count = totalPotions - indexFound
   ```

---

### 🧮 Example Walkthrough

```
spells = [5,1,3]
potions = [1,2,3,4,5]
success = 7
```

**Sorted potions:** [1,2,3,4,5]

- Spell = 5 → binary search → first potion index = 1 → 5\*2=10≥7
  ✅ Successful pairs = 5 - 1 = 4
- Spell = 1 → none satisfy → 0
- Spell = 3 → first potion index = 2 → 3\*3=9≥7
  ✅ Successful pairs = 5 - 2 = 3

**Result:** `[4, 0, 3]`

---

### ⏱️ Time & Space Complexity

| Operation                    | Complexity                  |
| ---------------------------- | --------------------------- |
| Sorting potions              | O(m log m)                  |
| Binary search for each spell | O(n log m)                  |
| **Total**                    | **O((n + m) log m)**        |
| **Space**                    | **O(1)** (excluding output) |
