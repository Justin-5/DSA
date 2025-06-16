// Problem: Two Sum
// Approach: Brute-force nested loops
// Time Complexity: O(n^2)
// Space Complexity: O(1) (excluding output array)

#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    // Allocate memory for the result
    int* result = (int*)malloc(2 * sizeof(int));

    // Brute-force search through all pairs
    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                *returnSize = 2;
                return result;  // Return immediately when pair is found
            }
        }
    }

    // If no pair is found (though problem guarantees one), return NULL
    *returnSize = 0;
    return NULL;
}

// Sample usage
int main() {
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    int returnSize;

    int* indices = twoSum(nums, 4, target, &returnSize);

    if (indices != NULL && returnSize == 2) {
        printf("Indices: [%d, %d]\n", indices[0], indices[1]);
        free(indices);  // Don't forget to free the allocated memory
    } else {
        printf("No solution found.\n");
    }

    return 0;
}
