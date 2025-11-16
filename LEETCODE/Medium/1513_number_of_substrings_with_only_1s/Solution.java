class Solution {
    public int numSub(String s) {
        long count = 0;
        final int mod = 1_000_000_007;
        
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '1') {
                int len = 0;

                // Count consecutive '1's
                while (i < n && s.charAt(i) == '1') {
                    len++;
                    i++;
                }

                // Add number of substrings formed:
                // k * (k + 1) / 2
                count = (count + (long) len * (len + 1) / 2) % mod;

            } else {
                i++; // skip '0'
            }
        }

        return (int) count;
    }
}
