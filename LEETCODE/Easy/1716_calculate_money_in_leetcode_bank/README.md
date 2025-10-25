# 1716. Calculate Money in Leetcode Bank

**Difficulty:** Easy  
**Topics:** Math, Simulation  
**LeetCode Link:** [1716. Calculate Money in Leetcode Bank](https://leetcode.com/problems/calculate-money-in-leetcode-bank/)

---

## 🧩 Problem Statement

Hercy wants to save money for his first car. He deposits money into the Leetcode bank every day.

- On the first Monday, he puts in **$1**.
- Each day from Tuesday to Sunday, he puts in **$1 more** than the previous day.
- Every subsequent Monday, he starts the week with **$1 more** than the previous Monday.

Given `n`, return the **total amount of money** he will have in the bank after `n` days.

---

## 🔹 Example 1

**Input:**

```

n = 4

```

**Output:**

```

10

```

**Explanation:**

```

Days: 1, 2, 3, 4
Deposits: 1 + 2 + 3 + 4 = 10

```

---

## 🔹 Example 2

**Input:**

```

n = 10

```

**Output:**

```

37

```

**Explanation:**

```

Week 1: 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
Week 2: 2 + 3 + 4 = 9
Total = 28 + 9 = 37

```

---

## 🔹 Example 3

**Input:**

```

n = 20

```

**Output:**

```

96

```

**Explanation:**

```

Week 1: 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
Week 2: 2 + 3 + 4 + 5 + 6 + 7 + 8 = 35
Week 3: 3 + 4 + 5 + 6 + 7 + 8 = 33
Total = 28 + 35 + 33 = 96

```

---

## ⚙️ Constraints

- `1 <= n <= 1000`

---

## 💡 Approach

We can think of this problem in **weeks**:

1. Each week starts on Monday and has 7 days.
2. The first week deposits: `1 + 2 + 3 + 4 + 5 + 6 + 7 = 28`.
3. The second week deposits: `2 + 3 + 4 + 5 + 6 + 7 + 8 = 35`.
4. Each week’s total increases by **7** from the previous week’s total.

We can split the total deposit into:

- **Full weeks** (using arithmetic progression)
- **Remaining days** (also an arithmetic progression)

### Formula Derivation:

- For full weeks:

```

week_1 = 28
week_2 = 35
week_3 = 42 ...
=> Arithmetic progression with a = 28, d = 7

```

So, sum of k weeks = `k/2 × [2a + (k-1)d]`

- For remaining days:

```

start = 1 + fullWeeks
terms = remainingDays
sum = remDays / 2 × [2 × start + (remDays - 1)]

```

Combine both sums for the result.

---

## 🧾 Code

```java
class Solution {
  public int totalMoney(int n) {
      // Number of full weeks and remaining days
      int fullWeeks = n / 7;
      int remDays = n % 7;

      // Sum of full weeks (arithmetic series)
      // First week = 28, difference = 7
      int sumOfFullWeeks = (fullWeeks * (2 * 28 + (fullWeeks - 1) * 7)) / 2;

      // Sum of remaining days after full weeks
      // Starts from (1 + fullWeeks)
      int sumOfRemDays = (remDays * (2 * (1 + fullWeeks) + (remDays - 1))) / 2;

      // Total amount in the bank
      return sumOfFullWeeks + sumOfRemDays;
  }
}
```

---

## 🧠 Alternative (Simulation)

If you prefer a simpler but less efficient approach:

```java
class Solution {
    public int totalMoney(int n) {
        int total = 0, monday = 1, day = 1;
        for (int i = 1; i <= n; i++) {
            total += day;
            day++;
            if (i % 7 == 0) {  // next Monday
                monday++;
                day = monday;
            }
        }
        return total;
    }
}
```

---

## ⏱️ Complexity Analysis

| Type      | Complexity                           |
| --------- | ------------------------------------ |
| **Time**  | O(1) — direct arithmetic computation |
| **Space** | O(1) — only a few variables          |

---

## ✅ Example Walkthrough

### Input:

```
n = 10
```

### Steps:

- `fullWeeks = 1`
- `remDays = 3`
- `sumOfFullWeeks = (1 * (2*28 + 0*7))/2 = 28`
- `sumOfRemDays = (3 * (2*(1+1) + (3-1)))/2 = (3 * (4 + 2))/2 = 9`
- `total = 28 + 9 = 37`

✅ **Output = 37**
