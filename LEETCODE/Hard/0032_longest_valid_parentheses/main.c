#include <stdio.h>

// Function to return the length of the longest valid parentheses substring
int longestValidParentheses(char* s) {
    int count = 0, maxcount = 0;
    
    if (s[0] == '\0') return 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int open = 0, close = 0;

        for (int j = i; s[j] != '\0'; j++) {
            if (s[j] == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                count = close * 2;
                if (maxcount < count) {
                    maxcount = count;
                }
            } else if (close > open) {
                break;
            }
        }
    }
    return maxcount;
}

// Driver code
int main() {
    char s1[] = "(()";
    char s2[] = ")()())";
    char s3[] = "";

    printf("Input: \"%s\" → Output: %d\n", s1, longestValidParentheses(s1));
    printf("Input: \"%s\" → Output: %d\n", s2, longestValidParentheses(s2));
    printf("Input: \"%s\" → Output: %d\n", s3, longestValidParentheses(s3));

    return 0;
}
