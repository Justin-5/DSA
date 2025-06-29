// Problem: Find the Index of the First Occurrence in a String (Leetcode 28)
// Approach: Brute-force substring match
// Time Complexity: O(n * m), where n is length of haystack and m is length of needle

#include <stdio.h>
#include <string.h>

// Function to find the first occurrence of `needle` in `haystack`
int strStr(char* haystack, char* needle) {
    // Iterate through each character of haystack
    for (int i = 0; haystack[i] != '\0'; i++) {
        int j = 0;
        // Check if needle matches starting from haystack[i]
        while (haystack[i + j] != '\0' && needle[j] != '\0' && haystack[i + j] == needle[j]) {
            j++;
        }

        // If we reached the end of needle, match is found
        if (needle[j] == '\0') {
            return i;
        }
    }

    // No match found
    return -1;
}

// Driver code to test strStr
int main() {
    char haystack[] = "sadbutsad";
    char needle[] = "sad";

    int index = strStr(haystack, needle);

    if (index != -1)
        printf("First occurrence of \"%s\" in \"%s\" is at index %d\n", needle, haystack, index);
    else
        printf("\"%s\" not found in \"%s\"\n", needle, haystack);

    return 0;
}
