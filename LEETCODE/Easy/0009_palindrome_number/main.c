// Problem: Palindrome Number
// Approach: Reverse the number and compare with original
// Time Complexity: O(log10 n)
// Space Complexity: O(1)

#include <stdio.h>
#include <stdbool.h>

bool isPalindrome(int x) {
    // Negative numbers are not palindromes
    if (x < 0)
        return false;

    int rev = 0;
    int i = x;

    // Reverse the digits
    while (i != 0) {
        int num = i % 10;
        rev = rev * 10 + num;
        i = i / 10;
    }

    // Check if original number is equal to its reverse
    return x == rev;
}

int main() {
    int x = 121;

    if (isPalindrome(x)) {
        printf("%d is a palindrome.\n", x);
    } else {
        printf("%d is not a palindrome.\n", x);
    }

    return 0;
}