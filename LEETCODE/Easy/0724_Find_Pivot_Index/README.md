# LeetCode 724. Find Pivot Index

## Problem Description

Given an array of integers `nums`, calculate the **pivot index** of this array.

The **pivot index** is the index where the sum of all the numbers **strictly to the left** of the index is equal to the sum of all the numbers **strictly to the right** of the index.

- If the index is on the left edge of the array, then the left sum is `0` because there are no elements to the left.
- If the index is on the right edge of the array, then the right sum is `0` because there are no elements to the right.
- You must return the **leftmost** pivot index.
- If no such index exists, return `-1`.

### Examples

#### Example 1

**Input:**

nums = [1,7,3,6,5,6]

````

**Output:**


3
```

**Explanation:**

* Left sum at index 3 = `nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11`
* Right sum at index 3 = `nums[4] + nums[5] = 5 + 6 = 11`

Since left sum equals right sum, index `3` is the pivot index.

---

#### Example 2

**Input:**


nums = [1,2,3]
```

**Output:**


-1
```

**Explanation:**

There is no index where the left sum equals the right sum, so the answer is `-1`.

---

#### Example 3

**Input:**


nums = [2,1,-1]
```

**Output:**



**Explanation:**

* Left sum at index 0 = `0` (no elements to the left)
* Right sum at index 0 = `nums[1] + nums[2] = 1 + -1 = 0`

So index `0` is the pivot index.

---

### Constraints

* `1 <= nums.length <= 10^4`
* `-1000 <= nums[i] <= 1000`

---

## Approach

### Idea

We want to find an index `i` such that:


sum of elements to the left of i == sum of elements to the right of i
```

Instead of recomputing left and right sums for every index (which would be O(n²)), we can do this efficiently in **O(n)** using prefix-style logic:

1. **Compute the total sum** of the array (`total`).

2. Maintain a running **left sum** (`left`) as we iterate through the array.

3. For each index `i`:

   * The current element is `nums[i]`.
   * The **right sum** can be computed as:


     right = total - left - nums[i]
     ```

     because:

     * `total` is sum of all elements,
     * subtract `left` (sum of elements before `i`),
     * subtract `nums[i]` (current element),
     * what remains is the sum of elements after `i`.
   * If `left == right`, then `i` is the pivot index, so we return `i`.
   * Otherwise, add `nums[i]` to `left` and continue.

4. If we finish the loop without finding any pivot index, return `-1`.

### Why This Works

By using the total sum and a running left sum, we avoid recomputing sums for each index. This keeps the time complexity linear and uses only a few extra variables for bookkeeping.

### Complexity

* **Time Complexity:** `O(n)` — We traverse the array twice: once to compute the total sum, and once to find the pivot index.
* **Space Complexity:** `O(1)` — We only use a few integer variables (`total`, `left`, `right`).

````
