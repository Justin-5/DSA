#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Backtracking helper function
void backtrack(char *cur, int pos, int open, int close, int n, char **result, int *count) {
    if (open == n && close == n) {
        cur[pos] = '\0';
        result[*count] = strdup(cur); // store a copy of cur
        (*count)++;
        return;
    } else if (open < n) {
        cur[pos] = '(';
        backtrack(cur, pos + 1, open + 1, close, n, result, count);
    }
    if (close < open) {
        cur[pos] = ')';
        backtrack(cur, pos + 1, open, close + 1, n, result, count);
    }
}

// Main function to generate parentheses
char** generateParenthesis(int n, int* returnSize) {
    int open = 0, close = 0, pos = 0, count = 0;
    if (n == 0)
        return NULL;
    char *cur = (char *)malloc(sizeof(char) * ((2 * n) + 1));
    char **result = (char **)malloc(sizeof(char*) * 5000); // Over-allocate space
    backtrack(cur, pos, open, close, n, result, &count);
    *returnSize = count;
    free(cur);
    return result;
}

// Helper function to print result array
void printResult(char **result, int size) {
    printf("[");
    for (int i = 0; i < size; i++) {
        printf("\"%s\"", result[i]);
        if (i != size - 1)
            printf(",");
    }
    printf("]\n");
}

// Driver code
int main() {
    int n = 3;
    int returnSize;
    char **result = generateParenthesis(n, &returnSize);
    printf("Generated parentheses for n = %d:\n", n);
    printResult(result, returnSize);

    // Free memory
    for (int i = 0; i < returnSize; i++) {
        free(result[i]);
    }
    free(result);

    return 0;
}
