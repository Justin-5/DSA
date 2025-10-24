
class Solution {
    // Check if a number is numerically balanced
    public boolean isBalanced(int n) {
        int[] digitFreq = new int[10];
        while (n != 0) {
            int digit = n % 10;
            digitFreq[digit]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (digitFreq[i] > 0 && digitFreq[i] != i) {
                return false;
            }
        }
        return true;
    }

    // Find the next greater numerically balanced number
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (!isBalanced(num)) {
            num++;
        }
        return num;
    }
}
