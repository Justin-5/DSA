# 3074. Apple Redistribution into Boxes

## 🧠 Problem Description

You are given two integer arrays:

- `apple[i]` → number of apples in the `i`-th pack
- `capacity[j]` → maximum number of apples the `j`-th box can hold

You must select a **minimum number of boxes** such that all apples from all packs can be redistributed into the selected boxes.

### Important Notes

- Apples from the **same pack can be split across multiple boxes**
- Each box can be used **at most once**
- The input guarantees that redistribution is always possible

---

## 📌 Examples

### Example 1

```

Input:
apple    = [1, 3, 2]
capacity = [4, 3, 1, 5, 2]

Output: 2

```

Explanation:

- Total apples = `6`
- Using boxes with capacities `5` and `4` gives total capacity `9 ≥ 6`

---

### Example 2

```

Input:
apple    = [5, 5, 5]
capacity = [2, 4, 2, 7]

Output: 4

```

Explanation:

- Total apples = `15`
- All boxes are required to store all apples

---

## 📋 Constraints

- `1 <= n == apple.length <= 50`
- `1 <= m == capacity.length <= 50`
- `1 <= apple[i], capacity[i] <= 50`
- Redistribution is always possible

---

## 💡 Solution Approach (Greedy)

### Key Insight

Since apples can be split across boxes, the **only thing that matters** is:

```

Total capacity ≥ total apples

```

To minimize the number of boxes:

- Always pick the **largest capacity boxes first**

---

### 🧩 Algorithm Steps

1. Compute the total number of apples
2. Sort the `capacity` array in ascending order
3. Iterate from the **largest capacity to smallest**
4. Keep adding capacities until total capacity ≥ total apples
5. Count how many boxes were used

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(m log m)** due to sorting

### Space Complexity

- **O(1)** (sorting in place, constant extra variables)

---

## 🧪 Edge Cases Covered

- Single apple pack
- Single box
- All boxes needed
- Large capacity boxes dominating small ones
