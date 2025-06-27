// Problem: Remove Element
// Approach: Two-pointer overwrite technique
// Time Complexity: O(n), Space Complexity: O(1)

#include <stdio.h>

// Function to remove all instances of `val` from `nums` in-place
int removeElement(int* nums, int numsSize, int val) {
    int j = 0;  // j tracks the index for elements not equal to `val`

    for (int i = 0; i < numsSize; i++) {
        // If current element is NOT equal to the target value, keep it
        if (nums[i] != val) {
            nums[j] = nums[i];  // Move element to the correct position
            j++;                // Increment count of valid elements
        }
    }

    return j;  // Return new length of the modified array
}

// Utility function to print the array up to length k
void printArray(int* nums, int k) {
    for (int i = 0; i < k; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}

// Driver code to test removeElement
int main() {
    int nums[] = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    int size = sizeof(nums) / sizeof(nums[0]);

    int k = removeElement(nums, size, val);

    printf("New length after removing %d = %d\n", val, k);
    printf("Array after removal: ");
    printArray(nums, k);

    return 0;
}
