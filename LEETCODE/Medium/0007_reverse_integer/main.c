#include <stdio.h>
#include <limits.h>

// Function to reverse digits of a 32-bit signed integer
int reverse(int x) {
    int digit = 0;
    long rev = 0;

    while (x != 0) {
        digit = x % 10;
        rev = rev * 10 + digit;
        x /= 10;
    }

    if (rev > INT_MAX || rev < INT_MIN)
        return 0;

    return (int)rev;
}

// Driver code
int main() {
    int x1 = 123;
    int x2 = -123;
    int x3 = 120;
    int x4 = 1534236469; // Will overflow

    printf("Input: %d => Output: %d\n", x1, reverse(x1)); // 321
    printf("Input: %d => Output: %d\n", x2, reverse(x2)); // -321
    printf("Input: %d => Output: %d\n", x3, reverse(x3)); // 21
    printf("Input: %d => Output: %d\n", x4, reverse(x4)); // 0 (overflow)

    return 0;
}
