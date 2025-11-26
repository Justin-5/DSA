class Solution {
    public int smallestRepunitDivByK(int k) {
        // If divisible by 2 or 5, never possible
        if (k == 2 || k == 5) {
            return -1;
        }

        int curRemainder = 0;
        // At most k iterations because remainders cycle within [0..k-1]
        for (int i = 1; i <= k; i++) {
            curRemainder = (curRemainder * 10 + 1) % k;
            if (curRemainder == 0) {
                return i;
            }
        }

        return -1;
    }
}
