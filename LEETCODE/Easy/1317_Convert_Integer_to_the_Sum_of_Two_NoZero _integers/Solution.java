class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];

        // Iterate through possible values for 'a'
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = n - i;

            // Check if both are No-Zero integers
            if (checkNonZero(a) && checkNonZero(b)) {
                arr[0] = a;
                arr[1] = b;
                break; // Stop at the first valid pair
            }
        }
        return arr;
    }

    // Helper function to check if a number has no '0' digit
    public boolean checkNonZero(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0) {
                return false; // Found a zero → invalid
            }
            n /= 10;
        }
        return true; // No zero found → valid No-Zero integer
    }
}
