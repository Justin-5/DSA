#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Multiply two numeric strings without using BigInteger or converting to integers
char* multiply(char* num1, char* num2) {
    if (num1[0] == '0' || num2[0] == '0')  
        return strdup("0");

    int m = strlen(num1);
    int n = strlen(num2);
    int result[m + n];
    memset(result, 0, sizeof(result));

    for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            int mul = (num1[i] - '0') * (num2[j] - '0');
            mul = result[i + j + 1] + mul;
            if (mul > 9) {
                result[i + j + 1] = mul % 10;
                mul = mul / 10;
                result[i + j] = result[i + j] + mul;
            } else {
                result[i + j + 1] = mul;
            }
        }
    }

    char* multi = (char*)malloc(m + n + 1);
    int i = 0;
    int k = 0;

    // Skip leading zeros
    while (i < m + n && result[i] == 0) {
        i++;
    }

    // Build string
    while (i < m + n) {
        multi[k++] = result[i++] + '0';
    }

    multi[k] = '\0';
    return multi;
}

// Driver code to test the multiply function
int main() {
    char num1[] = "123";
    char num2[] = "456";
    char* result = multiply(num1, num2);
    printf("Product of %s and %s is %s\n", num1, num2, result);
    free(result);
    return 0;
}
