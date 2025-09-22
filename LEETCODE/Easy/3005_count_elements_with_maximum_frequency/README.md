# 3005. Count Elements With Maximum Frequency

## Problem Statement

You are given an array `nums` consisting of positive integers.

Return the **total frequencies** of all elements in `nums` that appear with the **maximum frequency**.

- The frequency of an element is the number of times it occurs in the array.

---

## Examples

### Example 1

```

Input: nums = \[1,2,2,3,1,4]
Output: 4

```

- Frequencies:
  - `1 → 2 times`
  - `2 → 2 times`
  - `3 → 1 time`
  - `4 → 1 time`
- Maximum frequency = **2** (for `1` and `2`).
- Total = `2 (for 1) + 2 (for 2) = 4`.

---

### Example 2

```

Input: nums = \[1,2,3,4,5]
Output: 5

```

- All numbers appear once.
- Maximum frequency = **1**.
- Total = `1 + 1 + 1 + 1 + 1 = 5`.

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`

---

## Approach

### Idea

1. Count the **frequency of each element** using a hashmap.
2. Track the **maximum frequency** while iterating.
3. Once frequencies are known:
   - Sum up the frequencies of all elements that have the maximum frequency.

### Steps

1. Iterate through `nums` and build a `Map<Integer, Integer>` (frequency map).
2. Track:
   - `maxFreq` = largest frequency so far.
   - `maxCount` = total count of elements with frequency `maxFreq`.
3. Update values while processing each element.
4. Return `maxCount`.

---

## Complexity

- **Time Complexity:** `O(n)`  
  We traverse the array once and update the hashmap.
- **Space Complexity:** `O(k)`  
  Where `k` is the number of distinct elements (`≤ 100`).
