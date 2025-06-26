// Problem: Remove Duplicates from Sorted Array
// Approach: Use two-pointer technique to overwrite duplicates in-place
// Time Complexity: O(n), Space Complexity: O(1)

#include <stdio.h>

// Function to remove duplicates in-place
int removeDuplicates(int* nums, int numsSize) {
    // If the array has only one element, it's already unique
    if (numsSize == 0) return 0;

    int k = 1;  // `k` keeps track of the position of the next unique element
    for (int i = 1; i < numsSize; i++) {
        // If current element is different from the previous unique one
        if (nums[i] != nums[i - 1]) {
            nums[k] = nums[i];  // Move unique element to its correct position
            k++;                // Increment count of unique elements
        }
    }
    return k;  // Return the count of unique elements
}

// Function to print the first k elements of the array
void printArray(int* nums, int k) {
    for (int i = 0; i < k; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}

// Sample driver code
int main() {
    int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int size = sizeof(nums) / sizeof(nums[0]);

    int k = removeDuplicates(nums, size);

    printf("After removing duplicates, new length = %d\n", k);
    printf("Array with unique elements: ");
    printArray(nums, k);

    return 0;
}
