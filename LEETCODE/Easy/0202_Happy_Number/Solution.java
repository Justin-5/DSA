import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        // If n is 1 or 7, it's known to be a happy number
        if (n == 1 || n == 7) {
            return true;
        }

        int num = n;
        Set<Integer> seen = new HashSet<>();

        // Continue the process until we find 1 or a loop
        while (num != 1) {
            if (seen.contains(num)) {
                // We entered a cycle, hence not a happy number
                return false;
            }

            seen.add(num);
            int res = 0;

            // Replace number with sum of squares of its digits
            while (num != 0) {
                int digit = num % 10;
                res += Math.pow(digit, 2);
                num /= 10;
            }

            num = res;
        }

        // If we reached 1, it's a happy number
        return true;
    }
}
