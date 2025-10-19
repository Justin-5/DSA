// 29. Divide Two Integers
// Approach: Bit manipulation + exponential subtraction
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // Work with absolute values (cast to long to avoid overflow)
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;

        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long powerOfTwo = 1;

            // Double divisor until it exceeds dividend
            while ((tempDivisor << 1) <= absDividend) {
                tempDivisor <<= 1;
                powerOfTwo <<= 1;
            }

            absDividend -= tempDivisor;
            quotient += powerOfTwo;
        }

        quotient *= sign;

        return (int) quotient;
    }
}
