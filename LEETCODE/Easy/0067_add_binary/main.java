class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Loop until both strings are processed
        while (i >= 0 || j >= 0) {
            int sum = carry;

            // Add bit from a if available
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Add bit from b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Insert the binary digit at the beginning
            result.insert(0, sum % 2);

            // Update carry
            carry = sum / 2;
        }

        // If there is a remaining carry, insert it at the beginning
        if (carry == 1) {
            result.insert(0, '1');
        }

        String finalresult = result.toString();
        return finalresult;
    }
}
