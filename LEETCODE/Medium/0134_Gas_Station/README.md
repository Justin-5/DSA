# 134. Gas Station

## 🧩 Problem Description

There are `n` gas stations along a circular route, where the amount of gas at the `i-th` station is given by `gas[i]`.  
You have a car with an unlimited gas tank, and it costs `cost[i]` units of gas to travel from station `i` to `(i + 1)`.

You begin the journey with an empty tank at one of the gas stations.

Return the **starting gas station's index** if you can travel around the circuit once in a clockwise direction, otherwise return `-1`.  
It is guaranteed that if a solution exists, it will be **unique**.

---

## 🧠 Example 1

**Input:**

```

gas = [1,2,3,4,5]
cost = [3,4,5,1,2]

```

**Output:**

```

3

```

**Explanation:**
Start at station 3 (index 3):

```

Tank = 0 + 4 = 4
→ Travel to 4: Tank = 4 - 1 + 5 = 8
→ Travel to 0: Tank = 8 - 2 + 1 = 7
→ Travel to 1: Tank = 7 - 3 + 2 = 6
→ Travel to 2: Tank = 6 - 4 + 3 = 5
→ Travel to 3: Tank = 5 - 5 = 0

```

Return **3** as the starting index.

---

## 🧠 Example 2

**Input:**

```

gas = [2,3,4]
cost = [3,4,3]

```

**Output:**

```

-1

```

**Explanation:**
No valid starting point exists — from any station, the car runs out of gas before completing the loop.

---

## ⚙️ Constraints

- `n == gas.length == cost.length`
- `1 <= n <= 10^5`
- `0 <= gas[i], cost[i] <= 10^4`
- The input guarantees that the answer is unique.

---

## 💡 Approach

1. **Check Total Feasibility:**  
   If total gas < total cost, it's impossible to complete the circuit → return `-1`.

2. **Find Start Station:**  
   Traverse through stations and keep a running `curTank` (current fuel).

   - If at any station `curTank` becomes negative, that means we cannot start from any of the previous stations.
   - Reset `curTank` to `0` and set the next station as the new `startIndex`.

3. The final `startIndex` will be the valid starting gas station.

---

## 🧮 Example Walkthrough

For `gas = [1,2,3,4,5]` and `cost = [3,4,5,1,2]`:

| i   | gas[i] | cost[i] | netGain | curTank    | startIndex |
| --- | ------ | ------- | ------- | ---------- | ---------- |
| 0   | 1      | 3       | -2      | -2 → reset | 1          |
| 1   | 2      | 4       | -2      | -2 → reset | 2          |
| 2   | 3      | 5       | -2      | -2 → reset | 3          |
| 3   | 4      | 1       | +3      | 3          | 3          |
| 4   | 5      | 2       | +3      | 6          | 3          |

Return `3`.

## 🧪 Complexity Analysis

| Metric    | Complexity                  |
| --------- | --------------------------- |
| **Time**  | O(n) — single pass          |
| **Space** | O(1) — constant extra space |

---

## 🏁 Summary

✅ Linear time solution
✅ Constant space
✅ Greedy strategy ensures minimal resets
✅ Guaranteed unique answer

````

---

### 💻 `Solution.java`

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        // Check if overall fuel is enough
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }

        int curTank = 0;
        int startIndex = 0;

        // Find the valid start station
        for (int i = 0; i < gas.length; i++) {
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                startIndex = i + 1;
                curTank = 0;
            }
        }
        return startIndex;
    }
}
````
