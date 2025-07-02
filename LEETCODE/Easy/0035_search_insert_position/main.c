// Problem: 35. Search Insert Position
// Approach: Linear search with insertion point detection
// Time Complexity: O(n) — Note: Binary Search is better for O(log n)

#include <stdio.h>

// Function to find the index or insertion position of target
int searchInsert(int* nums, int numsSize, int target) {
    int k = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == target)
            return i; // Found target, return its index
        else if (nums[i] < target && (i == numsSize - 1 || nums[i + 1] > target))
            k = i + 1; // Target fits between nums[i] and nums[i+1]
    }
    return k; // Return insertion position
}

int main() {
    int nums[] = {1, 3, 5, 6};
    int target = 5;
    int size = sizeof(nums) / sizeof(nums[0]);

    int index = searchInsert(nums, size, target);

    printf("Target %d should be at index %d\n", target, index);

    return 0;
}
