class Solution {
    public int smallestNumber(int n) {
        double powerOf2 = 1;
        int i = 1;

        // Keep finding next power of 2 greater than n
        while (powerOf2 <= n) {
            powerOf2 = Math.pow(2, i);
            i++;
        }

        // Subtract 1 to get number with all bits set (like 111, 1111, etc.)
        powerOf2 -= 1;
        return (int) powerOf2;
    }
}
