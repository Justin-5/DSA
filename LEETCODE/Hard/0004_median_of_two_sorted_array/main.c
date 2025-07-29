#include <stdio.h>
#include <stdlib.h>

// Function to find the median of two sorted arrays
double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int i = 0, j = 0, k = 0;
    int m = (nums1Size + nums2Size) / 2;
    double* merge = (double*)malloc(sizeof(double) * (nums1Size + nums2Size));

    while (i < nums1Size && j < nums2Size) {
        if (nums1[i] < nums2[j]) {
            merge[k] = nums1[i];
            i++;
            k++;
        } else {
            merge[k] = nums2[j];
            j++;
            k++;
        }
    }

    while (i < nums1Size) {
        merge[k] = nums1[i];
        i++;
        k++;
    }

    while (j < nums2Size) {
        merge[k] = nums2[j];
        j++;
        k++;
    }

    double median;
    if ((nums1Size + nums2Size) % 2 != 0) {
        median = merge[m];
    } else {
        median = (merge[m - 1] + merge[m]) / 2;
    }

    free(merge);
    return median;
}

// Driver code
int main() {
    int nums1[] = {1, 3};
    int nums2[] = {2};
    int size1 = sizeof(nums1) / sizeof(nums1[0]);
    int size2 = sizeof(nums2) / sizeof(nums2[0]);

    double median = findMedianSortedArrays(nums1, size1, nums2, size2);
    printf("Median: %.5f\n", median);
    return 0;
}
