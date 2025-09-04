# 🏃 3516. Find Closest Person

### 📌 Problem

You are given three integers `x`, `y`, and `z` representing positions of three people on a number line:

- `x` → Person 1
- `y` → Person 2
- `z` → Person 3 (fixed)

Both Person 1 and Person 2 move toward Person 3 at the same speed.

👉 Return:

- `1` if Person 1 arrives first
- `2` if Person 2 arrives first
- `0` if both arrive at the same time

🔗 [Problem Link](https://leetcode.com/problems/find-closest-person/)

---

### 💡 Examples

**Example 1**  
Input:

```text
x = 2, y = 7, z = 4
```

Output:

```text
1
```

Explanation: Person1 → distance = 2, Person2 → distance = 3.
Person1 is closer → result = 1.

---

**Example 2**
Input:

```text
x = 2, y = 5, z = 6
```

Output:

```text
2
```

Explanation: Person1 → distance = 4, Person2 → distance = 1.
Person2 is closer → result = 2.

---

**Example 3**
Input:

```text
x = 1, y = 5, z = 3
```

Output:

```text
0
```

Explanation: Person1 → distance = 2, Person2 → distance = 2.
Both reach at the same time → result = 0.

---

### ⚙️ Approach

1. Compute distances:

   - `p1Distance = |z - x|`
   - `p2Distance = |z - y|`

2. Compare distances:

   - If `p1Distance < p2Distance` → return 1
   - If `p1Distance > p2Distance` → return 2
   - Else → return 0

---

### 🛠️ Complexity

- **Time:** `O(1)`
- **Space:** `O(1)`

---

### 🧑‍💻 Code

See [FindClosestPerson.java](./FindClosestPerson.java) for the full implementation.
