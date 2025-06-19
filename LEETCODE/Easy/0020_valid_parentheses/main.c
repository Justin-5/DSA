// Problem: Valid Parentheses
// Approach: Use a stack to match opening and closing brackets
// Time Complexity: O(n)
// Space Complexity: O(n)

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

// Function to check if the input string of brackets is valid
bool isValid(char* s) {
    int len = strlen(s);
    char stk[len];      // Stack to keep track of opening brackets
    int top = -1;       // Initialize top of stack

    for (int i = 0; s[i] != '\0'; i++) {
        // Push opening brackets onto the stack
        if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
            stk[++top] = s[i];
        }
        // If current character is a closing bracket, check for a match
        else if (top > -1 && 
                ((s[i] == ')' && stk[top] == '(') ||
                 (s[i] == ']' && stk[top] == '[') ||
                 (s[i] == '}' && stk[top] == '{'))) {
            top--; // Pop the matched opening bracket
        }
        // If no match found or stack is empty when trying to close, return false
        else {
            return false;
        }
    }

    // If stack is empty at the end, all brackets were matched
    return top == -1;
}

int main() {
    char s[] = "([]{})"; // Example input string

    if (isValid(s)) {
        printf("The string \"%s\" is valid.\n", s);
    } else {
        printf("The string \"%s\" is NOT valid.\n", s);
    }

    return 0;
}
