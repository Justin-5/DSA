# 31. Next Permutation

## 🧩 Problem Description

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

The **next permutation** of an array is the next lexicographically greater permutation of its integers.  
If such an arrangement is not possible, rearrange it as the **lowest possible order** (ascending order).

The replacement must be **in-place** and use only **constant extra memory**.

---

### 🔍 Examples

#### Example 1:

**Input:**

```

nums = [1,2,3]

```

**Output:**

```

[1,3,2]

```

#### Example 2:

**Input:**

```

nums = [3,2,1]

```

**Output:**

```

[1,2,3]

```

#### Example 3:

**Input:**

```

nums = [1,1,5]

```

**Output:**

```

[1,5,1]

```

---

### ⚙️ Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 100`

---

## 💡 Approach

1. **Identify the first decreasing element from the right**  
   Traverse from the end of the array to find the first element that breaks the descending order.  
   This index is called the **pivot**.

2. **Find the next greater element to the pivot**  
   Again traverse from the end and find the smallest element that is greater than the pivot.

3. **Swap them**  
   Swap the pivot and the next greater element.

4. **Reverse the suffix**  
   Reverse all elements to the right of the pivot to get the smallest lexicographic order.

If the array is in descending order (no pivot found), just sort it in ascending order.

---

### ⏱️ Time Complexity

- **O(N)** – one pass to find the pivot, one to swap, one to reverse.

### 💾 Space Complexity

- **O(1)** – in-place operation.

---

## ✅ Code (Java)

See [`Solution.java`](./Solution.java) for a fully-commented implementation.

````

---

### 💻 Solution.java

```java
import java.util.Arrays;

/**
 * 31. Next Permutation
 *
 * The goal is to rearrange the array into the next lexicographically greater permutation.
 * If no such permutation exists (i.e., the array is in descending order),
 * we rearrange it to the smallest possible order (ascending).
 */
class Solution {

    // Helper function to swap two elements
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse a subarray
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first decreasing element from the right
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot found, array is in descending order -> sort ascending
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the next greater element to the right of the pivot
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // Step 3: Reverse the suffix (right side of pivot)
        reverse(nums, pivot + 1, n - 1);
    }
}

/*
Example walkthrough:
Input: [1,2,3]
1. Pivot = 1 (nums[1] < nums[2])
2. Next greater element = 3
3. Swap -> [1,3,2]
4. Reverse suffix (only 2 remains)
Output: [1,3,2]
*/
````
