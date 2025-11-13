class Solution {
    public int maxOperations(String s) {
        int i = 0;
        int n = s.length();
        int onesCount = 0;
        int maxOp = 0;

        while (i < n) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } else {
                // For a block of zeros, all previous 1's can move right
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                maxOp += onesCount;
                i--; // Step back to recheck last valid position
            }
            i++;
        }

        return maxOp;
    }
}
