// Problem: 58. Length of Last Word
// Given a string `s` consisting of words and spaces,
// return the length of the last word in the string.

#include <stdio.h>
#include <string.h>
#include <ctype.h>

// Function to find the length of the last word in a string
int lengthOfLastWord(char* s) {
    int count = 0;
    int i = strlen(s) - 1;

    // Skip trailing spaces
    while (i >= 0 && isspace(s[i])) {
        i--;
    }

    // Count characters of the last word
    while (i >= 0 && isalpha(s[i])) {
        count++;
        i--;
    }

    return count;
}

int main() {
    char s[] = "   fly me   to   the moon  ";
    int result = lengthOfLastWord(s);

    printf("Length of last word: %d\n", result);  // Output should be 4

    return 0;
}
