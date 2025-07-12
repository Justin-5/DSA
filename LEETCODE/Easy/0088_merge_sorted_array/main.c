#include <stdio.h>

// Efficient merge from the end of the arrays (O(m + n) time)
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int i = m - 1;         // Pointer for end of nums1 actual elements
    int j = n - 1;         // Pointer for end of nums2
    int k = m + n - 1;     // Pointer for the end of merged array (nums1)

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }

    // Copy remaining elements from nums2 (if any)
    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}

// Utility function to print an array
void printArray(int* arr, int size) {
    for (int i = 0; i < size; ++i)
        printf("%d ", arr[i]);
    printf("\n");
}

// Sample usage
int main() {
    int nums1[6] = {1, 2, 3, 0, 0, 0};
    int nums2[3] = {2, 5, 6};
    int m = 3, n = 3;

    printf("Before merge:\n");
    printArray(nums1, m + n);

    merge(nums1, 6, m, nums2, 3, n);

    printf("After merge:\n");
    printArray(nums1, m + n);

    return 0;
}
