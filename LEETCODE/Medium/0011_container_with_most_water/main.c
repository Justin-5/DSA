#include <stdio.h>

// Function to return the maximum water a container can store
int maxArea(int* height, int heightSize) {
    int maxarea = 0;
    int area = 0;
    int i = 0;
    int j = heightSize - 1;

    while (i < j) {
        int h = height[i] < height[j] ? height[i] : height[j];
        area = (j - i) * h;
        if (area > maxarea)
            maxarea = area;

        if (height[i] == h) {
            i++;
        } else {
            j--;
        }
    }

    return maxarea;
}

// Driver code to test the function
int main() {
    int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int size = sizeof(height) / sizeof(height[0]);

    int result = maxArea(height, size);
    printf("Maximum water the container can store: %d\n", result); // Output: 49

    return 0;
}
