# 2125. Number of Laser Beams in a Bank

## 🧩 Problem Description

A bank is represented as a binary matrix where:

- `'0'` represents an empty space.
- `'1'` represents a security device.

Each row of the matrix is given as a string in the array `bank`.

A **laser beam** exists between two devices if:

1. They are on different rows `r1` and `r2` (`r1 < r2`).
2. All rows between them have **no devices** (i.e., rows between `r1` and `r2` are all zeros).

You need to calculate the **total number of laser beams** in the bank.

---

## 🧠 Example 1

**Input:**

```

bank = ["011001","000000","010100","001000"]

```

**Output:**

```

8

```

**Explanation:**
Each device on a row with devices connects with **all devices** on the next non-empty row:

- Row 0 has 3 devices (`[1, 2, 5]`).
- Row 2 has 2 devices (`[1, 3]`).
- Row 3 has 1 device (`[2]`).

Connections:

- Between row 0 and 2 → `3 * 2 = 6`
- Between row 2 and 3 → `2 * 1 = 2`

Total beams = **6 + 2 = 8**.

---

## 🧠 Example 2

**Input:**

```

bank = ["000","111","000"]

```

**Output:**

```

0

```

**Explanation:**
There is only one row with devices, so no laser beams can exist.

---

## ⚙️ Constraints

- `1 <= m, n <= 500`
- `bank[i][j]` is either `'0'` or `'1'`

---

## 💡 Approach

1. **Count Devices Per Row:**  
   For each row, count how many `'1'`s it contains.

2. **Compute Beam Connections:**

   - Keep track of the number of devices in the **previous non-empty row**.
   - For each new row with devices, multiply its device count with the previous row’s count and add to total.
   - Update the previous row’s count.

3. **Skip Empty Rows:**  
   Rows with 0 devices do not contribute to any beam connections.

---

## 🧮 Example Walkthrough

For `bank = ["011001","000000","010100","001000"]`:

| Row | String | Devices | Calculation | Total |
| --- | ------ | ------- | ----------- | ----- |
| 0   | 011001 | 3       | —           | —     |
| 1   | 000000 | 0       | skip        | —     |
| 2   | 010100 | 2       | 3 × 2 = 6   | 6     |
| 3   | 001000 | 1       | 2 × 1 = 2   | 8     |

**Final Result → 8**

---

## 🧾 Code Implementation

```java
class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int[] deviceCount = new int[m];

        // Step 1: Count number of '1's in each row
        for (int i = 0; i < m; i++) {
            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    deviceCount[i]++;
                }
            }
        }

        int totalBeams = 0;
        int prevDevices = 0;

        // Step 2: Calculate laser beams between non-empty rows
        for (int i = 0; i < m; i++) {
            if (deviceCount[i] == 0) continue; // skip empty rows
            totalBeams += prevDevices * deviceCount[i];
            prevDevices = deviceCount[i];
        }

        return totalBeams;
    }
}
```

---

## 🧪 Complexity Analysis

| Metric    | Complexity                        |
| --------- | --------------------------------- |
| **Time**  | O(m × n) — each cell checked once |
| **Space** | O(m) — to store device counts     |

---

## 🏁 Summary

✅ Counts devices row-wise
✅ Efficient one-pass connection logic
✅ Handles sparse and dense grids easily
✅ Linear time and space complexity
