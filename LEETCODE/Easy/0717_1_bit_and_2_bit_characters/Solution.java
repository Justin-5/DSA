class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (bits[i] == 1) {   // 2-bit character
                i++;             // skip next bit
                flag = false;
            } else {             // 1-bit character
                flag = true;
            }
        }

        return flag;  // true if last decoded character is 1-bit
    }
}
