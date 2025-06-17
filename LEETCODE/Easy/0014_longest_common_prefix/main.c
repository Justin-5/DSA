// Problem: Longest Common Prefix
// Approach:
// 1. Sort the array of strings.
// 2. Compare the first and last strings in the sorted array character by character.
// 3. The common characters from the beginning of both strings will be the longest common prefix.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Comparator function used by qsort to sort the strings lexicographically
int compare(const void *a, const void *b) {
    return strcmp(*(const char**)a, *(const char**)b);
}

// Function to find the longest common prefix among the given array of strings
char* longestCommonPrefix(char** strs, int strsSize) {
    // If the array is empty, return an empty string
    if (strsSize == 0) return "";

    // If the array contains only one string, return it as the prefix
    if (strsSize == 1) return strs[0];

    // Step 1: Sort the array of strings lexicographically
    qsort(strs, strsSize, sizeof(char*), compare);

    // Step 2: Compare the first and last strings in the sorted array
    // The common prefix between these two will be the answer
    int len = strlen(strs[0]); // length of the shortest string (after sort)
    char *ans = (char *)malloc((len + 1) * sizeof(char)); // allocate memory for the result
    int i = 0;

    // Compare characters of first and last strings until they match
    while (strs[0][i] == strs[strsSize - 1][i] &&
           strs[0][i] != '\0' && strs[strsSize - 1][i] != '\0') {
        ans[i] = strs[0][i]; // copy matching characters
        i++;
    }

    ans[i] = '\0'; // null-terminate the resulting prefix string
    return ans;
}

int main() {
    // Sample input: array of strings
    char *words[] = {"flower", "flow", "flight"};
    int size = sizeof(words) / sizeof(words[0]); // calculate number of strings

    // Find the longest common prefix
    char *prefix = longestCommonPrefix(words, size);

    // Print the result
    printf("Longest Common Prefix: \"%s\"\n", prefix);

    // Free dynamically allocated memory
    free(prefix);

    return 0;
}