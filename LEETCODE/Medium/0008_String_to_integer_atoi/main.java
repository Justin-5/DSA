// Problem: 8. String to Integer (atoi)
// Difficulty: Medium
// Language: Java
// This solution follows the problem statement directly without any optimizations.
// It parses the given string into a signed integer while handling whitespaces, optional signs,
// numeric characters, and integer overflow/underflow according to the rules provided.

class main {
    public int myAtoi(String s) {
        int i = 0;             // Pointer to traverse the string
        int sign = 1;          // Default sign is positive
        long result = 0;       // Store result in long to detect overflow

        // Step 1: Skip leading whitespace characters
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check if the next character is '+' or '-'
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;         // Negative number
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;               // Positive number, sign stays 1
        }

        // Step 3: Convert consecutive numeric characters into an integer
        int digit;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            digit = s.charAt(i) - '0';           // Convert char to integer value
            result = result * 10 + digit;        // Append digit to the result

            // Step 4: Check for overflow/underflow before proceeding
            if (sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;        // Clamp to max int
            }
            if (sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;        // Clamp to min int
            }

            i++;
        }

        // Step 5: Apply the sign to the result
        result *= sign;

        // Step 6: Return the final integer result
        return (int) result;
    }
}
