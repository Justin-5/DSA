// Problem: 69. Sqrt(x)
// Given a non-negative integer x, return the square root of x
// rounded down to the nearest integer, without using built-in sqrt/pow functions.

#include <stdio.h>

// Function to compute the floor of the square root of x
int mySqrt(int x) {
    int low = 1, high = x, mid, sqr = 0;

    // Handle base cases
    if (x < 0)
        return 0;
    else if (x == 0 || x == 1)
        return x;

    // Binary search between 1 and x
    while (low <= high) {
        mid = low + (high - low) / 2;

        if (mid == x / mid) {
            // Found perfect square
            return mid;
        } else if (mid < x / mid) {
            // mid^2 < x → move right
            low = mid + 1;
            sqr = mid;  // Update potential answer
        } else {
            // mid^2 > x → move left
            high = mid - 1;
        }
    }

    return sqr;
}

int main() {
    int x = 8;
    printf("Square root of %d is: %d\n", x, mySqrt(x));  // Output should be 2
    return 0;
}
