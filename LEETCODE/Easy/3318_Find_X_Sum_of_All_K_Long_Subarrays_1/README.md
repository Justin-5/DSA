# 3318. Find X-Sum of All K-Long Subarrays I

## 🧩 Problem Description

You are given an array `nums` of `n` integers and two integers `k` and `x`.

The **x-sum** of an array is calculated as follows:

1. Count the occurrences of all elements in the array.
2. Keep only the top `x` most frequent elements.
   - If two elements have the same frequency, the **larger value** is considered more frequent.
3. Compute the **sum** of the resulting array.

If the array has fewer than `x` distinct elements, the **x-sum** is simply the sum of all elements.

You must return an integer array `answer` of length `n - k + 1` where `answer[i]` is the **x-sum** of the subarray `nums[i..i + k - 1]`.

---

## 🔍 Example 1

**Input**

```java
nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
```

**Output**

```java
[6,10,12]
```

**Explanation**

| Subarray      | Top 2 Most Frequent Elements | X-Sum                  |
| ------------- | ---------------------------- | ---------------------- |
| [1,1,2,2,3,4] | 1 and 2                      | 1 + 1 + 2 + 2 = 6      |
| [1,2,2,3,4,2] | 2 and 4                      | 2 + 2 + 2 + 4 = 10     |
| [2,2,3,4,2,3] | 2 and 3                      | 2 + 2 + 2 + 3 + 3 = 12 |

---

## 🔍 Example 2

**Input**

```java
nums = [3,8,7,8,7,5], k = 2, x = 2
```

**Output**

```java
[11,15,15,15,12]
```

**Explanation**
Since `k == x`, the result for each subarray is simply the sum of that subarray.

---

## ⚙️ Constraints

- `1 <= n == nums.length <= 50`
- `1 <= nums[i] <= 50`
- `1 <= x <= k <= nums.length`

---

## 💡 Approach

We iterate over all subarrays of length `k`, calculate their **x-sum**, and store each result.

### Steps:

1. For each subarray of length `k`, count occurrences using a `HashMap`.
2. Sort elements by:

   - Frequency (descending)
   - Value (descending, for ties)

3. Keep only the **top `x` elements** and compute the sum of all elements in the subarray that belong to these top `x` elements.
4. Repeat for all possible subarrays.

Since constraints are small (`n <= 50`), the brute-force approach is efficient and simple to implement.

---

## ⏱️ Complexity Analysis

| Type      | Complexity       | Explanation                                                   |
| --------- | ---------------- | ------------------------------------------------------------- |
| **Time**  | `O(n * k log k)` | Sorting the frequencies for each of the `n - k + 1` subarrays |
| **Space** | `O(k)`           | HashMap + temporary data structures per subarray              |

---

## 🧮 Example Walkthrough

**Input**

```java
nums = [1,1,2,2,3,4,2,3]
k = 6, x = 2
```

**Steps**

1. Subarray [1,1,2,2,3,4]:

   - Frequencies → {1=2, 2=2, 3=1, 4=1}
   - Top 2 → {2, 1}
   - X-Sum = 1 + 1 + 2 + 2 = 6

2. Subarray [1,2,2,3,4,2]:

   - Frequencies → {1=1, 2=3, 3=1, 4=1}
   - Top 2 → {2, 4}
   - X-Sum = 2 + 2 + 2 + 4 = 10

3. Subarray [2,2,3,4,2,3]:

   - Frequencies → {2=3, 3=2, 4=1}
   - Top 2 → {2, 3}
   - X-Sum = 2 + 2 + 2 + 3 + 3 = 12
